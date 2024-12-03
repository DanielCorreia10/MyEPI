/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CargoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author arauj
 */
public class CargoDAO {
     Connection conn;
    PreparedStatement pstm;
    
    public void cadastrarCargo(CargoDTO cargodto){
        String sql = "insert into tabela(NomeCargo)values (?)";
        
        conn = new Conexao().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, cargodto.getNomeCargo()); 
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " CargoDAO");
        }
    }

}
