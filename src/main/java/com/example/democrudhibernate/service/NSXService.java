package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.NSX;

import java.util.List;
import java.util.UUID;

public interface NSXService {
    List<NSX> getALl();
    Boolean add(NSX nsx);
    void delete(UUID id);
    NSX timTheoID(UUID id);
}
