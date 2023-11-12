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
@Getter
@Setter
@Builder
@Entity
@Table(name = "DinhTanGiay")
public class DinhTanGiay {

    @Id
    @GenericGenerator(name = "generator",strategy = "guid",parameters = {})
    @GeneratedValue(generator = "generator")
    @Column(name = "Id_DinhTanGiay",columnDefinition = "UNIQUEIDENTIFIER")
    private String id;

    @NotBlank(message = "Không được để trống")
    @Column(name = "tenDinhTanGiay")
    private  String tenDinhTanGiay	;

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
