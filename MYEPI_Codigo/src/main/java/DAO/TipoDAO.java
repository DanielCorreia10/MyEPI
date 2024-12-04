package DAO;

import DTO.TipoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TipoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;



    public void cadastrarFuncionario(TipoDTO tipodto) {
        String sql = "insert into tipo(nomeTipo)values (?)";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, tipodto.getNomeTipo());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " TipoDAO");
        }
    }

    public TipoDTO buscarPorId(int idTipo) throws SQLException  {
        String sql = "SELECT * FROM cargo WHERE idMarca = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idTipo);
        rs = pstm.executeQuery();

        if (rs.next()) {
            TipoDTO tipo = new TipoDTO();
            tipo.setIdMarca(rs.getInt("idTipo"));
            tipo.setNomeMarca(rs.getString("nomeTipo"));
            return tipo;
        }

        return null;
    }
}
