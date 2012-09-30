<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mysql.jdbc.Connection"%>
<%@ page import="com.mysql.jdbc.Statement"%>
<%@ page import="com.isamm.tp1.*" %>
<%
ArrayList<Virement> listV = new ArrayList<Virement>();
listV =(ArrayList<Virement>)session.getAttribute("liste");

%>
Bonjour <%out.print(session.getAttribute("nomComplet")); %>
<br>
Vous avez <%out.print(session.getAttribute("solde")); %> dinars

<TABLE width=60% border=1>
<TR>
<TD>Num Benif</TD> 
<TD>Montant</TD> 
</TR>

<% for (int i=0;i<listV.size();i++)
{
	%><TR>
	<TD><%out.print( listV.get(i).getBenif()); %> </TD> 
	<TD><%out.print( listV.get(i).getMontant());  %> </TD> 
	</TR>

<%
}
	
	
	
	%>

</TABLE> <br>
<a href="nouveauVir.html">Nouveau Virement</a>


</body>
</html>