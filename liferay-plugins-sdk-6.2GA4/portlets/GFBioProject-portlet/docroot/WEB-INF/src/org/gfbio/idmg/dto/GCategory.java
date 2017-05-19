package org.gfbio.idmg.dto;

import org.json.simple.JSONObject;

public class GCategory implements Comparable<GCategory> {

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
	public int compareTo(GCategory o) {
		int i = this.label.compareTo(o.getLabel());
		if (this.name.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}
	
	@Override
	public String toString() {
		return "GCategory [id=" + id + ", name=" + name + ", label=" + label
				+ "]";
	}

}
