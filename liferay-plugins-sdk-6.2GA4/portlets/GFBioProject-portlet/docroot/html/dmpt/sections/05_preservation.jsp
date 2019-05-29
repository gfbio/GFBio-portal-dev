
<h2>Preservation and Sharing</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>5. Preservation and Sharing</h2>
	</div>
	<div id="lastTab">
		<div class="row dmpt-row">
	        <h4>When will your data be submitted to GFBio?
	        	<a name="title" title="Submit the final and quality-assured version of your datasets. Metadata will be curated by our data centers and will subsequently be published via the GFBio portal. Research data will be published within the limit of their respective embargo and license.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	        </h4>
	        <div id="dataSubmit" class="col-md-12">
            	<div>
               		<input name="dataSubmission" type="checkbox"/>
	               	<span>Data linked to an article (or another kind of publication) will be submitted before or at the same time as the publication of the article. This option will allow you to refer to your dataset via unique identifier (e.g. DOI) within your article.</span>
                </div>
                <div>
                   	<input name="dataSubmission" type="checkbox"/>
                   	<span>Datasets will continously be submitted during the project´s runtime.</span>
                </div>
                <div>
                   	<input name="dataSubmission" type="checkbox"/>
                   	<span>All datasets will be submitted at the end of the project.</span>
                </div>
                <div>
                   	<input name="dataSubmission" type="checkbox"/>
                   	<span>All datasets will be submitted no later than one year after the project's end.</span>
                </div>
                <div>
                   	<input id="submit-cb" name="dataSubmission" type="checkbox"/>
                   	<span>Other submission plan</span>
                </div>
	            <div>
       				<input id="submitOther" name="submitOther" class="before_error" type="text" placeholder="Other submission plan" />
	            </div>
	        </div>
	    </div>
		<div class="row dmpt-row">
			<h4>How is your data backed up during project runtime? Who is responsible for data backup?
				<a name="title" title="With which technologies and in which locations are your data stored? Are there regular backups and at what intervals? Who is responsible for data backup and which service providers (e.g. local IT support) are involved?">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
			</h4>
			<div class ="col-md-12">
				<textarea id="backup" name="backup" class="before_error" maxlength="1000" rows="5" cols="100" placeholder="Please explain as detailed as possible."></textarea>
			</div>
		</div>
		<div class="row dmpt-row">
	        <h4>Where will your data be long-term archived?
	        	<a name="title" title="If you are not sure which data center fits best for your data, choose &#34;GFBio Data Centers&#34; and our curation experts will find the best solution for storing your data within GFBio.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	        </h4>
	        <div id="dataArchives">
	        	<div class="col-xs-12 col-sm-6">
	            	<div>
	                	<label class="mod-cb">
			               	<input name="archives" type="checkbox"/>
			               	<span>GFBio Data Centers</span>
	                	</label>
	                </div>
	                <div>
	                    <label class="mod-cb">
	                      	<input name="archives" type="checkbox"/>
	                      	<span>DSMZ</span>
	                    </label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	           		<div>
	                	<label class="mod-cb">
			               	<input name="archives" type="checkbox"/>
			               	<span>ENA</span>
	                	</label>
	                </div>
	                <div>
	                  	<label class="mod-cb">
		                  	<input name="archives" type="checkbox"/>
		                  	<span>MfN</span>
	                  	</label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	            	<div>	
	                	<label class="mod-cb">
			               	<input name="archives" type="checkbox"/>
			               	<span>PANGAEA</span>
	                	</label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
		                    <input name="archives" type="checkbox"/>
		                    <span>SMNS</span>
	                    </label>
	                </div>
	            </div>
	            <div class="col-xs-12 col-sm-6">
	            	<div>	
	                	<label class="mod-cb">
			               	<input name="archives" type="checkbox"/>
			               	<span>ZFMK</span>
	                	</label>
	                </div>
	                <div>	
	                    <label class="mod-cb">
		                    <input id="archives-cb" name="archives" type="checkbox" value="Other"/>
		                    <span>Other</span>
	                    </label>
	                </div>
	            </div>
	            
	            <div class="col-md-12">
	             	<input id="archiveOther" name="archiveOther" class="before_error" type="text" class="inputtext_long" 
	             	placeholder="Other archive"/>
	            </div>
	        </div>
	    </div>
		<div class="row dmpt-row">
	        <h4>Do you need a persistent idenfifier (e.g. ePIC PID / DOI) for your data?
	        	<a name="title" title="With a persistent identifiers (PID) - like DOI - you make your data citable and linkable to publications which is increasingly required by journals. GFBio recommends to add a PID to your data.">
					<span class="icon-landing-flex icon-information4 info-blue" ></span>
				</a>
	        </h4>
	        <div id="persistentIdentifier">
		        <div class="col-md-3">
		            <label class="mod-cb">
			            <input class="radio_input" name="pid" type="radio" value="Yes" />
			            <span>Yes (recommended)</span>
					</label>
		        </div>
		        <div class="col-md-3">
	                <label class="mod-cb">
	                	<input class="radio_input" name="pid" type="radio" value="No" />
		               	<span>No</span>
		            </label>
		        </div>
		        <div class="col-md-3">
		        	<label class="mod-cb">
		        		<input class="radio_input" name="pid" type="radio" value="Dont know yet" />
	        			<span>Don't know yet</span>
	        		</label>
		        </div>
	        </div>
	    </div>
		<!-- <div class="row dmpt-row">
		    <h4>Do you need help estimating the cost and effort for data management?</h4>
		    <div id="needHelp" class="col-md-12">
		    	<div class="ccol-md-3">
		            <label class="mod-cb">
		            	<input class="radio_input" name="help" type="radio" value="true" />
		            	<span>Yes</span>
		            </label>
		        </div>
		        <div class="col-md-3">
		            <label class="mod-cb">
		            	<input class="radio_input" name="help" type="radio" value="false" />
		            	<span>No</span>
		            </label>
		        </div>
		    </div>
		</div> -->
	</div>
	
	<jsp:include page="06_finish_wizard.jsp" />
</section>