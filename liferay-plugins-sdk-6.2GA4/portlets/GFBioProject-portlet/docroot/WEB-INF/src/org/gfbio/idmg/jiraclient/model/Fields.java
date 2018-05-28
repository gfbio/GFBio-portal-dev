package org.gfbio.idmg.jiraclient.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fields {
	
	public Project project;
	public String summary;
	public IssueType issuetype;
	public Reporter reporter;
	public String description;
	public Assignee assignee;
	
	// request type
	public String customfield_10010;
	
	// DCRT Fields
	// Datacenters
	public List<Customfield_10217> customfield_10217;
	// Radio input answers
	public String customfield_10500;
	
	// DMPT Fields
	// Project Name
	public String customfield_10206;
	// Project Abstract
	public String customfield_10301;
	// Principal Investigators
	public String customfield_10204; 
	// Funding
	// public Customfield_10223 customfield_10223; not up to date
	// Project Type
	// public Customfield_10220 customfield_10220; not up to date
	// Project Work Types
	// public List<Customfield_10221> customfield_10221; not up to date
	// Project Data Contact
	// public String customfield_10222; not up to date
	// Data License
	// public Customfield_10202 customfield_10202; not up to date
	// Physical Objects
	// public Customfield_10214 customfield_10214; not up to date
	
	
	public Fields(Project project, String summary, IssueType issuetype, Reporter reporter, String description,
			Assignee assignee, String customfield_10010, List<Customfield_10217> customfield_10217,
			String customfield_10500) {
		this.project = project;
		this.summary = summary;
		this.issuetype = issuetype;
		this.reporter = reporter;
		this.description = description;
		this.assignee = assignee;
		this.customfield_10010 = customfield_10010;
		this.customfield_10217 = customfield_10217;
		this.customfield_10500 = customfield_10500;
	}
	
	public Fields(Project project, String summary, IssueType issuetype, Reporter reporter, String description,
			Assignee assignee, String customfield_10010, String customfield_10206, String customfield_10301, 
			String customfield_10204) {
		this.project = project;
		this.summary = summary;
		this.issuetype = issuetype;
		this.reporter = reporter;
		this.description = description;
		this.assignee = assignee;
		this.customfield_10010 = customfield_10010;
		this.customfield_10206 = customfield_10206;
		this.customfield_10301 = customfield_10301;
		this.customfield_10204 = customfield_10204;
		//this.customfield_10223 = customfield_10223;
		//this.customfield_10220 = customfield_10220;
		//this.customfield_10221 = customfield_10221;
		//this.customfield_10222 = customfield_10222;
		//this.customfield_10202 = customfield_10202;
		//this.customfield_10214 = customfield_10214;
	}
}
