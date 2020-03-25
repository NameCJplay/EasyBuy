package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBhelper.DButil;

import entity.Product;
import entity.product_category;

public class ProductDao {
	public ArrayList<Product> select(){
		ArrayList<Product> plist = new ArrayList<Product>();
		Connection conn = DButil.getConn();
		String sql = "select * from easybuy_product";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int epcid = rs.getInt("EPC_ID");
				product_category pcate = new product_category(epcid, null, 0);
				int epid = rs.getInt("EP_ID");
				String epname = rs.getString("EP_NAME");
				String epdesc = rs.getString("EP_DESCRIPTION");
				double epprice = rs.getDouble("EP_PRICE");
				int epstock = rs.getInt("EP_STOCK");
				int epcchildid = rs.getInt("EPC_CHILD_ID");
				String epfilename = rs.getString("EP_FILE_NAME");
				String epspecialprice = rs.getString("EP_SPECIAL_PRICE");
				String epspecialbuy = rs.getString("EP_SPECIAL_BUY");
				Product pro = new Product(epid, epname, epdesc, epprice, epstock, epcchildid, epfilename, epspecialprice, epspecialbuy, pcate);
				plist.add(pro);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return plist;
	}
	
	public void add(Product product){
		Connection conn = DButil.getConn();
		String sql = "insert into EASYBUY_PRODUCT (EP_NAME, EP_DESCRIPTION, EP_PRICE, EP_STOCK, EPC_ID, EPC_CHILD_ID, EP_FILE_NAME,EP_SPECIAL_PRICE,EP_SPECIAL_BUY) values (?, ?, ?, ?, ?, ?, ?,?,?);";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, product.getEpname());
			ps.setString(2, product.getEpdesc());
			ps.setDouble(3, product.getEpprice());
			ps.setInt(4, product.getEpstock());
			ps.setInt(5, product.getPcate().getEPC_ID());
			ps.setInt(6, product.getEpcchildid());
			ps.setString(7, product.getEpfilename());
			ps.setString(8, product.getEpspecialprice());
			ps.setString(9, product.getEpspecialbuy());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
	
	//¸ù¾ÝID²éÑ¯
	public Product selectbyid(int id){
		Product pro = null;
		Connection conn = DButil.getConn();
		String sql = "select * from easybuy_product where EP_ID=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				int epcid = rs.getInt("EPC_ID");
				product_category pcate = new product_category(epcid, null, 0);
				int epid = rs.getInt("EP_ID");
				String epname = rs.getString("EP_NAME");
				String epdesc = rs.getString("EP_DESCRIPTION");
				double epprice = rs.getDouble("EP_PRICE");
				int epstock = rs.getInt("EP_STOCK");
				int epcchildid = rs.getInt("EPC_CHILD_ID");
				String epfilename = rs.getString("EP_FILE_NAME");
				String epspecialprice = rs.getString("EP_SPECIAL_PRICE");
				String epspecialbuy = rs.getString("EP_SPECIAL_BUY");
				pro = new Product(epid, epname, epdesc, epprice, epstock, epcchildid, epfilename, epspecialprice, epspecialbuy, pcate);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
		return pro;
		
	}
	
	public void delete(int id){
		Connection conn =DButil.getConn();
		String sql = "delete from easybuy_product where EP_ID=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
	
	public void update(Product pro){
		Connection conn = DButil.getConn();
		String sql = "update easybuy_product set EP_NAME=?,EP_DESCRIPTION=?,EP_PRICE=?,EP_STOCK=?,EPC_ID=?,EPC_CHILD_ID=?,EP_FILE_NAME=?,EP_SPECIAL_PRICE=?,EP_SPECIAL_BUY=? where ep_id=?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getEpname());
			ps.setString(2, pro.getEpdesc());
			ps.setDouble(3, pro.getEpprice());
			ps.setInt(4, pro.getEpstock());
			ps.setInt(5, pro.getPcate().getEPC_ID());
			ps.setInt(6, pro.getEpcchildid());
			ps.setString(7, pro.getEpfilename());
			ps.setString(8, pro.getEpspecialprice());
			ps.setString(9, pro.getEpspecialbuy());
			ps.setInt(10, pro.getEpid());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
}
