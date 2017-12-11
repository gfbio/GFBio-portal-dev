package org.gfbio.idmg.dto;

import java.io.Serializable;
import java.util.List;

public class DMPTInput implements Serializable {

	private static final long serialVersionUID = -9212800098322282803L;

	// General Information
	private String projectName;
	private String category;
	private String reproducible;
	private List<String> projectTypes;
	private String projectAbstract;
	private List<String> investigators;
	private String responsibleName;
	private String phoneNumber;
	private String email;
	private GFunding funding;
	private String fundingLink;
	private List<GPolicy> policies; //Kommt aus DB
	private String policyLink;
	private String policyOther;
	
	// Data Collection
	private Boolean physical;
	private Boolean alive;
	private Boolean taxon;
	private Boolean sequenced;
	private List<String> dataformats;
	private boolean openlyDocumented;
	private String dataVolume;
	private String dataSets;
	private String methodologies;
	
	// Metadata
	private List<GMetadata> metadata;
	private String metadataDescription;
	
	// Ethics
	private GLegalRequirement requirement; //Kommt aus DB 
	private GLicense license;
	private boolean accessRestriction;
	//if accessRestriction true
	private String accessDuration;
	private String accessReason;
	
	// Preservation and Sharing
	private List<String> dataArchives; //Vielleicht aus DB?
	private String pid;
	private boolean estimatingHelp;
	
	// GFBio Services
	private List<String> gfbioServices;
	
	public DMPTInput() {}

