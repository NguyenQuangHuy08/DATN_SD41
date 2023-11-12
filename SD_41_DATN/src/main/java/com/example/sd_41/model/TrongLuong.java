package com.example.sd_41.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "TrongLuong")
public class TrongLuong {

    @Id
    @GenericGenerator(name = "generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id_TrongLuong",columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "tenTrongLuong")
    private  String tenTrongLuong	;

    @NotBlank(message = "Không được để trống")
    @Column(name = "ghiChu")
    private String ghiChu;

    @NotNull(message = "Ngày không được trống")
    @Column(name = "ngayTao")
    private Date ngayTao;

    @NotNull(message = "Ngày không được trống")
    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

}
