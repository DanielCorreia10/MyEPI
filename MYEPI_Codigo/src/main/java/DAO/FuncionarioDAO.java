package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author arauj
 */
public class FuncionarioDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarFuncionario(FuncionarioDTO funcionariodto){
        String sql = "insert into tabela(NomeFuncionario, Sobrenome)values (?,?)";
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNomeFuncionario()); 
            pstm.setString(2, funcionariodto.getSobrenomeFuncionario());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " FuncionarioDAO");
        }
    }
}
