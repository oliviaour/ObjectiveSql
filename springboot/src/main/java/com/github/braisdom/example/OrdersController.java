package com.github.braisdom.example;

import com.github.braisdom.example.model.Member;
import com.github.braisdom.example.model.Order;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class OrdersController {

    @PostMapping("/orders/{memberNo}")
    public ResponseObject makeOrder(@PathVariable("memberNo") String memberNo,
                           @RequestBody RequestObject rawOrder) throws SQLException {
        Member owner = Member.queryByNo(memberNo);
        Order.makeOrder(owner, rawOrder);
        return ResponseObject.createSuccessResponse();
    }
}