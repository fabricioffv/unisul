<%
	session.setAttribute("NomeUsuario", "");
	Cookie cookie = new Cookie("NomeUsuario", "");
	cookie.setMaxAge(0);
	response.addCookie(cookie);
	response.sendRedirect("index.jsp");
%>