package com.isamm.tp1;






import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class ListeVirements
 */
@WebServlet("/ListeVirements")
public class ListeVirements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListeVirements() {
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
		String numeroCompte = (String) session.getAttribute("numeroCompte");
		
		System.out.println(numeroCompte);
		
		ArrayList<Virement> listV = new ArrayList<Virement>();
		
		Connection c = (Connection) Connecteur.getConenction();
		Statement st = null;
		Statement st2 = null;
		String solde = null;
		try {
			st = (Statement) c.createStatement();
		
			ResultSet resultat = st.executeQuery("SELECT * FROM  `virement` WHERE numeroCompteExpediteur ='"+numeroCompte+"'");
			
			while(resultat.next())
			{
				listV.add(new Virement(resultat.getInt(1), resultat.getInt(2), resultat.getInt(3), resultat.getInt(4)));
			}
	
			session.setAttribute("liste", listV );
			
			st2 = (Statement) c.createStatement();
			ResultSet resultat2 = st2.executeQuery("SELECT  solde FROM utilisateur where numeroCompte='"+numeroCompte+"'");
			
			if(resultat2.next())
			{
				solde=resultat2.getString("solde");
				session.setAttribute("solde",solde);
			}
			
			getServletContext().getRequestDispatcher("/ListeVirement.jsp").forward(request, response);
		
			
		
			
		
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
