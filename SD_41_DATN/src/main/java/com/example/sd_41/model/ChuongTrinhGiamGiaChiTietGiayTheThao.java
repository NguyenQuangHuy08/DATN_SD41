package com.example.sd_41.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "ChuongTrinhGiamGiaChiTietGiayTheThao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChuongTrinhGiamGiaChiTietGiayTheThao {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_ChuongTrinhGiamGiaChiTietGiayTheThao")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "Id_ChuongTrinhGiamGiaGiayTheThao", referencedColumnName = "Id_ChuongTrinhGiamGiaGiayTheThao")
    private ChuongTrinhGiamGiaGiayTheThao chuongTrinhGiamGiaGiayTheThao;

    @ManyToOne
    @JoinColumn(name = "Id_GiayTheThao", referencedColumnName = "Id_GiayTheThao")
    private GiayTheThao giayTheThao;

    @Column(name = "SoTienDaGiam")
    private BigDecimal soTienDaGiam;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgaySua")
    private String ngaySua;

    @Column(name = "TrangThai")
    private int trangThai;
}
