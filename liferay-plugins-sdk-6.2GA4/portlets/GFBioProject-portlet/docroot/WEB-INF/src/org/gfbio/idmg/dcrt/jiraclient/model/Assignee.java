package org.gfbio.idmg.dcrt.jiraclient.model;

public class Assignee {

	public String name;
	
	public Assignee(String name) {
		this.name = name;
	}

	public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Assignee [name=" + name + "]";
	}
    
}
