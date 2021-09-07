package DB;


import Model.Volunteering;

import java.sql.*;
import java.util.ArrayList;

public class VolunteeringDB {
    public static ArrayList<Volunteering> getAllVolunteeringData(Connection db) throws SQLException {
        String sql = "SELECT * FROM dbso.volunteering";

        ArrayList<Volunteering> volunteerings = new ArrayList<Volunteering>();

        PreparedStatement ps = db.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Volunteering volunteering = new Volunteering(rs.getInt("volunteerid"),
                    rs.getString("Name"), rs.getInt("Age"), rs.getString("Gender"),
                    rs.getString("PhoneNumber"), rs.getString("Address"),
                    rs.getString("Problem"), rs.getTimestamp("Time"));

            volunteerings.add(volunteering);
        }

        return volunteerings;
    }

    public static void insertData(Connection db, Volunteering volunteering) throws SQLException {
        String sql = "INSERT INTO volunteering (volunteerId, Name, Age, Gender, Address, PhoneNumber, Problem, Time) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = db.prepareStatement(sql);
        ps.setInt(1, volunteering.getVolunteerId());
        ps.setString(2, volunteering.getName());
        ps.setInt(3, volunteering.getAge());
        ps.setString(4, volunteering.getGender());
        ps.setString(5, volunteering.getAddress());
        ps.setString(6, volunteering.getPhoneNumber());
        ps.setString(7, volunteering.getProblem());
        ps.setTimestamp(8, volunteering.getTime());
        ps.executeUpdate();
    }

    public static void deleteData(Connection db, Volunteering volunteering) throws SQLException {
        String sql = "DELETE FROM volunteering WHERE volunteerId=?;";

        PreparedStatement ps = db.prepareStatement(sql);
        ps.setInt(1, volunteering.getVolunteerId());
        ps.executeUpdate();
    }
}
