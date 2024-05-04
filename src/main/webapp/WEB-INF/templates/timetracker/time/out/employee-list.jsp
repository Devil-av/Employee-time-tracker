<%@ include file="../../navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <body onload="makeActive('out')">
 <form action="/employee-time-tracker/timetracker/timeout/record-outtime">
  <div class='dv'>
   <label class='hdu'>Record employee out time</label>
  </div>
  <div class='dv'>
   <select name="eid" id="eid" class='la' onchange="checkEmployee(this)">
   	 <option value="-1">Select Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	  <option value="${emp.eid}">${emp.firstname} ${emp.lastname}(${emp.eid})</option>
   	 </c:forEach>
   </select>
  </div>
  <div class='dv'>
   <button disabled id='bt' class='btn btn-primary'>Submit</button>
  </div>
  <div class='dvv' id='msg'>
  </div> 
 </form> 
 </body>
</html>