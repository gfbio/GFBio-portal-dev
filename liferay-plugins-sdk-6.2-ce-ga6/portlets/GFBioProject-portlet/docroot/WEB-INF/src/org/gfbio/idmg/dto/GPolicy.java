package org.gfbio.idmg.dto;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class GPolicy implements Comparable<GPolicy>, Serializable {

	private static final long serialVersionUID = 3101060534949900447L;

	long id;
	String name;
	String label;
	String description;
	String url;
	
	public GPolicy(long id, String name, String label, String description, String url) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.description = description;
		this.url = url;
	}
	
	public GPolicy(JSONObject fundingJson) {
		if (fundingJson.containsKey("id") && fundingJson.containsKey("name") && fundingJson.containsKey("label")){
            this.id = Long.valueOf((String) fundingJson.get("id")).longValue();
            this.name = (String) fundingJson.get("name");
            this.label = (String) fundingJson.get("label");
            this.description = (String) fundingJson.get("description");
            this.url = (String) fundingJson.get("url");
        }
	}

	public GPolicy() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int compareTo(GPolicy o) {
		int i = this.name.compareTo(o.getName());
		if (this.name.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}

	@Override
	public String toString() {
		return "GPolicy [id=" + id + ", name=" + name + ", label=" + label + ", description=" + description + ", url="
				+ url + "]";
	}
}
