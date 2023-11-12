package com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia;

import com.example.sd_41.model.ChuongTrinhGiamGiaChiTietGiayTheThao;

import com.example.sd_41.model.ChuongTrinhGiamGiaGiayTheThao;
import com.example.sd_41.model.GiayTheThao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ChuonTrinhGiamGiaChiTietGiayTheThaoRepo
        extends JpaRepository<ChuongTrinhGiamGiaChiTietGiayTheThao, UUID> {
    List<ChuongTrinhGiamGiaChiTietGiayTheThao> findAllByChuongTrinhGiamGiaGiayTheThao(ChuongTrinhGiamGiaGiayTheThao gg);
    @Query("Delete FROM ChuongTrinhGiamGiaChiTietGiayTheThao gg WHERE gg.chuongTrinhGiamGiaGiayTheThao.id = :gg and gg.giayTheThao.id = :gtt")
    void deleteByChuongTrinhGiamGiaGiayTheThaoAndGiayTheThao(@Param("gg") UUID gg, @Param("gtt") UUID gtt);
    ChuongTrinhGiamGiaChiTietGiayTheThao findByChuongTrinhGiamGiaGiayTheThaoAndGiayTheThao(ChuongTrinhGiamGiaGiayTheThao gg, GiayTheThao gtt);
}
