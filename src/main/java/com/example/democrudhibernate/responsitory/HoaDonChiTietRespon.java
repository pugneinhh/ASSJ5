package com.example.democrudhibernate.responsitory;

import com.example.democrudhibernate.model.HoaDonChiTiet;
import com.example.democrudhibernate.model.IdHoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRespon extends JpaRepository<HoaDonChiTiet, IdHoaDonChiTiet> {
    List<HoaDonChiTiet> findAll();
    List<HoaDonChiTiet> findHoaDonChiTietsById_IdHoaDon_Id(UUID idHD);
    HoaDonChiTiet findHoaDonChiTietById_IdHoaDon_IdAndId_IdChiTietSp_Id(UUID idhd,UUID idctsp);
    @Query(value = "SELECT SUM(o.don_gia) FROM hoa_don_chi_tiet o JOIN hoa_don on o.id_hoa_don=hoa_don.id WHERE hoa_don.id=:id",nativeQuery = true)
    BigDecimal getTongTien(UUID id);


}
