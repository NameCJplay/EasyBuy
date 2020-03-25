package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DBhelper.DButil;
import entity.Product;
import entity.news;

public class news_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs =null;
	
	//查所有
	public ArrayList<news> selectall(){
		ArrayList<news> newslist = new ArrayList<news>();
		Connection conn = DButil.getConn();
		String sql = "select * from EASYBUY_NEWS";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				news nw = new news();
				nw.show(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"),
						rs.getString("EN_CREATE_TIME"));
				newslist.add(nw);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return newslist;
	}
	//添加
	public int add(news ne){
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int count = 0;
		Connection conn = DButil.getConn();
		String sql = "insert into easybuy_news values(null,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ne.getEN_TITLE());
			ps.setString(2, ne.getEN_CONTENT());
			ps.setString(3, smp.format(new Date()));
			count = ps.executeUpdate();	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return count;
	}
	
	//查单个
	public news selectone(int id){
		news ne = new news();
		Connection conn = DButil.getConn();
		String sql = "select * from EASYBUY_NEWS where EN_ID=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				
				ne.show(rs.getInt("EN_ID"), rs.getString("EN_TITLE"), rs.getString("EN_CONTENT"),
						rs.getString("EN_CREATE_TIME"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DButil.close(rs, ps, conn);
		}
		return ne;
	}
	
	//修改
	public int upodate(news ne){

		int count = 0;
		Connection conn = DButil.getConn();
		String sql = "update easybuy_news set EN_TITLE=?,EN_CONTENT=? where EN_ID=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ne.getEN_TITLE());
			ps.setString(2, ne.getEN_CONTENT());
			ps.setInt(3, ne.getEN_ID());
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
		Connection conn = DButil.getConn();
		String sql = "delete from easybuy_news where EN_ID=?";
		try {
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
	
	
}
