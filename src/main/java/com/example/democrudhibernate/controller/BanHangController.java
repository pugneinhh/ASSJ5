package com.example.democrudhibernate.controller;

import com.example.democrudhibernate.model.*;
import com.example.democrudhibernate.responsitory.HoaDonChiTietRespon;
import com.example.democrudhibernate.service.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ban-hang")
public class BanHangController {
    @Autowired
    NhanVienService nvs;
    @Autowired
    HoaDonService hds;
    @Autowired
    HoaDonChiTietService hdcts;
    @Autowired
    KhachHangSerivce khs;
    @Autowired
    HttpServletResponse response;
    @Autowired
    HttpServletRequest req;
    @Autowired
    DongSPSerivce dsps;
    @Autowired
    ChiTietSPService ctsps;

    @Autowired
    private HoaDonChiTietRespon hoaDonChiTietRespon;

    public void getCookie(Model model) {
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
                if (cookie.getName().equals("idNV")) {
                    String id = cookie.getValue();
                    NhanVien nv = nvs.timTheoID(UUID.fromString(id));
                }
            }
        }
    }

    @GetMapping("/hien-thi")
    private String show(Model model,
                        @ModelAttribute("hd") HoaDon hoaDon) {
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
                if (cookie.getName().equals("idNV")) {
                    String id = cookie.getValue();
                    NhanVien nv = nvs.timTheoID(UUID.fromString(id));
                    model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));
                    model.addAttribute("hd", new HoaDon());

                }
            }
        }

        return "/viewBanHang/BanHang";
    }

    @GetMapping("/chonKH/{id}")
    private String chonKH(@PathVariable("id") String id,
                          Model model) {
        model.addAttribute("idHD", id);
        model.addAttribute("LISTKH", khs.getALl());
        return "/viewBanHang/KhachHangBan";
    }

    @GetMapping("/taoHD")
    private String addKH(Model model) {
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
                if (cookie.getName().equals("idNV")) {
                    String id = cookie.getValue();
                    NhanVien nv = nvs.timTheoID(UUID.fromString(id));
                    if (hds.findHoaDonByNhanVienAndTinhTrang(nv,0).size() >= 5) {
                        model.addAttribute("ThongBao", "Vui lòng thanh toán các hóa đơn chờ");
                        model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));
                        model.addAttribute("hd", new HoaDon());
                    } else {
                        HoaDon hd = new HoaDon();
                        hd.setNhanVien(nv);
                        hd.setMa("HD0" + hds.getALl().size());
                        hd.setTinhTrang(0);
                        Date date = new Date();
                        java.sql.Date ngayTao = new java.sql.Date(date.getTime());
                        hd.setNgayTao(ngayTao);
                        hds.add(hd);
                        model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));
                        model.addAttribute("hd", new HoaDon());
                    }
                }
            }
        }
        return "/viewBanHang/BanHang";
    }

    @GetMapping("/addKH/{idKH}/{idHD}")
    public String themKHvaoHD(@PathVariable("idKH") String idKH,
                              @PathVariable("idHD") String idHD,
                              Model model) {
        String id = "";
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
                if (cookie.getName().equals("idNV")) {
                    id = cookie.getValue();
                }
            }
        }
        NhanVien nv = nvs.timTheoID(UUID.fromString(id));
        HoaDon hoaDon = hds.findHDbyID(UUID.fromString(idHD));
        System.out.println(hoaDon.toString());
        KhachHang kh = khs.timTheoID(UUID.fromString(idKH));
        hoaDon.setKhachHang(kh);
        hds.updateKHofHD(hoaDon);
        model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));
        model.addAttribute("hd", hoaDon);
        model.addAttribute("LISTHDCT",hdcts.getHoaDonByID(UUID.fromString(idHD)));
        model.addAttribute("thanhTien",hdcts.getTongTien(UUID.fromString(idHD)));
        return "/viewBanHang/BanHang";
    }

    @GetMapping("/deleteHD/{id}")
    private String deleteHD(@PathVariable("id") String id, Model model) {
        HoaDon hoaDon = hds.findHDbyID(UUID.fromString(id));
        hoaDon.setTinhTrang(2);
        hds.updateKHofHD(hoaDon);
        String idNV = "";
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
                if (cookie.getName().equals("idNV")) {
                    idNV = cookie.getValue();

                }
            }
        }
        NhanVien nv = nvs.timTheoID(UUID.fromString(idNV));
        model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));
        model.addAttribute("hd", new HoaDon());
        return "/viewBanHang/BanHang";
    }
    @GetMapping("/chon-HD/{id}")
    private String chonHd(@PathVariable("id") String id,
                          Model model){
        HoaDon hoaDon=hds.findHDbyID(UUID.fromString(id));
        model.addAttribute("hd",hoaDon);
        String idNV = "";
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
                if (cookie.getName().equals("idNV")) {
                    idNV = cookie.getValue();

                }
            }
        }
        NhanVien nv=nvs.timTheoID(UUID.fromString(idNV));
        model.addAttribute("LISTHD",hds.findHoaDonByNhanVienAndTinhTrang(nv,0));
        model.addAttribute("thanhTien",hdcts.getTongTien(UUID.fromString(id)));
        model.addAttribute("LISTHDCT",hdcts.getHoaDonByID(UUID.fromString(id)));

        return "/viewBanHang/BanHang";
    }

    @GetMapping("/deleteHDCT/{idHD}/{idCTSP}")
    private String hoaDonCT(@PathVariable("idHD") String idHD,
                            @PathVariable("idCTSP") String idCTSP,
                            Model model){
        HoaDonChiTiet hdct=hdcts.getHDCT(UUID.fromString(idHD),UUID.fromString(idCTSP));
        ChiTietSP c=ctsps.getByID(UUID.fromString(idCTSP));
        c.setSlt(c.getSlt()+hdct.getSoLuong());
        ctsps.add(c);
        hdcts.deleteHDCT(hdct);
        model.addAttribute("ThongBao","Xóa thành công");
        String idNV = "";
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
                if (cookie.getName().equals("idNV")) {
                    idNV = cookie.getValue();

                }
            }
        }
        NhanVien nv=nvs.timTheoID(UUID.fromString(idNV));
        HoaDon hoaDon=hds.findHDbyID(UUID.fromString(idHD));
        model.addAttribute("hd",hoaDon);
        model.addAttribute("thanhTien",hdcts.getTongTien(UUID.fromString(idHD)));
        model.addAttribute("LISTHD",hds.findHoaDonByNhanVienAndTinhTrang(nv,0));
        model.addAttribute("LISTHDCT",hdcts.getHoaDonByID(UUID.fromString(idHD)));

        return "/viewBanHang/BanHang";
    }
    @GetMapping("/sanPham/{id}")
    private String showSP(@PathVariable("id") String id,
                          Model model){
        model.addAttribute("LIST_DM",dsps.getALl());
        model.addAttribute("LIST_CTSP",ctsps.getAll());
        model.addAttribute("idHD",id);
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
        return "/viewBanHang/SanPhamBan";
    }
    @PostMapping("/mua-hang")
    private String muaHang(@RequestParam("idHD") String idHD,
                           @RequestParam("idSP") String idSP,
                           @RequestParam("soLuong") String sl,
                           Model model){
        if(Integer.parseInt(sl)>ctsps.getByID(UUID.fromString(idSP)).getSlt()){
            model.addAttribute("ThongBao","Sản phẩm vượt quá số lượng trong kho");
        }else {
            IdHoaDonChiTiet id = new IdHoaDonChiTiet();
            id.setIdHoaDon(hds.findHDbyID(UUID.fromString(idHD)));
            id.setIdChiTietSp(ctsps.getByID(UUID.fromString(idSP)));
            List<HoaDonChiTiet> list=hdcts.getHoaDonByID(UUID.fromString(idHD));

            int soLuong;
            double gia  ;
            int check=0;
            HoaDonChiTiet hdc=hdcts.getHDCT(UUID.fromString(idHD),UUID.fromString(idSP));
                if(hdc!=null){
                    soLuong=Integer.parseInt(sl)+hdc.getSoLuong();
                    gia=(Integer.parseInt(sl) * ctsps.getByID(UUID.fromString(idSP)).getGiaBan().doubleValue())+hdc.getDonGia().doubleValue();
                    hdc.setSoLuong(soLuong);
                    hdc.setDonGia(BigDecimal.valueOf(gia));
                    hdcts.updateHDCT(hdc);
                    ChiTietSP c=ctsps.getByID(UUID.fromString(idSP));
                    c.setSlt(c.getSlt()-soLuong);
                    ctsps.add(c);
                    check=1;
                }

            if(check==0) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setId(id);
                soLuong=Integer.parseInt(sl);
                gia=Integer.parseInt(sl) * ctsps.getByID(UUID.fromString(idSP)).getGiaBan().doubleValue();
                hdct.setSoLuong(soLuong);
                hdct.setDonGia(BigDecimal.valueOf(gia));
                hdcts.addHDCT(hdct);
                ChiTietSP c=ctsps.getByID(UUID.fromString(idSP));
                c.setSlt(c.getSlt()-soLuong);
                ctsps.add(c);
            }
        }
        String idNV = "";
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
                if (cookie.getName().equals("idNV")) {
                    idNV = cookie.getValue();

                }
            }
        }
        NhanVien nv=nvs.timTheoID(UUID.fromString(idNV));
        HoaDon hoaDon=hds.findHDbyID(UUID.fromString(idHD));
        model.addAttribute("hd",hoaDon);
        model.addAttribute("thanhTien",hdcts.getTongTien(UUID.fromString(idHD)));
        model.addAttribute("LISTHD",hds.findHoaDonByNhanVienAndTinhTrang(nv,0));
        model.addAttribute("LISTHDCT",hdcts.getHoaDonByID(UUID.fromString(idHD)));
        return "/viewBanHang/BanHang";
    }

    @PostMapping("/thanh-toan")
    public String thanhToan(@RequestParam("id") String id,
                            @RequestParam("thanhTien") String ttien,
                            @RequestParam("tienKhach") String tienK,
                            @RequestParam("tienTra") String tienT,
                            Model model){
        HoaDon hd=hds.findHDbyID(UUID.fromString(id));

        int check=0;
        if(Double.parseDouble(tienK)<Double.parseDouble(ttien)){
            check=1;
            model.addAttribute("ThongBao","Tiền khách đưa không đủ");
            model.addAttribute("hd",hd);
            model.addAttribute("thanhTien",hdcts.getTongTien(UUID.fromString(id)));
            model.addAttribute("LISTHDCT",hdcts.getHoaDonByID(UUID.fromString(id)));
        }
        if(check==0){
            hd.setThanhTien(BigDecimal.valueOf(Double.parseDouble(ttien)));
            Date date=new Date();
            java.sql.Date ngayTT=new java.sql.Date(date.getTime());
            hd.setNgayThanhToan(ngayTT);
            hd.setTinhTrang(1);
            hds.add(hd);
            model.addAttribute("hd", new HoaDon());
            model.addAttribute("ThongBao","Thanh toán thành công");
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
                if (cookie.getName().equals("idNV")) {
                    String idNV = cookie.getValue();
                    NhanVien nv = nvs.timTheoID(UUID.fromString(idNV));
                    model.addAttribute("LISTHD", hds.findHoaDonByNhanVienAndTinhTrang(nv, 0));

                }
            }
        }
        return "/viewBanHang/BanHang";
    }
}
