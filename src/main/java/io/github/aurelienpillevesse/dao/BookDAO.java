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
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				book.setIsbn(this.rs.getString("isbn"));
				book.setBookName(this.rs.getString("book_name"));
				book.setStock(this.rs.getInt("stock"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    try { this.st.close(); } catch (Exception e) { /* ignored */ }
		    try { this.rs.close(); } catch (Exception e) { /* ignored */ }
		    try { this.connect.close(); } catch (Exception e) { /* ignored */ }
		}
		
		return book;
	}
}
