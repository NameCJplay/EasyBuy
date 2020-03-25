package entity;

public class t_shopping_car {
	private int c_id;
	private int c_g_id;
	private int c_g_count;
	private int c_u_id;
	public int getC_id() {
		return c_id;
	}
	public void setC_id(int cId) {
		c_id = cId;
	}
	public int getC_g_id() {
		return c_g_id;
	}
	public void setC_g_id(int cGId) {
		c_g_id = cGId;
	}
	public int getC_g_count() {
		return c_g_count;
	}
	public void setC_g_count(int cGCount) {
		c_g_count = cGCount;
	}
	public int getC_u_id() {
		return c_u_id;
	}
	public void setC_u_id(int cUId) {
		c_u_id = cUId;
	}
	public t_shopping_car(int cId, int cGId, int cGCount, int cUId) {
		super();
		c_id = cId;
		c_g_id = cGId;
		c_g_count = cGCount;
		c_u_id = cUId;
	}
}
