package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class FuncionarioDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<FuncionarioDTO> lista = new ArrayList<>();
    
    public void cadastrarFuncionario(FuncionarioDTO funcionariodto){
        String sql = "insert into funcionario(NomeFuncionario, Sobrenome)values (?,?)";
        
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
     public ArrayList<FuncionarioDTO> PesquisarFuncionario(){
    
        String sql = "select * from funcionario";
        
        conn = new Conexao().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
            FuncionarioDTO funcionariodto = new FuncionarioDTO();
            funcionariodto.setIdFuncionario(rs.getInt("idFuncionario"));
            funcionariodto.setNomeFuncionario(rs.getString("nomeFuncionario"));
            funcionariodto.setSobrenomeFuncionario(rs.getString("sobrenome"));
            funcionariodto.setCargo_idCargo(rs.getInt("cargo_idCargo"));
          
            
            lista.add(funcionariodto);
            
            }
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,erro + "Erro Pesquisar funcionario");
        }
        
        return lista;
        
    }
    
    public void alterarFuncionario(int id, String nome, String sobrenome, int idCargo){
        
        String sql = "UPDATE funcionario SET nomeFuncionario = ?, sobrenome = ?, cargo_idcargo = ? WHERE  id = ?;";
        
        conn = new Conexao().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, sobrenome);
            pstm.setInt(3, idCargo);
            pstm.setInt(4, id);
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e + "Alterar FuncionarioDAO");
            
        }
    
    }
    
    public void excluirFuncionario(int id){
        
        String sql = "DELETE FROM funcionario WHERE id = ?;";
        
        conn = new Conexao().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e + "Excluir FuncionarioDAO");
            
        }
    
    }
}
