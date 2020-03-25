package entity;

public class easybuy_orderdetail {
	private int EOD_ID;
	private String EO_ali_id;
	private int EP_ID;
	private int EOD_Quantity;
	private double EOD_COST;
	public int getEOD_ID() {
		return EOD_ID;
	}
	public void setEOD_ID(int eODID) {
		EOD_ID = eODID;
	}
	public String getEO_ali_id() {
		return EO_ali_id;
	}
	public void setEO_ali_id(String eOAliId) {
		EO_ali_id = eOAliId;
	}
	public int getEP_ID() {
		return EP_ID;
	}
	public void setEP_ID(int ePID) {
		EP_ID = ePID;
	}
	public int getEOD_Quantity() {
		return EOD_Quantity;
	}
	public void setEOD_Quantity(int eODQuantity) {
		EOD_Quantity = eODQuantity;
	}
	public double getEOD_COST() {
		return EOD_COST;
	}
	public void setEOD_COST(double eODCOST) {
		EOD_COST = eODCOST;
	}
	public easybuy_orderdetail(int eODID, String eOAliId, int ePID,
			int eODQuantity, double eODCOST) {
		super();
		EOD_ID = eODID;
		EO_ali_id = eOAliId;
		EP_ID = ePID;
		EOD_Quantity = eODQuantity;
		EOD_COST = eODCOST;
	}
	
	
	
}
