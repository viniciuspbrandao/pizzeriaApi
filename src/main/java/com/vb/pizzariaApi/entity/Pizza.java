package com.vb.pizzariaApi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String namePizza;
    private int ingredients;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requestDateTime;


//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Telefone> telefones;

//    @JoinColumn(name = "client_id")// Aqui entra a coluna com a foregn Key
//    private List<Cliente> cliente;

}
