package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.CuaHang;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CuaHangService {
    List<CuaHang> getAll();
    boolean add(CuaHang c);

    List<CuaHang> timTheoTen(String ten,String ma);
    CuaHang timTheoID(UUID id);

    void delete(UUID id);
}
