<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/27
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="UserServlet?action=register">
        Username:<input type="text" name="u_username" ><br>
        Password:<input type="text" name="u_password" ><br>
        Gender:<input type="radio" name="u_sex" value="male">male
               <input type="radio" name="u_sex" value="female">female<br>
        Hobbies:<input type="checkbox" name="u_hobbies" value="hiking">hiking
                <input type="checkbox" name="u_hobbies" value="boxing">boxing
                <input type="checkbox" name="u_hobbies" value="fencing">fencing
                <input type="checkbox" name="u_hobbies" value="racing">racing
                <input type="checkbox" name="u_hobbies" value="others">others<br>
        Address:<select>
                    <option>-Mainland-</option>
                    <option>-Hongkong-</option>
                    <option>-Macau-</option>
                    <option>-Taiwan-</option>
                </select>
        <input type="submit">

    </form>

</body>
</html>
