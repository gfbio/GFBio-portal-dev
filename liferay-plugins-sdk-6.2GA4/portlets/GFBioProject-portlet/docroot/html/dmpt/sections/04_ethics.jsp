<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Ethics and Legal Compliance</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>4. Ethics and Legal Compliance</h2>
	</div>
	<div class="row">
	    <h4>Which legal requirements will your research data meet? 
	    	<a name="title" href="#" title="Will your data meet any ethical issues or legal requirements such as personally identifiable information? 
Data dealing with abundance of Red List Species needs to be handled according to the legal requirements and may not be easily published .
In terms of handling genetic resources, the Nagoya Protocol has to be considered.
If you feel uncertain about legal requirements, choose 'uncertain' and we support you in identifying your legal requirements.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
	    </h4>
	    <div id="legRequirement" >
		<!-- <select id="requirement" name="requirement" multiple="multiple" size="6"> 
 	           <c:forEach var="req" items="${requirements}"> 
 	           		<option value="${req.id}" title="${req.description}" >${req.name}</option> 
 				</c:forEach> 
 	           <option value="other" >Other</option> 
	           <option value="none" >Not applicable</option> 
 	       	</select> -->
	       	
	       	<div>
				<c:forEach var="legal" items="${requirements}">
					<div class="col-md-6">
						<label class="mod-cb">
							<input id="legal-${legal.label}" name="requirements" type="checkbox" />
							<span title="${legal.description}"><c:out value="${legal.name}" /></span>
						</label>
					</div>
				</c:forEach>
				<div class="col-md-6">
					<label class="mod-cb">
						<input id="legal-other" name="requirements" type="checkbox" />
						<span>Other</span>
					</label>
				</div>
				<div class="col-md-6">
					<label class="mod-cb">
						<input id="legal-none" name="requirements" type="checkbox" />
						<span>Not applicable</span>
					</label>
				</div>
				<div class="col-md-12">
					<input id="requirementOther" name="requirementOther" type="text" class="inputtext_long" placeholder="Other legal requirement"/>
	       		</div>
			</div>
	   	</div>
    </div>
    
	<div class="row">
    	<h4>How will your data be licensed for reuse?
    		<a name="title" href="#" title="The overall goal of GFBio is to provide a sustainable, service oriented, national data infrastructure facilitating data sharing. 
Thus, we support  the idea of  open access to data. Attaching a  corresponding license to your data is  an  important part of data management. 
Open access does not mean everyone can use your data at his leisure. Data can be cited as well as publications can be. Licenses define citation demands as well as  further terms of use, e.g. if the data may be remixed or transformed.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
    	</h4>
    	<div>
	    	<div class="col-md-12">
		       	<select id="licenses" name="licenses" >
		           <c:forEach var="license" items="${licenses}">
						<option value="${license.label}">
							<c:out value="${license.name}" />
						</option>
					</c:forEach>
					<option value="none" >Not applicable</option>
		       	</select>
		       	
		       	<div style="margin-top: 5px;">
					<input id="licenseOther" type="text" class="inputtext_long" 
		        	placeholder="Other license"/>
		       </div> 
		    </div>  
		     	
	       	<!-- <c:forEach var="license" items="${licenses}">
				<div class="col-md-6">
					<label class="mod-cb">
						<input id="license-${license.label}" name="license" type="radio" value="${license.name}" />
						<span><c:out value="${license.name}" /></span>
					</label>
				</div>
			</c:forEach>
			<div class="col-md-6">
				<label class="mod-cb">
					<input id="license-not" name="license" type="radio" />
					<span>Not applicable</span>
				</label>
			</div> -->
	       	
	       <!-- extended data -->
	       <div class="col-md-12">
	       		<a id="licensceUrl" href=""></a>
	       		<span id="licenseDescription"></span>
	       </div>
	   	</div>
    </div>
	<div class="row">
        <h4>Do you need access restriction for your data?</h4>
        <div>
	        <div class="col-xs-6 col-md-3">
	            <label class="mod-cb">
		            <input class="radio_input" name="restriction" type="radio" value="true" />
		            <span>Yes</span>
	            </label>
	        </div>
	        <div class="col-xs-6 col-md-3">
	      		<label class="mod-cb">
	      			<input class="radio_input" name="restriction" type="radio" value="false" />
	                <span>No</span>
	            </label>
	        </div>
        </div>
        <div id="accessYes" class="col-md-12">
        	<label>For how long do you need exclusive use of the data?</label>
        	<input id="accessDuration" name="accessDuration" type="text" class="inputtext_long" />
        	<label>Why do you need exclusive use of the data?</label>
        	<input id="accessReason" name="accessReason" type="text" class="inputtext_long" />
       	</div>
    </div>
</section>