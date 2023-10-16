package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.responsitory.DongSPRespon;
import com.example.democrudhibernate.service.DongSPSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DongSPServiceImpl implements DongSPSerivce {
    @Autowired
    DongSPRespon dongSPRespon;
    @Override
    public List<DongSP> getALl() {
        return dongSPRespon.findAll();
    }

    @Override
    public Boolean add(DongSP dsp) {
        dongSPRespon.save(dsp);
        return true;
    }

    @Override
    public void delete(UUID id) {
        dongSPRespon.deleteById(id);
    }

    @Override
    public DongSP timTheoID(UUID id) {
        return dongSPRespon.findDongSPById(id);
    }
}
