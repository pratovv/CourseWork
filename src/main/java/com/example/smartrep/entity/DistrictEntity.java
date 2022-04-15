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
    private Short id;

    @Column(name = "perv")
    private Long perv;

    @Column(name = "oktyab")
    private Long oktyab;

    @Column(name = "lenin")
    private Long lenin;

    @Column(name = "sverd")
    private Long sverd;
}
