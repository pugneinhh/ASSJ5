package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.responsitory.ChucVuRespon;
import com.example.democrudhibernate.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuRespon chucVuRespon;
    @Override
    public List<ChucVu> getAll() {
        return  chucVuRespon.findAll();
    }

    @Override
    public boolean add(ChucVu c) {
        chucVuRespon.save(c);
        return true;
    }

    @Override
    public ChucVu timTheoID(UUID id) {
        return  chucVuRespon.findChucVuById(id);
    }

    @Override
    public Boolean delete(ChucVu ch) {
        chucVuRespon.delete(ch);
        return true;
    }
}
