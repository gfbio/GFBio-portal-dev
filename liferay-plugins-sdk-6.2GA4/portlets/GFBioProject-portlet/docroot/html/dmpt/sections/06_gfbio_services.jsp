<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="cp" scope="page" value="${renderRequest.getContextPath()}"/>

<h2>GFBio Services</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>6. GFBio Services</h2>
	</div>
    <div id="gfbioServicesStep" class="question_div">
        <h4>What GFBio services are you interested in?</h4>
        <div id="gfbioServices" class="col-md-12">
            <div>
                <input name="services" type="checkbox"/>
                <label>Data Management Plan (DMP) Support</label>
                <a target="_blank" href="${cp}/about/services#service-dmpsupport" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>
                <input name="services" type="checkbox"/>
                <label>Data Collection and Assurance</label>
               	<a target="_blank" href="${cp}/about/services#service-datacollection" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>
                <input name="services" type="checkbox"/>
                <label>Data Curation</label>
               	<a target="_blank" href="${cp}/about/services#service-datacuration" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>
                <input name="services" type="checkbox"/>
                <label>Data Submission</label>
               	<a target="_blank" href="${cp}/about/services#service-datasubmission" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Archiving</label>
                <a target="_blank" href="${cp}/about/services#service-dataarchiving" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Search</label>
                <a target="_blank" href="${cp}/about/services#service-datasearch" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Visualization and Analysis</label>
                <a target="_blank" href="${cp}/about/services#service-dataintegration" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Publication</label>
                <a target="_blank" href="${cp}/about/services#service-datapublication" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Terminology Service</label>
                <a target="_blank" href="${cp}/about/services#service-terminologyservice" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Management Training</label>
                <a target="_blank" href="${cp}/about/services#service-datamanagementtraining" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
            <div>	
                <input name="services" type="checkbox"/>
                <label>Data Management Cost Estimation</label>
                <a target="_blank" href="${cp}/about/services#service-datamanagementcostestimation" >
					<span class="icon-landing-flex icon-information4 info-grey" ></span>
				</a>
            </div>
	            
        </div>
    </div>
    
    <jsp:include page="handleInput.jsp" />
</section>