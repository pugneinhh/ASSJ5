package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.HoaDon;
import com.example.democrudhibernate.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRespon extends JpaRepository<HoaDon, UUID> {
   List<HoaDon> getHoaDonsByNhanVienAndTinhTrang(NhanVien nv, int tt);
    HoaDon findHoaDonById(UUID id);
    @Query(value = "SELECT * from hoa_don WHERE ngay_thanh_toan between :ngayBD AND :ngayKT",nativeQuery = true)
    List<HoaDon> getHoaDonTheoNgay(Date ngayBD,Date ngayKT);
    List<HoaDon> getHoaDonsByTinhTrang(int tt);
    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate()) AND MONTH(ngay_thanh_toan)=MONTH(getdate()) AND DAY(ngay_thanh_toan)=DAY(getdate()) AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuNgay();
    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate()) AND MONTH(ngay_thanh_toan)=MONTH(getdate()) AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuThang();
    @Query(value = "SELECT SUM(thanh_tien) FROM hoa_don WHERE YEAR(ngay_thanh_toan)=YEAR(getdate())  AND tinh_trang=1",nativeQuery = true)
    BigDecimal getDoanhThuNam();
}
