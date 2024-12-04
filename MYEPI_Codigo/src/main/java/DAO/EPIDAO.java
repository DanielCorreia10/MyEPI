
package DAO;

import DTO.EPIDTO;
import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class EPIDAO {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EPIDTO> lista = new ArrayList<>();
    
    public void cadastrarEPI(EPIDTO epidto){
        String sql = "insert into epi (nomeEPI, validade, ca, descricao, quantidade, marca_idMarca, tipo_idTipo)values (?,?,?,?,?,?,?)";
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, epidto.getNomeEpi()); 
            pstm.setDate(2, epidto.getValidade());
            pstm.setInt(3, epidto.getCa());
            pstm.setString(4, epidto.getDescricao());
            pstm.setInt(5, epidto.getQuantidade());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " EPIDAO");
        }
    }
    
     public ArrayList<EPIDTO> PesquisarEpi(){
    
        String sql = "select * from epi";
        
        conn = new Conexao().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            while(rs.next()){
            EPIDTO epiDto = new EPIDTO();
            epiDto.setNomeEpi(rs.getString("nomeEpi"));
            epiDto.setIdEpi(rs.getInt("idEpi"));
            
            lista.add(epiDto);
            
            }
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,erro + "Erro Pesquisar");
        }
        
        return lista;
        
    }
    
    public void alterarEpi(int id, String nome, String sobrenome, int idCargo){
        
        String sql = "UPDATE epi SET nomeEPI = ?, validade = ?, ca = ?, descricao = ?, quantidade = ?, marca_idMarca = ?, tipo_idTipo = ?";
        
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
            
             JOptionPane.showMessageDialog(null, e + "Alterar EPIDAO");
            
        }
    
    }
    
    public void excluirEpi(int id){
        
        String sql = "DELETE FROM epi WHERE id = ?;";
        
        conn = new Conexao().conectaBD();
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            pstm.close();
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, e + "Excluir EPIDAO");
            
        }
    
    }
}
