package io.github.aurelienpillevesse;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import io.github.aurelienpillevesse.dao.BookDAO;
import io.github.aurelienpillevesse.dao.DAO;
import io.github.aurelienpillevesse.model.Book;
import io.github.aurelienpillevesse.model.CustomResponse;


@Path("/updatestock")
public class UpdateStock {
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String BuyWholesaler(String jsonRecevied)
	{		
		JSONParser parser = new JSONParser();
		String isbn;
		int quantity;
		
		try{
	         Object obj = parser.parse(jsonRecevied);
	         JSONObject obj2 = (JSONObject) obj;
	         isbn = (String) obj2.get("isbn");
	         
	         quantity = (int) (long) obj2.get("quantity");
	         
	     }	catch(ParseException pe){
			return pe.getMessage();
	     }
		
		DAO<Book> dao = new BookDAO();
		dao.updateStock(isbn, quantity);
		
		return quantity + " " + isbn;
		
		//appeller le stockservice pour ajouter la quantity nécessaire à la commande +5
		//call stock service
		
		
	}	
}