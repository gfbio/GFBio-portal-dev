package org.gfbio.idmg.dao;

import org.json.simple.JSONObject;

public class GMetadata implements Comparable<GMetadata> {

	long id;
	String name;
	String label;
	String description;
	String version;
	String schema;
	
	public GMetadata(long id, String name, String label, String description, String version, String schema) {
		this.id = id;
		this.name = name;
		this.label = label;
		this.description = description;
		this.version = version;
		this.schema = schema;
	}
	
	public GMetadata(JSONObject metadataJson) {
		if (metadataJson.containsKey("id") && metadataJson.containsKey("name") && metadataJson.containsKey("label")){
            this.id = Long.valueOf((String) metadataJson.get("id")).longValue();
            this.name = (String) metadataJson.get("name");
            this.label = (String) metadataJson.get("label");
            this.description = (String) metadataJson.get("description");
            this.version = (String) metadataJson.get("version");
            this.schema = (String) metadataJson.get("schema");
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

	@Override
	public int compareTo(GMetadata o) {
		int i = this.label.compareTo(o.getLabel());
		if (this.label.equalsIgnoreCase("other")) {
			i = 1;
		}
		return i;
	}
	
	@Override
	public String toString() {
		return "Metadata [id=" + id + ", name=" + name + ", label=" + label + ", description=" + description
				+ ", version=" + version + ", schema=" + schema + "]";
	}
	
}
