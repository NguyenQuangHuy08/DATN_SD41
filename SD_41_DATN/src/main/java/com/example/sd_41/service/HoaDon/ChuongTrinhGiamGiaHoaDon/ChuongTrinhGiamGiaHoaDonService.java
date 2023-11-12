package com.example.sd_41.service.HoaDon.ChuongTrinhGiamGiaHoaDon;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia.ChuongTrinhGiamGiaHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ChuongTrinhGiamGiaHoaDonService {

        @Autowired
        private ChuongTrinhGiamGiaHoaDonRepository chuongTrinhGiamGiaHoaDonRepository;

        //Tìm kiếm all

        public List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDon(String tenChuongTrinh) {
            if (tenChuongTrinh != null) {

                return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonByTenChuongTrinh(tenChuongTrinh);

            } else{
                // Trường hợp không có tham số được cung cấp, bạn có thể trả về toàn bộ danh sách sản phẩm
                return chuongTrinhGiamGiaHoaDonRepository.findAll();
            }
        }



       //Todo codo update


    public List<ChuongTrinhGiamGiaHoaDon> filterResults(ChuongTrinhGiamGiaHoaDon filter) {
        // Thực hiện tìm kiếm và lọc dựa trên các trường trong filter
        // Sử dụng Spring Data JPA hoặc các truy vấn tương ứng
        // Return danh sách kết quả
        return chuongTrinhGiamGiaHoaDonRepository.findAllByTenChuongTrinhAndPhanTramGiamAndSoLuongSanPhamAndSoTienHoaDon(
                filter.getTenChuongTrinh(),
                filter.getPhanTramGiam(),
                filter.getSoLuongSanPham(),
                filter.getSoTienHoaDon()
        );
    }


}

