package com.isamm.tp1;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class Identification
 */
@WebServlet("/Identification")
public class Identification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Identification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		

		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		
		Connection c = (Connection) Connecteur.getConenction();
		Statement st = null;
		try {
			st = (Statement) c.createStatement();
		
		

		ResultSet resultat = st.executeQuery("select * from utilisateur where numeroCompte='"+num +"' and password='"+pass+"'");
		
		
		if(resultat.next()==false)	
			//FALSE
			getServletContext().getRequestDispatcher("/identification.html").forward(request, response); 
		else {
			//trueeee
			System.out.println(num + " "+ pass);
			session.setAttribute("nomComplet", resultat.getString("nomComplet"));
			session.setAttribute("numeroCompte", resultat.getString("numeroCompte"));
			
			
			
			//redirection lel virement
			getServletContext().getRequestDispatcher("/ListeVirements").forward(request, response);
		}
		
		
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
