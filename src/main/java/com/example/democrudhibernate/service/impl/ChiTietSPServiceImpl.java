package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.ChiTietSP;
import com.example.democrudhibernate.responsitory.ChiTietSPRespon;
import com.example.democrudhibernate.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSPServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSPRespon ctr;
    @Override
    public List<ChiTietSP> getAll() {
        return ctr.findAll();
    }

    @Override
    public ChiTietSP getByID(UUID id) {
        return ctr.findChiTietSPById(id);
    }

    @Override
    public Boolean add(ChiTietSP c) {
        ctr.save(c);
        return true ;
    }

    @Override
    public void delete(UUID id) {
        ctr.deleteById(id);
    }
}
