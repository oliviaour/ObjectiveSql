/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.braisdom.objsql.transition;

import com.github.braisdom.objsql.DomainModelDescriptor;

import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public interface ColumnTransitional<T> {

    /**
     * Puts the Java field value into the database.
     *
     * @param databaseMetaData
     * @param object
     * @param domainModelDescriptor
     * @param fieldName
     * @param fieldValue
     * @return
     * @throws SQLException
     */
    default Object sinking(DatabaseMetaData databaseMetaData,
                           T object, DomainModelDescriptor domainModelDescriptor,
                           String fieldName, Object fieldValue) throws SQLException {
        return fieldValue;
    }

    /**
     * Pulls the database column value to Java field
     *
     * @param databaseMetaData
     * @param resultSetMetaData
     * @param object
     * @param domainModelDescriptor
     * @param fieldName
     * @param columnValue
     * @return
     * @throws SQLException
     */
    default Object rising(DatabaseMetaData databaseMetaData, ResultSetMetaData resultSetMetaData,
                          T object, DomainModelDescriptor domainModelDescriptor,
                          String fieldName, Object columnValue) throws SQLException {
        return columnValue;
    }
}
