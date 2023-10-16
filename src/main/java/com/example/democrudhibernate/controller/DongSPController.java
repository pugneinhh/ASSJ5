package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.DongSP;
import com.example.democrudhibernate.service.ChucVuService;
import com.example.democrudhibernate.service.DongSPSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/dongSP")
public class DongSPController {
    @Autowired
    DongSPSerivce dongSPSerivce;

    @GetMapping("/hien-thi")
    private String getALl(Model model){
        model.addAttribute("dsp",new DongSP());
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        return "viewDongSP/dongSP";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        DongSP dongSP = dongSPSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("dsp",dongSP);
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        return "viewDongSP/dongSP";
    }

    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){

        dongSPSerivce.delete(UUID.fromString(id));
        model.addAttribute("dsp", new DongSP());
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        return "viewDongSP/dongSP";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("dsp") DongSP dongSP, Model model){
        dongSPSerivce.add(dongSP);
        model.addAttribute("dsp", new DongSP());
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        return "viewDongSP/dongSP";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("dsp") DongSP dongSP, Model model){
        dongSPSerivce.add(dongSP);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        model.addAttribute("dsp", new DongSP());
        return "viewDongSP/dongSP";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        DongSP dongSP = dongSPSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("dsp",dongSP);
        model.addAttribute("LISTDSP",dongSPSerivce.getALl());
        return "viewDongSP/dongSPUpdate";
    }
}
