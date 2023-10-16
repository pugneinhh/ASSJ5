package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.HoaDonRespon;
import com.example.democrudhibernate.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRespon hdr;
    @Override
    public List<HoaDon> getALl() {
        return hdr.findAll();
    }

    @Override
    public void add(HoaDon hd) {
        hdr.save(hd);
    }


    @Override
    public void delete(UUID id) {
        hdr.deleteById(id);

    }

    @Override
    public List<HoaDon> findHoaDonByNhanVienAndTinhTrang(NhanVien nhanVien, int tt) {
        return hdr.getHoaDonsByNhanVienAndTinhTrang(nhanVien,tt);
    }

    @Override
    public void updateKHofHD(HoaDon hd) {
        hdr.save(hd);
    }

    @Override
    public HoaDon findHDbyID(UUID id) {
        return hdr.findHoaDonById(id);
    }
}
