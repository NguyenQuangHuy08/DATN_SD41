package com.example.sd_41.repository.SanPham.AllGiayTheThao;

import com.example.sd_41.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User , String> {
    List<User> findByTenUserContainingOrderById(String tenUser);
    List<User> findByTrangThaiContainingOrderById (Integer trangThai);
}
