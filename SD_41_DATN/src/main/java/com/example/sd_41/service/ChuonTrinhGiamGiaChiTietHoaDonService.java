package com.example.sd_41.service;

import java.util.List;


import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia.ChuongTrinhGiamGiaChiTietHoaDonRepo;
import com.example.sd_41.service.impl.ChuongTrinhGiamGiaChiTietHoaDonImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sd_41.model.ChuongTrinhGiamGiaChiTietHoaDon;

@Service
public class ChuonTrinhGiamGiaChiTietHoaDonService implements ChuongTrinhGiamGiaChiTietHoaDonImpl {

    @Autowired
    private ChuongTrinhGiamGiaChiTietHoaDonRepo repo;
    
    @Override
    public List<ChuongTrinhGiamGiaChiTietHoaDon> getById(ChuongTrinhGiamGiaHoaDon ctggHD) {
        return repo.findAllByCtggHD(ctggHD);
    }

    @Override
    public List<ChuongTrinhGiamGiaChiTietHoaDon> getAllByTrangThaiHD() {
        return repo.getAllByTrangThaiHD();
    }

}
