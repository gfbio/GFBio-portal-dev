<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h2>General Project Information</h2>
<section>
	<div id="dmppreview" style="display: none;">
		<h2>Available Data Management Plans</h2>
		
		<div class="col-xs-12" style="margin-top: 10px;">
			
			<!-- LIST -->
	        <div class="row">
	            <div class="col-md-7 col-sm-5 col-xs-8">
	                Name
	            </div>
	            <div class="col-md-2 col-sm-2 col-xs-2">
	                TicketId
	            </div>
	            <div class="col-md-2 col-sm-3 hidden-xs">
	                Last Modified
	            </div>
	            <div class="col-md-1 col-sm-2 col-xs-2">
	                Actions
	            </div>
	        </div>
	        <div id="dmp-list">
				<c:forEach items="${dmpsforuser}" var="dmp">
					<div class="row dmp-list ${dmp.dmpID}">
						<div class="col-md-7 col-sm-5 col-xs-8 dmp-name">
							<c:out value="${dmp.name}" />
						</div>
						<div class="ticketid col-md-2 col-sm-2 col-xs-2">
							<c:choose>
								<c:when test="${dmp.ticketID > 0}">
									<a title="Helpdesk" href="https://helpdesk.gfbio.org">
										<c:out value="${dmp.ticketID}" />
									</a>
								</c:when>
								<c:otherwise>
									-
								</c:otherwise>
							</c:choose>
			            </div>
			            <div class="col-md-2 col-sm-3 hidden-xs">
			            	<fmt:formatDate value="${dmp.lastModifiedDate}" pattern="dd.MM.yyyy HH:mm" />    
			            </div>
			            <div class="col-md-1 col-sm-2 col-xs-2">
					        <a class="edit-dmp" title="edit">
					        	<i id="edit-${dmp.dmpID}" class="fa fa-pencil" aria-hidden="true"></i>
					        </a>
					        <a class="delete-dmp" title="delete">
					        	<i id="delete-${dmp.dmpID}" class="fa fa-trash" aria-hidden="true"></i>
					        </a>
			            </div>
					</div>
		  		</c:forEach>
	        </div>
        </div>
		
        <div class="col-xs-12" style="margin-top: 20px;">
           	<input id="start" class="startdmp" type="button" value="New Data Management Plan"/>
        </div>
	</div>
	
	<div id="dialog-delete-load" style="display: none;">
		<div id="delete-load-answer" style="text-align: center;"></div>
	</div>
	
	<div id="generalinformation">
		<div name="title" title="Test" class="hidden-md hidden-lg">
			<h2>1. General Project Information</h2>
		</div>
		<div class="row dmpt-row">
			<div class="col-md-12">
				<div id="save-message" class="portlet-msg-alert col-md-12" style="display: none;">
					Only logged in users can save their inputs at the end of the wizard. Please <a href="${portalurl}/sign-in?saveLastPath=0"><span style="color:#006400; font-weight:bold">sign in</span></a> to enable the feature.
				</div>
			</div>
			<h4>What is the official name of your research project? *</h4>
	        <div class="col-md-12">
	        	<input id="dmpId" type="hidden" value="0"/>
				<input id="name" name="projectName" type="text" placeholder="Project Name" class="before_error"/> <!-- required -->
			</div>
		</div>
		<div class="row dmpt-row">
			<h4>Please select a category:</h4>
			<div class="col-md-12">
				<select id="category" name="category">
					<option selected="selected" label="Select" value="default">Select</option>
					<c:forEach var="field" items="${researchfields}">
						<option label="<c:out value="${field.name}" />"
									value="<c:out value="${field.name}"/>"><c:out
										value="${field.name}" /></option>
					</c:forEach>
				</select>
			</div>
		</div>
	  	<div class="row dmpt-row">
	      	<h4>Is your research data reproducible?
	      		<a name="title" title="Imagine your research data gets lost. Would you (or someone else) be able to reproduce your data? What effort or resources would be necessary?">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	      	</h4>
	      	<div id="nature">
	      		<div class="col-xs-12 col-sm-4">
	            	<label class="mod-cb">
	            		<input name="reproducible" type="checkbox" value="One-time observation" />
	            		<span title="A one-time observation might for example be a gray seal count in the German wadden sea in June 2006 or a DNA analysis without sample storage.">One-time observation</span>
	            	</label>
	     		</div>
	      		<div class="col-xs-12 col-sm-4">
			        <label class="mod-cb">
				        <input name="reproducible" type="checkbox" value="Repeatable experiments" />
				        <span title="A repeatable experiment might for example be a DNA analysis with the deposit of sample material or a documented statistical analysis of slug counts in Sweden in the years 1956 to 1996 (assumed computer code and primary data are available).">Repeatable experiments</span>
			        </label>
	          	</div>
	          	<div class="col-xs-12 col-sm-4">
			        <label class="mod-cb">
				        <input name="reproducible" type="checkbox" value="Time series" />
				        <span title="A time series (observation) is a series of one-time observations and might for example be the periodic raw counts of slugs in Sweden during the years 1956-1996 or	daily measurements of precipitation and air temperature.">Time series</span>
			        </label>
	          	</div>
	          	<div class="col-sm-12" style="margin-top: 10px;">
	      			<textarea id="reproducibleText" name="reproducibleText" class="before_error" maxlength="1000" rows="3" cols="100" placeholder="Add additional information (e.g. data reproduction might cause high costs or a lot of effort)."></textarea> 
	    		</div>
	     	</div>
		</div>
	    <div class="row dmpt-row">
	   		<h4>Please specify your project type.
	   			<a name="title" title="You can combine several types.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	   		</h4>
	        <div id="projectTypes" >
	        	<div class="col-xs-12 col-sm-6">
	            	<div>
	                	<label class="mod-cb">
			               	<input name="types" type="checkbox" value="Field Work"/>
			               	<span>Field Work</span>
	                	</label>
	                </div>
	                <div>
	                      <label class="mod-cb">
	                      	<input name="types" type="checkbox" value="Observational"/>
	                      	<span>Observational</span>
	                      </label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	           		<div>
	                	<label class="mod-cb">
			               	<input name="types" type="checkbox" value="Simulation"/>
			               	<span>Simulation</span>
	                	</label>
	                </div>
	                <div>
	                  	<label class="mod-cb">
		                  	<input name="types" type="checkbox" value="Assimilation"/>
		                  	<span>Assimilation</span>
	                  	</label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	            	<div>	
	                	<label class="mod-cb">
			               	<input name="types" type="checkbox" value="Experimental"/>
			               	<span>Experimental</span>
	                	</label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
		                    <input name="types" type="checkbox" value="Laboratory"/>
		                    <span>Laboratory</span>
	                    </label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	                <div>
	                    <label class="mod-cb">
	                    		<input name="types" type="checkbox" value="Modelling"/>
	                    		<span>Modelling</span>
	                    </label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
	                    		<input id="types-cb" name="types" type="checkbox" value="Other"/>
	                    		<span>Other</span>
	                    </label>
	                </div>
	            </div>
	            <div class="col-md-12">
            		<input id="typesOther" name="typesOther" type="text" placeholder="Other project type" class="before_error" />
	            </div>
	        </div>
	        
		</div>
		<div class="row dmpt-row">
	    	<h4>Provide your project abstract or describe your work and the data involved.</h4>
	        <div id="projectInformation" class="col-md-12">
	      		<textarea maxlength="2000" id="abstract" name="projectAbstract" rows="5" cols="100" class="before_error" placeholder="Project Abstract"></textarea> 
	    	</div>
		</div>
		<div class="row dmpt-row">
	    	<h4>Who is the point of contact for the project data? *
	    		<a name="title" title="Who should be contacted in case of any question concerning data management? This might be technical issues as well as questions concerning data policies, legal requirements or data volumes and formats.  
	Most commonly this is: you - the one preparing the DMP.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	    	</h4>
	    	
	    	<div id="responsible" style="overflow: auto;">
		 		<div class="col-md-6">
		    		<input id="responsibleName" name="responsibleName" type="text" placeholder="Name" class="parent_error"
		    		value="<c:out value="${username}" />" onfocus="getPrincipal()" />
		    	</div>
		    	
			 	<div class="col-md-6" >
			    	<input id="phone" name="phoneNumber" type="tel" placeholder="Phone Number" value="<c:out value="${phone}" />" /> 
			    </div>
			    
			    <div class="col-md-12" >
		     		<input id="email" name="email" type="email" placeholder="E-Mail" value="<c:out value="${email}" />" />
		 		</div>
	    	</div>
		</div>
		<div class="row dmpt-row">
	    	<h4>Who are the principal investigators?</h4>
	    	<div class="col-md-12" style="margin-bottom: 10px;">
	    		<input id="sameContact" type="checkbox" />
				<span>Same as point of contact for project data.</span>
	    	</div>
	    	<div class="col-md-12">
	        	<div id="principal">
	     			<input id="firstPrincInput" name="investigator" type="text" class="parent_error" 
	            	placeholder="Principal Investigator" />
	 			</div>
	 			<div style="margin-top: 5px;">
	            	<input id="princButton" type="button" value="Add principal investigator" disabled="disabled" />
	        	</div>    
	    	</div>
		</div>
		<div class="row dmpt-row">
	    	<h4>For which funding are you applying?
	    		<a name="title" title="Funding agencies or even funding programmes demand certain data management standards.
	We support you in meeting their requirements.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	    	</h4>
	    	
	    	<div id="fundings" class="col-md-12">
	        	<select id="funding" name="funding" >
		            <option selected="selected" label="Select" value="Select" >Select</option>
		          	<option value="individual" >DFG Individual Grants Programmes</option>
		        	<option value="coordinated" >DFG Coordinated Programmes</option>
		            <option value="excellence" >DFG Excellence Strategy</option>
		            <option value="research" >DFG Research Infrastructure</option>
		            <option value="international" >DFG International Programmes</option>
		            <option value="other" >Other</option>
		            <option value="none" >None</option>
	        	</select>
	        	<div style="margin-top: 5px;">
	        		<input id="fundingLink" name="fundingLink" type="text" class="before_error" placeholder="Link your funding call or programme"/>
	        		<input id="fundingOther" name="fundingOther" type="text" class="before_error" placeholder="Please name the funding you apply for"/>
	        	</div>
	    	</div>
		</div>
		<div class="row dmpt-row">
			<h4>If you are part of a coordinated programme (Koordinierte Programme, Verbundprojekte), is there any specific coordination, guideline or policy for data management?</h4>
			<div class="col-md-12">
	      		<textarea id="coordinatedProgramme" name="programme" maxlength="1000" rows="3" cols="100" class="before_error" placeholder="Please describe the data management coordination of your programme. Who takes care of it? Is there a data management plan, guideline or policy on which all project members agree? If there are any documents available, please refer to them (by upload, link, DOI or full citation)."></textarea> 
	    	</div>
		</div>
		<div class="row dmpt-row">
			<h4>Are you a member of a research unit (Forschungsgruppe)?
	    		<a href="http://www.dfg.de/en/research_funding/programmes/coordinated_programmes/research_units/index.html" target="_blank">
					<span class="icon-landing-flex icon-link info-blue" ></span>
				</a>
	    	</h4>
	    	<div class="col-md-12">
				<input id="researchUnit" type="checkbox" />
				<span>I am a member of a research unit (Forschergruppe).</span>
			</div>
		</div>
		<div class="row dmpt-row">
			<h4>Please estimate the total volume of your research proposal?</h4>
			<div class="col-md-12">
				<div class="input-icon">
			    	<i>&#8364;</i>
			      	<input id="researchProposal" type="text" pattern="\d*" placeholder="0">
			    </div>
			</div>
		</div>
		<div class="row dmpt-row">
	    	<h4>Which policies or guidelines for research data management will you follow?
	    		<a name="title" title="Does your institution or your funder have certain data management policies or guidelines?">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	    	</h4>
		    <div id="follow-policies">
		    	<div class="col-md-12">
	            	<div>
	                	<label class="mod-cb">
			               	<input name="policies" type="checkbox"/>
			               	<span>DFG Guidelines on the Handling of Research Data</span>
	                	</label>
	                </div>
	                <div>
	                      <label class="mod-cb">
	                      	<input name="policies" type="checkbox"/>
	                      	<span>DFG Guidelines on the Handling of Research Data in Biodiversity Research</span>
	                      </label>
	                </div>
	            </div>
	            <div class="col-md-12">
	           		<div>
	                	<label class="mod-cb">
			               	<input name="policies" type="checkbox"/>
			               	<span>DFG Guidelines for Safeguarding Good Scientific Practice</span>
	                	</label>
	                </div>
	                <div>
	                  	<label class="mod-cb">
		                  	<input id="pol-other" name="policies" type="checkbox" value="Other"/>
		                  	<span>Other</span>
	                  	</label>
	                </div>
	            </div>
	            <div class="col-md-12">
	            	<div>	
	                	<label class="mod-cb">
			               	<input id="pol-none" name="policies" type="checkbox" value="None"/>
			               	<span>None</span>
	                	</label>
	                </div>
	            </div>
		    	
		        <!-- <select id="policies" name="policies" multiple="multiple" size="5">
		            <option value="individual" >DFG Guidelines on the Handling of Research Data</option>
		            <option value="coordinated" >DFG Guidelines on the Handling of Research Data in Biodiversity Research</option>
		            <option value="excellence" >DFG Guidelines for Safeguarding Good Scientific Practice</option>
		            <option value="other" >Other</option>
		            <option value="none" >None</option>
		        </select> -->
		        
		        <div class="col-md-12">
		         	<input id="policyOther" name="policyOther" type="text" class="inputtext_long before_error" placeholder="Other Research Data Policy and Guideline"/>
		         	<input id="policyLink" name="policyLink" type="text" class="inputtext_long before_error" placeholder="Link Research Data Policy or Guideline"/>
		        </div> 
		    </div>   
		</div>
		<div class="row dmpt-row">
			<p>* mandatory</p>
		</div>
	</div>
</section>
