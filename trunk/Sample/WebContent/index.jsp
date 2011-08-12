<%@page import="javax.swing.text.html.HTML"%>
<html>
<head>
<title>Welcome!</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body>
	<h2>Welcome!</h2>
	<form name="hello" method="post" action="hello.action">
		user name<input type="text" name="name" /> 
		email<input type="text" name="email" />
		<input type="submit" value="commit" />
	</form>
</body>
</html>