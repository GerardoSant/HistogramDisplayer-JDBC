package View;

import Model.Mail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {

    public static List<Mail> read(){
        List<Mail> mailList = new ArrayList<>();
        String sql = "SELECT * FROM EMAIL";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                mailList.add(new Mail(rs.getString("Mail")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mailList;
    }

    private static Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
