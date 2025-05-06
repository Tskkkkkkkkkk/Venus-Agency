package com.venus.service;

import com.venus.config.DbConfig;
import com.venus.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginService {

    /**
     * Fetch a user by username from the database.
     * @param username the username to look for
     * @return a UserModel if found, otherwise null
     */
    public UserModel getUserByUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ?";

        try (Connection conn = DbConfig.getDbConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("user_id");
                String contact = rs.getString("contact");
                String role = rs.getString("role");
                String password = rs.getString("password");

                return new UserModel(id, username, contact, role, password);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("LoginService Error: " + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}

