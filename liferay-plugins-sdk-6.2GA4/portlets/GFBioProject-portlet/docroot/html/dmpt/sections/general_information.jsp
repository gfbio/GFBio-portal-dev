<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>General Project Information</h2>
<section>

	<div name="title" class="hidden-md hidden-lg">
		<h2>1. General Project Information</h2>
	</div>
	<div class="row">
		<h4>What's the official name of your research project?</h4>
        <div class="col-md-12">
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
								value="<c:out value="${field.id}"/>"><c:out
									value="${field.name}" /></option>
				</c:forEach>
			</select>
		</div>
	</div>
  	<div class="row">
      	<h4>Is your research data reproducible?
      		<a href="#" title="A onetime observation might be a measurement or a count at a certain point in time or at a certain location, whereas a repetable experiment might be a DNA sequencing which exactly reproduces data.">
				<span class="icon-landing-flex icon-information4" ></span>
			</a>
      	</h4>
      	<div id="nature">
      		<div class="col-xs-6 col-sm-3">
            	<input name="nature" type="radio" value="snapshot" />
            	<label>Onetime observation</label>
     		</div>
      		<div class="col-xs-6 col-sm-3">
		        <input name="nature" type="radio" value="reapeatable" />
		        <label>Repeatable experiments</label>
          	</div>
     	</div>
	</div>
    <div class="row">
   		<h4>Please specify your project type.
   			<a href="#" title="You can combine several types.">
				<span class="icon-landing-flex icon-information4" ></span>
			</a>
   		</h4>
        <div id="projectTypes" >
        	<div class="col-xs-6 col-sm-3">
            	<div>
                	<input name="types" type="checkbox"/>
                    <label>Field Work</label>
                </div>
                <div>
                      <input name="types" type="checkbox"/>
                      <label>Observational</label>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
           		<div>
                	<input name="types" type="checkbox"/>
                    <label>Simulation</label>
                </div>
                <div>
                  	<input name="types" type="checkbox"/>
                    <label>Assimilation</label>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
            	<div>	
                	<input name="types" type="checkbox"/>
                    <label>Experimental</label>
                </div>
                <div>	
                    <input name="types" type="checkbox"/>
                    <label>Laboratory</label>
                </div>
            </div>
            <div class="col-xs-6 col-sm-3">
                <div>
                    <input name="types" type="checkbox"/>
                    <label>Modelling</label>
                </div>
                <div>	
                    <input id="types-cb" name="types" type="checkbox"/>
                    <label>Other</label>
                </div>
            </div>
            <div class="col-md-12">
            	<input id="typesOther" name="typesOther" type="text" />
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
    		<a href="#" title="Who should be contacted in case of any question concerning data management? This might be technical issues as well as questions concerning data policies, legal requirements or data volumes and formats.  
Most commonly this is: you - the one preparing the DMP.">
				<span class="icon-landing-flex icon-information4" ></span>
			</a>
    	</h4>
    	
    	<div id="responsible" style="overflow: auto;">
	 		<div class="col-md-6">
	    		<input id="responsibleName" name="responsibleName" type="text" placeholder="Name" onfocus="getPrincipal()" />
	    	</div>
	    	
		 	<div class="col-md-6" >
		    	<input name="phoneNumber" type="tel" placeholder="Phone Number"/> 
		    </div>
		    
		    <div class="col-md-12" >
	     		<input name="email" type="email" placeholder="E-Mail"/>
	 		</div>
    	</div>
	</div>
	<div class="row">
    	<h4>For which funding are you applying?
    		<a href="#" title="Funding agencies or even funding programmes demand certain data management standards.
We support you in meeting their requirements.">
				<span class="icon-landing-flex icon-information4" ></span>
			</a>
    	</h4>
    	
    	<div id="fundings" class="col-md-12">
        	<select id="funding" name="funding" style="border: 1px solid lightgrey;">
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
    		<a href="#" title="Does your institution or your funder have certain data management policies or guidelines?">
				<span class="icon-landing-flex icon-information4" ></span>
			</a>
    	</h4>
	    <div id="follow-policies" class="col-md-12">
	        <select id="policies" name="policies" multiple="multiple" size="5">
	            <option value="individual" >DFG Guidelines on the Handling of Research Data</option>
	            <option value="coordinated" >DFG Guidelines on the Handling of Research Data in Biodiversity Research</option>
	            <option value="excellence" >DFG Guidelines for Safeguarding Good Scientific Practice</option>
	            <option value="other" >Other</option>
	            <option value="none" >None</option>
	        </select>
	        <div>
	         	<input id="policyOther" name="policyOther" type="text" class="inputtext_long" placeholder="Other Research Data Policy and Guideline"/>
	         	<input id="policyLink" type="text" class="inputtext_long" placeholder="Link Research Data Policy or Guideline"/>
	        </div>
	    </div>   
	</div>
</section>