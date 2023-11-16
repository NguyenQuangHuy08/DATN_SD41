<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
<%@ include file="../templates/Admin/Layouts/GiayTheThao/_HeaderGiayTheThao.jsp" %>
<form:form action="/user/update/${id}" modelAttribute="user" cssClass="container">
    <div class="form-group">
        <label>Email</label>
        <form:input path="email" class="form-control"/>
        <form:errors class="text-danger" element="span" path="email"/>
    </div>
    <div class="form-group">
        <label>Mật khẩu</label>
        <form:input path="matKhau" class="form-control"/>
        <form:errors class="text-danger" element="span" path="matKhau"/>
    </div>
    <div class="form-group">
        <label>Tên user</label>
        <form:input path="tenUser" class="form-control"/>
        <form:errors class="text-danger" element="span" path="tenUser"/>
    </div>
    <div class="form-group">
        <label>Giới tinh</label>
        <form:input path="gioiTinh" class="form-control"/>
        <form:errors class="text-danger" element="span" path="gioiTinh"/>
    </div>

    <div class="form-group">
        <label>Ngày sinh</label>
        <form:input type="date" path="ngaySinh" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ngaySinh"/>
    </div>
    <div class="form-group">
        <label>CCCD</label>
        <form:input path="maCCCD" class="form-control"/>
        <form:errors class="text-danger" element="span" path="maCCCD"/>
    </div>
    <div class="form-group">
        <label>Hộ khẩu</label>
        <form:input path="hoKhau" class="form-control"/>
        <form:errors class="text-danger" element="span" path="hoKhau"/>
    </div>
    <div class="form-group">
        <label>SĐT</label>
        <form:input path="soDienThoai" class="form-control"/>
        <form:errors class="text-danger" element="span" path="soDienThoai"/>
    </div>
    <div class="form-group">
        <label>Địa chỉ</label>
        <form:input path="diaChi" class="form-control"/>
        <form:errors class="text-danger" element="span" path="diaChi"/>
    </div>
    <div class="form-group">
        <label>Ghi Chú</label>
        <form:input path="ghiChu" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ghiChu"/>
    </div>
    <div class="form-group">
        <label>Ngày tạo</label>
        <form:input type="date" path="ngayTao" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ngayTao"/>
    </div>
    <div class="form-group">
        <label>Ngày sửa</label>
        <form:input type="date" path="ngaySua" class="form-control"/>
        <form:errors class="text-danger" element="span" path="ngaySua"/>
    </div>
    <div class="form-group">
        <label>Trạng Thái</label>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="0" checked="true" />
            <label class="form-check-label">Đang làm</label>
        </div>
        <div class="form-check">
            <form:radiobutton cssClass="form-check-input" path="trangThai" value="1" />
            <label class="form-check-label">Đã nghỉ</label>
        </div>
    </div>
    <button class="btn btn-success">Update</button>
</form:form>
<%@ include file="../templates/Admin/Layouts/GiayTheThao/_FooterGiayTheThao.jsp" %>
</body>
</html>