package com.example.demohotelapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_HOTELS")
public class HotelModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID hotelID;

    private String nome;
    private String cidade;
    private int qtsQuartos;
    private boolean disponivel;

    public UUID getHotelID() {
        return hotelID;
    }

    public void setHotelID(UUID hotelID) {
        this.hotelID = hotelID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getQtsQuartos() {
        return qtsQuartos;
    }

    public void setQtsQuartos(int qtsQuartos) {
        this.qtsQuartos = qtsQuartos;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

