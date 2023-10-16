package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "chi_tiet_sp")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ChiTietSP {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham sanPham;
    @ManyToOne
    @JoinColumn(name = "id_nsx")
    private NSX nsx;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;
    @ManyToOne
    @JoinColumn(name = "id_dong_sp")
    private DongSP dongSP;
    @Column(name = "nam_bh")
    private int namBH;
    @Column(name = "so_luong_ton")
    private int slt;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String hinh;
    private String moTa;
}
