<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

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
    <h3 style="text-align: center;">Create khách hàng</h3>
    <div>
        <h1 style="text-align: center; color: black; margin-top: 30px; margin-bottom: 60px">Thêm khách hàng</h1>
        <frm:form
                modelAttribute="khachHang"
                action="${pageContext.request.contextPath}/KhachHang/create"
                method="POST"
                enctype="multipart/form-data">
            <div class="row">
                <div class="col-6">
                    <label style="margin-left: 30px">Tên khách hàng</label>
                    <frm:input path="tenKhachHang" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors path="tenKhachHang"></frm:errors>
                    <label class="">${tenKhachHangNotNull}</label>
                    <label>${tenKhachHangHopLe}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 30px">Email</label>
                    <frm:input path="email" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors path="email"></frm:errors>
                    <label class="">${emailNotNull}</label>
                    <label>${emailHopLe}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 30px">Mật khẩu</label>
                    <frm:input path="matKhau" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors path="matKhau"></frm:errors>
                    <label class="">${matKhauNotNull}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 30px">Địa chỉ</label>
                    <frm:input path="diaChi" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors path="diaChi"></frm:errors>
                    <label class="">${diaChiNotNull}</label>
                    <label>${diaChiHopLe}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 30px">Số điện thoại</label>
                    <frm:input path="soDienThoai" cssStyle="width: 300px;" placeholder="text" value=""/>
                    <frm:errors path="soDienThoai"></frm:errors>
                    <label class="">${soDienThoaiNotNull}</label>
                    <label>${soDienThoaiHopLe}</label>
                </div>
                <div class="col-6">
                    <label style="margin-left: 150px; margin-right: 66px; margin-bottom: 30px">Ngày sinh</label>
                    <frm:input path="ngaySinh" cssStyle="width: 200px;" type="date" value=""/>
                </div>

                <div class="col-6">
                    <label style="margin-left: 150px; margin-right: 66px; margin-bottom: 30px">Ghi chú</label>
<%--                    <frm:textarea id="long-text" name="long-text" rows="4" cols="50"></frm:textarea>--%>
                    <frm:input path="ghiChu" cssStyle="width: 200px;" type=""  value=""/>
<%--                    <textarea id="long-text" path="ghiChu" name="long-text" rows="4" cols="50"></textarea>--%>

                <%--                                <div class="textTitle"><frm:errors cssStyle="margin-left: 400px; color: red" class="errors" path="name" /></div>--%>
                </div>
                <div class="col-6">
                    <label style="margin-left: 27px; margin-right: 25px; margin-bottom: 50px">Giới tính</label>
                    <frm:select path="gioiTinh" cssStyle="width: 200px;">
                        <option value="Nam">
                            Nam
                        </option>
                        <option value="Nữ">
                            Nữ
                        </option>
                    </frm:select>
                </div>
                <div class="col-6">
                    <label style="margin-left: 27px; margin-right: 25px; margin-bottom: 50px">Trạng thái</label>
                    <frm:select path="trangThai" cssStyle="width: 200px;">
                        <option value="1">
                            Còn hoạt động
                        </option>
                        <option value="0">
                            Không hoạt động
                        </option>
                    </frm:select>
                </div>
            </div>
            <button type="submit" onclick="if (!confirm('Bạn chắc chắn muốn thêm không ?')){return false;}else{return true;}" style="margin-left: 400px; margin-bottom: 190px" class="btn btn-primary">Create</button>
            <label>${message}</label>
        </frm:form>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>