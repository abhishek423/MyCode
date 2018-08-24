<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<title>test</title>
</head>
<body>
	<script>
		var linkId;
		var friendValue = "subha123";
		var userId = "ab423";

		function getLinkId(friendValue) {
			return $.ajax({
				type : "GET",
				url : "getLinkId",
				data : "userId=" + userId + "&friendValue=" + friendValue,
			});
		}

		$.when(getLinkId(friendValue)).done(function(data) {
			linkId = data;
			console.log("data" + data);
		});
	</script>

</body>
</html>