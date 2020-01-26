<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          
        
        <h1>Login | Logout  <a href="${pageContext.request.contextPath}/reporter/sec/logout"> > </a> </h1>
        <form name="form" action="${pageContext.request.contextPath}/j_security_check" method="post">
            <p>
                
                <label id="name">Name:</label>
                <input type="text" name="j_username" value="" />
            </p>
            <p>
                <label id="password">Password:</label>
                <input type="password" name="j_password" value=""/>
            </p>
            <p>
                <input type="submit" value="Login" name="button"/>
                </form>
            </p>
            ${msg}
            <hr>s
              
        <form name="form" action="${mvc.basePath}/j_security_check" method="post">
            <p>
                <input type="submit" value="Logout" name="button"/>
            </p>
        
        </form>
    </body>
</html>
