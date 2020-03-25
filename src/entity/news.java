package entity;

public class news {
	private int EN_ID;
	private String EN_TITLE;
	private String EN_CONTENT;
	private String EN_CREATE_TIME;
	public int getEN_ID() {
		return EN_ID;
	}
	public void setEN_ID(int eNID) {
		EN_ID = eNID;
	}
	public String getEN_TITLE() {
		return EN_TITLE;
	}
	public void setEN_TITLE(String eNTITLE) {
		EN_TITLE = eNTITLE;
	}
	public String getEN_CONTENT() {
		return EN_CONTENT;
	}
	public void setEN_CONTENT(String eNCONTENT) {
		EN_CONTENT = eNCONTENT;
	}
	public String getEN_CREATE_TIME() {
		return EN_CREATE_TIME;
	}
	public void setEN_CREATE_TIME(String eNCREATETIME) {
		EN_CREATE_TIME = eNCREATETIME;
	}
	public void show(int eNID, String eNTITLE, String eNCONTENT, String eNCREATETIME) {
		EN_ID = eNID;
		EN_TITLE = eNTITLE;
		EN_CONTENT = eNCONTENT;
		EN_CREATE_TIME = eNCREATETIME;
	}
	
}
