package org.gfbio.idmg.dcst.dao;

public class GCategoryResearchField {

	long categoryId;
	long researchFieldId;
	
	public GCategoryResearchField(long categoryId, long researchFieldId) {
	
		this.categoryId = categoryId;
		this.researchFieldId = researchFieldId;
	}
	
	public GCategoryResearchField(){}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public long getResearchFieldId() {
		return researchFieldId;
	}

	public void setResearchFieldId(long researchFieldId) {
		this.researchFieldId = researchFieldId;
	}

	@Override
	public String toString() {
		return "CategoryResearchField [categoryId=" + categoryId
				+ ", researchFieldId=" + researchFieldId + "]";
	}
	
}
