package com.example.sd_41.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_HoaDon")
    private UUID id;

    @ManyToOne()
    @JoinColumn(name = "Id_KhachHang", referencedColumnName = "Id_KhachHang")
    private KhachHang kh;

    @ManyToOne
    @JoinColumn(name = "Id_User", referencedColumnName = "Id_User")
    private User user;

    @Column(name = "ThanhTien")
    private BigDecimal thanhTien;

    @Column(name = "GhiChu")
    private String ghiChu;

    @Column(name = "NgayTao")
    private String ngayTao;

    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;

    @Column(name = "NgaySua")
    private String ngaySua;

    @Column(name = "TrangThai")
    private int trangThai;
}
