<%-- by Paolo Ciccarese --%>
<%-- 
Parameters list
 1) item | instance of GroupCreateCommand
Stylesheet
 1) fieldError | background and font color in erroneous text fields
--%>
<div class="sectioncontainer">
	<div class="dialog" >
		<fieldset>
			<legend><span id="systemsTitle">Loading Systems</span> <img id="systemsSpinner" src="${resource(dir:'images',file:'spinner.gif',plugin:'users-module')}" /></legend>
			<div id="userSystemsComponent">
				<div class="list tablescroll">
					<table id="systemsTable" style="border: 1px solid #ddd;">
						<thead>
							<tr>
								<th style="width: 200px">${message(code: 'agentPerson.id.label', default: 'System Name')}</th>
								<th style="width: 200px">${message(code: 'agentPerson.id.label', default: 'Since')}</th>
								<th>${message(code: 'agentPerson.id.label', default: 'Status')}</th>
							</tr>
						</thead>
						<tbody id="systemsContent">
						</tbody>
					</table>
					<div class="paginateButtons">
				   		<g:paginate total="1" />
					</div>
				</div>
				<div class="buttons">
					<span class="button">
						<g:link class="edit" controller="dashboard" action="manageUserSystems"  id="${user.id}" style="text-decoration: none;">Manage Systems</g:link>
					</span>
					&nbsp;
					<span class="button">
						<g:link class="add" controller="dashboard" action="addUserSystems" id="${user.id}" style="text-decoration: none;">Enroll in Systems</g:link>
					</span>
				</div>
			</div>
		</fieldset> 
	</div>
</div>
