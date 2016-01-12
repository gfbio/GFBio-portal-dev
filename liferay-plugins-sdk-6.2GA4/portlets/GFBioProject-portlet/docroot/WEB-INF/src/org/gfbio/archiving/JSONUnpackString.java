package org.gfbio.archiving;

public class JSONUnpackString {
	public JSONUnpackString(String text, int index ) {
		this.text = text;
		this.index = index;
	}

	public JSONUnpackString(String origntext, String text, int index ) {
		this.origntext = origntext;
		this.text = text;
		this.index = index;
	}

	public void addText(String text) {
		this.text = this.text.concat(text);
	}

	public int getIndex() {
		return this.index;
	}

	public String getOrigntext() {
		return this.origntext;
	}

	public String getText() {
		return this.text;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setOrigntext(String origntext) {
		this.origntext = origntext;
	}

	public void setText(String text) {
		this.text = text;
	}

	private int index;
	private String origntext = new String();
	private String text = new String ();

}