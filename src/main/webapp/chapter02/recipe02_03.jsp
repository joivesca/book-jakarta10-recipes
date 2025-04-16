<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe 2-3: Separating Business Logic from View Code</title>
</head>
<body>
<jsp:useBean id="randomBean" scope="application"
             class="com.onndoo.book.jakarta10.recipes.chapter2.bean.RandomBean"/>
Display a Random Number!<br/>
Your random number is ${randomBean.randomNumber}. Refresh page to see another!

</body>
</html>
