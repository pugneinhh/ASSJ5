package com.example.democrudhibernate.service;


import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.model.KhachHang;

import java.util.List;
import java.util.UUID;

public interface KhachHangSerivce {
    List<KhachHang> getALl();
    Boolean add(KhachHang kh);
    void delete(UUID id);
    KhachHang timTheoID(UUID id);
}
