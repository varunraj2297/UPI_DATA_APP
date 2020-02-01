<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View/Update/Delete Customers</title>
<style type="text/css">
table,td,thead,tr,th {
	padding: 5px;
	border: 2px solid black;
	text-align: center;
	border-collapse: collapse;
}
</style>
</head>
<body>
<h1 style="color:red;text-align: center">All UPI Data</h1>
   <c:choose>
     <c:when test="${!empty upis}">
       <table align="center" style="padding: 10px">
         <thead>
           <tr>
              <th>S.No</th>
              <th>Name</th>
              <th>Address</th>
              <th>Logo</th>
              <th>URL</th>
              <th>Code</th>
              <th>KI </th>
              <th>Key Value </th>
              <th>Created Date</th>
              <th>Update Date</th>
           </tr>
         </thead>
         <tbody>
            <c:forEach items="${upis}" var="upi" varStatus="index">
              <tr>
                <td>${index.count}</td>
                <td>${upi.name}</td>
                <td>${upi.addr}</td>
                <td>${upi.logo}</td>
                <td>${upi.url}</td>
                <td>${upi.code}</td>
                <td>${upi.ki}</td>
                <td>${upi.keyValue}</td>
                <td>${upi.createdDate}</td>
                <td>${upi.updateDate}</td>
              </tr>
             </c:forEach>
         </tbody>
       </table>
     </c:when>
     
     <c:otherwise>
        <h1 style="color: red;text-align: center">No UPI Data Found</h1>
     </c:otherwise>
   </c:choose>
<br><br>
<center>
   <c:if test="${currentPage>1}">
         <a href="getAllUPIData?pn=${currentPage-1}">Previous</a>
   </c:if>
   
   <c:forEach begin="1" end="${totalPages}" var="i">
      
      <c:choose>
        <c:when test="${ i == currentPage}">
         ${i}
        </c:when>
        <c:otherwise>
          <a href="getAllUPIData?pn=${i}">${i}</a>
        </c:otherwise>
      </c:choose>
  
   </c:forEach>
   
   <c:if test="${currentPage<totalPages}">
         <a href="getAllUPIData?pn=${currentPage+1}">Next</a>
   </c:if>
   
   <br><br>
   
   <a href="/">Home</a>
 </center>  
</body>
</html>