package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDataService;
import com.virtualpairprogrammers.domain.MenuItem;

public class OrderServlet extends HttpServlet {

	public void service (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		out.println("<html><body><h1>Ricky's Restaurant</h1><h2>Order your food</h2>");
		out.println("<form action='/restaurant/orderReceived.html' method='POST'><ul>");
		
		MenuDataService menuDataService = new MenuDataService();
		List<MenuItem> menuItems = menuDataService.getFullMenu();
		
		for (MenuItem menuItem : menuItems) {
			out.print("<li>" + menuItem + "<input type='text' name='item_" + menuItem.getId() + "' /></li>");
		}
		
		out.println("</ul><input type='submit' />");
		out.println("</form></body></html>");
		
		out.close();
	}
}
