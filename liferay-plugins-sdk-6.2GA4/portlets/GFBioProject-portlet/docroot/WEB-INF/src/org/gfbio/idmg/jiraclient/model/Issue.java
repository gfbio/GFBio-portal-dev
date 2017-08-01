package org.gfbio.idmg.jiraclient.model;

public class Issue {
	
	public Fields fields;

	public Issue(Fields fields) {
		this.fields = fields;
	}

	public Fields getFields() {
		return fields;
	}

	public void setFields(Fields fields) {
		this.fields = fields;
	}

	@Override
	public String toString() {
		return "Issue [fields=" + fields + "]";
	}
	
}