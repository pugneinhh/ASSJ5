package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.ChucVu;

import java.util.List;
import java.util.UUID;

public interface ChucVuService {
    List<ChucVu> getAll();
    boolean add(ChucVu c);
//    List<CuaHang> timTheoTen(String ten,String ma);
    ChucVu timTheoID(UUID id);

    Boolean delete(ChucVu ch);
}
