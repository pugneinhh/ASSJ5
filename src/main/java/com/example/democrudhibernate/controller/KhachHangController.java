package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.model.KhachHang;
import com.example.democrudhibernate.service.KhachHangSerivce;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired

    KhachHangSerivce khachHangSerivce;
    @Autowired
    HttpServletRequest req;
    public void getCookie(Model model){
        Cookie ck[] = req.getCookies();
        if (ck != null) {
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("tenNV")) {
                    String value = cookie.getValue();
                    model.addAttribute("tenNV", value);
                }
                if (cookie.getName().equals("anhNV")) {
                    String hinh = cookie.getValue();
                    model.addAttribute("anhNV", hinh);
                }
            }
        }
    }
    @GetMapping("/hien-thi")
    private String getALl(Model model){
        getCookie(model);
        model.addAttribute("kh",new KhachHang());
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        return "viewKhachHang/khachHang";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        KhachHang khachHang = khachHangSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("kh",khachHang);
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        getCookie(model);
        return "viewKhachHang/khachHang";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){

        khachHangSerivce.delete(UUID.fromString(id));
        model.addAttribute("kh", new KhachHang());
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        getCookie(model);
        return "viewKhachHang/khachHang";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("kh") KhachHang khachHang, Model model){
        khachHangSerivce.add(khachHang);
        model.addAttribute("kh", new KhachHang());
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        getCookie(model);
        return "viewKhachHang/khachHang";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("kh") KhachHang khachHang, Model model){
        khachHangSerivce.add(khachHang);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        model.addAttribute("kh", new KhachHang());
        getCookie(model);
        return "viewKhachHang/khachHang";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        KhachHang khachHang = khachHangSerivce.timTheoID(UUID.fromString(id));
        model.addAttribute("kh",khachHang);
        model.addAttribute("LISTKH",khachHangSerivce.getALl());
        getCookie(model);
        return "viewKhachHang/updateKhachHang";
    }
}
