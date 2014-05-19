
<%@ page import="org.commonsemantics.grails.systems.utils.SystemsUtils" %>
<%-- 
<%@ page import="org.commonsemantics.grails.systems.model.Usersystem" %>
--%>

<%-- 
By Dr. Paolo Ciccarese <paolo.ciccarese@gmail.com>

Parameters list
 1) user | instance of systemCreateCommand
Stylesheet
 1) fieldError | background and font color in erroneous text fields
--%>
<div class="sectioncontainer">
	<g:if test="${system!=null}">
		<table>
			<tbody>
				<%-- 
				<tr>
					<td valign="top" colspan="2"  style="horizontal-align:center;">
						<img src="${resource(dir:'images/dashboard',file:'no_image.gif',plugin:'users-module')}" width="200px" />
					</td>
				</tr>
				--%>
				<tr>
					<td valign="top" width="150px"  align="left">
						<g:message code="org.commonsemantics.grails.systems.model.field.name" default="Name"/>
					</td>
					<td valign="top" width="265px" align="left">
						<g:if test="${system.name}">${system.name}</g:if>
						<g:else>-</g:else>
					</td>
				</tr>
				<g:if test="${grailsApplication.config.org.commonsemantics.grails.systems.model.field.shortName!='hide'}">
					<tr>
						<td valign="top" width="150px"  align="left">
							<g:message code="org.commonsemantics.grails.systems.model.field.shortName" default="Short Name"/>
						</td>
						<td valign="top" width="265px" align="left">
							<g:if test="${system.shortName}">${system.shortName}</g:if>
							<g:else>-</g:else>
						</td>
					</tr>
				</g:if>
				<g:if test="${grailsApplication.config.org.commonsemantics.grails.systems.model.field.description!='hide'}">
					<tr>
						<td valign="top" width="150px"  align="left">
							<g:message code="org.commonsemantics.grails.systems.model.field.description" default="Description"/>
						</td>
						<td valign="top" width="265px" align="left">
							<g:if test="${system.description}">${system.description}</g:if>
							<g:else>-</g:else>
						</td>
					</tr>
				</g:if>
				<tr>
					<td valign="top" align="left">
						<g:message code="org.commonsemantics.grails.systems.model.field.status" default="Account Status"/>
					</td>
					<td valign="top" colspan="2" align="left">
						<div>
							${SystemsUtils.getStatusLabel(system)}						
						</div>
					</td>
				</tr>
				<tr>
					<td valign="top" width="150px"  align="left">
						<g:message code="org.commonsemantics.grails.systems.model.field.createdBy" default="Created By"/>
					</td>
					<td valign="top" width="265px" align="left">
						<g:if test="${system.createdBy}"><g:link action="showUser" id="${system.createdBy.id}">${system.createdBy.username}</g:link></g:if>
						<g:else>-</g:else>
					</td>
				</tr>
				<%-- 
				<tr>
					<td valign="top" width="150px"  align="left">
						<g:message code="org.commonsemantics.grails.systems.model.field.membersCounter" default="Members Counter"/>
					</td>
					<td valign="top" width="265px" align="left">
						<g:link action="listsystemUsers" id="${system.id}">
							${UserSystem.findAllWhere(system: system).size()}
						</g:link>
					</td>
				</tr>
				--%>
			</tbody>
		</table>
	</g:if>
	<g:else>
		<g:render plugin="cs-commons" template="/lenses/error" model="['message':'Cssystems._systemShow: system object cannot be null.']"/>
	</g:else>
</div>


