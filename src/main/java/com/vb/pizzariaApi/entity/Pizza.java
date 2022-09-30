package com.vb.pizzariaApi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


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

    @OneToMany
    private List<Cliente> cliente;
}
