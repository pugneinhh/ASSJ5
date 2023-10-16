package com.example.democrudhibernate.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name = "san_pham")
@Entity
@Data
public class SanPham {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private UUID id;

    private String ma;
    private String ten;
}
