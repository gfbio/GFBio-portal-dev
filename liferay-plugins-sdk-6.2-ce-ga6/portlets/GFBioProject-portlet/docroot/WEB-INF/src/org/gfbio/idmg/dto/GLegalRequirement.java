package org.gfbio.idmg.dto;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class GLegalRequirement implements Comparable<GLegalRequirement>, Serializable {

	private static final long serialVersionUID = 8408718539947134085L;

	long id;
	String name;
	String label;
	String description;
	String extendedData;

	public GLegalRequirement(long id, String name, String label, String description, String extendedData) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.description = description;
		this.extendedData = extendedData;
	}
	
	public GLegalRequirement(JSONObject licenseJson) {
		if (licenseJson.containsKey("id") && licenseJson.containsKey("name") && licenseJson.containsKey("label")){
            this.id = Long.valueOf((String) licenseJson.get("id")).longValue();
            this.name = (String) licenseJson.get("name");
            this.label = (String) licenseJson.get("label");
            this.description = (String) licenseJson.get("description");
            this.extendedData = (String) licenseJson.get("extendeddata");
        }
	}
	
	public GLegalRequirement(){}
	
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
	public String getExtendedData() {
		return extendedData;
	}
	public void setExtendedData(String extendedData) {
		this.extendedData = extendedData;
	}

	@Override
	public int compareTo(GLegalRequirement o) {
		int i = this.name.compareTo(o.getName());
		if (this.name.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}
	
	@Override
	public String toString() {
		return "GLegalRequirement [id=" + id + ", name=" + name + ", label=" + label + ", description=" + description
				+ ", extendedData=" + extendedData + "]";
	}
}
