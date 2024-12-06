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
    ArrayList<FuncionarioDTO> listaFuncionarios = new ArrayList<>();

    public void cadastrarFuncionario(FuncionarioDTO funcionariodto) {
        String sql = "insert into funcionario(NomeFuncionario, Sobrenome, cargo_idCargo )values (?,?,?)";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionariodto.getNomeFuncionario());
            pstm.setString(2, funcionariodto.getSobrenomeFuncionario());
            pstm.setInt(3, funcionariodto.getCargo_idCargo());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " FuncionarioDAO");
        }
    }

    public ArrayList<FuncionarioDTO> listarTodosFuncionarios() {

        try {

            String sql = "SELECT f.idFuncionario, f.nomeFuncionario, f.sobrenome, c.nomeCargo "
                    + "FROM funcionario f "
                    + "JOIN cargo c ON f.cargo_idCargo = c.idCargo "
                    + "ORDER BY f.idFuncionario";

            conn = new Conexao().conectaBD();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                FuncionarioDTO funcionariodto = new FuncionarioDTO();
                funcionariodto.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionariodto.setNomeFuncionario(rs.getString("nomeFuncionario"));
                funcionariodto.setSobrenome(rs.getString("sobrenome"));
                funcionariodto.setNomeCargo(rs.getString("nomeCargo"));

                listaFuncionarios.add(funcionariodto);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, erro + "Erro Pesquisar funcionario");
        }

        return listaFuncionarios;

    }

    public ArrayList<FuncionarioDTO> pesquisarFuncionario(String id, String nome) {

        String sql = "SELECT f.idFuncionario, f.nomeFuncionario,f.sobrenome,c.nomeCargo"
                + "FROM funcionario f "
                + "JOIN cargo c ON c.cargo_idCargo = c.idCargo"
                + "WHERE (? = '' OR f.idFuncionario = ?) "
                + "AND (? = '' OR f.nomeFuncionario LIKE ?)";

        try {

            conn = new Conexao().conectaBD();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, id);
            pstm.setString(2, id);
            pstm.setString(3, nome);
            pstm.setString(4, "%" + nome + "%");

            rs = pstm.executeQuery();

            while (rs.next()) {

                FuncionarioDTO funcionarioDto = new FuncionarioDTO();
                funcionarioDto.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionarioDto.setNomeFuncionario(rs.getString("nomeFuncionario"));
                funcionarioDto.setSobrenome(rs.getString("sobrenome"));
                funcionarioDto.setNomeCargo(rs.getString("nomeCargo"));

                listaFuncionarios.add(funcionarioDto);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, erro + "Erro Pesquisar");
        }

        return listaFuncionarios;

    }

    public void alterarFuncionario(int id, String nome, String sobrenome, int idCargo) {

        String sql = "UPDATE funcionario SET nomeFuncionario = ?, sobrenome = ?, cargo_idCargo = ? WHERE  id = ?;";

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

    public void excluirFuncionario(int id) {

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
