<%-- by Paolo Ciccarese --%>
<%-- 
Parameters list
 1) system | instance of GroupCreateCommand
Stylesheet
 1) fieldError | background and font color in erroneous text fields
--%>
<%@ page import="org.commonsemantics.grails.systems.utils.DefaultSystemStatus" %>
<tr>
	<td valign="top">
		<g:hiddenField name="id" value="${system?.id}" /> 
		<table class="simpleTable">
			<tbody>
				<tr class="prop">
					<td valign="top" width="70px"  class="name">
						<label for="name">Name</label>
					</td>
					<td valign="top" width="255px" class="value">
						<div>
							<g:textField name="name" style="width: 240px;"
								value="${system?.name}" class="${hasErrors(bean: system, field: 'name', 'fieldError')}"/>
						</div>
					</td>
					<td valign="top" class="caption">
						<g:if test="${system?.name!=null}">
							<g:renderErrors bean="${system}" field="name" />
						</g:if> 
						<g:else>
				        	(max 255 chars)
				        </g:else>
				    </td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">
						<label for="shortName">Short Name</label>
					</td>
					<td valign="top" class="value">
						<g:textField name="shortName" style="width: 240px;"
							value="${system?.shortName}" class="${hasErrors(bean: system, field: 'shortName', 'fieldError')}"/>
					</td>
					<td valign="top" class="caption">
						<g:if test="${system?.shortName!=null}">
							<g:renderErrors bean="${system}" field="shortName" />
						</g:if> 
						<g:else>
			           		(max 100 chars)
			            </g:else>
			        </td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">
						<label for="description">Description</label>
					</td>
					<td valign="top" class="value">
						<g:textArea name="description" style="width: 240px;"
							value="${system?.description}"  class="${hasErrors(bean: system, field: 'description', 'fieldError')}"/>
					</td>
					<td valign="top" class="caption">
						<g:if test="${system?.description!=null}">
							<g:renderErrors bean="${system}" field="description" />
						</g:if> 
						<g:else>
			           		(max 1024 chars)
			            </g:else>
			        </td>
				</tr>
				<tr class="prop">
					<td valign="top" class="name">
						<label for="description">Status</label>
					</td>
					<td valign="top" colspan="2" class="value">
						<g:if test="${action=='create'}">
							<g:radio name="systemStatus" value="${DefaultSystemStatus.ACTIVE.value()}" checked="checked"/> Enabled
						</g:if>
						<g:else>
							<g:if test="${system?.enabled==true}">
								<g:radio name="systemStatus" value="${DefaultSystemStatus.ACTIVE.value()}" checked="checked"/> Enabled
								<g:radio name="systemStatus" value="${DefaultSystemStatus.DISABLED.value()}" /> Disabled
							</g:if>
							<g:else>
								<g:radio name="systemStatus" value="${DefaultSystemStatus.ACTIVE.value()}"/> Enabled
								<g:radio name="systemStatus" value="${DefaultSystemStatus.DISABLED.value()}" checked="checked"/> Disabled
							</g:else>
						</g:else>
			        </td>
				</tr>
			</tbody>
		</table>
	</td>
</tr>
