package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRespon extends JpaRepository<ChucVu, UUID> {
    ChucVu findChucVuById(UUID id);
}
