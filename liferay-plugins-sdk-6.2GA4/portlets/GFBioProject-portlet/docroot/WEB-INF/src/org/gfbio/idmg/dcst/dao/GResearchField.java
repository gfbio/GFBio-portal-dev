package org.gfbio.idmg.dcst.dao;

public class GResearchField {

	long id;
	String name;
	String description;
	
	public GResearchField(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public GResearchField() {}
	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GResearchField [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}
	
}
