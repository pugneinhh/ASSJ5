package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRespon extends JpaRepository<NhanVien, UUID> {
    NhanVien findNhanVienById(UUID id);
    NhanVien findNhanVienByMaAndMatKhau(String ma,String pass);
}
