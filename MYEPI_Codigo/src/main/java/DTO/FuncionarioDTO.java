package DTO;

/**
 *
 * @author arauj
 */
public class FuncionarioDTO {

    private String NomeFuncionario, SobrenomeFuncionario; 

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
}
