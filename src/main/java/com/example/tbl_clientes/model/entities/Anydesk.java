package com.example.tbl_clientes.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "anydesks")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Anydesk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_maquina", nullable = false)
    private String tipoMaquina;

    @Column(name = "endereco_anydesk", nullable = false, unique = true)
    private String enderecoAnydesk;

    @Column(name = "senha_any")
    private String senhaAny;

    @Column(name = "senha_win")
    private String senhaWin;

    @Column
    private String observacao;

    @ManyToOne(targetEntity = Posto.class, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "posto_id", referencedColumnName = "id")
    private Posto posto;

}
