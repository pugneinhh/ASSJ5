package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Table
@Entity
@Data
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private String gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private String matKhau;
    @ManyToOne()
    @JoinColumn(name = "id_ch")
    public CuaHang cuaHang;
    @ManyToOne()
    @JoinColumn(name = "id_cv")
    public ChucVu chucVu;
    private String hinh;
    private int trangThai;

}
