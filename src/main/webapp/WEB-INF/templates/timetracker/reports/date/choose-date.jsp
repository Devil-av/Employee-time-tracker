<%@ include file="../../navbar.jsp" %>
<html>
  <body onload="makeActive('date')">
  <div class='dvv'>
    <label class='lahu'>View date wise report</label>
  </div>
   <table class='ta'>
    <tr>
     <td class='pd'>
      <form action='datewise/current' method="post">
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
      <form action='datewise/any' method="post">
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