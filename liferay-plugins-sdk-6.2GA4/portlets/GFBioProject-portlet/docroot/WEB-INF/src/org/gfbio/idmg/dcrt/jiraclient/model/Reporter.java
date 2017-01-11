package org.gfbio.idmg.dcrt.jiraclient.model;

public class Reporter {

	public String name;

	public Reporter(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Reporter [name=" + name + "]";
	}
	
}
