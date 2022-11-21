package repositories;

import database.ConnectionFactory;
import models.AlunoModel;
import models.ProjetoModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeRepository {

    public static void add(int id, List<Integer> matriculas) {
        for (int matricula :matriculas) {
            try (Connection connection = ConnectionFactory.getConnection()) {

                String sql = "insert into equipe(fk_matricula, fk_cadastro) values (?,?)";
                PreparedStatement pstm = connection.prepareStatement(sql);
                pstm.setInt(1, matricula);
                pstm.setInt(2, id);

                pstm.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    //Deletar (DELETE)
    public static void delete(int id) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "delete from equipe where fk_cadastro = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Alterar informações (ATUALIZAR) (UPDATE)
    public static void update(List<Integer> matriculas, int id) {

        delete(id);
        add(id, matriculas);
    }
    public static ArrayList<AlunoModel> findAlunosPorProjeto(int id) {

        ArrayList<AlunoModel> alunos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            String selectMatriculas = "select fk_matricula from equipe where fk_cadastro = " + id;
            PreparedStatement pstm2 = connection.prepareStatement(selectMatriculas);

            ResultSet result2 = pstm2.executeQuery();

            String matriculas = "(";
            while (result2.next()) {
                int matricula = result2.getInt("fk_matricula");
                matriculas = matriculas + matricula + ",";
            }
            matriculas = matriculas.substring(0, matriculas.length() - 1) + ")";

            String sql = "select * from aluno where matricula in " + matriculas;
            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            while (result.next()) {
                int matricula = result.getInt("matricula");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                AlunoModel aluno = new AlunoModel(matricula, nome, telefone, email);
                alunos.add(aluno);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public static ArrayList<AlunoModel> findAlunosDiferenteDoProjeto(int id) {

        ArrayList<AlunoModel> alunos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            String selectMatriculas = "select fk_matricula from equipe where fk_cadastro = " + id;
            PreparedStatement pstm2 = connection.prepareStatement(selectMatriculas);

            ResultSet result2 = pstm2.executeQuery();

            String matriculas = "(";
            while (result2.next()) {
                int matricula = result2.getInt("fk_matricula");
                matriculas = matriculas + matricula + ",";
            }
            matriculas = matriculas.substring(0, matriculas.length() - 1) + ")";

            String sql = "select * from aluno where matricula not in " + matriculas;
            PreparedStatement pstm = connection.prepareStatement(sql);

            ResultSet result = pstm.executeQuery();

            while (result.next()) {
                int matricula = result.getInt("matricula");
                String nome = result.getString("nome");
                String telefone = result.getString("telefone");
                String email = result.getString("email");
                AlunoModel aluno = new AlunoModel(matricula, nome, telefone, email);
                alunos.add(aluno);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }
}

