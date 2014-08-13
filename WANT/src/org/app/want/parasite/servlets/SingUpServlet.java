package org.app.want.parasite.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.app.want.parasite.converters.ToUserAccount;
import org.app.want.parasite.file.File;
import org.app.want.parasite.useraccount.UserAccount;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.gson.Gson;

@SuppressWarnings("serial")
public class SingUpServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		UserAccount s = new UserAccount();
		String servletPath = req.getQueryString().toString();
		String user = servletPath;
		
		try{
			Query q = new Query("UserAccount").setFilter(new FilterPredicate("userName", FilterOperator.EQUAL, user));
			PreparedQuery pq = datastore.prepare(q);
			Entity e = pq.asSingleEntity();
			
			s.setName((String) e.getProperty("name"));
			s.setSurname((String) e.getProperty("surname"));
			s.setUserName((String) e.getProperty("userName"));
			s.setPassword((String) e.getProperty("password"));
			s.setMail((String)e.getProperty("mail"));
			s.setPhone((String)e.getProperty("phone"));
			s.setZipcode(new Integer(e.getProperty("zipcode").toString()));
			
			Gson gson = new Gson();
			String cad= gson.toJson(s);
			resp.setContentType("text/json");
			resp.getWriter().println(cad);
			
		}catch(Exception e){
			System.out.println("Exception: Method GET SingUpServlet");
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		UserAccount s = ToUserAccount.urlToUserAccount(req.getQueryString());
		Entity e = new Entity("UserAccount");
		Entity u = new Entity("User");
		
		e.setProperty("name", s.getName());
		e.setProperty("surname", s.getSurname());
		e.setProperty("userName", s.getUserName());
		u.setProperty("userName", s.getUserName());
		e.setProperty("password", s.getPassword());
		e.setProperty("mail", s.getMail());
		u.setProperty("mail", s.getMail());
		e.setProperty("phone", s.getPhone());
		u.setProperty("phone", s.getPhone());
		e.setProperty("zipcode", s.getZipcode());
		e.setProperty("uType", s.getuType());
		u.setProperty("files", new ArrayList<File>());
		
		datastore.put(e);
		datastore.put(u);
		
		Gson gson = new Gson();
		String cad= gson.toJson(s);
		resp.setContentType("text/json");
		resp.getWriter().println(cad);
	}
	public void doDelete (HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		String user = req.getQueryString().toString();
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		
		try{

			Filter f = new FilterPredicate("userName",Query.FilterOperator.EQUAL,user);
			Query q = new Query("UserAccount").setFilter(f);
			Query qu = new Query("User").setFilter(f);
			PreparedQuery pq = datastore.prepare(q);
			PreparedQuery pqu = datastore.prepare(qu);
			Entity e = pq.asSingleEntity();
			Entity eu = pqu.asSingleEntity();
			
			datastore.delete(e.getKey());
			datastore.delete(eu.getKey());
			
			Gson gson = new Gson();
			String cad= gson.toJson(user);
			resp.setContentType("text/json");
			resp.getWriter().println(cad);
			
		}catch(Exception e){
			System.out.println("Error deleting a UserAccount Object"
					+ "Maybe the entity doesn't exist in datastore.");
		}
		
	}
	public void doPut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException{
		UserAccount user = ToUserAccount.urlToUserAccount(req.getQueryString().toString());
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		try{
			Query q = new Query("UserAccount").setFilter(new FilterPredicate("userName", Query.FilterOperator.EQUAL, user.getUserName()));
			Query qu = new Query("User").setFilter(new FilterPredicate("userName", Query.FilterOperator.EQUAL, user.getUserName()));
			PreparedQuery pq = datastore.prepare(q);
			PreparedQuery pqu = datastore.prepare(qu);
			Entity e = pq.asSingleEntity();
			Entity eu = pqu.asSingleEntity();
			
			e.setProperty("name", user.getName());
			e.setProperty("surname", user.getSurname());
			e.setProperty("userName", user.getUserName());
			eu.setProperty("userName", user.getUserName());
			e.setProperty("password", user.getPassword());
			e.setProperty("mail", user.getMail());
			eu.setProperty("mail", user.getMail());
			e.setProperty("phone", user.getPhone());
			eu.setProperty("phone", user.getPhone());
			e.setProperty("zipcode", user.getZipcode());
			e.setProperty("uType", user.getuType());
			
			datastore.put(e);
			datastore.put(eu);
			
			Gson gson = new Gson();
			String cad= gson.toJson(user);
			resp.setContentType("text/json");
			resp.getWriter().println(cad);

		}catch(Exception e){
			System.out.println("Error updating a Teacher Object");
		}
		
	}
	
}
