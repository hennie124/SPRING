package com.springlec.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.springlec.Dto.BDto;

public class BDao {
DataSource dataSource;
	
	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:com/env/jdbc/mvc");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//초기화면(검색)
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select bId,bTitle,bContent,bDate from mvc_board";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				
				BDto dto = new BDto(bId,bName,bTitle,bContent,bDate);
				dtos.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtos;
	}

}
