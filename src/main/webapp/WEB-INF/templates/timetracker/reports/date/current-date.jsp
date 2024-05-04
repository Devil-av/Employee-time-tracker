<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file='../../navbar.jsp' %>
<html>
 <body onload='makeActive("date")'>
  <div class='dvv'>
     <label class='hdu'>Report of current date</label>
  </div>
  <div class='container'>
   <div class='card mx-auto'>
     <div class='card-body'>
      <div class='table scrollit'>
       <table class='table table-hover'>
        <thead>
         <tr>
          <th>S.No</th><th>Emp Id</th><th>Out Time</th><th>In Time</th><th>Total Time</th><th>Date</th>
         </tr> 
        </thead>
        <tbody>
        <c:set var="sn" value="0"></c:set>
        <c:forEach var="timeinfo" items="${clist}">
          <tr> 
         	<td>${sn=sn+1}</td>
         	<td>${timeinfo.eid}</td>
         	<td>${timeinfo.outtime}</td>
         	<td>${timeinfo.intime}</td>
         	<td>${timeinfo.totaltime}</td>
         	<td>${timeinfo.date}</td>
           </tr>
        </c:forEach>
        </tbody>
       </table>
      </div>
     </div>
   </div> 
  </div>
  <div style='text-align: center;margin-top:10px'>
   <input type='button' value='Back' onclick='history.back()' class='btr' style='background-color:orange'>
  </div>
 </body>
</html>