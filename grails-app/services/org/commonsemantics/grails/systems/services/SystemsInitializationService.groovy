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
package org.commonsemantics.grails.systems.services

import org.commonsemantics.grails.systems.model.SystemStatus
import org.commonsemantics.grails.systems.model.SystemType
import org.commonsemantics.grails.systems.utils.DefaultSystemStatus
import org.commonsemantics.grails.systems.utils.DefaultSystemTypes

/**
 * @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
 */
class SystemsInitializationService {

	def grailsApplication;
	
	def initializeStatus() {
		def enumeration = null;
		def enumerationClass = grailsApplication.config.org.commonsemantics.grails.systems.init.status
		if(enumerationClass!=null &&
				((enumerationClass instanceof ConfigObject && !enumerationClass.isEmpty()) ||
				(enumerationClass instanceof String && enumerationClass.trim().length()>0))) {
			log.debug "Selected enumeration status " + enumerationClass
			enumeration = this.getClass().classLoader.findClass(enumerationClass)
		} else {
			log.debug "Selected default enumeration status"
			enumeration = DefaultSystemStatus;
		}
		
		enumeration.values().each {
			if(!SystemStatus.findByValue(it.value())) {
				new SystemStatus(value: it.value(), uuid: it.uuid(), label: it.label(), description: it.description()).save(failOnError: true)
				log.trace "Initialized: " + it.value()
			} else {
				log.trace "Found: " + it.value()
			}
		}
	}
	
	
	def initializeTypes() {
		def enumeration = null;
		def enumerationClass = grailsApplication.config.org.commonsemantics.grails.systems.types
		if(enumerationClass!=null &&
				((enumerationClass instanceof ConfigObject && !enumerationClass.isEmpty()) ||
				(enumerationClass instanceof String && enumerationClass.trim().length()>0))) {
			log.debug "Selected enumeration types " + enumerationClass
			enumeration = this.getClass().classLoader.findClass(enumerationClass)
		} else {
			log.debug "Selected default enumeration types"
			enumeration = DefaultSystemTypes;
		}
		
		enumeration.values().each {
			if(!SystemType.findByGlobalIdentifier(it.globalIdentifier())) {
				new SystemType(globalIdentifier: it.globalIdentifier(), shortName: it.shortName(), description: it.description()).save(failOnError: true)
				log.trace "Initialized: " + it.globalIdentifier()
			} else {
				log.trace "Found: " + it.globalIdentifier()
			}
		}
	}

}
