<div id="request" class="sectioncontainer">
<div class="dialog">
	<div class="title">Systems List for ${user.person.displayName} - total# ${userSystems.size()}</div>

<div class="list">
	<g:set var="g" value="${group}"/>
	<table class="tablelist">
		<thead>
			<tr>
				<g:sortableColumn property="name" title="${message(code: 'agentPerson.id.label', default: 'Name')}" />
				<g:sortableColumn property="shortName" title="${message(code: 'agentPerson.id.label', default: 'Short')}" />
				<g:sortableColumn property="description" title="${message(code: 'agentPerson.id.label', default: 'Description')}" />
				<g:sortableColumn property="dateCreated" title="${message(code: 'agentPerson.id.label', default: 'Created on')}" />
				<g:sortableColumn property="lastUpdated" title="${message(code: 'agentPerson.id.label', default: 'Last updated')}" />
				<g:sortableColumn property="status" title="${message(code: 'agentPerson.id.label', default: 'Status')}" />
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<g:if test="${userSystems.size()==0}">
				<tr>
					<td colspan="8">No Systems have been defined</td>
				</tr>
			</g:if>
			<g:each in="${userSystems}" status="i" var="userSystem">
				<g:set var="system" value="${userSystem.system}"/>
				<tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
		     		<td>
						<g:link action="showSystem" id="${system.id}">
		     				${system.name}
						</g:link>
		     		</td>
		     		<td>
						${system.shortName}
		     		</td>
		     		<td>
						${system.description}
		     		</td>
		     		 
		     		<td><g:formatDate format="MM/dd/yyyy hh:mm" date="${system.dateCreated}"/></td>
		     		<td><g:formatDate format="MM/dd/yyyy hh:mm" date="${system.lastUpdated}"/></td>
		     		
		     		<td>	
		     			<g:if test="${system.enabled==true}">Enabled</g:if>
			     		<g:else>Disabled</g:else>
		     		</td>
		     			
		     		<td>
			     		<div class="buttons">		     		
							<g:form>
								<g:hiddenField name="id" value="${system?.id}" /> 
								<g:hiddenField name="redirect" value="manageUserSystems" />
								<g:hiddenField name="targetid" value="${user.id}" />
								<span class="button">
									<g:actionSubmit class="edit" action="editSystem" value="${message(code: 'default.button.edit.account.label', default: 'Edit')}" />
								</span>
								
								<g:if test="${system.enabled!=true}">
									<span class="button">
										<g:actionSubmit class="enable" action="enableSystem" value="${message(code: 'default.button.enable.account.label', default: 'Enable')}" />
									</span>
								</g:if>
								<g:elseif test="${system.enabled==true}">
									<span class="button">
										<g:actionSubmit class="disable" action="disableSystem" value="${message(code: 'default.button.disable.account.label', default: 'Disable')}" 
											onclick="return confirm('${message(code: 'default.button.disable.account.confirm.message', default: 'Are you sure you want to disable the system: '+system.shortName+' ?')}');" />
									</span>
								</g:elseif>
							</g:form>					
						</div>	     		
		     		</td>
		     	</tr>
			</g:each>
		</tbody>
	</table>
	<div class="paginateButtons">
   		<g:paginate total="${systemsTotal}" />
	</div>
</div>
</fieldset>
</div>
</div>