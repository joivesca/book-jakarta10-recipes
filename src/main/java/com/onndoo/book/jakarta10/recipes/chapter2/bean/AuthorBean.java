package com.onndoo.book.jakarta10.recipes.chapter2.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onndoo.book.jakarta10.recipes.chapter2.servlet.CreateConnection;

public class AuthorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Author> authorList = null;
	
	public List<Author> queryAuthors() {
		
		String sql = "SELECT id, first, last FROM book_author";
		List<Author> authorList = new ArrayList<Author>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Connection conn = CreateConnection.getConnection();			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Author author = new Author();
				author.setId(rs.getInt("id"));
				author.setFirst(rs.getString("first"));
				author.setLast(rs.getString("last"));
				authorList.add(author);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null ) {
				try {
					pstmt.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		return authorList;
	}
	
	
	public List<Author> getAuthorList() {
		authorList = queryAuthors();
		return authorList;
	}

}
