/*
 * Copyright 2014 Common Semantics  (commonsemantics.org)
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.commonsemantics.grails.systems.model

/**
 * @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
 */
class SystemType {

	public static final Integer GLOBAL_MAX_SIZE = 128;
	public static final Integer SHORTNAME_MAX_SIZE = 16;
	public static final Integer DESCRIPION_MAX_SIZE = 1024;
	
	String id;
	String globalIdentifier;
	
	String shortName;
	String description;
	
	static mapping = {
		id generator:'uuid', sqlType: "varchar(36)"
		version false
	}
	
	static constraints = {
		id maxSize: 36
		globalIdentifier maxSize:GLOBAL_MAX_SIZE
		
		shortName  (nullable:false, blank: false, maxSize:SHORTNAME_MAX_SIZE)
		description (nullable:true, blank:true, maxSize:DESCRIPION_MAX_SIZE)
	}
}
