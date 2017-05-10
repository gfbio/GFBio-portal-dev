package org.gfbio.idmg.dao;

import org.json.simple.JSONObject;

public class GCategory {

	long id;
	String name;
	String label;
	
	public GCategory(long id, String name, String label) {
		this.id = id;
		this.name = name;
		this.label = label;
	}
	
	public GCategory(JSONObject categoryJson) {
        if (categoryJson.containsKey("id") && categoryJson.containsKey("name") && categoryJson.containsKey("label")){
            this.id = Long.valueOf((String) categoryJson.get("id")).longValue();
            this.name = (String) categoryJson.get("name");
            this.label = (String) categoryJson.get("label");
        }
    }
	
	public GCategory() {}
	
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

	@Override
	public String toString() {
		return "GCategory [id=" + id + ", name=" + name + ", label=" + label
				+ "]";
	}
	
}
