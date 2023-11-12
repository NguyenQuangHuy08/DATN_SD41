<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Giỏ hàng</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.6/dist/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.6/dist/sweetalert2.all.min.js"></script>

</head>
<body>
<%--Header cho giỏ hàng --%>
<%@ include file="../../Layouts/Index/_Header_No_Register.jsp" %>

<div class="container" style="margin-top: 130px">

     <p style="color: black">Home/Detail/GioHang</p>

     <h1 style="text-align: center">
         Thông tin giỏ hàng
     </h1>

    <form action="">

    </form>

    <table style="border:1px solid #FAFAFA; width:100%; margin-top: 40px">
        <thead>
        <tr>
            <th scope="col" style="text-align: center;color: black; width: 40px">#</th>
            <th scope="col" style="text-align: center;color: black">Tên giầy thể thao</th>
            <th scope="col" style="text-align: center;color: black">Hình ảnh</th>
            <th scope="col" style="text-align: center;color: black">Giá bán</th>
            <th scope="col" style="text-align: center;color: black">Số lượng</th>
            <th scope="col" style="text-align: center;color: black">Đơn giá</th>
            <th scope="col" style="text-align: center;color: black">Functions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="gioHangChiTiet" items="${listGioHangChiTiet}" varStatus="i">
                <tr>
                    <td style="padding-top: 20px; text-align: center; color: black">
                           <input type="checkbox" name="chon" value="${gioHangChiTiet.giayTheThaoChiTiet.id}">
                    </td>
                    <td style="padding-top: 20px; text-align: center; color: black">
                            ${gioHangChiTiet.giayTheThaoChiTiet.giayTheThao.tenGiayTheThao}
                    </td>
                    <td style="padding-top: 20px; text-align: center; color: black">
                         <img style="width: 100px;margin-bottom: 10px" src="/upload/${gioHangChiTiet.giayTheThaoChiTiet.giayTheThao.image.get(0).link}" alt="">
                    </td>
                    <td style="padding-top: 20px; text-align: center; color: black">
                                <fmt:formatNumber type="" value="${gioHangChiTiet.giayTheThaoChiTiet.giayTheThao.giaBan}" pattern="#,##0.###" /> VNĐ
                    </td>
                    <td style="padding-top: 20px; text-align: center; color: black">
                            ${gioHangChiTiet.soLuong}
                    </td>
                    <td style="padding-top: 20px; text-align: center; color: black">
                            ${gioHangChiTiet.donGia}
                    </td>
                    <td style="margin-bottom: 10px">
                        <a class="col-sm-4" href="${pageContext.request.contextPath}/GiayTheThao/delete/${gioHangChiTiet.id}">
                            <button class="btn btn-primary" style="margin-top: 0px">
                                 Xóa
                            </button>
                        </a>
                    </td>
                </tr>
        </c:forEach>
        </tbody>
    </table>






</div>


<script>
        var successMessage = "${successMessage}";
        if(successMessage){
            Swal.fire({

                icon: 'success',
                title: '<span style="font-size: 17px;">Thêm sản phẩm vào giỏ hàng thành công</span>',
                showConfirmButton: false, // Ẩn nút OK
                timer: 1000, // Thời gian hiển thị thông báo (miligiây)

            })
        }
</script>

<%@ include file="../../Layouts/Index/_Session1.jsp" %>

</body>
</html>


