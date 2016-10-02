<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Author Sneha Kasetty Sudarshan -->
<html>
<head>
    <style type="text/css">
    #twitter-table {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        font-size: 12px;
        margin: 5px;
        text-align: left;
        border-collapse: collapse;
        border: 1px solid #69c;
    }

    #twitter-table th {
        padding: 12px 17px 12px 17px;
        font-weight: normal;
        font-size: 14px;
        /*color: #039;*/
        /*  border-bottom: 1px dashed #69c; */
    }

    #twitter-table td {
        padding: 7px 17px 7px 17px;
        color: #669;
    }

    #twitter-table tbody tr:hover td {
        color: #339;
        background: #d0dafd;
    }

    #image {
        height: 100px;
        text-align: left;
        display: inline-block;
        margin-right: 10px;
    }

    #header {
        display: inline-block;
        color: teal;
        font-size: 48px;
        vertical-align: top;
        font-family: 'Signika', sans-serif;
        margin: 0;
        margin-top: 25px;
        margin-left: 50px;
    }

    #header-div {
        height: 100px;
        border: 1px solid teal;
        margin-bottom: 30px;
        width: 680px;
    }

    .inlineTable {
        display: inline-block;
    }
    </style>
</head>

<body>
    <div style="border:1px;width: 694px;margin: auto;">
      <%-- Header and image  --%>
        <div id="header-div">
            <img src="data:image/jpeg;base64,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" id="image">
            <h1 id="header">Twitter Dashboard</h1>
        </div>
        <%-- Tweets count/followers/follows table --%>
        <table id="twitter-table" class="inlineTable" style="height:133px">
            <thead>
                <tr>
                    <th scope="col">Tweets</th>
                    <th scope="col">${count}</th>
                </tr>
                <tr>
                    <th scope="col">Followers</th>
                    <th scope="col">${followers}</th>
                </tr>
                <tr>
                    <th scope="col">Follows</th>
                    <th scope="col">${following}</th>
                </tr>
            </thead>
        </table>
        <%-- This div contains 2 tables --%>
        <%-- One for header and the other for tweets --%>
        <div class="inlineTable">
            <table id="twitter-table" style="width: 503px;"">
                <thead  style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Tweets</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 500px;height: 80px;overflow: scroll;">
                <tbody>            
                    <c:forEach var="twt" items="${tweets}">
    					  <tr><td><c:out value="${twt}"/></td></tr>
					</c:forEach>                
                </tbody>
            </table>
        </div>
    </div>
    <%-- This div contains trends and  timeline --%>
     <div style="border:1px;margin-top: 50px;width: 694px;margin: auto;">
       <div class="inlineTable">
            <table id="twitter-table" style="width: 328px;">
                <thead style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Trends</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 325px;height: 180px;overflow: scroll;">
                <tbody>
                       <c:forEach var="trendslist" items="${trends}">
    					  <tr><td><c:out value="${trendslist}"/></td></tr>
					</c:forEach>             
                </tbody>
            </table>
        </div>
        <div class="inlineTable">
            <table id="twitter-table" style="width: 328px;"">
                <thead style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Timeline</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 325px;height: 180px;overflow: scroll;">
                <tbody>
                    <c:forEach var="timelinelist" items="${timeline}">
    					  <tr><td><c:out value="${timelinelist}"/></td></tr>
					</c:forEach> 
                </tbody>
            </table>
        </div>
    </div>
    <%-- This div contains 3 tables Friends/Followers/Re-tweets --%>
     <div style="border:1px;margin-top: 50px;width: 694px;margin: auto;">
        <div class="inlineTable">
            <table id="twitter-table" style="width: 213px;"">
                <thead style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Friends</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 210px;height: 80px;overflow: scroll;">
                <tbody>
                    <c:forEach var="friendslist" items="${friendsNames}">
    					  <tr><td><c:out value="${friendslist}"/></td></tr>
					</c:forEach> 
                </tbody>
            </table>
        </div>
        <div class="inlineTable">
            <table id="twitter-table" style="width: 213px;"">
                <thead style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Followers</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 210px;height: 80px;overflow: scroll;">
                <tbody>
                    <c:forEach var="followerlist" items="${follwerNames}">
    					  <tr><td><c:out value="${followerlist}"/></td></tr>
					</c:forEach> 
                </tbody>
            </table>
        </div>
        <div class="inlineTable">
            <table id="twitter-table" style="width: 213px;"">
                <thead style="background: teal;color: white;">
                    <tr>
                        <th scope="col">Re-Tweets</th>
                    </tr>
                </thead>
            </table>
            <table id="twitter-table" class="inlineTable" style="width: 210px;height: 80px;overflow: scroll;">
                <tbody>
                    <c:forEach var="retweetlist" items="${reTweets}">
    					  <tr><td><c:out value="${retweetlist}"/></td></tr>
					</c:forEach> 
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
