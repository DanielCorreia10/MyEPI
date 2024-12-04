
package DTO;

import java.sql.Date;


public class EPIDTO {
    private String nomeEpi, descricao;
    private Date validade;
    private int idEpi, ca, quantidade, marca_idMarca, tipo_idTipo;

    public int getCa() {
        return ca;
    }

    public String getDescricao() {
        return descricao;
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

    public String getNomeEpi() {
        return nomeEpi;
    }

    public void setNomeEpi(String nomeEpi) {
        this.nomeEpi = nomeEpi;
    }

    public int getIdEpi() {
        return idEpi;
    }

    public void setIdEpi(int idEpi) {
        this.idEpi = idEpi;
    }

    
}
