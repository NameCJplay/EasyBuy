package entity;

public class EASYBUY_USER {
	private int eu_user_id;
	private String eu_user_name;
	private String eu_password;
	private String eu_sex;
	private String eu_birthday;
	private String eu_identity_code;
	private String EU_EMAIL;
	private String eu_mobile;
	private String eu_address;
	private int eu_status;
	public int getEu_user_id() {
		return eu_user_id;
	}
	public void setEu_user_id(int euUserId) {
		eu_user_id = euUserId;
	}
	public String getEu_user_name() {
		return eu_user_name;
	}
	public void setEu_user_name(String euUserName) {
		eu_user_name = euUserName;
	}
	public String getEu_password() {
		return eu_password;
	}
	public void setEu_password(String euPassword) {
		eu_password = euPassword;
	}
	public String getEu_sex() {
		return eu_sex;
	}
	public void setEu_sex(String euSex) {
		eu_sex = euSex;
	}
	public String getEu_birthday() {
		return eu_birthday;
	}
	public void setEu_birthday(String euBirthday) {
		eu_birthday = euBirthday;
	}
	public String getEu_identity_code() {
		return eu_identity_code;
	}
	public void setEu_identity_code(String euIdentityCode) {
		eu_identity_code = euIdentityCode;
	}
	
	public String getEu_mobile() {
		return eu_mobile;
	}
	public void setEu_mobile(String euMobile) {
		eu_mobile = euMobile;
	}
	public String getEu_address() {
		return eu_address;
	}
	public void setEu_address(String euAddress) {
		eu_address = euAddress;
	}
	
	public int getEu_status() {
		return eu_status;
	}
	public void setEu_status(int euStatus) {
		eu_status = euStatus;
	}
	public String getEU_EMAIL() {
		return EU_EMAIL;
	}
	public void setEU_EMAIL(String eUEMAIL) {
		EU_EMAIL = eUEMAIL;
	}
	public EASYBUY_USER(int euUserId, String euUserName, String euPassword,
			String euSex, String euBirthday, String euIdentityCode,
			String eUEMAIL, String euMobile, String euAddress, int eu_Status) {
		super();
		eu_user_id = euUserId;
		eu_user_name = euUserName;
		eu_password = euPassword;
		eu_sex = euSex;
		eu_birthday = euBirthday;
		eu_identity_code = euIdentityCode;
		EU_EMAIL = eUEMAIL;
		eu_mobile = euMobile;
		eu_address = euAddress;
		this.eu_status = eu_Status;
	}
	
	
	
}
