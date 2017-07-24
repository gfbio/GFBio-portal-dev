<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Documentation and Metadata</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>3. Documentation and Metadata</h2>
	</div>
	<div class="row">
		<h4>What metadata will accompany the data?
			<a href="#" title="In order to be able to read and interpret as well as archive and find your data in future, metadata are needed. 
If you don't know which metadata standard to choose, please select 'other' and describe your type of documentation which will accompany the data.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
		</h4>
		<div id="metadata">
			<div class="col-md-12">
				<c:forEach var="meta" items="${metadata}">
					<div>
						<label><input id="metadata-${meta.label}" name="${meta.label}" type="checkbox" /> 
						<c:out value="${meta.name}" /></label>
					</div>
				</c:forEach>
			</div>
			<div id="metadataDesc" class="col-md-12">
				<textarea rows="3" cols="100" placeholder="Describe your type of documentation which will accompany the data."></textarea>
			</div>
		</div>
	</div>
</section>
