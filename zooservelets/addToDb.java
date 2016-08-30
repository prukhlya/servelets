package com.zooservelets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.animalsinzoo.Animal;
import com.animalsinzoo.DAOZoo;

/**
 * Servlet implementation class addToDb
 */
@WebServlet("/addToDb")
public class addToDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToDb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Animal addToDb = new Animal();
		
		Integer age = Integer.parseInt(request.getParameter("animal_age"));
		Double weight = Double.parseDouble(request.getParameter("animal_weight"));
		
		addToDb.setAnimalSpecies(request.getParameter("animal_species"));
		addToDb.setAnimalName(request.getParameter("animal_name"));
		addToDb.setAnimalAge(age);
		addToDb.setAnimalWeight(weight);
		
		DAOZoo.writeToDatabase(addToDb);
	} // do post

}
