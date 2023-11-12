<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>--%>

<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Đăng kí tài khoản</title>--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="icon" type="/image/png" href="/images/icons/favicon.jpg"/>--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/vendor/bootstrap/css/bootstrap.min.css">--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/fonts/font-awesome-4.7.0/css/font-awesome.min.css">--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/vendor/animate/animate.css">--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/vendor/css-hamburgers/hamburgers.min.css">--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/vendor/select2/select2.min.css">--%>
<%--    <!--===============================================================================================-->--%>
<%--    <link rel="stylesheet" type="text/css" href="/css/util.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="/css/main.css">--%>
<%--    <!--===============================================================================================-->--%>

<%--    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">--%>

<%--    <style>--%>
<%--        .custum-file-upload {--%>
<%--            height: 200px;--%>
<%--            width: 200px;--%>
<%--            display: flex;--%>
<%--            flex-direction: column;--%>
<%--            align-items: space-between;--%>
<%--            gap: 20px;--%>
<%--            cursor: pointer;--%>
<%--            align-items: center;--%>
<%--            justify-content: center;--%>
<%--            border: 2px dashed #cacaca;--%>
<%--            background-color: rgba(255, 255, 255, 1);--%>
<%--            padding: 1.5rem;--%>
<%--            border-radius: 10px;--%>
<%--            box-shadow: 0px 48px 35px -48px rgba(0,0,0,0.1);--%>
<%--        }--%>

<%--        .custum-file-upload .icon {--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            justify-content: center;--%>
<%--        }--%>

<%--        .custum-file-upload .icon svg {--%>
<%--            height: 80px;--%>
<%--            fill: rgba(75, 85, 99, 1);--%>
<%--        }--%>

<%--        .custum-file-upload .text {--%>
<%--            display: flex;--%>
<%--            align-items: center;--%>
<%--            justify-content: center;--%>
<%--        }--%>

<%--        .custum-file-upload .text span {--%>
<%--            font-weight: 400;--%>
<%--            color: rgba(75, 85, 99, 1);--%>
<%--        }--%>

<%--        .custum-file-upload input {--%>
<%--            display: none;--%>
<%--        }--%>
<%--    </style>--%>

<%--</head>--%>
<%--<body>--%>



<%--<div class="limiter">--%>
<%--    <div class="container-login100">--%>
<%--        <div class="wrap-login100">--%>
<%--            <div class="login100-pic js-tilt" data-tilt style="margin-bottom: 10px; width: 200px">--%>
<%--                <img src="/images/img-01.jpg" alt="IMG">--%>
<%--&lt;%&ndash;            <label class="custum-file-upload" for="file">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="icon">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <svg xmlns="http://www.w3.org/2000/svg" fill="" viewBox="0 0 24 24"><g stroke-width="0" id="SVGRepo_bgCarrier"></g><g stroke-linejoin="round" stroke-linecap="round" id="SVGRepo_tracerCarrier"></g><g id="SVGRepo_iconCarrier"> <path fill="" d="M10 1C9.73478 1 9.48043 1.10536 9.29289 1.29289L3.29289 7.29289C3.10536 7.48043 3 7.73478 3 8V20C3 21.6569 4.34315 23 6 23H7C7.55228 23 8 22.5523 8 22C8 21.4477 7.55228 21 7 21H6C5.44772 21 5 20.5523 5 20V9H10C10.5523 9 11 8.55228 11 8V3H18C18.5523 3 19 3.44772 19 4V9C19 9.55228 19.4477 10 20 10C20.5523 10 21 9.55228 21 9V4C21 2.34315 19.6569 1 18 1H10ZM9 7H6.41421L9 4.41421V7ZM14 15.5C14 14.1193 15.1193 13 16.5 13C17.8807 13 19 14.1193 19 15.5V16V17H20C21.1046 17 22 17.8954 22 19C22 20.1046 21.1046 21 20 21H13C11.8954 21 11 20.1046 11 19C11 17.8954 11.8954 17 13 17H14V16V15.5ZM16.5 11C14.142 11 12.2076 12.8136 12.0156 15.122C10.2825 15.5606 9 17.1305 9 19C9 21.2091 10.7909 23 13 23H20C22.2091 23 24 21.2091 24 19C24 17.1305 22.7175 15.5606 20.9844 15.122C20.7924 12.8136 18.858 11 16.5 11Z" clip-rule="evenodd" fill-rule="evenodd"></path> </g></svg>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <div class="text">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <span>Click to upload image</span>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </div>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <input type="file" id="file">&ndash;%&gt;--%>
<%--&lt;%&ndash;            </label>&ndash;%&gt;--%>

