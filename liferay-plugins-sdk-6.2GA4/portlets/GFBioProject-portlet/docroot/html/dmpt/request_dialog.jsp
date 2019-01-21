<div id="dialog-request" style="display: none;">
	<div id="send-request" class="row request-row" >
		<form id="dialogForm">
			<div class="col-md-12">
				<div id="autosaveMessage" class="portlet-msg-alert col-md-12" >
					Please notice that your Data Management Plan will be saved automatically to your dashboard after sending the request.
				</div>
			</div>
			<div>
				<h4>Message</h4>
			</div>
			<div class="col-md-12">
				<textarea id="additionalText" name="additionalText" class="before_error" maxlength="1000" rows="5" cols="100"
					placeholder="Would you like to send any additional information or do you have any questions?"></textarea>
			</div>
			<!-- Upload Attachement -->
			<!-- <div>
				<h4>Upload Attachement</h4>
			</div>
			<div class="col-md-12">
				
				<input type="file" id="file" name="file1" />
			</div> -->
			<div>
				<h4>What GFBio services are you interested in?</h4>
			</div>
			<div class="col-md-12">
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Collection and Assurance" /> 
					<label>Data Collection and Assurance</label> 
					<a target="_blank" href="/about/services#service-datacollection">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Curation" />
					<label>Data Curation</label>
					<a target="_blank" href="/about/services#service-datacuration">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Archiving" />
					<label>Data Archiving</label>
					<a target="_blank" href="/about/services#service-dataarchiving">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Visualization and Analysis" />
					<label>Data Visualization and Analysis</label>
					<a target="_blank" href="/about/services#service-dataintegration">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Publication" />
					<label>Data Publication</label>
					<a target="_blank" href="/about/services#service-datapublication">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Terminology Service" />
					<label>Terminology Service</label>
					<a target="_blank" href="/about/services#service-terminologyservice">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
				<div>
					<input name="gfbio_services" type="checkbox" value="Data Management Training" />
					<label>Data Management Training</label>
					<a target="_blank" href="/about/services#service-datamanagementtraining">
						<span class="icon-landing-flex icon-link info-grey"></span>
					</a>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="../idmg/loading_spinner.jsp" />
	<div id="successAnswer" style="display: none;">
		<div class="answer-wrapper">
			<img alt="Icon Check"
				src="/GFBioProject-portlet/images/circle-check.png">
			<p>Your request has been successfully sent.</p>
		</div>
	</div>
	<div id="errorAnswer" style="display: none;">
		<div class="answer-wrapper">
			<img alt="Icon Check"
				src="/GFBioProject-portlet/images/circle-close.png">
			<p>Your request could not been sent. Please try again and contact us if the problem persists!</p>
		</div>
	</div>
</div>