<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>General Project Information</h2>
<section>
	<div id="dmppreview" style="display: none;">
		<h2>Do you want to load an existing Data Management Plan?</h2>
		<div class="col-xs-12" style="margin-top: 10px;">
			<div class="col-md-6 col-sm-5 col-xs-10" style="margin-top: 5px;">
				<select id="dmps" name="dmps" style="width: 100% !important; height: 29px;">
					<c:forEach var="dmp" items="${dmpsforuser}">
						<option label="<c:out value="${dmp.name}" />"
									value="<c:out value="${dmp.dmpID}"/>"><c:out
										value="${dmp.name}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-1 col-sm-2 col-xs-2" style="margin-top: 5px;">
	           	<input id="delete" style="width: 100% !important; min-height: 29px;" type="button" class="icon-landing-flex icon-bin" value="&#xee44"/>
	        </div>
			<div class="col-md-5 col-sm-5 col-xs-12" style="margin-top: 5px;">
	           	<input id="load" style="width: 100% !important" type="button" value="Load Data Management Plan"/>
	        </div>
        </div>
        <div class="col-xs-12" style="margin-top: 20px;">
	        <div class="col-xs-12">
	           	<input id="start" class="startdmp" type="button" value="New Data Management Plan"/>
	        </div>
        </div>
	</div>
	
	<div id="dialog-delete" style="display: none;">
		<div id="delete-answer" style="text-align: center;"></div>
	</div>
	
	<div id="generalinformation">
		<div name="title" title="Test" class="hidden-md hidden-lg">
			<h2>1. General Project Information</h2>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div id="save-message" class="portlet-msg-alert col-md-12" style="display: none;">
					Only logged in users can save their inputs at the end of the wizard. Please <a href="${portalurl}/sign-in?saveLastPath=0"><span style="color:#006400; font-weight:bold">sign in</span></a> to enable the feature.
				</div>
			</div>
			<h4>What's the official name of your research project?</h4>
	        <div class="col-md-12">
	        	<input id="dmpId" type="hidden" value="0"/>
				<input id="name" name="projectName" type="text" placeholder="Project Name"/> <!-- required -->
			</div>
		</div>
		<div class="row">
			<h4>Please select a category</h4>
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
	  	<div class="row">
	      	<h4>Is your research data reproducible?
	      		<a name="title" title="Imagine your research data gets lost. Would you (or someone else) be able to reproduce your data? What effort or resources would be necessary?">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	      	</h4>
	      	<div id="nature">
	      		<div class="col-xs-12 col-sm-4">
	            	<label class="mod-cb">
	            		<input name="nature" type="radio" value="Onetime observation" />
	            		<span>Onetime observation</span>
	            	</label>
	     		</div>
	      		<div class="col-xs-12 col-sm-4">
			        <label class="mod-cb">
				        <input name="nature" type="radio" value="Reapeatable experiments" />
				        <span>Repeatable experiments</span>
			        </label>
	          	</div>
	          	<div class="col-xs-12 col-sm-4">
			        <label class="mod-cb">
				        <input name="nature" type="radio" value="Time Series" />
				        <span>Time Series</span>
			        </label>
	          	</div>
	          	<div class="col-sm-12" style="margin-top: 10px;">
	      			<textarea id="reproducibleText" rows="3" cols="100" placeholder="Add additional information (e.g. data reproduction might cause high costs or a lot of effort)."></textarea> 
	    		</div>
	     	</div>
		</div>
	    <div class="row">
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
	            		<input id="typesOther" name="typesOther" type="text" placeholder="Other project type" />
	            </div>
	        </div>
	        
		</div>
		<div class="row">
	    	<h4>Provide your project abstract or describe your work and the data involved.</h4>
	        <div id="projectAbstract" class="col-md-12">
	      		<textarea id="abstract" rows="5" cols="100" placeholder="Project Abstract"></textarea> 
	    	</div>
		</div>
		<div class="row">
	    	<h4>Who is/are the principal investigator/s?</h4>
	    	<div class="col-md-12">
	        	<div id="principal">
	        	<!-- required -->
	     		<input id="firstPrincInput" name="investigator" type="text"  
	            	placeholder="Principal Investigator" />
	 			</div>
	 			<div style="margin-top: 5px;">
	            	<input id="princButton" type="button" value="Add principal investigator" disabled="disabled" />
	        	</div>    
	    	</div>
		</div>
		<div class="row">
	    	<h4>Who is the point of contact for the project data?
	    		<a name="title" title="Who should be contacted in case of any question concerning data management? This might be technical issues as well as questions concerning data policies, legal requirements or data volumes and formats.  
	Most commonly this is: you - the one preparing the DMP.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	    	</h4>
	    	
	    	<div id="responsible" style="overflow: auto;">
		 	<div class="col-md-6">
		    		<input id="responsibleName" name="responsibleName" type="text" placeholder="Name" 
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
		<div class="row">
	    	<h4>For which funding are you applying?
	    		<a name="title" title="Funding agencies or even funding programmes demand certain data management standards.
	We support you in meeting their requirements.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	    	</h4>
	    	
	    	<div id="fundings" class="col-md-12">
	        	<select id="funding" name="funding" >
		            <option selected="selected" label="Select" value="select" >Select</option>
		          	<option value="individual" >DFG Individual Grants Programmes</option>
		        	<option value="coordinated" >DFG Coordinated Programmes</option>
		            <option value="excellence" >DFG Excellence Strategy</option>
		            <option value="research" >DFG Research Infrastructure</option>
		            <option value="international" >DFG International Programmes</option>
		            <option value="other" >Other</option>
		            <option value="none" >None</option>
	        	</select>
	        	<div style="margin-top: 5px;">
	        		<input id="fundingLink" type="text" placeholder="Link your funding call or programme"/>
	        		<input id="fundingOther" name="fundingOther" type="text" placeholder="Please name the funding you apply for"/>
	        	</div>
	    	</div>
		</div>
		<div class="row">
	    	<h4>Which policies or guideliness for research data management will you follow?
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
		        
		        <div>
		         	<input id="policyOther" name="policyOther" type="text" class="inputtext_long" placeholder="Other Research Data Policy and Guideline"/>
		         	<input id="policyLink" type="text" class="inputtext_long" placeholder="Link Research Data Policy or Guideline"/>
		        </div> 
		    </div>   
		</div>
	</div>
</section>
