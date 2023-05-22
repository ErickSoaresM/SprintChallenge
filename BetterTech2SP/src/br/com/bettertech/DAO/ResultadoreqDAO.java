package br.com.bettertech.DAO;

import java.sql.*;

import br.com.bettertech.TO.ResultadoreqTO;

public class ResultadoreqDAO {
    private Connection connection;


    public ResultadoreqDAO() {
        try {

            String url = "jdbc:mysql://localhost:3306/Bettertech";
            String username = "Bettertech";
            String password = "BT!1!2!3!AEE@";
            
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserir(ResultadoreqTO resultado) {
        String sql = "INSERT INTO Resultadoreq (Resultado, Requisicao, Usuario) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, resultado.getResultado());
            statement.setString(2, resultado.getRequisicao());
            statement.setString(3, resultado.getUsuario());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(ResultadoreqTO resultado) {
        String sql = "UPDATE Resultadoreq SET Resultado=?, Requisicao=?, Usuario=? WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, resultado.getResultado());
            statement.setString(2, resultado.getRequisicao());
            statement.setString(3, resultado.getUsuario());
            statement.setInt(4, resultado.getId());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remover(int id) {
        String sql = "DELETE FROM Resultadoreq WHERE id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet listar() {
        String sql = "SELECT * FROM Resultadoreq";
        ResultSet resultSet = null;

        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }

    public void fecharConexao() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

