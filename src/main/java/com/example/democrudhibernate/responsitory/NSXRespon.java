package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NSXRespon extends JpaRepository<NSX, UUID> {
    NSX findNSXById(UUID id);
}
