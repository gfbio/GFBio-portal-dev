package org.gfbio.idmg.dcrt.jiraclient.model;

import java.util.Arrays;
import java.util.List;

public class Fields {
	
	public Project project;
	public String summary;
	public IssueType issuetype;
	public Reporter reporter;
	public String description;
	public Assignee assignee;
	
	public String customfield_10010;
	public List<Customfield_10217> customfield_10217;
	public String customfield_10500;
	
	public Fields(){
	}
	
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

	public Reporter getReporter() {
		return reporter;
	}

	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public IssueType getIssuetype() {
		return issuetype;
	}

	public void setIssuetype(IssueType issuetype) {
		this.issuetype = issuetype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Assignee getAssignee() {
		return assignee;
	}

	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}

	public String getCustomfield_10010() {
		return customfield_10010;
	}

	public void setCustomfield_10010(String customfield_10010) {
		this.customfield_10010 = customfield_10010;
	}

	public List<Customfield_10217> getCustomfield_10217() {
		return customfield_10217;
	}

	public void setCustomfield_10217(List<Customfield_10217> customfield_10217) {
		this.customfield_10217 = customfield_10217;
	}

	public String getCustomfield_10500() {
		return customfield_10500;
	}

	public void setCustomfield_10500(String customfield_10500) {
		this.customfield_10500 = customfield_10500;
	}

	@Override
	public String toString() {
		return "Fields [project=" + project + ", summary=" + summary + ", issuetype=" + issuetype + ", reporter="
				+ reporter + ", description=" + description + ", assignee=" + assignee + ", customfield_10010="
				+ customfield_10010 + ", customfield_10217=" + customfield_10217
				+ ", customfield_10500=" + customfield_10500 + "]";
	}
	
}
