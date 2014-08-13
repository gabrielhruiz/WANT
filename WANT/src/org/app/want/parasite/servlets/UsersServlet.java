package org.app.want.parasite.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.want.parasite.useraccount.UserAccount;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class UsersServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		UserAccount s = new UserAccount();
		String servletPath = req.getQueryString().toString();
		String user = servletPath;
		
		try{
			Query q = new Query("User").setFilter(new FilterPredicate("userName", FilterOperator.EQUAL, user));
			PreparedQuery pq = datastore.prepare(q);
			Entity e = pq.asSingleEntity();
			
			s.setUserName((String) e.getProperty("userName"));
			s.setMail((String)e.getProperty("mail"));
			s.setPhone((String)e.getProperty("phone"));
			
			Gson gson = new Gson();
			String cad= gson.toJson(s);
			resp.setContentType("text/json");
			resp.getWriter().println(cad);
			
		}catch(Exception e){
			System.out.println("Exception: Method GET UserServlet");
		}
	}
}
