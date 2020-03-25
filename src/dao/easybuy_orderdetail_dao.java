package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import DBhelper.DButil;

import entity.easybuy_order;
import entity.easybuy_orderdetail;

public class easybuy_orderdetail_dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	//Ìí¼Ó
	public int add(easybuy_orderdetail orderdet){
		
		int count = 0;
		conn=DButil.getConn();
		try {
			String sql = "INSERT into EASYBUY_ORDER_DETAIL VALUES(null,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, orderdet.getEO_ali_id());
			ps.setInt(2, orderdet.getEP_ID());
			ps.setInt(3, orderdet.getEOD_Quantity());
			ps.setDouble(4, orderdet.getEOD_COST());
			
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DButil.close(rs, ps, conn);
		}
		return count;
	}
}
