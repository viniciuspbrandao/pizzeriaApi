package com.vb.pizzariaApi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String clientName;
//    private String clientAdress;
//    private String clientPhone;

//    @ManyToOne
//    @JoinColumn() // nullable = false / name = "pizza_id"
//    private Pizza pizza;
}
