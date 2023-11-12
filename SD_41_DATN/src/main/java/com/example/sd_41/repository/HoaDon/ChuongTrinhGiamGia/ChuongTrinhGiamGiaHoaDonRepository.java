package com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository
public interface ChuongTrinhGiamGiaHoaDonRepository extends JpaRepository<ChuongTrinhGiamGiaHoaDon, UUID> {

//    @Query("SELECT hd FROM ChuongTrinhGiamGiaHoaDon hd WHERE hd.tenChuongTrinh LIKE ?1 AND hd.ngayTao BETWEEN ?2 AND ?3")
//    List<ChuongTrinhGiamGiaHoaDon> findByKeywordAndDate(String keyword, String min, String max);

    //Tìm kiếm theo tên hóa đơn, số lượng , số tiền hóa đơn, phần trăm giảm

    //Tìm kiếm tổng hợp

    List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonByTenChuongTrinhAndSoTienHoaDonAndPhanTramGiamAndSoLuongSanPham(String tenChuongTrinh, BigDecimal soTienHoaDon, String phanTramGiam, String soLuongSanPham);

    //Tìm kiếm theo từng mục nhỏ
    List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonByTenChuongTrinh(String tenChuongTrinh);

    List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonBySoTienHoaDon(BigDecimal soTienHoaDon);

    List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonByPhanTramGiam(String phanTramGiam);

    List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonBySoLuongSanPham(String soLuongSanPham);

    List<ChuongTrinhGiamGiaHoaDon> findAllByTenChuongTrinhAndPhanTramGiamAndSoLuongSanPhamAndSoTienHoaDon(String tenChuongTrinh, String phanTramGiam, String soLuongSanPham, BigDecimal soTienHoaDon);



}
