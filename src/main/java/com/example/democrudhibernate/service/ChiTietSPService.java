package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.ChiTietSP;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSP> getAll();
    ChiTietSP getByID(UUID id);
    Boolean add(ChiTietSP c);
    void delete(UUID id);

}
