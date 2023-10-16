package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.MauSac;
import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/mau-sac")
public class MauSacController {
    @Autowired
    MauSacService mauSacService;

    @GetMapping("/hien-thi")
    private String getALL(Model model) {
        model.addAttribute("LISTMS", mauSacService.getALl());
        model.addAttribute("ms", new MauSac());
        return "viewMauSac/mauSac";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("ms") MauSac ms, Model model){
        mauSacService.add(ms);
        model.addAttribute("LISTMS",mauSacService.getALl());
        model.addAttribute("ms", new MauSac());
        return "viewMauSac/mauSac";
    }

    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        MauSac mauSac = mauSacService.timTheoID(UUID.fromString(id));
        model.addAttribute("ms",mauSac);
        model.addAttribute("LISTMS",mauSacService.getALl());
        return "viewMauSac/mauSac";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        mauSacService.delete(UUID.fromString(id));
        model.addAttribute("ms",new MauSac());
        model.addAttribute("LISTMS",mauSacService.getALl());
        return "viewMauSac/mauSac";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("ms") MauSac mauSac, Model model){
        mauSacService.add(mauSac);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTMS",mauSacService.getALl());
        model.addAttribute("ms", new MauSac());
        return "viewMauSac/mauSac";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        MauSac mauSac = mauSacService.timTheoID(UUID.fromString(id));
        model.addAttribute("ms",mauSac);
        model.addAttribute("LISTMS",mauSacService.getALl());
        return "viewMauSac/updateMS";
    }
}
