<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Ethics and Legal Compliance</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>4. Ethics and Legal Compliance</h2>
	</div>
	<div class="row">
	    <h4>Which legal requirements will your research data meet? 
	    	<a href="#" title="Will your data meet any ethical issues or legal requirements such as personally identifiable information? 
Data dealing with abundance of Red List Species needs to be handled according to the legal requirements and may not be easily published .
In terms of handling genetic resources, the Nagoya Protocol has to be considered.
If you feel uncertain about legal requirements, choose 'uncertain' and we support you in identifying your legal requirements.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
	    </h4>
	    <div id="sensitiveData" class="col-md-12">
	    
	    	<!-- <div class="col-md-12">
				<c:forEach var="legal" items="${sensitiveData}">
					<div>
						<input id="legal-${legal.label}" name="${legal.label}" type="checkbox" /> 
						<label><c:out value="${legal.name}" /></label>
					</div>
				</c:forEach>
			</div> -->
	       	<select id="sensitive" name="sensitive" multiple="multiple" size="6">
	           <option value="individual" >Nagoya Protocol</option>
	           <option value="coordinated" >Red List</option>
	           <option value="excellence" >Personally Identifiable Information</option>
	           <option value="other" >Other</option>
	           <option value="uncertain" >Uncertain</option>
	           <option value="none" >None</option>
	       	</select>
	       	<div>
				<input id="sensitiveOther" name="sensitiveOther" type="text" class="inputtext_long" 
	        	placeholder="Other sensitive data"/>
	       </div>
	   	</div>
    </div>
	<div class="row">
    	<h4>How will your data be licensed for reuse?
    		<a href="#" title="The overall goal of GFBio is to provide a sustainable, service oriented, national data infrastructure facilitating data sharing. 
Thus, we support  the idea of  open access to data. Attaching a  corresponding license to your data is  an  important part of data management. 
Open access does not mean everyone can use your data at his leisure. Data can be cited as well as publications can be. Licenses define citation demands as well as  further terms of use, e.g. if the data may be remixed or transformed.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
    	</h4>
    	<div class="col-md-12">
	       	<select id="licenses" name="licenses" multiple="multiple" size="8">
	           <c:forEach var="license" items="${licenses}">
					<option value="<c:out value="${license.label}"/>"
							title="<c:out value="${license.name}"/>">
							<c:out value="${license.label}" />
					</option>
				</c:forEach>
	       	</select>
	       	<div>
				<input id="licenseOther" name="licenseOther" type="text" class="inputtext_long" 
	        	placeholder="Other license"/>
	       </div>
	   	</div>
    	
    </div>
	<div class="row">
        <h4>Do you need access restriction for your data?</h4>
        <div class="col-md-12">
	        <div style="display: block;">
	            <input class="radio_input" name="restriction"
	                type="radio" value="yes" />
	          	<label>Yes</label>
	        </div>
	        <div style="display: block;">
	      		<input class="radio_input" name="restriction"
	                type="radio" value="no" />
	          	<label>No</label>
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