<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>${title}</title>
    <!-- css and script are there in attached source-->
</head>
<body>          
        <div class="wrap">

            <div class="login-form">
        
                <form class="login_form" name='loginForm' action="<c:url value='../j_spring_security_check' />" method='POST'>
                    <h1>Login Into Your Account</h1>
                    <ul>
                        <li>
                            <input type="text" class="textbox1" id="username" name="j_username" placeholder="Username" required="">
                            <p><img src="../images/contact.png" alt=""></p>
                        </li>
                        <li>
                            <input type="password" id="password" name="j_password" class="textbox2" placeholder="Password">
                            <p><img src="../images/lock.png" alt=""></p>
                        </li>
                    </ul>
                    <input type="submit" name="Sign In" value="Sign In">
                    <div class="clear"></div>   
                    <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i></i>Remember me</label>
                    <div class="forgot">
                        <a href="#">forgot password?</a>
                    </div>  
                    <div class="clear"></div>   
                </form>
<%--                 <c:url value="../services/signup" var="signupurl" />` --%>
            <div class="account">
                <%-- <h2><a href="${signupurl}">Don't have an account? Sign Up!</a></h2> --%>
                <!-- ?scope=email,user_about_me,user_birthday -->
                <div class="span">
                    <form name='facebookSocialloginForm' action="<c:url value='/facebook/login' />" method='POST'>
                            <img src="../images/facebook.png" alt="">
                            <button type="submit">
                                <i>Sign In with Facebook</i>
                            </button>   
                            <div class="clear"></div>
                    </form>     
                </div>  
<%--                 <div class="span1">
                    <form name='TwitterSocialloginForm'
                      action="<c:url value='../auth/twitter?scope=email,user_about_me,user_birthday' />" method='POST'>
                        <img src="../images/twitter.png" alt="">
                        <button type="submit">
                            <i>Sign In with Twitter</i>
                        </button>           
                        <div class="clear"></div>
                    </form>
                </div>
                <div class="span2">
                    <form name='LinkedInSocialloginForm'
                      action="<c:url value='../auth/linkedin' />" method='POST'>
                        <img src="../images/linkedin.png" alt="">
                        <button type="submit">
                            <i>Sign In with Linkedin</i>
                        </button>   
                        <div class="clear"></div>
                    </form>
                </div> --%>
            </div>  
            <div class="clear"></div>   
        </div>

    </div>
    
    


<div
  class="fb-like"
  data-share="true"
  data-width="450"
  data-show-faces="true">sdfsdfdfdfd
</div>
</body>
</html>