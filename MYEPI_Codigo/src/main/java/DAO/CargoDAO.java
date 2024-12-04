
package DAO;

import DTO.CargoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CargoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    public void cadastrarCargo(CargoDTO cargodto) {
        String sql = "insert into cargo(nomeCargo)values (?)";

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

    public CargoDTO buscarPorId(int idCargo) throws SQLException{
        String sql = "SELECT * FROM cargo WHERE idCargo = ?";
        pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idCargo);
        rs = pstm.executeQuery();

        if (rs.next()) {
            CargoDTO cargo = new CargoDTO();
            cargo.setIdCargo(rs.getInt("idCargo"));
            cargo.setNomeCargo(rs.getString("nomeCargo"));
            return cargo;
        }

        return null;    
    }

}
