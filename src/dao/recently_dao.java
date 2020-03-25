package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DBhelper.DButil;
import entity.Product;
import entity.recently;
import entity.t_shopping_car;

public class recently_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	//查所有
	public ArrayList<recently> selectByUid(){
		ArrayList<recently> list = new ArrayList<recently>();
		Connection conn = DButil.getConn();
		String sql = "SELECT * from recently";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int r_id = rs.getInt("r_id");
				int r_p_id = rs.getInt("r_p_id");
				String r_time = rs.getString("r_time");
				int r_u_id = rs.getInt("r_u_id");
				
				recently rc = new recently(r_id, r_p_id, r_u_id, r_time);
				list.add(rc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return list;
	}
	//添加
	public void add(int r_p_id,int r_u_id){
		
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn = DButil.getConn();
		String sql ="insert into recently VALUES(?,null,?,?)";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, r_u_id);
			ps.setInt(2, r_p_id);
			ps.setString(3, sim.format(new Date()));
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
	//查是否重复
	public int selectrepaly(int u_id,int p_id){
		int count = 0;
		Connection conn = DButil.getConn();
		String sql = "SELECT * from recently where r_p_id=? and r_u_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, p_id);
			ps.setInt(2, u_id);
			rs = ps.executeQuery();
			if(rs.next()){
				int r_id = rs.getInt("r_id");
				int r_p_id = rs.getInt("r_p_id");
				String r_time = rs.getString("r_time");
				int r_u_id = rs.getInt("r_u_id");
				recently rc = new recently(r_id, r_p_id, r_u_id, r_time);
				if(rc.getR_id()>0){
					count = 1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	
}
