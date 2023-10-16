package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.MauSac;
import com.example.democrudhibernate.responsitory.MauSacRespon;
import com.example.democrudhibernate.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    MauSacRespon mauSacRespon;
    @Override
    public List<MauSac> getALl() {
        return mauSacRespon.findAll();
    }

    @Override
    public Boolean add(MauSac ms) {
         mauSacRespon.save(ms);
        return true;
    }

    @Override
    public void delete(UUID id) {
        mauSacRespon.deleteById(id);
    }

    @Override
    public MauSac timTheoID(UUID id) {
        return mauSacRespon.findMauSacById(id);
    }
}
