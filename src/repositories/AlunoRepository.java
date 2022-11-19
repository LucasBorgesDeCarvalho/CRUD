package repositories;

import database.ConnectionFactory;
import models.AlunoModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {

    //Adicionar (CREATE)
    public static void add(AlunoModel aluno) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "insert into aluno(nome, matricula, email, telefone) values (?,?,?,?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, aluno.getNome());
            pstm.setInt(2, aluno.getMatricula());
            pstm.setString(3, aluno.getEmail());
            pstm.setString(4, aluno.getTelefone());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<AlunoModel> findAll() {

        ArrayList<AlunoModel> alunos = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "select * from aluno";
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

    //Deletar (DELETE)
    public static void delete(List<Integer> matriculasAlunos) {

        String matriculas = "(";
        for (Integer matricula: matriculasAlunos) {
            matriculas = matriculas + matricula + ",";
        }
        matriculas = matriculas.substring(0, matriculas.length() - 1) + ")";

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql2 = "delete from equipe where fk_matricula in " + matriculas;
            String sql = "delete from aluno where matricula in " + matriculas;
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.executeUpdate();
            PreparedStatement pstm2 = connection.prepareStatement(sql2);
            pstm2.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Alterar informações (ATUALIZAR) (UPDATE)
    public static void update(AlunoModel aluno) {

        try (Connection connection = ConnectionFactory.getConnection()) {

            String sql = "update aluno set nome = ?, email = ?, telefone = ? where matricula = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, aluno.getNome());
            pstm.setString(2, aluno.getEmail());
            pstm.setString(3, aluno.getTelefone());
            pstm.setInt(4, aluno.getMatricula());

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
