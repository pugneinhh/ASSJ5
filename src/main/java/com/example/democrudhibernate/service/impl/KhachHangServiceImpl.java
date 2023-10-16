package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.model.KhachHang;
import com.example.democrudhibernate.responsitory.KhachHangRespon;
import com.example.democrudhibernate.service.KhachHangSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangServiceImpl implements KhachHangSerivce {
    @Autowired
    KhachHangRespon khachHangRespon;
    @Override
    public List<KhachHang> getALl() {
        return khachHangRespon.findAll();
    }

    @Override
    public Boolean add(KhachHang kh) {
        khachHangRespon.save(kh);
        return  true;
    }

    @Override
    public void delete(UUID id) {
        khachHangRespon.deleteById(id);
    }

    @Override
    public KhachHang timTheoID(UUID id) {
        return khachHangRespon.findKhachHangById(id);
    }
}
