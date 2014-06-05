/*
 * Copyright 2013 Common Semantics  (commonsemantics.org)
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

import grails.validation.Validateable

import org.commonsemantics.grails.groups.model.Group
import org.commonsemantics.grails.users.model.User


/**
* @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
*/
@Validateable
class SystemApi {

	public static final Integer NAME_MAX_SIZE = 255;
	public static final Integer SHORTNAME_MAX_SIZE = 16;
	public static final Integer DESCRIPION_MAX_SIZE = 1024;
	
	String id;
	String name;
	String shortName;
	String description;
	
	User createdBy;
	Date dateCreated, lastUpdated
	
	/**
	 * Api key to be used by the external application to get to the
	 * annotation framework node data.
	 */
	String apikey;
	/**
	 * Secret key that could be used for authentication
	 */
	String secretkey;
	
	/**
	 * System access can be disabled.
	 */
	boolean enabled
	
	/**
	 * If true it allows the external application to get to all the 
	 * public data of the annotation framework node.
	 */
	boolean accessToPublicData
	/**
	 * Grants access to the data belonging to specified groups and
	 * users.
	 */
	static hasMany = [admins: User, groups: Group, users: User]
	
	String getUri() {
		return "urn:system:uuid:"+id;
	}
	
	static mandatory = ['name']
	static optional = []
	
	static mapping = {
		id generator:'uuid', sqlType: "varchar(36)"
		version false
	}
	
	static constraints = {
		id maxSize: 36
		
		apikey (nullable:false, blank: false, unique: true, maxSize:255)
		
		secretkey (nullable:true, blank: false, unique: true, maxSize:255)
		
		name (nullable:false, blank: false, maxSize:NAME_MAX_SIZE)
		shortName  (nullable:true, blank: true, maxSize:SHORTNAME_MAX_SIZE)
		description (nullable:true, blank:true, maxSize:DESCRIPION_MAX_SIZE)
	}
}
