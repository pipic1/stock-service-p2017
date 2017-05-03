package io.github.aurelienpillevesse;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.aurelienpillevesse.dao.BookDAO;
import io.github.aurelienpillevesse.dao.DAO;
import io.github.aurelienpillevesse.model.Book;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;

/**
 * Root resource (exposed at "bookStock" path)
 */
@Path("bookStock")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book getStock(Book b) {
    	DAO<Book> dao = new BookDAO();    	
		b = dao.find(b.getIsbn());
		
    	return b;
    	//database connexion
    	//get request : stock where isbn = :isbn
    	
    	/*ResultSet rs = null;
    	PreparedStatement st = null;
    	int stock = 0;
    	
    	try {		
			st = getConnection().prepareStatement("select * from books where isbn = ?");
			st.setInt(1, isbn); 
			rs = st.executeQuery();
			while (rs.next()) {
				stock = rs.getInt("stock");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
    	//return "stock de livre pour l'isbn " + isbn + ": " + stock;
    	
    	//verification si isbn faux
        
    }
}
