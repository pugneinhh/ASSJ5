package com.example.democrudhibernate.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Table (name = "mau_sac")
@Entity
@Data
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String ma;
    private String ten;
}
