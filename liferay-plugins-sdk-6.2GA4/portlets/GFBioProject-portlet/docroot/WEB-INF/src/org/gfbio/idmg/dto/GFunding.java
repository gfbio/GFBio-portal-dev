package org.gfbio.idmg.dto;

import org.json.simple.JSONObject;

public class GFunding implements Comparable<GFunding> {

	long id;
	String name;
	String label;
	String fundingId;
	
	public GFunding(long id, String name, String label, String fundingId) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.fundingId = fundingId;
	}
	
	public GFunding(JSONObject fundingJson) {
		if (fundingJson.containsKey("id") && fundingJson.containsKey("name") && fundingJson.containsKey("label")){
            this.id = Long.valueOf((String) fundingJson.get("id")).longValue();
            this.name = (String) fundingJson.get("name");
            this.label = (String) fundingJson.get("label");
            this.fundingId = (String) fundingJson.get("fundingid");
        }
	}

	public GFunding() {}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getFundingId() {
		return fundingId;
	}

	public void setFundingId(String fundingId) {
		this.fundingId = fundingId;
	}

	@Override
	public int compareTo(GFunding o) {
		int i = this.label.compareTo(o.getLabel());
		if (this.label.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}
	
	@Override
	public String toString() {
		return "GFunding [id=" + id + ", name=" + name + ", label=" + label + ", fundingId=" + fundingId + "]";
	}
	
}
