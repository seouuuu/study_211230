<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function () {
    $("button").click(function() {
        $("tbody").empty();
        
        $.ajax({
            url:"listCustomer.jsp",
            success:function(arr){
                $.each(arr,function(){
                      let td1 = $("<td></td>").html(this.custid);
                      let td2 = $("<td></td>").html(this.name);
                      let td3 = $("<td></td>").html(this.address);
                      let td4 = $("<td></td>").html(this.phone);
                      let tr = $("<tr></tr>").append(td1,td2,td3,td4);
                      $("tbody").append(tr);
                });
            }
        });
    });
});
</script>
</head>
<body>
    <button>고객 목록 확인</button>
    <hr>
    <table border="1">
        <thead>
        <tr>
            <th>고객번호</th>
            <th>이름</th>
            <th>주소</th>
            <th>전화번호</th>
        </tr>
        </thead>
        <tbody></tbody>
    </table>
</body>
</html>