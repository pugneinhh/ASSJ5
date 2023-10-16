package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.NhanVien;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    List<NhanVien> getALl();
    Boolean add(NhanVien nv);
    void delete(UUID id);
    NhanVien timTheoID(UUID id);
    NhanVien login(String ma,String pass);
}
