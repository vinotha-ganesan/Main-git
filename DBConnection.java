import java.sql.Connection;
import java.sql.DriverManager;

class DBConnection {

    static Connection connect() {

        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3307/hospital_db",
                    "root",
                    "Vino@#kookie@#321"
            );

            System.out.println("Database Connected!");

        } catch (Exception e) {

            System.out.println(e);
        }

        return con;
    }
}