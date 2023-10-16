package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSPRespon extends JpaRepository<DongSP, UUID> {
    DongSP findDongSPById(UUID id);
}
