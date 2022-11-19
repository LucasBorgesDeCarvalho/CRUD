package repositories;

import database.ConnectionFactory;
import models.ProjetoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProjetoRepository {

    public static int add(ProjetoModel cadastro) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            String generatedColumns[] = { "ID" };
            String sql = "insert into cadastro(titulo, area, cidade, estado, descricao) values (?,?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql, generatedColumns);
            pstm.setString(1, cadastro.getTitulo());
            pstm.setString(2, cadastro.getArea());
            pstm.setString(3, cadastro.getCidade());
            pstm.setString(4, cadastro.getEstado());
            pstm.setString(5, cadastro.getDescricao());

            pstm.executeUpdate();
            ResultSet rs = pstm.getGeneratedKeys();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    //Adicionar (CREATE)
    public static ArrayList<ProjetoModel> findAll() {

        ArrayList<ProjetoModel> cadastros = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "select * from cadastro";
            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String titulo = result.getString("titulo");
                String area = result.getString("area");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                String descricao = result.getString("descricao");
                ProjetoModel cadastro = new ProjetoModel(id, titulo, area, cidade, estado, descricao);
                cadastros.add(cadastro);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cadastros;
    }

    //Deletar (DELETE)
    public static void delete(List<Integer> ProjetosId) {

        String projetos = "(";
        for (Integer id: ProjetosId) {
            projetos = projetos + id + ",";
        }
        projetos = projetos.substring(0, projetos.length() - 1) + ")";

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql2 = "delete from equipe where fk_cadastro in " + projetos;
            String sql = "delete from cadastro where id in " + projetos;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.executeUpdate();
            PreparedStatement pstm2 = connection.prepareStatement(sql2);
            pstm2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Alterar informações (ATUALIZAR) (UPDATE)
    public static void update(ProjetoModel cadastro) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "update cadastro set titulo = ?, area = ?, cidade = ?, estado = ?, descricao = ? where id = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, cadastro.getTitulo());
            pstm.setString(2, cadastro.getArea());
            pstm.setString(3, cadastro.getCidade());
            pstm.setString(4, cadastro.getEstado());
            pstm.setString(5, cadastro.getDescricao());
            pstm.setInt(6, cadastro.getId());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
