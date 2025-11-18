package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class Database {
    private static final String URL = "jdbc:mysql://localhost:8889/test-jdbc?createDatabaseIfNotExist=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertEtudiant(Etudiant e) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO etudiants (name, moyenne, avis) VALUES (?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        stmt.setString(1, e.getNom());
        stmt.setFloat(2, e.getMoyenne());
        stmt.setString(3, e.getAvis());
        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next())
            e.setId(rs.getInt(1));
    }
}