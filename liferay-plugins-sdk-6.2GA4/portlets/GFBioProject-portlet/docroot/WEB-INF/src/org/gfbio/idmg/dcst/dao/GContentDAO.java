package org.gfbio.idmg.dcst.dao;

import java.util.HashMap;
import java.util.List;

public class GContentDAO {

	private List<HashMap<Long, String>> contents;
	private List<HashMap<Long, String>> columnNames;
	
	public List<HashMap<Long, String>> getContents() {
		return contents;
	}
	public void setContents(List<HashMap<Long, String>> contents) {
		this.contents = contents;
	}
	public List<HashMap<Long, String>> getColumnNames() {
		return columnNames;
	}
	public void setColumnNames(List<HashMap<Long, String>> columnNames) {
		this.columnNames = columnNames;
	}
	
}
