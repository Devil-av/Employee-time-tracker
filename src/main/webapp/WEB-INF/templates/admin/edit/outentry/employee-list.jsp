<%@ include file="../../navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <body onload="makeActive('outentry')">
 <form action="/employee-time-tracker/admin/edit/updateoutentry">
  <div class='dv'>
   <label class='hdu'>Edit employee outtime entry</label>
  </div>
  <div class='dv'>
   <select name="eid1" id="eid1" class='la' onchange="checkEmployee(this)">
   	 <option value="-1">Select incorrect Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	  <option value="${emp.eid}">${emp.firstname} ${emp.lastname}(${emp.eid})</option>
   	 </c:forEach>
   </select>&nbsp;&nbsp;&nbsp;
   <select name="eid2" id="eid2" class='la' onchange="checkEmployee(this)">
   	 <option value="-1">Select correct Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	  <option value="${emp.eid}">${emp.firstname} ${emp.lastname}(${emp.eid})</option>
   	 </c:forEach>
   </select>
  </div>
  <div class='dv'>
   <button disabled id='bt' class='btn btn-primary' onclick="return checkEmployeeId()">Submit</button>
  </div>
  <div class='dvv' id='msg'>
  </div> 
 </form> 
 </body>
</html>