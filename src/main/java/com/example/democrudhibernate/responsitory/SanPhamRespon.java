package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRespon extends JpaRepository<SanPham, UUID> {
    SanPham findSanPhamById(UUID id);
}
