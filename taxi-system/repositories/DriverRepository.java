package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Drivers;
import com.company.repositories.interfaces.IDriverRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverRepository implements IDriverRepository {
    private final IDB db;

    public DriverRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Drivers getDriver(int driverId) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT driver_id, driver_first_name, driver_last_name, driver_phone_number, driver_rating, driver_status FROM drivers WHERE driver_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, driverId);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Drivers driver = new Drivers(rs.getInt("driver_id"),
                        rs.getString("driver_first_name"),
                        rs.getString("driver_last_name"),
                        rs.getLong("driver_phone_number"),
                        rs.getDouble("driver_rating"),
                        rs.getBoolean("driver_Status"));

                return driver;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
