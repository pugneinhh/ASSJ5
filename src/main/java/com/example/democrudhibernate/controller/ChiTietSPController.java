package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChiTietSP;
import com.example.democrudhibernate.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/chi-tiet-sp")
public class ChiTietSPController {
    @Autowired
    ChiTietSPService ctsps;
    @Autowired
    NSXService nsxs;
    @Autowired
    MauSacService mss;
    @Autowired
    DongSPSerivce dsps;
    @Autowired
    SanPhamService sps;
    @GetMapping("/hien-thi")
    private String show(Model model){
        model.addAttribute("listSP",sps.getALl());
        model.addAttribute("listNSX",nsxs.getALl());
        model.addAttribute("listMS",mss.getALl());
        model.addAttribute("listDSP",dsps.getALl());
        model.addAttribute("c",new ChiTietSP());
        model.addAttribute("LISTCTSP",ctsps.getAll());
        return "viewCTSP/CTSanPham";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("c") ChiTietSP c,
                       Model model){
        ctsps.add(c);
        model.addAttribute("listSP",sps.getALl());
        model.addAttribute("listNSX",nsxs.getALl());
        model.addAttribute("listMS",mss.getALl());
        model.addAttribute("listDSP",dsps.getALl());
        model.addAttribute("c",new ChiTietSP());
        model.addAttribute("LISTCTSP",ctsps.getAll());
        return "viewCTSP/CTSanPham";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable("id") String id,
                          Model model){
        ChiTietSP c=ctsps.getByID(UUID.fromString(id));
        model.addAttribute("listSP",sps.getALl());
        model.addAttribute("listNSX",nsxs.getALl());
        model.addAttribute("listMS",mss.getALl());
        model.addAttribute("listDSP",dsps.getALl());
        model.addAttribute("c",c);
        model.addAttribute("LISTCTSP",ctsps.getAll());
        return "viewCTSP/CTSanPham";
    }
    @GetMapping("/view-update/{id}")
    private String chiTiet(@PathVariable("id") String id,
                          Model model){
        ChiTietSP c=ctsps.getByID(UUID.fromString(id));
        model.addAttribute("listSP",sps.getALl());
        model.addAttribute("listNSX",nsxs.getALl());
        model.addAttribute("listMS",mss.getALl());
        model.addAttribute("listDSP",dsps.getALl());
        model.addAttribute("c",c);
        model.addAttribute("LISTCTSP",ctsps.getAll());
        return "viewCTSP/UpdateCTSanPham";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable("id") String id,
                          Model model){
        ctsps.delete(UUID.fromString(id));
        model.addAttribute("ThongBao","Xóa thành công");
        model.addAttribute("listSP",sps.getALl());
        model.addAttribute("listNSX",nsxs.getALl());
        model.addAttribute("listMS",mss.getALl());
        model.addAttribute("listDSP",dsps.getALl());
        model.addAttribute("c",new ChiTietSP());
        model.addAttribute("LISTCTSP",ctsps.getAll());
        return "viewCTSP/CTSanPham";
    }
}
