package com.example.democrudhibernate.responsitory;


import com.example.democrudhibernate.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacRespon extends JpaRepository<MauSac, UUID> {
    MauSac findMauSacById(UUID id);
}
