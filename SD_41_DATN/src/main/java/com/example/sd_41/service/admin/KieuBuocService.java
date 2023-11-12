package com.example.sd_41.service.admin;

import com.example.sd_41.model.KieuBuoc;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.KieuBuocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KieuBuocService {
    @Autowired
    private KieuBuocRepository kieuBuocRepository;

    public List<KieuBuoc> getAll() {
        return kieuBuocRepository.findAll();
    }

    public KieuBuoc getOne(String id) {
        return kieuBuocRepository.findById(id).orElse(null);
    }

    public void save(KieuBuoc kieuBuoc) {
        this.kieuBuocRepository.save(kieuBuoc);
    }

    public void delete(String id) {
        this.kieuBuocRepository.deleteById(id);
    }

    public List<KieuBuoc> searchByTen(String tenKieuBuoc) {
        return kieuBuocRepository.findByTenKieuBuocContainingOrderById(tenKieuBuoc);
    }

}

