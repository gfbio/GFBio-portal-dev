<div id="handleInput">
	<h4>Send a DMP support request to GFBio, download your DMP or save it to your private dashboard.</h4>

	<div id="finish-wizard" class="row dmpt-row">

		<div class="col-sm-6 ico-container">
			<i class="icon-landing-flex icon-envelop ico-btn"></i>
			<h5>Request Data Management Plan Support</h5>
			<input id="sendDMP" class="wizardblue" type="button" value="Send Request" />
		</div>

		<div class="col-sm-6 ico-container">
			<i class="icon-landing-flex icon-download2 ico-btn"></i>
			<h5>Download PDF-File</h5>
			<input id="downloadDMP" class="wizardblue" type="button" value="Download" />
		</div>

		<div class="col-sm-6 ico-container">
			<i class="icon-landing-flex icon-floppy-disk ico-btn"></i>
			<h5>Save Data Management Plan</h5>
			<input id="saveDMP" class="wizardblue" type="button" value="Save" />
		</div>

		<div class="col-sm-6 ico-container">
			<i class="icon-landing-flex icon-enter ico-btn"></i>
			<h5>Finish Wizard</h5>
			<input id="finishDMP" class="wizardblue" type="button" value="Finish" />
		</div>
	</div>
</div>

<div id="dialog-save" style="display: none;">
	<div id="save-answer" style="text-align: center;"></div>
</div>

<div id="dialog-request" style="display: none;">
	<div id="send-request" class="row request-row" >
		<form id="dialogForm">
			<div class="col-md-12">
				<div class="portlet-msg-alert col-md-12" >
					Please notice that your Data Management Plan will be saved automatically to your dashboard after sending the request.
				</div>
			</div>
			<div class="col-md-12">
				<textarea id="additinal-text" maxlength="1000" rows="5" cols="100"
					placeholder="Would you like to send any additional information or do you have any questions?"></textarea>
			</div>
			<div class="col-md-12">
			<!-- Upload Attachement -->
			</div>
			<h4>What GFBio services are you interested in?</h4>
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
	<jsp:include page="../../idmg/loading_spinner.jsp" />
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
			<p>Your request could not been sent.</p>
		</div>
	</div>
</div>