package entity;

import java.util.ArrayList;

public class product_category {
	private int EPC_ID;
	private String EPC_NAME;
	private int EPC_PARENT_ID;
	private ArrayList<Product> product;
	public int getEPC_ID() {
		return EPC_ID;
	}
	public void setEPC_ID(int ePCID) {
		EPC_ID = ePCID;
	}
	public String getEPC_NAME() {
		return EPC_NAME;
	}
	public void setEPC_NAME(String ePCNAME) {
		EPC_NAME = ePCNAME;
	}
	public int getEPC_PARENT_ID() {
		return EPC_PARENT_ID;
	}
	public void setEPC_PARENT_ID(int ePCPARENTID) {
		EPC_PARENT_ID = ePCPARENTID;
	}
	
	
	public ArrayList<Product> getProduct() {
		return product;
	}
	public void setProduct(ArrayList<Product> product) {
		this.product = product;
	}
	public product_category(int ePCID, String ePCNAME, int ePCPARENTID) {
		super();
		EPC_ID = ePCID;
		EPC_NAME = ePCNAME;
		EPC_PARENT_ID = ePCPARENTID;
	}
	

}
