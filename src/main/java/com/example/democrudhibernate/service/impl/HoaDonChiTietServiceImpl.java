package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.HoaDonChiTiet;
import com.example.democrudhibernate.model.IdHoaDonChiTiet;
import com.example.democrudhibernate.responsitory.HoaDonChiTietRespon;
import com.example.democrudhibernate.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRespon hdr;
    @Override
    public List<HoaDonChiTiet> getAll() {
        return hdr.findAll();
    }

    @Override
    public List<HoaDonChiTiet> getHoaDonByID(UUID id) {
        return hdr.findHoaDonChiTietsById_IdHoaDon_Id(id);
    }

    @Override
    public HoaDonChiTiet getHDCT(UUID idhd, UUID idctsp) {
        return hdr.findHoaDonChiTietById_IdHoaDon_IdAndId_IdChiTietSp_Id(idhd,idctsp);
    }

    @Override
    public void addHDCT(HoaDonChiTiet hdct) {
        hdr.save(hdct);
    }

    @Override
    public void updateHDCT(HoaDonChiTiet hdct) {
        hdr.save(hdct);
    }

    @Override
    public void deleteHDCT(HoaDonChiTiet hdct) {
        hdr.delete(hdct);
    }

    @Override
    public BigDecimal getTongTien(UUID id) {
        return hdr.getTongTien(id);
    }
}
