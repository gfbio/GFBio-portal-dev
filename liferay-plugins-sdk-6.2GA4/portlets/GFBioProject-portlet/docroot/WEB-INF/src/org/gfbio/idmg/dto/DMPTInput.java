package org.gfbio.idmg.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class DMPTInput implements Serializable {

	private static final long serialVersionUID = -9212800098322282803L;

	// General Information
	private String projectName;
	private String category;
	private List<String> reproducible;
	private String reproducibleText;
	private List<String> projectTypes;
	private String projectAbstract;
	private List<String> investigators;
	private String responsibleName;
	private String phoneNumber;
	private String email;
	private GFunding funding;
	private String fundingLink;
	private String coordinatedProgramme;
	private boolean researchUnit;
	private String researchProposal;
	private List<GPolicy> policies; //Kommt aus DB
	private String policyLink;
	private String policyOther;
	
	// Data Collection
	private Boolean physical;
	private Boolean alive;
	private Boolean taxon;
	private Boolean sequenced;
	private List<String> datatypes;
	private String createFormats;
	private String dataVolume;
	private String dataSets;
	private String methodologies;
	
	// Metadata
	private List<GMetadata> metadata;
	private String metadataDescription;
	
	// Ethics
	private List<GLegalRequirement> requirements; //Kommt aus DB 
	private GLicense license;
	private Boolean accessRestriction;
	//if accessRestriction true
	private String accessDuration;
	private String accessReason;
	
	// Preservation and Sharing
	private String backup;
	private List<String> dataArchives; //Vielleicht aus DB?
	private String pid;
	//private boolean estimatingHelp;
	
	public DMPTInput() {}

	public List<String> getAllPolicies() {
		List<String> list = new ArrayList<>();
		for (GPolicy p : policies) {
			list.add(p.getName());
		}
		if (policyOther != null && policyOther != "") {
			list.add(policyOther);
		}
		return list;
	}
	
	public List<String> getAllMetadata() {
		List<String> list = new ArrayList<>();
		for (GMetadata m : metadata) {
			list.add(m.getName() + " (" + m.getVersion() + ")");
		}
		return list;
	}
	
	public List<String> getAllRequirements() {
		List<String> list = new ArrayList<>();
		for (GLegalRequirement l : requirements) {
			list.add(l.getName());
		}
		return list;
	}
}
