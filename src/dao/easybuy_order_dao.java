package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DBhelper.DButil;

import entity.easybuy_order;

public class easybuy_order_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//查所有--分页
	public ArrayList<easybuy_order> selectall(int page,int size){
		ArrayList<easybuy_order> orderlist = new ArrayList<easybuy_order>();
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_order limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, page);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			while(rs.next()){
				easybuy_order order = new easybuy_order(rs.getInt("eo_Id"), rs.getInt("eo_user_Id"),
						rs.getString("eo_User_Name"), rs.getString("eo_User_Address"),rs.getString("eo_Create_Time"),
						rs.getDouble("eo_Cost"), rs.getInt("eo_status"), rs.getInt("eo_type"),rs.getString("EO_ali_id"));
				
				orderlist.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return orderlist;
	}
	
	//数据总个数
	public int selectcount(){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "select count(*) from easybuy_order";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt("count(*)");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	//查所有--模糊查询
	public ArrayList<easybuy_order> selectlike(String eid,String username){
		ArrayList<easybuy_order> orderlist = new ArrayList<easybuy_order>();
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_order where EO_ID like ? and EO_USER_NAME like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+eid+"%");
			ps.setString(2, "%"+username+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				easybuy_order order = new easybuy_order(rs.getInt("eo_Id"), rs.getInt("eo_user_Id"),
						rs.getString("eo_User_Name"), rs.getString("eo_User_Address"),rs.getString("eo_Create_Time"),
						rs.getDouble("eo_Cost"), rs.getInt("eo_status"), rs.getInt("eo_type"),rs.getString("EO_ali_id"));
				
				orderlist.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return orderlist;
	}
	//查单个
	public easybuy_order select(int eid){
		easybuy_order order = new easybuy_order(0, 0, null, null, null, 0, 0, 0,null);
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_order where EO_ID=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new easybuy_order(rs.getInt("eo_Id"), rs.getInt("eo_user_Id"),
						rs.getString("eo_User_Name"), rs.getString("eo_User_Address"),rs.getString("eo_Create_Time"),
						rs.getDouble("eo_Cost"), rs.getInt("eo_status"), rs.getInt("eo_type"),rs.getString("EO_ali_id"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return order;
	}
	//修改
	public int update(easybuy_order order){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "UPDATE easybuy_order set EO_USER_NAME=?," +
					"EO_USER_ADDRESS=?,EO_COST=?, EO_STATUS=?  where EO_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, order.getEo_user_name());
			ps.setString(2, order.getEo_user_address());
			ps.setDouble(3, order.getEo_cost());
			ps.setInt(4, order.getEo_status());
			ps.setInt(5, order.getEo_id());
			
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;	
	}
	//修改发货状态
	public int update_status(String oid,int status){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "UPDATE easybuy_order set EO_STATUS=? where EO_ali_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setString(2, oid);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;	
	}
	
	//删除
	public int delete(int eo_id){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "delete from EASYBUY_ORDER where eo_id=?";
			ps = conn.prepareStatement(sql);		
			ps.setInt(1, eo_id);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;	
	}
	//添加
	public int add(easybuy_order order){
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		int count = 0;
		conn=DButil.getConn();
		try {
			String sql = "insert into easybuy_order values(?,?,?,?,?,?,?,1,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getEo_id());
			ps.setInt(2, order.getEo_user_id());
			ps.setString(3, order.getEo_user_name());
			ps.setString(4, order.getEo_user_address());
			ps.setString(5, smp.format(new Date()));
			ps.setDouble(6, order.getEo_cost());
			ps.setInt(7, order.getEo_status());
			ps.setString(8, order.getEO_ali_id());
			
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	//查订单
	public easybuy_order selectali(String oid){
		easybuy_order order = new easybuy_order(0, 0, null, null, null, 0, 0, 0,null);
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_order where EO_ali_id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, oid);
			rs = ps.executeQuery();
			while(rs.next()){
				order = new easybuy_order(rs.getInt("eo_Id"), rs.getInt("eo_user_Id"),
						rs.getString("eo_User_Name"), rs.getString("eo_User_Address"),rs.getString("eo_Create_Time"),
						rs.getDouble("eo_Cost"), rs.getInt("eo_status"), rs.getInt("eo_type"),rs.getString("EO_ali_id"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return order;
	}
	
	
	
}
