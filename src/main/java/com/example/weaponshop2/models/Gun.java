package com.example.weaponshop2.models;

import javax.persistence.*;

@Entity
@Table(name = "guns")
public class Gun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public String name;

    @Column
    public int price;

    @Column
    public int amount;

    public Gun() {
    }
}
