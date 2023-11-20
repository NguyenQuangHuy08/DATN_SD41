<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create dữ liệu phiếu giao hàng</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<%--    <link href="/css/GiayTheThao/All_GiayTheThao/create.css" rel="stylesheet">--%>

</head>
<body>

<%@ include file="../templates/Admin/Layouts/GiayTheThao/_HeaderGiayTheThao.jsp" %>

<div class="container">

    <a href="/PhieuGiaoHang/listPhieuGiaoHang" style="text-decoration: none">
        <button style="margin-bottom: 10px;" type="submit" class="btn btn-primary">Back</button>
    </a>

    <h3 style="text-align: center; color: black; margin-top: 0px; margin-bottom: 30px">Thêm dữ liệu bảng phiếu giao hàng</h3>

    <frm:form
                    modelAttribute="phieuGiaoHang"
                    action="${pageContext.request.contextPath}/PhieuGiaoHang/create"
                    method="POST"
                    enctype="multipart/form-data"
            >

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label >Khách Hàng</label>
                        <select class="form-control" name="khachHang.id">
                            <c:forEach items="${khachHang}" var="khachHang">
                                <option value="${khachHang.id}">${khachHang.tenKhachHang}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label >User</label>
                        <select  class="form-control" name="user.id">
                            <c:forEach items="${user}" var="user">
                                <option value="${user.id}">${user.tenUser}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Hoá Đơn</label>
                        <select  class="form-control" name="hoaDon.id">
                            <c:forEach items="${hoaDon}" var="hoaDon">
                                <option value="${hoaDon.id}">${hoaDon.id}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label>Tên Người Nhận :</label>
                        <frm:input id="tenNguoiNhan" required="" type="text" class="form-control" path="tenNguoiNhan" cssStyle="" placeholder="Input text" value=""/>
                        <frm:errors path="tenNguoiNhan"></frm:errors>
                        <div class="er">
                             <label style="color: red">${erTenNguoiNhanIsEmty}</label>
                             <label style="color: red">${erCheckTenNguoiNhanSo}</label>
                             <label style="color: red">${erCheckTenNguoiNhanTrung}</label>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label>Phí Ship VNĐ</label>
                        <frm:input id="phiShip"  required="" type="text" class="form-control" path="phiShip" cssStyle="" onblur="formatPhiShip()" placeholder="Input VNĐ" value=""/>
                        <frm:errors path="phiShip"></frm:errors>
                        <div class="er">
                            <label style="color: red">${erCheckPhiShipNumber}</label>
                            <label style="color: red">${erCheckPhiShipSoConertString}</label>
                            <label style="color: red">${erCheckPhiShipIsEmtry}</label>
                        </div>
                    </div>
                    <div class="form-group col-md-4">
                        <label style="margin-left: 30px">Giới tính :</label>
                        <div class="gioiTinh" style="margin-top: 7px; margin-left: 50px">
                            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio1" value="Nam" checked = "checked" >
                            <label style="color: black; margin-right: 40px" class="form-check-label" for="inlineRadio1">Nam</label>
                            <input class="form-check-input" type="radio" name="gioiTinh" id="inlineRadio2" value="Nữ">
                            <label style="color: black" class="form-check-label" for="inlineRadio2">Nữ</label>
                        </div>
                    </div>
                </div>



        <button  style="margin-bottom: 30px; margin-left: 470px; margin-top: 30px" type="submit" class="btn btn-primary">Create</button>
    </frm:form>

</div>

<%@ include file="../templates/Admin/Layouts/GiayTheThao/_FooterGiayTheThao.jsp" %>
<%--<%@ include file="../../templates/Admin/Layouts/GiayTheThao/_FooterGiayTheThao.jsp" %>--%>


<%--Định dạng tiền--%>

<script>

    function formatPhiShip() {
        var phiShipInput = document.getElementById("phiShip");
        var phiShipValue = phiShipInput.value;

        // Loại bỏ dấu phẩy và khoảng trắng (nếu có)
        var phiShipFormatted = phiShipValue.replace(/,/g, '').replace(/\s/g, '');

        // Kiểm tra xem giá trị là một số
        if (!isNaN(phiShipFormatted)) {
            // Định dạng giá trị thành chuỗi có dấu phẩy
            var formattedValue = phiShipFormatted.replace(/\B(?=(\d{3})+(?!\d))/g, ",");

            // Cập nhật giá trị trên trường nhập
            phiShipInput.value = formattedValue;
        }
    }

</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</body>
</html>