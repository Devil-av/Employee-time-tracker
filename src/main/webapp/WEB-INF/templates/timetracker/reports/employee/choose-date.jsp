<%@ include file="../../navbar.jsp" %>
<html>
  <body onload="makeActive('emp')">
  <div class='dvv'>
    <label class='lahu'>View date wise report of employee having id ${eid}</label>
  </div>
   <table class='ta'>
    <tr>
     <td class='pd'>
      <form action='current'>
       <input type="hidden" value="${eid}" name="eid">
       <table class='cdta'>
        <tr>
         <td>Current date</td>
         <td align="right"><button class='cdbt'>SUBMIT</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
    <tr>
     <td class='pd'>
      <form action='any' method="post">
      <input type="hidden" value="${eid}" name="eid">
       <table class='cdta'>
        <tr>
         <td>Any date</td>
         <td><input type='date' class='tb' name='date' max="${cdate}" style='width:15vw' required></td>
         <td align="right"><button class='cdbt'>SUBMIT</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
    <tr>
     <td class='pd'>
      <form action="datewise/date-between" method="post">
      <input type="hidden" value="${eid}" name="eid">
       <table class='cdta'>
        <tr>
         <td>Date between&nbsp;&nbsp;&nbsp;&nbsp;</td>
         <td><input type='date' class='tb' id='date1' max="${cdate}" name="date1" style='width:15vw' required></td>
         <td><input type='date' class='tb' id='date2' max="${cdate}" name="date2" style='width:15vw' required></td>
         <td align="right"><button class='cdbt' onclick='return compareDate()'>SUBMIT</button></td>
        </tr>
       </table>
      </form>
     </td>
    </tr>
   </table>
 </body>
</html>