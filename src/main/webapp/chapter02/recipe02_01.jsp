<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Jakarta Server Page Example</title>
</head>
<body>
<jsp:useBean id="dateBean" scope="application"
    class="com.onndoo.book.jakarta10.recipes.chapter2.bean.DateBean"/>
Hello World!<br/>
The current date is: ${dateBean.currentDate}!
</body>
</html>