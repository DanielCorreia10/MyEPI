/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author arauj
 */
public class EPIDTO {
    private String nomeEPI, descricao;
    private Date validade;
    private int ca, quantidade, marca_idMarca, tipo_idTipo;

    public int getCa() {
        return ca;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNomeEPI() {
        return nomeEPI;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNomeEPI(String nomeEPI) {
        this.nomeEPI = nomeEPI;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getMarca_idMarca() {
        return marca_idMarca;
    }

    public void setMarca_idMarca(int marca_idMarca) {
        this.marca_idMarca = marca_idMarca;
    }

    public int getTipo_idTipo() {
        return tipo_idTipo;
    }

    public void setTipo_idTipo(int tipo_idTipo) {
        this.tipo_idTipo = tipo_idTipo;
    }

    
}
