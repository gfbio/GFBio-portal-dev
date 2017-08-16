<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>GFBio Services</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>6. GFBio Services</h2>
	</div>
    <div class="row">
        <h4>What GFBio services are you interested in?</h4>
        <div id="gfbioServices" >
        	<div class="col-md-8 col-lg-6">
	           <div>
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Management Plan (DMP) Support</span>
		        </label>
	               <a target="_blank" href="/about/services#service-dmpsupport" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Collection and Assurance</span>
		        </label>
	              	<a target="_blank" href="/about/services#service-datacollection" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		          	<span>Data Curation</span>
	          	</label>
	              	<a target="_blank" href="/about/services#service-datacuration" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Submission</span>
	            </label>
	              	<a target="_blank" href="/about/services#service-datasubmission" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Archiving</span>
	            </label>
	               <a target="_blank" href="/about/services#service-dataarchiving" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Search</span>
	            </label>
	               <a target="_blank" href="/about/services#service-datasearch" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Visualization and Analysis</span>
	            </label>
	               <a target="_blank" href="/about/services#service-dataintegration" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Publication</span>
	            </label>
	               <a target="_blank" href="/about/services#service-datapublication" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
	            	<span>Terminology Service</span>
	           	</label>
	               <a target="_blank" href="/about/services#service-terminologyservice" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Management Training</span>
	            </label>
	               <a target="_blank" href="/about/services#service-datamanagementtraining" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	           </div>
	           <div>	
	               <label class="mod-cb" style="width: 95%">
		            <input name="services" type="checkbox"/>
		            <span>Data Management Cost Estimation</span>
	            </label>
	               <a target="_blank" href="/about/services#service-datamanagementcostestimation" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
	          	</div>
	       	</div>
        </div>
    </div>
    
    <jsp:include page="07_handleInput.jsp" />
</section>