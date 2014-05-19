/*
 * Copyright 2013 Massachusetts General Hospital
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

import org.apache.log4j.Logger
import org.commonsemantics.grails.systems.model.SystemApi
import org.commonsemantics.grails.utils.LoggingUtils


/**
* @author Paolo Ciccarese <paolo.ciccarese@gmail.com>
*/
class SystemsUtils {

	static Logger log = Logger.getLogger(SystemsUtils.class) // log4j
	
	static def getSystemConfigurationMandatoryFields(def grailsApplication) {
		def mandatory = [];
		if(grailsApplication.config.org.commonsemantics.grails.systems.model.fields.mandatory.size()>0) {
			mandatory.addAll(Eval.me(grailsApplication.config.org.commonsemantics.grails.systems.model.fields.mandatory));
		}
		return mandatory;
	}
	
	static def getSystemDynamicMandatoryFields(def grailsApplication) {
		//if(isGroupStaticPropertyExisting('mandatory')) {
			def mandatory = SystemApi.mandatory.clone() as Set;
			mandatory.addAll(getSystemConfigurationMandatoryFields(grailsApplication));
			return mandatory;
		//} else return [];
	}
	
	static boolean isSystemFieldRequired(def grailsApplication, def fieldName) {
		// Mandatory fields by dynamic configuration
		def mandatoryByConfiguration = getSystemDynamicMandatoryFields(grailsApplication)
		// Mandatory fields by static coding
		if(!SystemApi.constraints[fieldName]?.nullable) mandatoryByConfiguration.add(fieldName);
		
		if((isSystemStaticPropertyExisting('mandatory') && fieldName in SystemApi.mandatory) || fieldName in mandatoryByConfiguration) {
			log.debug LoggingUtils.LOG_CONF + ' Group mandatory field: ' + fieldName;
			return true;
		}
		return false;
	}
	
	static def isSystemStaticPropertyExisting(def name) {
		SystemApi.class.declaredFields.find {
			it.name == 'x' && isStatic(it.modifiers)
		}
	}
	
	static String getStatusValue(SystemApi system) {
		if(system.isEnabled()) {
			 return DefaultSystemStatus.ACTIVE.value();
		} else {
			return DefaultSystemStatus.DISABLED.value();
		}
	}
	
	static String getStatusUuid(SystemApi system) {
		if(system.isEnabled()) {
			 return DefaultSystemStatus.ACTIVE.uuid();
		} else {
			return DefaultSystemStatus.DISABLED.uuid();
		}
	}
	
	static String getStatusLabel(SystemApi system) {
		if(system.isEnabled()) {
			return DefaultSystemStatus.ACTIVE.label();
		} else {
			return DefaultSystemStatus.DISABLED.label();
		}
	}
}
