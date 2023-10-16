package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;
import com.example.democrudhibernate.responsitory.HoaDonChiTietRespon;
import com.example.democrudhibernate.responsitory.HoaDonRespon;
import com.example.democrudhibernate.service.HoaDonChiTietService;
import com.example.democrudhibernate.service.NhanVienService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/trang-chu")
public class TrangChuController {
    @Autowired
    NhanVienService nvs;
    @Autowired
    HoaDonRespon hds;
    @Autowired
    HoaDonChiTietService hdcts;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest req;
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/hien-thi")
    private String hienThi(Model model){
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
        if(hds.getDoanhThuNgay()==null){
            model.addAttribute("DT_NGAY","0");
        }else{
            model.addAttribute("DT_NGAY",hds.getDoanhThuNgay());
        }

        model.addAttribute("DT_THANG",hds.getDoanhThuThang());
        model.addAttribute("DT_NAM",hds.getDoanhThuNam());
        model.addAttribute("LIST_HD",hds.getHoaDonsByTinhTrang(1));

        return "index";
    }
    @PostMapping("/trang-chinh")
    public String trangChu(@RequestParam("user") String user,
                           @RequestParam("pass") String pass,
                           Model model){
        NhanVien nv=nvs.login(user,pass);
        if(!user.equals(nv.getMa()) || !pass.equals(nv.getMatKhau())){
            model.addAttribute("LOI_LOGIN","Sai user hoặc password");
            return "login";
        }else{
            Cookie u=new Cookie("user",nv.getMa());
            Cookie ten=new Cookie("tenNV",nv.getTen());
            Cookie id=new Cookie("idNV",nv.getId().toString());
            Cookie hinh=new Cookie("anhNV",nv.getHinh());
            u.setMaxAge(10 * 60 * 60);
            ten.setMaxAge(10 * 60 * 60);
            id.setMaxAge(10 * 60 * 60);
            hinh.setMaxAge(10 * 60 * 60);
            u.setPath("/");
            ten.setPath("/");
            id.setPath("/");
            hinh.setPath("/");
            response.addCookie(ten);
            response.addCookie(u);
            response.addCookie(id);
            response.addCookie(hinh);
            model.addAttribute("tenNV",nv.getTen());
            model.addAttribute("anhNV",nv.getHinh());
            if(hds.getDoanhThuNgay()==null){
                model.addAttribute("DT_NGAY","0");
            }else{
                model.addAttribute("DT_NGAY",hds.getDoanhThuNgay());
            }
            model.addAttribute("LIST_HD",hds.getHoaDonsByTinhTrang(1));
            model.addAttribute("DT_THANG",hds.getDoanhThuThang());
            model.addAttribute("DT_NAM",hds.getDoanhThuNam());
            return "index";
        }

    }
    @GetMapping("/logout")
    public String logout(){
        Cookie u=new Cookie("user","");
        Cookie ten=new Cookie("tenNV","");
        Cookie id=new Cookie("idNV","");
        Cookie hinh=new Cookie("anhNV","");
        u.setMaxAge(0);
        ten.setMaxAge(0);
        id.setMaxAge(0);
        hinh.setMaxAge(0);
        u.setPath("/");
        response.addCookie(ten);
        response.addCookie(u);
        response.addCookie(id);
        response.addCookie(hinh);
        return "login";
    }
    @PostMapping("/loc-hoa-don")
    public String locHD(@RequestParam("ngayBD") String ngayBD,
                        @RequestParam("ngayKT") String ngayKT,
                        Model model){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1=sdf.parse(ngayBD);
            java.sql.Date ngaybd=new java.sql.Date(d1.getTime());
            Date d2=sdf.parse(ngayKT);
            java.sql.Date ngaykt=new java.sql.Date(d2.getTime());
            model.addAttribute("LIST_HD",hds.getHoaDonTheoNgay(ngaybd,ngaykt));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(hds.getDoanhThuNgay()==null){
            model.addAttribute("DT_NGAY","0");
        }else{
            model.addAttribute("DT_NGAY",hds.getDoanhThuNgay());
        }
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
        model.addAttribute("DT_THANG",hds.getDoanhThuThang());
        model.addAttribute("DT_NAM",hds.getDoanhThuNam());
        return "index";
    }
    @GetMapping("/xemHD/{id}")
    public String xemHD(@PathVariable("id") String idHD,
                        Model model){
        model.addAttribute("LIST_HDCT",hdcts.getHoaDonByID(UUID.fromString(idHD)));
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
        return "hoaDonTK";
    }
}
