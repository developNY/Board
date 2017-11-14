package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import Dto.Dto;

public class Dao {

	DataSource dataSource;
	
	public Dao(){
		try{
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/cntp");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Dto contentView(String bbId) {
		// TODO Auto-generated method stub
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Dto dto = null;
		
		try{
		con = dataSource.getConnection();
		String query = "select * from board where id=?";
		pstmt = con.prepareStatement(query);
		pstmt.setInt(1, Integer.parseInt(bbId));
		rs = pstmt.executeQuery();
		
		if(rs.next()){
			int bId = rs.getInt("bId");
			String name = rs.getString("name");
			String title = rs.getString("title");
			String content = rs.getString("content");
			
			dto = new Dto(bId, name, title, content);
		}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			rs.close();
			pstmt.close();
			con.close();
			}catch(Exception e){}
		}
		return dto;
	}

	public void write(String name, String title, String content) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = dataSource.getConnection();
			String query = "insert into board values(?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			int rn = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				con.close();
			}catch(Exception e1){}
		}
		
	}

	public void modify(String bId, String name, String title, String content) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = dataSource.getConnection();
			String query = "update board set name=?, title=?, content=? where bId=?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, Integer.parseInt(bId));
			int rn = pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
			pstmt.close();
			con.close();
			}catch(Exception e){}
		}
	}

	public ArrayList<Dto> list() {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Dto> dtos = new ArrayList<Dto>();
		
		try{
			con = dataSource.getConnection();
			String query = "select * from board";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				int bId = rs.getInt("bId");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				
				Dto dto = new Dto(bId, name, title, content);
				dtos.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}catch(Exception e2){}
		}
		return dtos;
	}

	public void delete(String bId) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = dataSource.getConnection();
			String 	query = "delete from board where bId=?";
			pstmt  = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId));
			int rs = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
			pstmt.close();
			con.close();
			}catch(Exception e2){}
		}
	}

}
