package org.gfbio.idmg.dto;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class GLicense implements Comparable<GLicense>, Serializable {
	
	private static final long serialVersionUID = 3269683332315255768L;

	long id;
	String name;
	String label;
	String description;
	String extendedData;
	String url;
	boolean preferredByGfbio;
	String version;
	
	public GLicense(long id, String name, String label, String description, String extendedData, String url, boolean preferredByGfbio, String version) {
		super();
		this.id = id;
		this.name = name;
		this.label = label;
		this.description = description;
		this.extendedData = extendedData;
		this.url = url;
		this.preferredByGfbio = preferredByGfbio;
		this.version = version;
	}

	public GLicense(JSONObject licenseJson) {
		if (licenseJson.containsKey("id") && licenseJson.containsKey("name") && licenseJson.containsKey("label")){
            this.id = Long.valueOf((String) licenseJson.get("id")).longValue();
            this.name = (String) licenseJson.get("name");
            this.label = (String) licenseJson.get("label");
            this.description = (String) licenseJson.get("description");
            this.extendedData = (String) licenseJson.get("extendeddata");
            this.url = (String) licenseJson.get("url");
            this.preferredByGfbio = Boolean.parseBoolean((String) licenseJson.get("preferredbygfbio"));
            this.version = (String) licenseJson.get("version");
        }
	}
	
	public GLicense() {}

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isPreferredByGfbio() {
		return preferredByGfbio;
	}

	public void setPreferredByGfbio(boolean preferredByGfbio) {
		this.preferredByGfbio = preferredByGfbio;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public int compareTo(GLicense o) {
		int i = this.label.compareTo(o.getLabel());
		if (this.label.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}

	@Override
	public String toString() {
		return "GLicense [id=" + id + ", name=" + name + ", label=" + label + ", description=" + description
				+ ", extendedData=" + extendedData + ", url=" + url + ", preferredByGfbio=" + preferredByGfbio
				+ ", version=" + version + "]";
	}

}