	public DMPTInput(String projectName, String category, String reproducible, List<String> projectTypes,
			String projectAbstract, List<String> investigators, String responsibleName, String phoneNumber,
			String email, GFunding funding, String fundingLink, List<GPolicy> policies,
			String policyLink, String policyOther, Boolean physical, Boolean alive, Boolean taxon,
			Boolean sequenced, List<String> dataformats, boolean openlyDocumented, String dataVolume, String dataSets,
			String methodologies, List<GMetadata> metadata, String metadataDescription, GLegalRequirement requirement,
			GLicense license, boolean accessRestriction, String accessDuration, String accessReason,
			List<String> dataArchives, String pid, boolean estimatingHelp, List<String> gfbioServices) {
		super();
		this.projectName = projectName;
		this.category = category;
		this.reproducible = reproducible;
		this.projectTypes = projectTypes;
		this.projectAbstract = projectAbstract;
		this.investigators = investigators;
		this.responsibleName = responsibleName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.funding = funding;
		this.fundingLink = fundingLink;
		this.policies = policies;
		this.policyLink = policyLink;
		this.policyOther = policyOther;
		this.physical = physical;
		this.alive = alive;
		this.taxon = taxon;
		this.sequenced = sequenced;
		this.dataformats = dataformats;
		this.openlyDocumented = openlyDocumented;
		this.dataVolume = dataVolume;
		this.dataSets = dataSets;
		this.methodologies = methodologies;
		this.metadata = metadata;
		this.metadataDescription = metadataDescription;
		this.requirement = requirement;
		this.license = license;
		this.accessRestriction = accessRestriction;
		this.accessDuration = accessDuration;
		this.accessReason = accessReason;
		this.dataArchives = dataArchives;
		this.pid = pid;
		this.estimatingHelp = estimatingHelp;
		this.gfbioServices = gfbioServices;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReproducible() {
		return reproducible;
	}

	public void setReproducible(String reproducible) {
		this.reproducible = reproducible;
	}

	public List<String> getProjectTypes() {
		return projectTypes;
	}

	public void setProjectTypes(List<String> projectTypes) {
		this.projectTypes = projectTypes;
	}

	public String getProjectAbstract() {
		return projectAbstract;
	}

	public void setProjectAbstract(String projectAbstract) {
		this.projectAbstract = projectAbstract;
	}

	public List<String> getInvestigators() {
		return investigators;
	}

	public void setInvestigators(List<String> investigators) {
		this.investigators = investigators;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GFunding getFunding() {
		return funding;
	}

	public void setFunding(GFunding funding) {
		this.funding = funding;
	}

	public Boolean getPhysical() {
		return physical;
	}

	public void setPhysical(Boolean physical) {
		this.physical = physical;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public Boolean getTaxon() {
		return taxon;
	}

	public void setTaxon(Boolean taxon) {
		this.taxon = taxon;
	}

	public Boolean getSequenced() {
		return sequenced;
	}

	public void setSequenced(Boolean sequenced) {
		this.sequenced = sequenced;
	}

	public List<String> getDataformats() {
		return dataformats;
	}

	public void setDataformats(List<String> dataformats) {
		this.dataformats = dataformats;
	}

	public boolean isOpenlyDocumented() {
		return openlyDocumented;
	}

	public void setOpenlyDocumented(boolean openlyDocumented) {
		this.openlyDocumented = openlyDocumented;
	}

	public String getDataVolume() {
		return dataVolume;
	}

	public void setDataVolume(String dataVolume) {
		this.dataVolume = dataVolume;
	}

	public String getDataSets() {
		return dataSets;
	}

	public void setDataSets(String datasets) {
		this.dataSets = datasets;
	}

	public String getMethodologies() {
		return methodologies;
	}

	public void setMethodologies(String methodologies) {
		this.methodologies = methodologies;
	}

	public List<GMetadata> getMetadata() {
		return metadata;
	}

	public void setMetadata(List<GMetadata> metadata) {
		this.metadata = metadata;
	}

	public GLicense getLicense() {
		return license;
	}

	public void setLicense(GLicense license) {
		this.license = license;
	}

	public boolean isAccessRestriction() {
		return accessRestriction;
	}

	public void setAccessRestriction(boolean accessRestriction) {
		this.accessRestriction = accessRestriction;
	}

	public String getAccessDuration() {
		return accessDuration;
	}

	public void setAccessDuration(String accessDuration) {
		this.accessDuration = accessDuration;
	}

	public String getAccessReason() {
		return accessReason;
	}

	public void setAccessReason(String accessReason) {
		this.accessReason = accessReason;
	}

	public List<String> getDataArchives() {
		return dataArchives;
	}

	public void setDataArchives(List<String> dataArchives) {
		this.dataArchives = dataArchives;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public boolean isEstimatingHelp() {
		return estimatingHelp;
	}

	public void setEstimatingHelp(boolean estimatingHelp) {
		this.estimatingHelp = estimatingHelp;
	}

	public List<String> getGfbioServices() {
		return gfbioServices;
	}

	public void setGfbioServices(List<String> gfbioServices) {
		this.gfbioServices = gfbioServices;
	}

	public List<GPolicy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<GPolicy> policies) {
		this.policies = policies;
	}

	public GLegalRequirement getRequirement() {
		return requirement;
	}

	public void setRequirement(GLegalRequirement requirement) {
		this.requirement = requirement;
	}

	public String getMetadataDescription() {
		return metadataDescription;
	}

	public void setMetadataDescription(String metadataDescription) {
		this.metadataDescription = metadataDescription;
	}

	public String getFundingLink() {
		return fundingLink;
	}

	public void setFundingLink(String fundingLink) {
		this.fundingLink = fundingLink;
	}

	public String getPolicyLink() {
		return policyLink;
	}

	public void setPolicyLink(String policyLink) {
		this.policyLink = policyLink;
	}

	public String getPolicyOther() {
		return policyOther;
	}

	public void setPolicyOther(String policyOther) {
		this.policyOther = policyOther;
	}

	@Override
	public String toString() {
		return "DMPTInput [projectName=" + projectName + ", category=" + category + ", reproducible=" + reproducible
				+ ", projectTypes=" + projectTypes + ", projectAbstract=" + projectAbstract + ", investigators="
				+ investigators + ", responsibleName=" + responsibleName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", funding=" + funding + ", fundingLink=" + fundingLink + ", policies=" + policies
				+ ", policyLink=" + policyLink + ", policyOther=" + policyOther + ", physical=" + physical + ", alive="
				+ alive + ", taxon=" + taxon + ", sequenced=" + sequenced + ", dataformats=" + dataformats
				+ ", openlyDocumented=" + openlyDocumented + ", dataVolume=" + dataVolume + ", dataSets=" + dataSets
				+ ", methodologies=" + methodologies + ", metadata=" + metadata + ", metadataDescription="
				+ metadataDescription + ", requirement=" + requirement + ", license=" + license + ", accessRestriction="
				+ accessRestriction + ", accessDuration=" + accessDuration + ", accessReason=" + accessReason
				+ ", dataArchives=" + dataArchives + ", pid=" + pid + ", estimatingHelp=" + estimatingHelp
				+ ", gfbioServices=" + gfbioServices + "]";
	}

}
