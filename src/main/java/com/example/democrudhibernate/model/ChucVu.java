package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table(name="chuc_vu")
@Entity
@Data
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String ma;
    private String ten;
}
