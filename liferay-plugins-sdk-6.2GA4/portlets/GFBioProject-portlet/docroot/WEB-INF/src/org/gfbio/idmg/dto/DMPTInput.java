package org.gfbio.idmg.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class DMPTInput implements Serializable {

	private static final long serialVersionUID = -9212800098322282803L;

	// General Information
	private String projectName;
	private String category;
	private String reproducible;
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
	private boolean reasearchUnit;
	private String researchProposal;
	private List<GPolicy> policies; //Kommt aus DB
	private String policyLink;
	private String policyOther;
	
	// Data Collection
	private Boolean physical;
	private Boolean alive;
	private Boolean taxon;
	private Boolean sequenced;
	private List<String> dataformats;
	private String createFormats;
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
	private String backup;
	private List<String> dataArchives; //Vielleicht aus DB?
	private String pid;
	private boolean estimatingHelp;
	
	public DMPTInput() {}

}
