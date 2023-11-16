package com.example.sd_41.service.admin;

import com.example.sd_41.model.Size;
import com.example.sd_41.repository.SanPham.AllGiayTheThao.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    public Size getOne(UUID id) {
        return sizeRepository.findById(id).orElse(null);
    }

    public void save(Size size) {
        this.sizeRepository.save(size);
    }

    public void delete(UUID id) {
        this.sizeRepository.deleteById(id);
    }

//    public List<Size> searchBySize(Integer size) {
//        return sizeRepository.findBySizeContainingOrderById(size);
//    }
}
