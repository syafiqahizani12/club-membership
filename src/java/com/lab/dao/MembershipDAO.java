/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lab.dao;

import com.lab.model.Membership;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MembershipDAO {
    
    private String jdbcURL = "jdbc:mysql://localhost:3306/CSE3023";
    private String jdbcUsername = "root";
    private String jdbcPassword = "admin";

    private static final String INSERT_SQL =
        "INSERT INTO membership(studentName, planType, status, expiryDate) VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL =
        "SELECT * FROM membership";

    private static final String DELETE_SQL =
        "DELETE FROM membership WHERE membershipId=?";

    protected Connection getConnection() throws SQLException {
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                jdbcURL, jdbcUsername, jdbcPassword
            );

            if (conn == null) {
                throw new SQLException("Connection is NULL");
            }

            return conn;

        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL Driver not found", e);
        }
    }

    public void insertMembership(Membership m) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_SQL)) {

            ps.setString(1, m.getStudentName());
            ps.setString(2, m.getPlanType());
            ps.setString(3, m.getStatus());
            ps.setString(4, m.getExpiryDate());

            ps.executeUpdate();
        }
    }

    public List<Membership> getAllMembership() throws SQLException {

        List<Membership> list = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Membership(
                        rs.getInt("membershipId"),
                        rs.getString("studentName"),
                        rs.getString("planType"),
                        rs.getString("status"),
                        rs.getString("expiryDate")
                ));
            }
        }
        return list;
    }

    public void deleteMembership(int id) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_SQL)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}