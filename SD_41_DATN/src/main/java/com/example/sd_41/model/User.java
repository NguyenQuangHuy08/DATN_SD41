package com.example.sd_41.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
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
    @GenericGenerator(name = "generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id_User",columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "email")
    private  String email	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "matKhau")
    private  String matKhau	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "tenUser")
    private  String tenUser	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "gioiTinh")
    private  String gioiTinh	;


    @NotBlank(message = "Không được để trống")
    @Column(name = "ngaySinh")
    private String ngaySinh	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "maCCCD")
    private  String maCCCD	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "hoKhau")
    private  String hoKhau	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "soDienThoai")
    private  String soDienThoai	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "diaChi")
    private  String diaChi;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ghiChu")
    private String ghiChu;


    @NotBlank(message = "Không được để trống")
    @Column(name = "ngayTao")
    private String ngayTao;


    @NotBlank(message = "Không được để trống")
    @Column(name = "ngaySua")
    private String ngaySua;

    @NotBlank(message = "Không được để trống")
    @Column(name = "trangThai")
    private String trangThai;
}
