package com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia;


import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sd_41.model.ChuongTrinhGiamGiaChiTietHoaDon;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ChuongTrinhGiamGiaChiTietHoaDonRepo extends JpaRepository<ChuongTrinhGiamGiaChiTietHoaDon, UUID>{
    List<ChuongTrinhGiamGiaChiTietHoaDon> findAllByCtggHD(ChuongTrinhGiamGiaHoaDon ctggHD);
    @Query("select c from ChuongTrinhGiamGiaChiTietHoaDon c join HoaDon h on c.id=h.id where h.trangThai = 1")
    List<ChuongTrinhGiamGiaChiTietHoaDon> getAllByTrangThaiHD();

}
