package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
import io.github.aurelienpillevesse.model.Book;

public class BookDAO extends DAO<Book> {
	public BookDAO() {
		super();
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
			this.st.setString(1, isbn);
			book.setIsbn(this.st.toString());
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				//book.setIsbn(this.rs.getString("isbn"));
				//book.setStock(this.rs.getInt("stock"));
			}
			this.rs.close();
			this.st.close();
		} catch (Exception e) {
			book.setIsbn(e.toString());
			e.printStackTrace();
		}
		
		return book;
	}
}
