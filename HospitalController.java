import java.sql.*;
import java.util.*;

class HospitalController {

    Connection con;

    HospitalController() {

        con = DBConnection.connect();
    }


    void addPatient(Patient p) {

        try {

            String query =
                    "INSERT INTO patients VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, p.id);
            ps.setString(2, p.name);
            ps.setInt(3, p.age);
            ps.setString(4, p.disease);
            ps.setString(5, p.gender);

            ps.executeUpdate();

            System.out.println("Patient Added!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void viewPatients() {

        try {

            String query = "SELECT * FROM patients";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        "Patient ID : " + rs.getInt(1)
                );

                System.out.println(
                        "Name : " + rs.getString(2)
                );

                System.out.println(
                        "Age : " + rs.getInt(3)
                );

                System.out.println(
                        "Disease : " + rs.getString(4)
                );

                System.out.println(
                        "Gender : " + rs.getString(5)
                );

                System.out.println("----------------");
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void addDoctor(Doctor d) {

        try {

            String query =
                    "INSERT INTO doctors VALUES(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, d.id);
            ps.setString(2, d.name);
            ps.setString(3, d.specialization);
            ps.setInt(4, d.experience);

            ps.executeUpdate();

            System.out.println("Doctor Added!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void viewDoctors() {

        try {

            String query = "SELECT * FROM doctors";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        "Doctor ID : " + rs.getInt(1)
                );

                System.out.println(
                        "Name : " + rs.getString(2)
                );

                System.out.println(
                        "Specialization : " + rs.getString(3)
                );

                System.out.println(
                        "Experience : " +
                        rs.getInt(4) + " years"
                );

                System.out.println("----------------");
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void addAppointment(Appointment a) {

        try {

            String query =
                    "INSERT INTO appointments VALUES(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, a.patientId);
            ps.setInt(2, a.doctorId);
            ps.setString(3, a.date);

            ps.executeUpdate();

            System.out.println("Appointment Booked!");

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    void viewAppointments() {

        try {

            String query =
                    "SELECT * FROM appointments";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                System.out.println(
                        "Patient ID : " + rs.getInt(1)
                );

                System.out.println(
                        "Doctor ID : " + rs.getInt(2)
                );

                System.out.println(
                        "Date : " + rs.getString(3)
                );

                System.out.println("----------------");
            }

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}