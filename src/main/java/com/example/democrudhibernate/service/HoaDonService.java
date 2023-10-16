package com.example.democrudhibernate.service;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> getALl();

    void add(HoaDon hd);

    void delete(UUID id);

    List<HoaDon> findHoaDonByNhanVienAndTinhTrang(NhanVien nhanVien, int tt);

    void updateKHofHD(HoaDon hd);

    HoaDon findHDbyID(UUID id);
}
