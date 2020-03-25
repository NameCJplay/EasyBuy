package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import DBhelper.DButil;

import entity.comment;

public class CommentDao {
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public ArrayList<comment> selectall(){
		ArrayList<comment> comlist=new ArrayList<comment>();
		Connection conn=DButil.getConn();
		String sql="select * from easybuy_comment";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				int ecid=rs.getInt("EC_ID");
				String eccontent=rs.getString("EC_CONTENT");
				String ec_create_time=rs.getString("EC_CREATE_TIME");
				String ecreply=rs.getString("EC_REPLY");
				String ec_reply_time=rs.getString("EC_REPLY_TIME");
				String ec_nick_name=rs.getString("EC_NICK_NAME");
				comment comm=new comment(ecid, eccontent, ec_create_time, ecreply, ec_reply_time, ec_nick_name);
				comlist.add(comm);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
			}
		return comlist;
	}
	
	
	
	public comment selectone(int id){
	comment com= new comment(0, null, null, null, null, null);
		Connection conn=DButil.getConn();
		String sql="select * from easybuy_comment where EC_ID=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				int ecid=rs.getInt("EC_ID");
				String eccontent=rs.getString("EC_CONTENT");
				String ec_create_time=rs.getString("EC_CREATE_TIME");
				String ecreply=rs.getString("EC_REPLY");
				String ec_reply_time=rs.getString("EC_REPLY_TIME");
				String ec_nick_name=rs.getString("EC_NICK_NAME");
				com=new comment(ecid, eccontent, ec_create_time, ecreply, ec_reply_time, ec_nick_name);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}finally{
			DButil.close(rs, ps, conn);
		}
		return com;
	}
	
	public void delect(int id){
		Connection conn=DButil.getConn();
		String sql="delete from easybuy_comment where EC_ID=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
		public int count(){
			int count=0;
			Connection conn=DButil.getConn();
			String sql="select count(*) from easybuy_comment";
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if(rs.next()){
					count=rs.getInt("count(*)");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				DButil.close(rs, ps, conn);
			}
			return count;
		}
		
		
		public ArrayList<comment> limit(int currentpage,int size){
			ArrayList<comment>plist=new ArrayList<comment>();
			Connection conn=DButil.getConn();
			String sql="select * from easybuy_comment limit ?,?";
			
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, currentpage);
				ps.setInt(2, size);
				rs=ps.executeQuery();
				while(rs.next()){
					int ecid=rs.getInt("EC_ID");
					String eccontent=rs.getString("EC_CONTENT");
					String ec_create_time=rs.getString("EC_CREATE_TIME");
					String ecreply=rs.getString("EC_REPLY");
					String ec_reply_time=rs.getString("EC_REPLY_TIME");
					String ec_nick_name=rs.getString("EC_NICK_NAME");
					comment com=new comment(ecid, eccontent, ec_create_time, ecreply, ec_reply_time, ec_nick_name);
					plist.add(com);
					
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally{
				DButil.close(rs, ps, conn);
			}
			return plist;
		} 
		
	
	public void update(comment com){
		
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn=DButil.getConn();
		String sql="update EASYBUY_COMMENT set EC_REPLY=?, EC_CREATE_TIME=? where EC_ID=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, com.getEcreply());
			ps.setString(2, smp.format(new Date()));
			ps.setInt(3, com.getEcid());
			ps.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
	//
	public int add(comment com){
		int count =0;
		SimpleDateFormat smp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn=DButil.getConn();
		String sql="INSERT INTO easybuy_comment VALUES(null,?,?,null,null,?)";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, com.getEccontent());
			ps.setString(2, smp.format(new Date()));
			ps.setString(3, com.getEc_nick_name());
			count=ps.executeUpdate();	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
		return count;
	}
}

