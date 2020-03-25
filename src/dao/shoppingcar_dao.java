package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBhelper.DButil;
import entity.Product;
import entity.product_category;
import entity.t_shopping_car;

public class shoppingcar_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	//查所有
	public ArrayList<t_shopping_car> selectByUid(int uid){
		ArrayList<t_shopping_car> list = new ArrayList<t_shopping_car>();
		Connection conn = DButil.getConn();
		String sql = "select * from EASYBUY_PRODUCT p join t_shopping_car " +
				"c on p.EP_ID=c.c_g_id where c.c_u_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			while(rs.next()){
				int c_id = rs.getInt("c_id");
				int g_id = rs.getInt("c_g_id");
				int count = rs.getInt("c_g_count");
				int u_id = rs.getInt("c_u_id");
				t_shopping_car tc = new t_shopping_car(c_id, g_id, count, u_id);
				list.add(tc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return list;
	}
	//添加
	public int add(t_shopping_car car){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql ="insert into t_shopping_car values(null,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, car.getC_g_id());
			ps.setInt(2, car.getC_g_count());
			ps.setInt(3, car.getC_u_id());
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	//删除
	public int delete(int id){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql ="delete from t_shopping_car where c_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);	
			count = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	//查重复
	public int selectrepaly(int pid,int uid){
		int count = 0;
		Connection conn = DButil.getConn();
		String sql = "select * from t_shopping_car WHERE c_g_id=? and c_u_id=?;";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setInt(2, uid);
			rs = ps.executeQuery();
			if(rs.next()){
				int c_id = rs.getInt("c_id");
				int g_id = rs.getInt("c_g_id");
				int com = rs.getInt("c_g_count");
				int u_id = rs.getInt("c_u_id");
				t_shopping_car tc = new t_shopping_car(c_id, g_id, com, u_id);
				if(tc.getC_id()>0){
					count = tc.getC_id();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	
	//修改数量
	public int updatecount(int cid){
		int count = 0;
		Connection conn = DButil.getConn();
		String sql = "UPDATE t_shopping_car set c_g_count=c_g_count+1 where c_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cid);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
}
