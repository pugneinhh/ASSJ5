package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.democrudhibernate.responsitory.CuaHangRespon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangServiceImpl implements CuaHangService {
    @Autowired
    CuaHangRespon cuaHangRespon;
    @Override

    public List<CuaHang> getAll() {
        return cuaHangRespon.findAll();
    }

    @Override
    public boolean add(CuaHang c) {
        cuaHangRespon.save(c);
          return  true;
    }



    @Override
    public List<CuaHang> timTheoTen(String ten, String ma) {
        return cuaHangRespon.findByTenAndMaOrderByMaDesc(ten,ma);
    }

    @Override
    public CuaHang timTheoID(UUID id) {
        return  cuaHangRespon.findCuaHangById(id);
    }

    @Override
    public void delete(UUID id) {
        cuaHangRespon.deleteById(id);
    }



}
