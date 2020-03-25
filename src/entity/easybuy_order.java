package entity;

public class easybuy_order {
	private int eo_id;
	private int eo_user_id;
	private String eo_user_name;
	private String eo_user_address;
	private String eo_create_time;
	private double eo_cost;
	private int eo_status;
	private int eo_type;
	private String EO_ali_id;
	
	public String getEO_ali_id() {
		return EO_ali_id;
	}
	public void setEO_ali_id(String eOAliId) {
		EO_ali_id = eOAliId;
	}
	public int getEo_user_id() {
		return eo_user_id;
	}
	public void setEo_user_id(int eoUserId) {
		eo_user_id = eoUserId;
	}
	public String getEo_user_name() {
		return eo_user_name;
	}
	public void setEo_user_name(String eoUserName) {
		eo_user_name = eoUserName;
	}
	public String getEo_user_address() {
		return eo_user_address;
	}
	public void setEo_user_address(String eoUserAddress) {
		eo_user_address = eoUserAddress;
	}
	public String getEo_create_time() {
		return eo_create_time;
	}
	public void setEo_create_time(String eoCreateTime) {
		eo_create_time = eoCreateTime;
	}
	public double getEo_cost() {
		return eo_cost;
	}
	public void setEo_cost(double eoCost) {
		eo_cost = eoCost;
	}
	public int getEo_status() {
		return eo_status;
	}
	public void setEo_status(int eoStatus) {
		eo_status = eoStatus;
	}
	public int getEo_type() {
		return eo_type;
	}
	public void setEo_type(int eoType) {
		eo_type = eoType;
	}
	public easybuy_order(int eoId, int eoUserId, String eoUserName,
			String eoUserAddress, String eoCreateTime, double eoCost,
			int eoStatus, int eoType, String eOAliId) {
		super();
		eo_id = eoId;
		eo_user_id = eoUserId;
		eo_user_name = eoUserName;
		eo_user_address = eoUserAddress;
		eo_create_time = eoCreateTime;
		eo_cost = eoCost;
		eo_status = eoStatus;
		eo_type = eoType;
		EO_ali_id = eOAliId;
	}
	public int getEo_id() {
		return eo_id;
	}
	public void setEo_id(int eoId) {
		eo_id = eoId;
	}
	
	
	
}
