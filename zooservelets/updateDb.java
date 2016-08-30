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
 * Servlet implementation class updateDb
 */
@WebServlet("/updateDb")
public class updateDb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateDb() {
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
		
		Animal updateDb = new Animal();
		
		updateDb.setAnimalID(Integer.parseInt(request.getParameter("animal_id")));
		updateDb.setAnimalSpecies(request.getParameter("animal_species"));
		updateDb.setAnimalName(request.getParameter("animal_name"));
		updateDb.setAnimalAge(Integer.parseInt(request.getParameter("animal_age")));
		updateDb.setAnimalWeight(Double.parseDouble(request.getParameter("animal_weight")));
		
		DAOZoo.updateToDatabase(updateDb);
		
		
	}

}
