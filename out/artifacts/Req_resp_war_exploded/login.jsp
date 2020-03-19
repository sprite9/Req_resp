<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script>
        window.onload=function () {
            document.getElementById("checkcode").onclick=function () {
                this.src="/res/checkcodedemo?time="+new Date().getTime();
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
<form action="/res/CheckCodeServlet" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td ><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td ><input type="text" name="checkcode"></td>
        </tr>
        <tr>
            <td colspan="2"><img id="checkcode" src="/res/checkcodedemo"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>

    </table>
</form>
<div><%=request.getAttribute("cc_error")==null ? "" : request.getAttribute("cc_error")%></div>
<div><%=request.getAttribute("login_error")==null ? "" : request.getAttribute("login_error")%></div>

</body>
</html>