<%--            <div style="margin-top: 50px; margin-left: 70px">--%>
<%--                    <a href="/home">--%>
<%--                        <button class=" btn btn-primary">Back</button>--%>
<%--                    </a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <p style="color: red">${er}</p>--%>

<%--            <frm:form cssStyle=" margin-left: 10px; width: 520px; margin-top: 4px"--%>
<%--                      modelAttribute="khachHang"--%>
<%--                      action="${pageContext.request.contextPath}/KhachHang/create"--%>

<%--                      method="post">--%>

<%--                <div class="row">--%>
<%--                    <h5 style="margin-bottom: 30px; margin-left: 100px; font-weight: bold">Tạo tài khoản</h5>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px">Email <span style="color: red">*</span></label>--%>
<%--                            <frm:input class="form-control" placeholder="Email" cssStyle="width: 250px; margin-left: 40px; margin-right: 30px"  path="email"/>--%>
<%--                            <frm:errors path="email" style="color: red;margin-left: 35px"></frm:errors>--%>
<%--                            <label style="color: red;margin-left: 35px">${emailNotNull}</label>--%>
<%--                            <label style="color: red;margin-left: 35px">${emailHopLe}</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px;">Mật khẩu <span style="color: red">*</span></label>--%>
<%--                            <frm:input class="form-control" type="password" placeholder="Mật khẩu" cssStyle="width: 250px; margin-left: 30px"  path="matKhau"/>--%>
<%--                            <frm:errors path="matKhau"></frm:errors>--%>
<%--                            <label class="">${matKhauNotNull}</label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px; margin-top: 20px">Tên khách hàng <span style="color: red">*</span></label>--%>
<%--                            <frm:input class="form-control" placeholder="Tên khách hàng" cssStyle="width: 250px; margin-left: 40px; margin-right: 30px"  path="tenKhachHang"/>--%>
<%--                            <frm:errors path="tenKhachHang"></frm:errors>--%>
<%--                            <label class="">${tenKhachHangNotNull}</label>--%>
<%--                            <label>${tenKhachHangHopLe}</label>--%>
<%--                        </div>--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 50px; margin-top: 20px; margin-bottom: 20px">Giới tính</label>--%>
<%--                            <br>--%>
<%--                            <frm:radiobutton path="gioiTinh" value="Nam" checked="checked" cssStyle="margin-left: 50px"/>Nam--%>
<%--                            <frm:radiobutton cssStyle="margin-left: 30px" path="gioiTinh" value="Nữ"/>Nữ--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px; margin-top: 20px">Ngày sinh</label>--%>
<%--                            <frm:input class="form-control" placeholder="Ngày sinh" cssStyle="width: 250px; margin-left: 40px; margin-right: 30px"  path="ngaySinh"/>--%>
<%--                        </div>--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px; margin-top: 20px">Số điện thoại <span style="color: red">*</span></label>--%>
<%--                            <frm:input class="form-control" placeholder="Số điện thoại" cssStyle="width: 250px; margin-left: 30px"  path="soDienThoai"/>--%>
<%--                            <frm:errors path="soDienThoai"></frm:errors>--%>
<%--                            <label class="">${soDienThoaiNotNull}</label>--%>
<%--                            <label>${soDienThoaiHopLe}</label>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="row">--%>
<%--                        <div class="col-6">--%>
<%--                            <label style="margin-left: 40px; margin-top: 20px">Địa chỉ <span style="color: red">*</span></label>--%>
<%--                            <frm:input class="form-control" placeholder="Địa chỉ" cssStyle="width: 250px; margin-left: 40px"  path="diaChi"/>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="container-login100-form-btn" style="width: 150px; margin-top: 30px; margin-bottom: 30px; margin-left: 200px">--%>
<%--                    <button type="submit" class="login100-form-btn">--%>
<%--                        Login--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </frm:form>--%>

<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>




<%--<!--===============================================================================================-->--%>
<%--<script src="/vendor/jquery/jquery-3.2.1.min.js"></script>--%>
<%--<!--===============================================================================================-->--%>
<%--<script src="/vendor/bootstrap/js/popper.js"></script>--%>
<%--<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>--%>
<%--<!--===============================================================================================-->--%>
<%--<script src="/vendor/select2/select2.min.js"></script>--%>
<%--<!--===============================================================================================-->--%>
<%--<script src="/vendor/tilt/tilt.jquery.min.js"></script>--%>
<%--<script >--%>
<%--    $('.js-tilt').tilt({--%>
<%--        scale: 1.1--%>
<%--    })--%>
<%--</script>--%>
<%--<!--===============================================================================================-->--%>
<%--<script src="/js/main.js"></script>--%>



<%--</body>--%>
<%--</html>--%>