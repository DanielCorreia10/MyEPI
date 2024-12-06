/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MarcaDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class MarcaDAO {

    Connection conn;
    PreparedStatement pstm;
     ResultSet rs;


    public void cadastrarFuncionario(MarcaDTO marcadto) {
        String sql = "insert into marca(nomeMarca)values (?)";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, marcadto.getNomeMarca());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " MarcaDAO");
        }
    }


}
