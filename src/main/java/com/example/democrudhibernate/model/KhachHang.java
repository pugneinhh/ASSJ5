package com.example.democrudhibernate.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Table(name = "khach_hang")
@Entity
@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ma;
    private String ten;
    private String tenDem;
    private String ho;
    private Date ngaySinh;
    private String sdt;
    private String diaChi;
    private String thanhPho;
    private String quocGia;
    private String matKhau;
}
