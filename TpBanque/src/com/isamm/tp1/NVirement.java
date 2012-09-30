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
 * Servlet implementation class NVirement
 */
@WebServlet("/NVirement")
public class NVirement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NVirement() {
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
		
		
		String benif = request.getParameter("benif");
		String montant = request.getParameter("montant");
		
		int oldSolde = 0;
		
		Connection c = (Connection) Connecteur.getConenction();
		Statement st = null;
		
			try {
				st = (Statement) c.createStatement();
			
				 st.executeUpdate("INSERT INTO `virement`(`numeroCompteExpediteur`, `numeroCompteDestinataire`, `montantVirement`) VALUES ("+numeroCompte+","+benif+","+montant+")");
		
			
			String sql2 = "SELECT `solde` FROM `utilisateur` WHERE numeroCompte='"+numeroCompte+"'";
			ResultSet resultat = st.executeQuery(sql2);
			while(resultat.next())
			{
				oldSolde = resultat.getInt(1);
			}
			
			int newSolde = oldSolde - Integer.parseInt(montant) ;
			
		st.executeUpdate("UPDATE `utilisateur` SET  `solde`='"+newSolde+"' WHERE numeroCompte='"+numeroCompte+"'");
		
		
		
		getServletContext().getRequestDispatcher("/ListeVirements").forward(request, response); 
			
			
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
