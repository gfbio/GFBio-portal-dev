<%@ include file="/init.jsp" %>


<aui:form>
	
	<aui:fieldset>
		<aui:input id="email" autocomplete="off" class="input_text" type="text" name="email" placeholder="Bitte E-Mail-Adresse angeben"></aui:input>
		<aui:input id="password" autocomplete="off" class="input_text" type="password" name="password" placeholder="Bitte Kennwort angeben"></aui:input>
	</aui:fieldset>

	<!-- <div id="portlet_content">
		<div class="content_container_variable_height">
			<table class="table" cellspacing="0" cellpadding="0">
				<tbody>
					<tr class="inputrow">
						<td class="inputcell_left"> E-Mail-Adresse </td>
						<td class="inputcell_right">
							<aui:fieldset>
								<aui:input id="email" autocomplete="off" class="input_text" type="text" name="email" placeholder="Bitte E-Mail-Adresse angeben"></aui:input>
							</aui:fieldset>
						</td>
					</tr>
					<tr class="inputrow">
						<td class="inputcell_left"> Kennwort </td>
						<td class="inputcell_right">
							<aui:fieldset>
								<aui:input id="password" autocomplete="off" class="input_text" type="password" name="password" placeholder="Bitte Kennwort angeben"></aui:input>
							</aui:fieldset>
						</td>
					</tr>
					<tr>
						<td> Allgemeine Anzahl der Benutzer </td>
					</tr>
				</tbody>
			</table>
</aui:form>