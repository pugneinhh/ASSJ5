package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.service.NSXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/nsx")
public class NSXController {

    @Autowired
    NSXService nsxService;

    @GetMapping("/hien-thi")
    private String getALl(Model model){
        model.addAttribute("nsx",new NSX());
        model.addAttribute("LISTNSX",nsxService.getALl());
        return "viewNSX/nsx";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        NSX nsx = nsxService.timTheoID(UUID.fromString(id));
        model.addAttribute("nsx",nsx);
        model.addAttribute("LISTNSX",nsxService.getALl());
        return "viewNSX/nsx";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        nsxService.delete(UUID.fromString(id));
        model.addAttribute("nsx", new NSX());
        model.addAttribute("LISTNSX",nsxService.getALl());
        return "viewNSX/nsx";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("nsx") NSX nsx,Model model){
        nsxService.add(nsx);
        model.addAttribute("nsx", new NSX());
        model.addAttribute("LISTNSX",nsxService.getALl());
        return "viewNSX/nsx";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("nsx") NSX nsx, Model model){
        nsxService.add(nsx);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTNSX",nsxService.getALl());
        model.addAttribute("nsx", new NSX());
        return "viewNSX/nsx";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        NSX nsx = nsxService.timTheoID(UUID.fromString(id));
        model.addAttribute("nsx",nsx);
        model.addAttribute("LISTNSX",nsxService.getALl());
        return "viewNSX/updateNSX";
    }
}
