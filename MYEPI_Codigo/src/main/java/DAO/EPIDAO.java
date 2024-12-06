package DAO;

import DTO.EPIDTO;
import DTO.FuncionarioDTO;
import DTO.TipoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;

public class EPIDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<EPIDTO> listaEpis = new ArrayList<>();

    public void cadastrarEPI(EPIDTO epidto) {

        String sql = "insert into epi (nomeEPI, validade, ca, descricao, quantidade, marca_idMarca, tipo_idTipo)values (?,?,?,?,?,?,?)";

        conn = new Conexao().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, epidto.getNomeEpi());
            pstm.setDate(2, epidto.getValidade());
            pstm.setInt(3, epidto.getCa());
            pstm.setString(4, epidto.getDescricao());
            pstm.setInt(5, epidto.getQuantidade());
            pstm.setInt(6, epidto.getMarca_idMarca());
            pstm.setInt(7, epidto.getTipo_idTipo());
            pstm.execute();
            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + " EPIDAO");
        }
    }

    public ArrayList<EPIDTO> ListarTodosEpis() {
         
        try {

             String sql = "SELECT e.idEpi, e.nomeEpi, t.nomeTipo, m.nomeMarca, e.quantidade, e.validade, e.descricao, e.ca " +
             "FROM epi e " +
             "JOIN tipo t ON e.tipo_idTipo = t.idTipo " +
             "JOIN marca m ON e.marca_idMarca = m.idMarca " +
             "ORDER BY e.idEpi";

            conn = new Conexao().conectaBD();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {

                EPIDTO epiDto = new EPIDTO();
                epiDto.setIdEpi(rs.getInt("idEpi"));
                epiDto.setNomeEpi(rs.getString("nomeEpi"));
                epiDto.setNomeTipo(rs.getString("nomeTipo"));
                epiDto.setNomeMarca(rs.getString("nomeMarca"));
                epiDto.setQuantidade(rs.getInt("quantidade"));
                epiDto.setValidade(rs.getDate("validade"));
                epiDto.setDescricao(rs.getString("descricao"));
                epiDto.setCa(rs.getInt("ca"));

                listaEpis.add(epiDto);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, erro + "Erro Pesquisar todos EPIs");
        }

        return listaEpis;

    }

    public ArrayList<EPIDTO> pesquisarEpi(String id, String nome) {

        String sql = "SELECT e.idEpi, e.nomeEpi, t.nomeTipo, m.nomeMarca, e.quantidade, e.validade, e.descricao, e.ca "
                + "FROM epi e "
                + "JOIN tipo t ON e.tipo_idTipo = t.idTipo "
                + "JOIN marca m ON e.marca_idMarca = m.idMarca "
                + "WHERE (? = '' OR e.idEpi = ?) "
                + "AND (? = '' OR e.nomeEpi LIKE ?)";

        

        try {

            conn = new Conexao().conectaBD();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, id);
            pstm.setString(2, id);
            pstm.setString(3, nome);
            pstm.setString(4, "%" + nome + "%");
            
            rs = pstm.executeQuery();

            while (rs.next()) {

                EPIDTO epiDto = new EPIDTO();
                epiDto.setIdEpi(rs.getInt("idEpi"));
                epiDto.setNomeEpi(rs.getString("nomeEpi"));
                epiDto.setNomeTipo(rs.getString("nomeTipo"));
                epiDto.setNomeMarca(rs.getString("nomeMarca"));
                epiDto.setQuantidade(rs.getInt("quantidade"));
                epiDto.setValidade(rs.getDate("validade"));
                epiDto.setDescricao(rs.getString("descricao"));
                epiDto.setCa(rs.getInt("ca"));

                listaEpis.add(epiDto);

            }

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, erro + "Erro Pesquisar");
        }

        return listaEpis;

    }

    public void alterarEpi(int id, String nome, String sobrenome, int idCargo) {

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

    public void excluirEpi(int id) {

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
