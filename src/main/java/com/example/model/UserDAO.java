package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/testdb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            // try-with-resources で自動クローズ
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users ORDER BY id ASC")) {

                while (rs.next()) {
                    users.add(new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public void insertUser(String name, int age) {
        try {
            Class.forName("org.postgresql.Driver");
            // try-with-resources で自動クローズ
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 PreparedStatement pstmt = conn.prepareStatement("INSERT INTO users (name, age) VALUES (?, ?)")) {

                pstmt.setString(1, name);
                pstmt.setInt(2, age);
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateUser(int id, String name, int age) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET name=?, age=? WHERE id=?")) {
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE id=?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}