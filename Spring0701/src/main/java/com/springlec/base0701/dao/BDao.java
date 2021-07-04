package com.springlec.base0701.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.springlec.base0701.dto.BDto;
import com.springlec.base0701.util.Constant;

public class BDao {
	
//	DataSource dataSource;
	JdbcTemplate template;
	
	public BDao() {
		this.template = Constant.template;
		
		// TODO Auto-generated constructor stub
//		try { 
//			Context context = new InitialContext();
//			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc_board");
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	// 초기화면(검색)
	
	public ArrayList<BDto> list(){
		
	//방법3
	String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
	return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		
		
		//방법2
//		ArrayList<BDto> dtos = null;
//		String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//		dtos = (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
//		return dtos;
		
	
		//방법1
//		ArrayList<BDto> dtos = new ArrayList<BDto>();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board";
//			preparedStatement = connection.prepareStatement(query);
//			resultSet = preparedStatement.executeQuery();
//			
//			while(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate);
//				dtos.add(dto);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return dtos;
	}
	
	public void write(final String bName,final String bTitle,final String bContent) {
		//final을 쓰면 다오에서 데이터를 바꿀 수 없다!!
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				String query = "insert into mvc_board(bName, bTitle, bContent, bDate) values(?,?,?,now())";
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1,bName);
				preparedStatement.setString(2,bTitle);
				preparedStatement.setString(3,bContent);
				
				return preparedStatement;
			}
		});
		
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//		connection = dataSource.getConnection();
//		
//		String query = "insert into mvc_board(bName, bTitle, bContent, bDate) values(?,?,?,now())";
//		preparedStatement = connection.prepareStatement(query);
//		preparedStatement.setString(1,bName);
//		preparedStatement.setString(2,bTitle);
//		preparedStatement.setString(3,bContent);
//		preparedStatement.executeUpdate();
//		}catch(Exception e) {
//		e.printStackTrace();
//	}finally {
//		try {
//			if(preparedStatement != null) preparedStatement.close();
//			if(connection != null) connection.close();
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//		
	}
//	
	public void delete(final int bId) {
		String query = "delete from mvc_board where bId = ? ";
		this.template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, bId);
			}
		});
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String query = "delete from mvc_board where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1,bId);
//			preparedStatement.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				//정리 다시 거꾸로 정리해주는것
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e){
//				e.printStackTrace();
//				
//			}
//		}
	}

	public void update(final String bId, final String bName, final String bTitle, final String bContent) {
		String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setString(4, bId);
			}
		});
	
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ?, bDate = now() where bId = ?";
//			preparedStatement = connection.prepareStatement(query);
//			
//			preparedStatement.setString(1, bName);
//			preparedStatement.setString(2, bTitle);
//			preparedStatement.setString(3, bContent);
//			preparedStatement.setString(4, bId);
//			
//			
//			preparedStatement.executeUpdate();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				//정리 다시 거꾸로 정리해주는것
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch(Exception e){
//				e.printStackTrace();
//				
//			}
//		}
	}

	 public BDto contentView(String Id) {
		 String query = "select * from mvc_board where bId = "+ Id;
		 return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
		 
		 
		 //where 뒤에 bId = ?에서 ?를 빼자!!
//		BDto dto = new BDto();
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			connection = dataSource.getConnection();
//			
//			String query = "select bId, bName, bTitle, bContent, bDate from mvc_board where bId = ? ";
//			preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, Id);
//			resultSet = preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				int bId = resultSet.getInt("bId");
//				String bName = resultSet.getString("bName");
//				String bTitle = resultSet.getString("bTitle");
//				String bContent = resultSet.getString("bContent");
//				Timestamp bDate = resultSet.getTimestamp("bDate");
//				
//				 dto = new BDto(bId, bName, bTitle, bContent, bDate);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(resultSet != null) resultSet.close();
//				if(preparedStatement != null) preparedStatement.close();
//				if(connection != null) connection.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return dto;
//
	}
	
	
} // BDao
