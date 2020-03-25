package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBhelper.DButil;

import entity.EASYBUY_USER;

public class easybuy_user_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//查所有
	public ArrayList<EASYBUY_USER> selectall(){
		ArrayList<EASYBUY_USER> stulist = new ArrayList<EASYBUY_USER>();
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_user";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EASYBUY_USER user = new EASYBUY_USER(rs.getInt("eu_user_id"),
						rs.getString("eu_user_name"), rs.getString("eu_password"), 
						rs.getString("eu_sex"), rs.getString("eu_birthday"),
						rs.getString("eu_identity_code"), rs.getString("EU_EMAIL"), 
						rs.getString("eu_mobile"), rs.getString("eu_address"), 
						rs.getInt("eu_status"));
				stulist.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return stulist;
	}
	
	//登录
	public EASYBUY_USER login(String name,String pwd){
		EASYBUY_USER user = new EASYBUY_USER(0, null, null, null, null, null, null, null, null, 0); 
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_user where EU_USER_NAME=? and EU_PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				user.setEu_user_id(rs.getInt("eu_user_id"));
				user.setEu_user_name(rs.getString("eu_user_name"));
				user.setEu_password(rs.getString("eu_password"));
				user.setEu_sex(rs.getString("eu_sex"));
				user.setEu_birthday(rs.getString("eu_birthday"));
				user.setEu_identity_code(rs.getString("eu_identity_code"));
				user.setEU_EMAIL(rs.getString("EU_EMAIL"));
				user.setEu_mobile(rs.getString("eu_mobile"));
				user.setEu_address(rs.getString("eu_address"));
				user.setEu_status(rs.getInt("eu_status"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return user;
	}
	//注册
	public int register(EASYBUY_USER user){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "insert into easybuy_user values(null,?,?,?,?,?,?,?,?,1)";
			ps = conn.prepareStatement(sql);	
			ps.setString(1, user.getEu_user_name());
			ps.setString(2, user.getEu_password());
			ps.setString(3, user.getEu_sex());
			ps.setString(4, user.getEu_birthday());
			ps.setString(5, user.getEu_identity_code());
			ps.setString(6, user.getEU_EMAIL());
			ps.setString(7, user.getEu_mobile());
			ps.setString(8, user.getEu_address());	
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}	
		return count;	
		}
	//删除
	public int delete(int id){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "delete from easybuy_user where EU_USER_ID=?";
			ps = conn.prepareStatement(sql);	
			ps.setInt(1, id);
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}	
		return count;	
	}
	//查单个
	public EASYBUY_USER select(int id){
		EASYBUY_USER user = new EASYBUY_USER(0, null, null, null, null, null, null, null, null, 0);
		conn = DButil.getConn();
		try {
			String sql = "select * from easybuy_user where eu_user_id=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				user = new EASYBUY_USER(rs.getInt("eu_user_id"),
						rs.getString("eu_user_name"), rs.getString("eu_password"), 
						rs.getString("eu_sex"), rs.getString("eu_birthday"),
						rs.getString("eu_identity_code"), rs.getString("EU_EMAIL"), 
						rs.getString("eu_mobile"), rs.getString("eu_address"), 
						rs.getInt("eu_status"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return user;
	}
	//修改
	public int update(EASYBUY_USER user){
		int count = 0;
		conn = DButil.getConn();
		try {
			String sql = "UPDATE easybuy_user set EU_USER_NAME=?,EU_PASSWORD=?,EU_SEX=?" +
					",EU_BIRTHDAY=?,EU_MOBILE=?,EU_ADDRESS=? where EU_USER_ID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEu_user_name());
			ps.setString(2, user.getEu_password());
			ps.setString(3, user.getEu_sex());
			ps.setString(4, user.getEu_birthday());
			ps.setString(5, user.getEu_mobile());
			ps.setString(6, user.getEu_address());
			ps.setInt(7, user.getEu_user_id());
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}	
		return count;
		
		
	}
}
