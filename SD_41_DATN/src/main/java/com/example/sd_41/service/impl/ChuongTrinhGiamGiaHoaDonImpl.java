package com.example.sd_41.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import org.springframework.web.multipart.MultipartFile;

public interface ChuongTrinhGiamGiaHoaDonImpl {
    public void add(ChuongTrinhGiamGiaHoaDon gg);

    public void addAll(MultipartFile file) throws IOException;

    public void update(ChuongTrinhGiamGiaHoaDon gg, UUID id);

    // public void delete(UUID id);
    public ChuongTrinhGiamGiaHoaDon getOne(UUID id);

    public List<ChuongTrinhGiamGiaHoaDon> getList();

    public Page<ChuongTrinhGiamGiaHoaDon> pagination(Pageable pageable);

    public Page<ChuongTrinhGiamGiaHoaDon> search(Pageable pageable, String name);

    public Page<ChuongTrinhGiamGiaHoaDon> filterByTrangThai(Pageable pageable, int name);

    public Page<ChuongTrinhGiamGiaHoaDon> filterByTrangThaiAndDate(Pageable pageable, int tt, String nbd, String nkt);

    public void updateTrangThai();

    public Page<ChuongTrinhGiamGiaHoaDon> filterByTTChuaHetHan(Pageable pageable);
}
