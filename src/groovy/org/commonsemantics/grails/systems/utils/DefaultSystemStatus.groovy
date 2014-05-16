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
package org.commonsemantics.grails.systems.utils

/**
 * These are the default entries for system status. The entries are supposed 
 * to be sat up in the Bootstrap.groovy file as follows:
 * 
 * log.info  '** System Status'
 * DefaultSystemStatus.values().each {
 *      if(!SystemStatus.findByValue(it.value())) {
 *           new SystemStatus(value: it.value(), uuid: it.uuid(), label: it.label(), description: it.description()).save(failOnError: true)
 *           log.info "Initialized: " + it.value()
 *      }
 * }
 * 
 * Alternative group status can be defined with a similar approach.
 * 
 * @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
 */
enum DefaultSystemStatus {

	ACTIVE("SYSTEM_ACTIVE", "Active", "Active", "org.mindinformatics.domeo.uris.status.Active"),
	LOCKED("SYSTEM_LOCKED", "Locked", "Not active but visible", "org.mindinformatics.domeo.uris.status.Locked"),
	DISABLED("SYSTEM_DISABLED", "Disabled", "Not active and not visible", "org.mindinformatics.domeo.uris.status.Disabled"),
	DELETED("SYSTEM_DELETED", "Deleted", "Not active, not visible and not restorable.", "org.mindinformatics.domeo.uris.status.Deleted")
	
	DefaultSystemStatus(String value, String label, String description, String uuid) {
		this.value = value
		this.label = label;
		this.description = description;
		this.uuid = uuid;
	}
	
	private final String uuid
	public String uuid() { return uuid }
	private final String value
	public String value() { return value }
	private final String label
	public String label() { return label }
	private final String description
	public String description() { return description }
}
