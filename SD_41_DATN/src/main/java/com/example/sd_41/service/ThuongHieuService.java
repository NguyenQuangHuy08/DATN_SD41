package com.example.sd_41.service;

import com.example.sd_41.model.ThuongHieu;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.ThuongHieuRepository;
import com.example.sd_41.service.impl.ThuongHieuImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ThuongHieuService implements ThuongHieuImpl {
    @Autowired
    private ThuongHieuRepository repo;

    @Override
    public void add(ThuongHieu th) {
        this.repo.save(th);
    }

    @Override
    public void update(ThuongHieu th, UUID id) {
        ThuongHieu thuongHieu = this.repo.findById(id).get();
        thuongHieu.setTenThuongHieu(th.getTenThuongHieu());
        thuongHieu.setGhiChu(th.getGhiChu());
        thuongHieu.setNgayTao(th.getNgayTao());
        thuongHieu.setNgaySua(th.getNgaySua());
        thuongHieu.setTrangThai(th.getTrangThai());
        this.repo.save(thuongHieu);
    }

//    @Override
//    public void delete(UUID id) {
//        ThuongHieu th = this.repo.findById(id).get();
//        this.repo.delete(th);
//    }

    @Override
    public Page<ThuongHieu> search(Pageable pageable, String name) {
        return this.repo.findByTenThuongHieuContaining(name, pageable);
    }

    @Override
    public Page<ThuongHieu> pagination(Pageable pageable) {
        return this.repo.findAll(pageable);
    }
}