package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.aurelienpillevesse.model.Book;

public class BookDAO {
	protected Connection connect = null;
    protected ResultSet rs = null;
	protected PreparedStatement st = null;

    public BookDAO(){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
			this.connect = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public boolean create(Book object) {
		return false;
	}

	public boolean delete(Book object) {
		return false;
	}

	public boolean update(Book object) {
		return false;
	}

	public Book find(String isbn) {
		Book book = new Book();
		
		try {
			this.st = this.connect.prepareStatement("select * from books where isbn = ?");
			/*this.st.setString(1, isbn);
			book.setIsbn("haha");
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				//book.setIsbn(this.rs.getString("isbn"));
				//book.setStock(this.rs.getInt("stock"));
			}
			this.rs.close();
			this.st.close();*/
		} catch (Exception e) {
			book.setIsbn(e.toString());
			e.printStackTrace();
		}
		
		return book;
	}
}
