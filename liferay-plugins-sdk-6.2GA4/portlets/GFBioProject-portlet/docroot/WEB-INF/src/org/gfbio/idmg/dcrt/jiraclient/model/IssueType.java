package org.gfbio.idmg.dcrt.jiraclient.model;

public class IssueType {

	public String name;
	
	public IssueType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "IssueType [name=" + name + "]";
	}
	
}
