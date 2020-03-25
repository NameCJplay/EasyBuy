package entity;

public class recently {
private int r_id;
private int r_p_id;
private int r_u_id;
public recently(int rId, int rPId, int rUId, String rTime) {
	super();
	r_id = rId;
	r_p_id = rPId;
	r_u_id = rUId;
	r_time = rTime;
}
public int getR_u_id() {
	return r_u_id;
}
public void setR_u_id(int rUId) {
	r_u_id = rUId;
}
private String r_time;

public int getR_id() {
	return r_id;
}
public void setR_id(int rId) {
	r_id = rId;
}
public int getR_p_id() {
	return r_p_id;
}
public void setR_p_id(int rPId) {
	r_p_id = rPId;
}
public String getR_time() {
	return r_time;
}
public void setR_time(String rTime) {
	r_time = rTime;
}

}
