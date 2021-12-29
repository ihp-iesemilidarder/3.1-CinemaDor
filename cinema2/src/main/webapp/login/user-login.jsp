<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="frmLogin" method="post" action="/cinema/action-login">
		<p>
			<label>Nom usuari (nick):</label>
			<input name="usuName" type="text" value="" required="required" />
		</p>
		<p>
			<label>Password:</label>
			<input name="usuPass" type="password" value="" required="required" />
		</p>
		<button type="submit">Entrar</button>		
	</form>

</body>
</html>