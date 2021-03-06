package org.gfbio.idmg.dto;

import java.io.Serializable;

import org.json.simple.JSONObject;

public class GMetadata implements Comparable<GMetadata>, Serializable {

	private static final long serialVersionUID = 8424946293409674241L;
	
	long id;
	String name;
	String label;
	String description;
	boolean preferredByGfbio;
	String version;
	String schema;
	String url;
	
	public GMetadata(long id, String name, String label, String description, boolean preferredByGfbio, String version, String schema, String url) {
		this.id = id;
		this.name = name;
		this.label = label;
		this.description = description;
		this.preferredByGfbio = preferredByGfbio;
		this.version = version;
		this.schema = schema;
		this.url = url;
	}
	
	public GMetadata(JSONObject metadataJson) {
		if (metadataJson.containsKey("id") && metadataJson.containsKey("name") && metadataJson.containsKey("label")){
            this.id = Long.valueOf((String) metadataJson.get("id")).longValue();
            this.name = (String) metadataJson.get("name");
            this.label = (String) metadataJson.get("label");
            this.description = (String) metadataJson.get("description");
            this.preferredByGfbio = Boolean.parseBoolean((String) metadataJson.get("preferredbygfbio"));
            this.version = (String) metadataJson.get("version");
            this.schema = (String) metadataJson.get("schema");
            this.url = (String) metadataJson.get("url");
        }
	}
	
	public GMetadata() {}

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

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int compareTo(GMetadata o) {
		int i = 0;
		if(o != null && this.label != null) {
			i = this.label.compareTo(o.getLabel());
		}
		if (this.label != null && this.label.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}

	@Override
	public String toString() {
		return "GMetadata [id=" + id + ", name=" + name + ", label=" + label + ", description=" + description
				+ ", preferredByGfbio=" + preferredByGfbio + ", version=" + version + ", schema=" + schema + ", url="
				+ url + "]";
	}
	
}
