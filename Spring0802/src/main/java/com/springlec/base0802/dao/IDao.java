package com.springlec.base0802.dao;

import java.util.ArrayList;

import com.springlec.base0802.dto.ContentDto;

public interface IDao {
	
	//전체검색
	public ArrayList<ContentDto> listDao();
	
	//조건검색
	public ArrayList<ContentDto> listQuery(String query, String content);
	
	//입력
	public void writeDao(String name, String telno, String address, String email , String relation);
	
	//특정 검색
		public ContentDto selectDao(int seqno);
		
	//수정
		public void updateDao(String name, String telno, String address, String email , String relation,int seqno);
	
	//삭제
	public void deleteDao(int seqno);
}
