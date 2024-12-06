package DTO;


public class FuncionarioDTO {

    private String nomeFuncionario, sobrenome, nomeCargo; 
    private int idFuncionario, cargo_idCargo;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return sobrenome; 
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome; 
    }

    public int getCargo_idCargo() {
        return cargo_idCargo;
    }

    public void setCargo_idCargo(int cargo_idCargo) {
        this.cargo_idCargo = cargo_idCargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public String getSobrenome() {
        return sobrenome;
    }
    
    
    
    
    
}
