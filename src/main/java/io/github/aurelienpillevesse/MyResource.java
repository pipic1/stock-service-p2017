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
import io.github.aurelienpillevesse.model.CustomResponse;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;

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
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStock(@DefaultValue("-1") @QueryParam("isbn") String isbn) {
    	DAO<Book> dao = new BookDAO();
    	CustomResponse cr = new CustomResponse();
    	Book b = new Book();
		b = dao.find(isbn);
		
    	if(b.getIsbn() == null) {
    		cr.setData(null);
    		cr.setMessage("invalid");
    		return Response.status(404).entity(cr).build();
    	}
    	
    	cr.setData(b);
    	cr.setMessage("valid");
    	return Response.status(200).entity(cr).build();
    }
}
