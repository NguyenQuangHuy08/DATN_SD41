package com.example.sd_41.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_User")
    private UUID id;

    @Column(name = "email")
    private  String email	;

    @Column(name = "matKhau")
    private  String matKhau	;

    @Column(name = "tenUser")
    private  String tenUser	;

    @Column(name = "gioiTinh")
    private  String gioiTinh	;

    @Column(name = "ngaySinh")
    private String ngaySinh	;

    @Column(name = "maCCCD")
    private  String maCCCD	;

    @Column(name = "hoKhau")
    private  String hoKhau	;

    @Column(name = "soDienThoai")
    private  String soDienThoai	;

    @Column(name = "diaChi")
    private  String diaChi;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
}
