package com.example.democrudhibernate.controller;


import com.example.democrudhibernate.model.ChucVu;
import com.example.democrudhibernate.model.CuaHang;
import com.example.democrudhibernate.service.ChucVuService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/chuc-vu")
public class ChucVuController {

    @Autowired
    ChucVuService chucVuService;
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
        model.addAttribute("cv",new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        return "viewChucVu/chucVu";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id, Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        model.addAttribute("cv",chucVu);
        model.addAttribute("list",chucVuService.getAll());
        getCookie(model);
        return "viewChucVu/chucVu";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id, Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        chucVuService.delete(chucVu);
        model.addAttribute("cv", new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        getCookie(model);
        return "viewChucVu/chucVu";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("cv") ChucVu chucVu, Model model){
        chucVuService.add(chucVu);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("list",chucVuService.getAll());
        model.addAttribute("cv", new ChucVu());
        getCookie(model);
        return "/viewChucVu/chucVu";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        ChucVu chucVu = chucVuService.timTheoID(UUID.fromString(id));
        model.addAttribute("cv",chucVu);
        model.addAttribute("LISTCV",chucVuService.getAll());
        getCookie(model);
        return "/viewChucVu/updateCV";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("cv") ChucVu chucVu,Model model){
        chucVuService.add(chucVu);
        model.addAttribute("cv", new ChucVu());
        model.addAttribute("list",chucVuService.getAll());
        getCookie(model);
        return "viewChucVu/chucVu";
    }
}
