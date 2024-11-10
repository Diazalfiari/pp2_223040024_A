package dao;

import db.MySqlConnection;
import model.Biodata;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BiodataDao {
    public void save(Biodata biodata) {
        String query = "INSERT INTO biodata (id, nama, alamat, telepon) VALUES (?, ?, ?, ?)";
        try (Connection connection = MySqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, biodata.getId());
            ps.setString(2, biodata.getNama());
            ps.setString(3, biodata.getAlamat());
            ps.setString(4, biodata.getTelepon());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Biodata biodata) {
        String query = "UPDATE biodata SET nama = ?, alamat = ?, telepon = ? WHERE id = ?";
        try (Connection connection = MySqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, biodata.getNama());
            ps.setString(2, biodata.getAlamat());
            ps.setString(3, biodata.getTelepon());
            ps.setString(4, biodata.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        String query = "DELETE FROM biodata WHERE id = ?";
        try (Connection connection = MySqlConnection.getConnection();
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Biodata> getAll() {
        List<Biodata> list = new ArrayList<>();
        String query = "SELECT * FROM biodata";
        try (Connection connection = MySqlConnection.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Biodata biodata = new Biodata(
                        rs.getString("id"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("telepon"));
                list.add(biodata);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
