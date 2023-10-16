package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.NhanVienRespon;
import com.example.democrudhibernate.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienRespon nhanVienRespon;
    @Override
    public List<NhanVien> getALl() {
        return nhanVienRespon.findAll();
    }

    @Override
    public Boolean add(NhanVien nv) {
        nhanVienRespon.save(nv);
        return true;
    }

    @Override
    public void delete(UUID id) {
        nhanVienRespon.deleteById(id);
    }

    @Override
    public NhanVien timTheoID(UUID id) {
        return nhanVienRespon.findNhanVienById(id);
    }

    @Override
    public NhanVien login(String ma, String pass) {
        return nhanVienRespon.findNhanVienByMaAndMatKhau(ma,pass);
    }
}
