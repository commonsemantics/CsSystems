<%-- by Paolo Ciccarese --%>
<%@ page import="org.commonsemantics.grails.systems.utils.SystemsUtils" %>
<%@ page import="org.commonsemantics.grails.systems.utils.DefaultSystemStatus" %>
<%-- 
Parameters list
 1) item | instance of UserCreateCommand
 2) error | errors in text format
--%>
<div class="sectioncontainer">
	<g:form method="post" >
	 	<div class="dialog" >
			<table style="width: 700px;" class="simpleTableNoBorder">
				<tr>
					<td valign="top" colspan="2">
						<g:if test="${msgError!=null}">
							${msgError}
						</g:if>
					</td>
				</tr>
				<g:if test="${grailsApplication.config.org.commonsemantics.grails.systems.model.field.name!='hide'}">			
					<g:render plugin="cs-agents" template="/agents/agentPropertyEntry" model="[
						messageCode:'org.commonsemantics.grails.systems.model.field.name',
						messageDefault:'Name',
						mandatory:SystemsUtils.isSystemFieldRequired(grailsApplication, 'name'),
						bean: system,
						variable: 'name',
						value: system?.name,
						caption: '(max 255 ' +  g.message(code: 'org.commonsemantics.grails.general.chars',default:'chars') + ')'
					]" />
				</g:if>
				<g:if test="${grailsApplication.config.org.commonsemantics.grails.systems.model.field.shortName!='hide'}">			
					<g:render plugin="cs-agents" template="/agents/agentPropertyEntry" model="[
						messageCode:'org.commonsemantics.grails.systems.model.field.shortName',
						messageDefault:'Short name',
						mandatory:SystemsUtils.isSystemFieldRequired(grailsApplication, 'shortName'),
						bean: system,
						variable: 'shortName',
						value: system?.shortName,
						caption: '(max 255 ' +  g.message(code: 'org.commonsemantics.grails.general.chars',default:'chars') + ')'
					]" />
				</g:if>
				<g:if test="${grailsApplication.config.org.commonsemantics.grails.systems.model.field.description!='hide'}">			
					<g:render plugin="cs-agents" template="/agents/agentPropertyEntry" model="[
						messageCode:'org.commonsemantics.grails.groups.model.field.description',
						messageDefault:'Description',
						mandatory:SystemsUtils.isSystemFieldRequired(grailsApplication, 'description'),
						bean: system,
						variable: 'description',
						value: system?.description,
						caption: '(max 255 ' +  g.message(code: 'org.commonsemantics.grails.general.chars',default:'chars') + ')'
					]" />
				</g:if>
				<tr class="prop">
					<td valign="top" class="name">
						<label for="description">Status</label>
					</td>
					<td valign="top" colspan="2" class="value">
						<g:if test="${action=='create'}">
							<g:radio name="status" value="${DefaultSystemStatus.ACTIVE.value()}" checked="checked"/> Enabled
						</g:if>
						<g:else>
							<g:if test="${system?.enabled==true}">
								<g:radio name="status" value="system?.enabled" checked="checked"/> Enabled
								<g:radio name="status" value="system?.enabled" /> Disabled
							</g:if>
							<g:else>
								<g:radio name="status" value="system?.enabled"/> Enabled
								<g:radio name="status" value="system?.enabled" checked="checked"/> Disabled
							</g:else>
						</g:else>
			        </td>
				</tr>

				<tr>
					<td valign="top" colspan="3" >
						<div class="buttons">
							<span class="button">
								<g:actionSubmit class="save" action="saveSystem" value="${message(code: 'default.button.edit.account.label', default: 'Save system')}" />
							</span>
							<span class="button">
								<g:actionSubmit class="cancel" action="listSystems" value="${message(code: 'default.button.edit.account.label', default: 'Cancel')}" />
							</span>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</g:form>
</div>