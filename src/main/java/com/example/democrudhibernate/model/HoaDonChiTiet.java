package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@ToString
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;
    private int soLuong;
    private BigDecimal donGia;
}
