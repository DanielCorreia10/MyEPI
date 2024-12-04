package DTO;


public class FuncionarioDTO {

    private String NomeFuncionario, SobrenomeFuncionario; 
    private int cargo_idCargo;

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return SobrenomeFuncionario; 
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public void setSobrenomeFuncionario(String SobrenomeFuncionario) {
        this.SobrenomeFuncionario = SobrenomeFuncionario; 
    }

    public int getCargo_idCargo() {
        return cargo_idCargo;
    }

    public void setCargo_idCargo(int cargo_idCargo) {
        this.cargo_idCargo = cargo_idCargo;
    }
    
    
}
