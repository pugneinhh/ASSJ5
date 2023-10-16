package com.example.democrudhibernate.service.impl;

import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.responsitory.NSXRespon;
import com.example.democrudhibernate.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NSXServiceImpl implements NSXService {
    @Autowired
    NSXRespon nsxRespon;
    @Override
    public List<NSX> getALl() {
        return nsxRespon.findAll();
    }

    @Override
    public Boolean add(NSX nsx) {
         nsxRespon.save(nsx);
         return true;
    }

    @Override
    public void delete(UUID id) {
        nsxRespon.deleteById(id);
    }
    @Override
    public NSX timTheoID(UUID id) {
        return nsxRespon.findNSXById(id);
    }
}
