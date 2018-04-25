<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Documentation and Metadata</h2>
<section>
	<div name="title" class="hidden-md hidden-lg">
		<h2>3. Documentation and Metadata</h2>
	</div>
	<div class="row">
		<h4>Which metadata schema does your data support (if any)?
			<a name="title" title="In order to be able to read and interpret as well as archive and find your data in future, metadata are needed. 
If you don't know which metadata standard to choose, please select 'other' and describe your type of documentation which will accompany the data.">
				<span class="icon-landing-flex icon-information4 info-blue" ></span>
			</a>
		</h4>
		<div id="metadata">
			<div class="col-md-12" >
				<c:forEach var="meta" items="${metadata}">
					<div>
						<label class="mod-cb">
							<input id="metadata-${meta.id}" name="metadata" type="checkbox" value="${meta.id}" />
							<span>
								<c:out value="${meta.name}" />
								<c:if test="${not empty meta.version}">
    								<c:out value=", ${meta.version}"/>
								</c:if>
							</span>
						</label>
						<div id="metainformation-${meta.id}" name="metainformation" class="meta-information">
							<a id="metaurl-${meta.id}" href="${meta.url}" target="_blank" ><c:out value="${meta.url}"/></a>
							<p id="metadesc-${meta.id}"><c:out value="${meta.description}"/></p>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-12">
				<textarea id="metadataDesc" rows="3" cols="100" placeholder="Describe your type of documentation which will accompany the data."></textarea>
			</div>
		</div>
	</div>
</section>
