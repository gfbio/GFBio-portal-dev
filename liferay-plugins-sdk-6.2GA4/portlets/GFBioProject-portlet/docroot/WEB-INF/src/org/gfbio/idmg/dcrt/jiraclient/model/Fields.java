package org.gfbio.idmg.dcrt.jiraclient.model;

public class Fields {
	
	public Project project;
	public String summary;
	public IssueType issuetype;
	public Reporter reporter;
	
	public String customfield_10206;
	public String customfield_10011;
	public String customfield_10021;
	public String customfield_10031;
	public String customfield_10041;
	public String customfield_10051;
	public String customfield_10061;
	
	public Fields(){
	}
	
	public Fields(Project project, String summary, IssueType issuetype, Reporter reporter, String dataCenter,
			String physicalObjects, String primarySequenced, String taxonBased, String deadOrAlive, String material,
			String category) {
		super();
		this.project = project;
		this.summary = summary;
		this.issuetype = issuetype;
		this.reporter = reporter;
		this.customfield_10206 = "Data Center: " + dataCenter;
//		this.customfield_10011 = "Physical objects: " + physicalObjects;
//		this.customfield_10021 = "Primary sequenced" + primarySequenced;
//		this.customfield_10031 = "Taxon-based: " + taxonBased;
//		this.customfield_10041 = "Alive" + deadOrAlive;
//		this.customfield_10051 = "Material" + material;
//		this.customfield_10061 = "Category" + category;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public IssueType getIssueType() {
		return issuetype;
	}
	public void setIssueType(IssueType issueType) {
		this.issuetype = issueType;
	}
	public Reporter getReporter() {
		return reporter;
	}
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}
	public String getDataCenter() {
		return customfield_10206;
	}
	public void setDataCenter(String dataCenter) {
		this.customfield_10206 = dataCenter;
	}
	public String getPhysicalObjects() {
		return customfield_10011;
	}
	public void setPhysicalObjects(String physicalObjects) {
		this.customfield_10011 = physicalObjects;
	}
	public String getPrimarySequenced() {
		return customfield_10021;
	}
	public void setPrimarySequenced(String primarySequenced) {
		this.customfield_10021 = primarySequenced;
	}
	public String getTaxonBased() {
		return customfield_10031;
	}
	public void setTaxonBased(String taxonBased) {
		this.customfield_10031 = taxonBased;
	}
	public String getDeadOrAlive() {
		return customfield_10041;
	}
	public void setDeadOrAlive(String deadOrAlive) {
		this.customfield_10041 = deadOrAlive;
	}
	public String getMaterial() {
		return customfield_10051;
	}
	public void setMaterial(String material) {
		this.customfield_10051 = material;
	}
	public String getCategory() {
		return customfield_10061;
	}
	public void setCategory(String category) {
		this.customfield_10061 = category;
	}
	
	@Override
	public String toString() {
		return "Fields [project=" + project + ", summary=" + summary + ", issueType=" + issuetype + ", reporter="
				+ reporter + ", dataCenter=" + customfield_10206 + ", physicalObjects=" + customfield_10011
				+ ", primarySequenced=" + customfield_10021 + ", taxonBased=" + customfield_10031 + ", deadOrAlive="
				+ customfield_10041 + ", material=" + customfield_10051 + ", category=" + customfield_10061 + "]";
	}

}
