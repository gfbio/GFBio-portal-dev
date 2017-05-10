package org.gfbio.idmg.dcrt.jiraclient.model;

public class Project {

	public String key;

	public Project(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Project [key=" + key + "]";
	}

}
