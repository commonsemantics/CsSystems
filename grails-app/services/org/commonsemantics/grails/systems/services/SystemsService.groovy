/*
 * Copyright 2014  Common Semantics (commonsemantics.org)
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

import org.commonsemantics.grails.groups.model.Group
import org.commonsemantics.grails.systems.model.SystemApi
import org.commonsemantics.grails.systems.model.UserSystemApi
import org.commonsemantics.grails.systems.utils.DefaultSystemStatus

/**
 * @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
 */
class SystemsService {

	def listSystems(def max, def offset, def sort, def _order) {
		
		def systems = [];
		def systemsCount = [:]
		SystemApi.list().each { system ->
			systemsCount.put (system.id, UserSystemApi.findAllWhere(system: system).size())
		}
		def systemsStatus = [:]
		SystemApi.list().each { system ->
			systemsStatus.put (system.id, system.enabled)
		}
		
		if (sort == 'systemsCount') {
			systemsCount = systemsCount.sort{ a, b -> a.value <=> b.value }
			if(_order == "desc")
				systemsCount.each { groupCount ->
					systems.add SystemApi.findById(groupCount.key);
				}
			else
				systemsCount.reverseEach { groupCount ->
					systems.add SystemApi.findById(groupCount.key);
				}
		} else if (sort == 'status') {
			systemsStatus = systemsStatus.sort{ a, b -> a.value.compareTo(b.value) }
			if(_order == "desc")
				systemsStatus.each { groupStatus ->
					systems.add Group.findById(groupStatus.key);
				}
			else
				systemsStatus.reverseEach { groupStatus ->
					systems.add Group.findById(groupStatus.key);
				}
		} else {
			systems = SystemApi.withCriteria {
				maxResults(max?.toInteger())
				firstResult(offset?.toInteger())
				order(sort, _order)
			}
		}
		
		[systems, systemsCount]
	}
	
	def updateSystemStatus(def system, def status) {
		log.debug 'System ' + system + ' status ' + status
		if(status.equals(DefaultSystemStatus.ACTIVE.value())) {
			system.enabled = true
		} else if(status.equals(DefaultSystemStatus.DISABLED.value())) {
			system.enabled = false
		} 
	}
	
	def isApiKeyValid(def apiKey) {
		log.info("Validating API key [" + apiKey + "]");
		def system = SystemApi.findByApikey(apiKey);
		if(system!=null && system.enabled) return true;
		else return false;
	}
}
