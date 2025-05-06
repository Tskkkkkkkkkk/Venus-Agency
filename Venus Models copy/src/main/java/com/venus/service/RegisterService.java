package com.venus.service;

import com.venus.config.DbConfig;
import com.venus.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterService {

    public boolean isUsernameTaken(String username) {
        String query = "SELECT COUNT(*) FROM user WHERE username = ?";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0;
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean register(UserModel user) {
        String query = "INSERT INTO user (username, contact, role, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user.getUserName());
            stmt.setString(2, user.getUserContact());
            stmt.setString(3, user.getUserRole());
            stmt.setString(4, user.getPassword());

            return stmt.executeUpdate() > 0;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}


