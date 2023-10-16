package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.SanPham;
import com.example.democrudhibernate.service.CuaHangService;
import com.example.democrudhibernate.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/san-pham")
public class SanPhamController{

    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/hien-thi")
    private String getALL(Model model) {
        model.addAttribute("LISTSP", sanPhamService.getALl());
        model.addAttribute("sp", new SanPham());
        return "/viewSanPham/sanPham";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("sp") SanPham sp, Model model){
        sanPhamService.add(sp);
        model.addAttribute("ThongBao","Thêm thành công");
        model.addAttribute("LISTSP",sanPhamService.getALl());
        model.addAttribute("sp", new SanPham());
        return "/viewSanPham/sanPham";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("sp") SanPham sp, Model model){
        sanPhamService.add(sp);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTSP",sanPhamService.getALl());
        model.addAttribute("sp", new SanPham());
        return "/viewSanPham/sanPham";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id, Model model){
        SanPham sp = sanPhamService.timTheoID(UUID.fromString(id));
        model.addAttribute("sp",sp);
        model.addAttribute("LISTSP",sanPhamService.getALl());
        return "/viewSanPham/updateSP";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id,Model model){
        SanPham sp = sanPhamService.timTheoID(UUID.fromString(id));
        model.addAttribute("sp",sp);
        model.addAttribute("LISTSP",sanPhamService.getALl());
        return "/viewSanPham/sanPham";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        sanPhamService.delete(UUID.fromString(id));
        model.addAttribute("ThongBao","Xóa thành công");
        model.addAttribute("sp",new SanPham());
        model.addAttribute("LISTSP",sanPhamService.getALl());
        return "/viewSanPham/sanPham";
    }
}
