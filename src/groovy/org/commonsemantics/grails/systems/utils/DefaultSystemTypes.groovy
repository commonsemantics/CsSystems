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
package org.commonsemantics.grails.systems.utils

enum DefaultSystemsType {

	TEST1("TestSystem1", "Testing system 1", "org.commonsemantics.grails.systems.utils.type.TestSystem1"),
	TEST2("TestSystem2", "Testing system 2", "org.commonsemantics.grails.systems.utils.type.TestSystem2")
	
	DefaultSystemsType(String shortName, String description, String globalIdentifier) {
		this.shortName = shortName;
		this.description = description;
		this.globalIdentifier = globalIdentifier;
	}
	
	private String globalIdentifier;
	public String globalIdentifier() { return globalIdentifier }
	
	private String shortName;
	public String shortName() { return shortName }
	
	private String description;
	public String description() { return description }
	
}
