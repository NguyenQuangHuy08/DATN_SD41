package com.example.sd_41.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "KieuBuoc")
public class KieuBuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_KieuBuoc")
    private UUID id;

    @Column(name = "tenKieuBuoc")
    private String tenKieuBuoc;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

}
