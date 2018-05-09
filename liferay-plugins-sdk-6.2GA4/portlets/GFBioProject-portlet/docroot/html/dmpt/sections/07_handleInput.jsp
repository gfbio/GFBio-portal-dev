<div id="handleInput">
	<h4>Send a DMP support request to GFBio, download your DMP or save it to your private dashboard.</h4>

	<div id="pdf-download">

		<h5>Request Data Management Plan Support</h5>
		<div>
			<input id="sendDMP" class="wizardblue" type="button"
				value="Send Request" />
		</div>

		<h5>Download PDF-File</h5>
		<div>
			<input id="downloadDMP" class="wizardblue" type="button"
				value="Download" />
		</div>

		<h5>Save Data Management Plan</h5>
		<div>
			<input id="saveDMP" class="wizardblue" type="button" value="Save" />
		</div>

	</div>
</div>

<div id="dialog-save" style="display: none;">
	<div id="save-answer" style="text-align: center;"></div>
</div>

<div id="dialog-request" style="display: none;">
	<div id="send-request" class="row" >
		<div class="col-md-12">
			<textarea id="additinal-text" rows="5" cols="100"
				placeholder="Would you like to send any additional information or do you have any questions?"></textarea>
		</div>
		<div class="col-md-12">
		<!-- Upload Attachement -->
		</div>
		<h4>What GFBio services are you interested in?</h4>
		<div class="col-md-12">
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Collection and Assurance" /> 
				<span>Data Collection and Assurance</span> 
				<a target="_blank" href="/about/services#service-datacollection">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Curation" />
				<span>Data Curation</span>
				<a target="_blank" href="/about/services#service-datacuration">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Archiving" />
				<span>Data Archiving</span>
				<a target="_blank" href="/about/services#service-dataarchiving">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Visualization and Analysis" />
				<span>Data Visualization and Analysis</span>
				<a target="_blank" href="/about/services#service-dataintegration">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Publication" />
				<span>Data Publication</span>
				<a target="_blank" href="/about/services#service-datapublication">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Terminology Service" />
				<span>Terminology Service</span>
				<a target="_blank" href="/about/services#service-terminologyservice">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
			<div>
				<input name="gfbio_services" type="checkbox" value="Data Management Training" />
				<span>Data Management Training</span>
				<a target="_blank" href="/about/services#service-datamanagementtraining">
					<span class="icon-landing-flex icon-information4 info-grey"></span>
				</a>
			</div>
		</div>
	</div>
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