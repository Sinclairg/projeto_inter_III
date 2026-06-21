package dao;

import database.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Veiculo;

public class VeiculoDAO {

    public void salvar(Veiculo veiculo) {

        String sql =
                "INSERT INTO veiculo " +
                "(nome, cor, ano, modelo, n_chassi, placa, unico_dono) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getCor());
            stmt.setInt(3, veiculo.getAno());
            stmt.setInt(4, veiculo.getModelo());
            stmt.setString(5, veiculo.getnChassi());
            stmt.setString(6, veiculo.getPlaca());
            stmt.setBoolean(7, veiculo.isUnicoDono());

            stmt.executeUpdate();

            System.out.println("Veículo cadastrado com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao cadastrar veículo.");
            e.printStackTrace();
        }
    }

    public List<Veiculo> listarTodos() {

        List<Veiculo> lista = new ArrayList<>();

        String sql =
                "SELECT * FROM vw_consulta_dados ORDER BY id";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(rs.getInt("id"));
                veiculo.setNome(rs.getString("nome"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setModelo(rs.getInt("modelo"));
                veiculo.setnChassi(rs.getString("n_chassi"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setUnicoDono(rs.getBoolean("unico_dono"));

                lista.add(veiculo);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao listar veículos.");
            e.printStackTrace();
        }

        return lista;
    }

    public Veiculo buscarPorId(int id) {

        String sql =
                "SELECT * FROM vw_consulta_dados WHERE id = ?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(rs.getInt("id"));
                veiculo.setNome(rs.getString("nome"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setModelo(rs.getInt("modelo"));
                veiculo.setnChassi(rs.getString("n_chassi"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setUnicoDono(rs.getBoolean("unico_dono"));

                rs.close();
                stmt.close();
                conn.close();

                return veiculo;
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao buscar veículo.");
            e.printStackTrace();
        }

        return null;
    }

    public void atualizar(Veiculo veiculo) {

        String sql =
                "UPDATE veiculo " +
                "SET nome = ?, " +
                "cor = ?, " +
                "ano = ?, " +
                "modelo = ?, " +
                "n_chassi = ?, " +
                "placa = ?, " +
                "unico_dono = ? " +
                "WHERE id = ?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setString(1, veiculo.getNome());
            stmt.setString(2, veiculo.getCor());
            stmt.setInt(3, veiculo.getAno());
            stmt.setInt(4, veiculo.getModelo());
            stmt.setString(5, veiculo.getnChassi());
            stmt.setString(6, veiculo.getPlaca());
            stmt.setBoolean(7, veiculo.isUnicoDono());
            stmt.setInt(8, veiculo.getId());

            stmt.executeUpdate();

            System.out.println("Veículo atualizado com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao atualizar veículo.");
            e.printStackTrace();
        }
    }

    public void excluir(int id) {

        String sql =
                "DELETE FROM veiculo WHERE id = ?";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            System.out.println("Veículo excluído com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao excluir veículo.");
            e.printStackTrace();
        }
    }

    public List<Veiculo> listarUnicoDono() {

        List<Veiculo> lista = new ArrayList<>();

        String sql =
                "SELECT * FROM vw_veiculos_unico_dono";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(rs.getInt("id"));
                veiculo.setNome(rs.getString("nome"));
                veiculo.setCor(rs.getString("cor"));
                veiculo.setAno(rs.getInt("ano"));
                veiculo.setModelo(rs.getInt("modelo"));
                veiculo.setnChassi(rs.getString("n_chassi"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setUnicoDono(rs.getBoolean("unico_dono"));

                lista.add(veiculo);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {

            System.out.println("Erro ao listar veículos de único dono.");
            e.printStackTrace();
        }

        return lista;
    }

    public int totalVeiculos() {

        String sql =
                "SELECT total_veiculos()";

        try {

            Connection conn = Conexao.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                int total = rs.getInt(1);

                rs.close();
                stmt.close();
                conn.close();

                return total;
            }

        } catch (SQLException e) {

            System.out.println("Erro ao obter total de veículos.");
            e.printStackTrace();
        }

        return 0;
    }
}