package com.example.smartrep.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "districts")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;
    @Column(name = "perv")
    private long perv;
    @Column(name = "oktyab")
    private long oktyab;
    @Column(name = "lenin")
    private long lenin;
    @Column(name = "sverd")
    private long sverd;
}
