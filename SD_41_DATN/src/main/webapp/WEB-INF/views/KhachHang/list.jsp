<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Khách hàng</title>
    <%--    <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <style>

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h3 style="text-align: center;">List Khách Hàng </h3>
    <br>
    <jsp:include page="search.jsp"></jsp:include>
<%--    <div class="" style="margin-top: 30px; margin-bottom: 30px">--%>
<%--    <h1>Tìm kiếm sản phẩm</h1>--%>
<%--        <form action="${pageContext.request.contextPath}/ChuongTrinhGiamGiaHoaDon/search" method="GET">--%>
<%--            <label for="tenChuongTrinh">Tên chương trình </label>--%>
<%--            <input style="width: 400px" type="text" id="tenChuongTrinh" name="tenChuongTrinh">--%>
<%--            <br>--%>
<%--            <label for="soLuongSanPham">Số lượng sản phẩm :</label>--%>
<%--            <input type="number" id="soLuongSanPham" name="soLuongSanPham">--%>
<%--            <br>--%>
<%--            <label for="phanTramGiam">Phần trăm giảm :</label>--%>
<%--            <input type="number" id="phanTramGiam" name="phanTramGiam">--%>
<%--            <br>--%>
<%--            <label for="soTienHoaDon">Số tiền hóa đơn cần đạt :</label>--%>
<%--            <input type="number" id="soTienHoaDon" name="soTienHoaDon">--%>
<%--            <br>--%>
<%--            <button type="submit">Tìm kiếm</button>--%>
<%--        </form>--%>
<%--    </div>--%>

<%--    <a href="/ChuongTrinhGiamGiaHoaDon/list">--%>
<%--        <button>Back</button>--%>
<%--    </a>--%>
<%--    <div class="thongBao">--%>
<%--&lt;%&ndash;           Tìm kiếm thành công &ndash;%&gt;--%>
<%--            <label>${messageDone}</label>--%>
<%--&lt;%&ndash;            Không tìm thấy id có mã&ndash;%&gt;--%>
<%--            <label>${messageFind}</label>--%>
<%--            Không tìm thầy sản phẩm--%>
<%--            <label>${messageErFind}</label>--%>
<%--            <label>${message}</label>--%>
<%--            <label>${messageErFindSoLuong}</label>--%>

<%--    </div>--%>

    <div><a href="${pageContext.request.contextPath}/KhachHang/view-create" class="btn btn-primary">Thêm khách hàng</a></div>


    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Tên khách hàng</th>
            <th scope="col">Email</th>
            <th scope="col">Mật khẩu</th>
            <th scope="col">Giới tính</th>
            <th scope="col">Ngày sinh</th>
            <th scope="col">Số điện thoại</th>
            <th scope="col">Địa chỉ</th>
            <th scope="col">Ghi chú</th>
            <th scope="col">Trạng thái</th>
            <th scope="col">Function</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="kh" items="${listPage}" varStatus="i">
            <tr>
                <th style="padding-top: 40px" scope="row">${i.index+1}</th>
                <td style="padding-top: 55px; text-align: center">${kh.tenKhachHang}</td>
                <td style="padding-top: 55px; text-align: center">${kh.email}</td>
                <td style="padding-top: 55px; text-align: center">${kh.matKhau}</td>
                <td style="padding-top: 55px; text-align: center">${kh.gioiTinh}</td>
                <td style="padding-top: 55px; text-align: center">${kh.ngaySinh}</td>
                <td style="padding-top: 55px; text-align: center">${kh.soDienThoai}</td>
                <td style="padding-top: 55px; text-align: center">${kh.diaChi}</td>
                <td style="padding-top: 55px; text-align: center">${kh.ghiChu}</td>
                <td style="padding-top: 55px; text-align: center">${hd.trangThai==1 ?"Không hoạt động" : "Còn hoạt động"}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/KhachHang/edit/${kh.id}"><button class="btn btn-primary">Edit</button></a>
                    <a href="${pageContext.request.contextPath}/KhachHang/delete/${kh.id}" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <ul class="pagination" style="margin-left: 500px">
        <c:forEach begin="1" end="${totalPage}" varStatus="status">
            <li class="page-item">
                <a href="${pageContext.request.contextPath}/KhachHang/list?pageNumber=${status.index}" class="page-link">${status.index}</a>
            </li>
        </c:forEach>
    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>