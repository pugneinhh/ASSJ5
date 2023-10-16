package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KhachHangRespon extends JpaRepository<KhachHang, UUID> {
    KhachHang findKhachHangById(UUID id);

}
