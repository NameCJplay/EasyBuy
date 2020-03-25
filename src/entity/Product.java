package entity;

public class Product {
	private int epid;
	private String epname;
	private String epdesc;
	private double epprice;
	private int epstock;
	private int epcchildid;
	private String epfilename;
	private String epspecialprice;
	private String epspecialbuy;
	private product_category pcate;
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
	}
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getEpdesc() {
		return epdesc;
	}
	public void setEpdesc(String epdesc) {
		this.epdesc = epdesc;
	}
	public double getEpprice() {
		return epprice;
	}
	public void setEpprice(double epprice) {
		this.epprice = epprice;
	}
	public int getEpstock() {
		return epstock;
	}
	public void setEpstock(int epstock) {
		this.epstock = epstock;
	}
	public int getEpcchildid() {
		return epcchildid;
	}
	public void setEpcchildid(int epcchildid) {
		this.epcchildid = epcchildid;
	}
	public String getEpfilename() {
		return epfilename;
	}
	public void setEpfilename(String epfilename) {
		this.epfilename = epfilename;
	}
	public String getEpspecialprice() {
		return epspecialprice;
	}
	public void setEpspecialprice(String epspecialprice) {
		this.epspecialprice = epspecialprice;
	}
	public String getEpspecialbuy() {
		return epspecialbuy;
	}
	public void setEpspecialbuy(String epspecialbuy) {
		this.epspecialbuy = epspecialbuy;
	}
	
	public product_category getPcate() {
		return pcate;
	}
	public void setPcate(product_category pcate) {
		this.pcate = pcate;
	}
	public Product(int epid, String epname, String epdesc, double epprice,
			int epstock, int epcchildid, String epfilename,
			String epspecialprice, String epspecialbuy, product_category pcate) {
		super();
		this.epid = epid;
		this.epname = epname;
		this.epdesc = epdesc;
		this.epprice = epprice;
		this.epstock = epstock;
		this.epcchildid = epcchildid;
		this.epfilename = epfilename;
		this.epspecialprice = epspecialprice;
		this.epspecialbuy = epspecialbuy;
		this.pcate = pcate;
	}
	
	
	
}
