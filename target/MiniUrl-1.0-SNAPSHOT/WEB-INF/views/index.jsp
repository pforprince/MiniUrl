<%-- 
    Document   : index
    Created on : 5 Sep, 2020, 7:11:46 PM
    Author     : princ
--%>
<%@include file="Components/CommonProperties.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mini Url</title>
    </head>
    <body  style="background-color: teal">
        <div class="container p-5">
            <c:if test="${alertMessage}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Oops!</strong> You have entered a wrong link!
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
            </c:if>
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <p class="display-4 text-center" style="color: white">Shorten your url in no time</p>
                    <hr>
                    <form action="short-url" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" name="url" placeholder="Enter your url">
                        </div>
                        <div class="text-center" >         
                            <button style="width: 50%" type="submit" class="btn btn-danger">Get shorter Url</button>
                        </div>
                    </form>
                    <hr>
                    <c:if test="${shorterUrl!=null}">
                        <div class="text-center" >         
                            <input type="text" class="form-control" value="${shorterUrl}"  id="myInput" >
                            <br>
                            <button  onclick="myFunction()" style="width: 50%" type="button" class="btn btn-success">Click to Copy</button>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </body>
</html>
