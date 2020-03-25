package entity;

public class comment {
	private int ecid;
	private String eccontent;
	private String ec_create_time;
	private String ecreply;
	private String ec_reply_time;
	private String ec_nick_name;
	public int getEcid() {
		return ecid;
	}
	public void setEcid(int ecid) {
		this.ecid = ecid;
	}
	public String getEccontent() {
		return eccontent;
	}
	public void setEccontent(String eccontent) {
		this.eccontent = eccontent;
	}
	public String getEc_create_time() {
		return ec_create_time;
	}
	public void setEc_create_time(String ecCreateTime) {
		ec_create_time = ecCreateTime;
	}
	public String getEcreply() {
		return ecreply;
	}
	public void setEcreply(String ecreply) {
		this.ecreply = ecreply;
	}
	public String getEc_reply_time() {
		return ec_reply_time;
	}
	public void setEc_reply_time(String ecReplyTime) {
		ec_reply_time = ecReplyTime;
	}
	public String getEc_nick_name() {
		return ec_nick_name;
	}
	public void setEc_nick_name(String ecNickName) {
		ec_nick_name = ecNickName;
	}
	public comment(int ecid, String eccontent, String ecCreateTime,
			String ecreply, String ecReplyTime, String ecNickName) {
		super();
		this.ecid = ecid;
		this.eccontent = eccontent;
		ec_create_time = ecCreateTime;
		this.ecreply = ecreply;
		ec_reply_time = ecReplyTime;
		ec_nick_name = ecNickName;
	}
	
}
