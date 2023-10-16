package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.CuaHang;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.democrudhibernate.service.CuaHangService;

import java.util.UUID;

@Controller
@RequestMapping("/cua-hang")
public class CuaHangController {

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
    private String getALL(Model model) {
        getCookie(model);
        model.addAttribute("LISTCH", cuaHangService.getAll());
        model.addAttribute("ch", new CuaHang());
        return "/viewCuaHang/cuaHang";
    }
    @PostMapping("/add")
    private String add(@ModelAttribute("ch") CuaHang ch, Model model){
        cuaHangService.add(ch);
        model.addAttribute("ThongBao","Thêm thành công");
        model.addAttribute("LISTCH",cuaHangService.getAll());
        model.addAttribute("ch", new CuaHang());
        getCookie(model);
        return "/viewCuaHang/cuaHang";
    }
    @PostMapping("/update")
    private String update(@ModelAttribute("ch") CuaHang ch, Model model){
        cuaHangService.add(ch);
        model.addAttribute("ThongBao","Cập nhật thành công");
        model.addAttribute("LISTCH",cuaHangService.getAll());
        model.addAttribute("ch", new CuaHang());
        getCookie(model);
        return "/viewCuaHang/cuaHang";
    }
    @GetMapping("/view-update/{id}")
    private String viewUpdate(@PathVariable String id,Model model){
        CuaHang cuaHang = cuaHangService.timTheoID(UUID.fromString(id));
        model.addAttribute("ch",cuaHang);
        model.addAttribute("LISTCH",cuaHangService.getAll());
        getCookie(model);
        return "/viewCuaHang/updateCH";
    }
    @GetMapping("/detail/{id}")
    private String detail(@PathVariable String id,Model model){
        CuaHang cuaHang = cuaHangService.timTheoID(UUID.fromString(id));
        model.addAttribute("ch",cuaHang);
        model.addAttribute("LISTCH",cuaHangService.getAll());
        getCookie(model);
        return "/viewCuaHang/cuaHang";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable String id,Model model){
        cuaHangService.delete(UUID.fromString(id));
        model.addAttribute("ThongBao","Xóa thành công");
        model.addAttribute("ch",new CuaHang());
        model.addAttribute("LISTCH",cuaHangService.getAll());
        getCookie(model);
        return "/viewCuaHang/cuaHang";
    }
}
