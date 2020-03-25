package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBhelper.DButil;

import entity.product_category;

//查询
public class Product_categoryDao {
	public ArrayList<product_category> select(){
	ArrayList<product_category>pclist=new ArrayList<product_category>();
	Connection conn=DButil.getConn();
	String sql="select * from easybuy_product_category";
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			int EPC_ID=rs.getInt("EPC_ID");
			String EPC_NAME=rs.getString("EPC_NAME");
			int EPC_PARENT_ID=rs.getInt("EPC_PARENT_ID");
			product_category pc=new product_category(EPC_ID, EPC_NAME, EPC_PARENT_ID);
			pclist.add(pc);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		DButil.close(rs, ps, conn);
	}
	return pclist;
	}

	//添加
	public void add(product_category pc){
		Connection conn=DButil.getConn();
		String sql="insert into easybuy_product_category values(null,?,?)";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, pc.getEPC_NAME());
			ps.setInt(2, pc.getEPC_PARENT_ID());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
	}
	
	//修改
	public int update(product_category pc){
		int count=0;
		Connection conn=DButil.getConn();
		String sql="update easybuy_product_category set EPC_NAME=?,EPC_PARENT_ID=? where EPC_ID=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, pc.getEPC_NAME());
			ps.setInt(2, pc.getEPC_PARENT_ID());
			ps.setInt(3, pc.getEPC_ID());
			count=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
		return count;
	}
	
	//删除
	public int delete(int EPC_ID){
		int count=0;
		Connection conn=DButil.getConn();
		String sql="delete from easybuy_product_category where EPC_ID=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1,EPC_ID );
			count=ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			DButil.close(null, ps, conn);
		}
		return count;
	}
	//
	//查单个
	
		public product_category selectone(int id){
		product_category pclist=new product_category(0, null, 0);
		Connection conn=DButil.getConn();
		String sql="select * from easybuy_product_category where EPC_ID=?";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				int EPC_ID=rs.getInt("EPC_ID");
				String EPC_NAME=rs.getString("EPC_NAME");
				int EPC_PARENT_ID=rs.getInt("EPC_PARENT_ID");
				pclist=new product_category(EPC_ID, EPC_NAME, EPC_PARENT_ID);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return pclist;
		}
		
		//查父ID
		
		public ArrayList<product_category> selectpare(int pareid){
			ArrayList<product_category>pclist=new ArrayList<product_category>();
			Connection conn=DButil.getConn();
			String sql="select * from easybuy_product_category where EPC_PARENT_ID=?";
			PreparedStatement ps=null;
			
			ResultSet rs=null;
			try {
				ps=conn.prepareStatement(sql);
				ps.setInt(1, pareid);
				rs=ps.executeQuery();
				while(rs.next()){
					int EPC_ID=rs.getInt("EPC_ID");
					String EPC_NAME=rs.getString("EPC_NAME");
					int EPC_PARENT_ID=rs.getInt("EPC_PARENT_ID");
					product_category pc=new product_category(EPC_ID, EPC_NAME, EPC_PARENT_ID);
					pclist.add(pc);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, ps, conn);
			}
			return pclist;
			}
}
