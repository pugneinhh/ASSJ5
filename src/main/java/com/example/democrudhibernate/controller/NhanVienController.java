package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.NSX;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.service.ChucVuService;
import com.example.democrudhibernate.service.CuaHangService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {
    @Autowired
    NhanVienService nhanVienService;
    @Autowired
    ChucVuService chucVuService;
    @Autowired
    CuaHangService cuaHangService;
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
        model.addAttribute("nv",new NhanVien());
        model.addAttribute("LISTNV",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        System.out.println(chucVuService.getAll());
        return "viewNhanVien/nhanVien";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        NhanVien nhanVien = nhanVienService.timTheoID(UUID.fromString(id));
        model.addAttribute("nv",nhanVien);
        model.addAttribute("LISTNV",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        getCookie(model);
        return "viewNhanVien/nhanVien";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){

        nhanVienService.delete(UUID.fromString(id));
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("LISTNV",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        getCookie(model);
        return "viewNhanVien/nhanVien";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("nv") NhanVien nhanVien, Model model){
        nhanVienService.add(nhanVien);
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        model.addAttribute("LISTNV",nhanVienService.getALl());
        getCookie(model);
        return "redirect:/nhan-vien/hien-thi";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("nv") NhanVien nv, Model model){
        nhanVienService.add(nv);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("nv", new NhanVien());
        model.addAttribute("LISTNV",nhanVienService.getALl());
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        getCookie(model);
        return "viewNhanVien/nhanVien";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        NhanVien nhanVien = nhanVienService.timTheoID(UUID.fromString(id));
        model.addAttribute("nv",nhanVien);
        model.addAttribute("listCV",chucVuService.getAll());
        model.addAttribute("listCH",cuaHangService.getAll());
        getCookie(model);
        return "viewNhanVien/updateNhanVien";
    }
}
