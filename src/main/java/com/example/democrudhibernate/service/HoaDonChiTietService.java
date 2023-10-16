package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.HoaDonChiTiet;
import com.example.democrudhibernate.model.IdHoaDonChiTiet;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> getAll();
    List<HoaDonChiTiet> getHoaDonByID(UUID id);
    HoaDonChiTiet getHDCT(UUID idhd,UUID idctsp);
    void addHDCT(HoaDonChiTiet hdct);
    void updateHDCT(HoaDonChiTiet hdct);
    void deleteHDCT(HoaDonChiTiet hdct);
    BigDecimal getTongTien(UUID id);
}
