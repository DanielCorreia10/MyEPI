/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.EPIDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author arauj
 */
public class EPIDAO {
    Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarEPI(EPIDTO epidto){
        String sql = "insert into epi (nomeEPI, validade, ca, descricao, quantidade, marca_idMarca, tipo_idTipo)values (?,?,?,?,?,?,?)";
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, epidto.getNomeEPI()); 
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
}
