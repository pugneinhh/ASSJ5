package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSPRespon extends JpaRepository<ChiTietSP,UUID> {
    ChiTietSP findChiTietSPById(UUID id);
}
