package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Status;
import com.company.repositories.interfaces.IStatusRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusRepository implements IStatusRepository {
    private final IDB db;

    public StatusRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Status getStatus(int statusNumber) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT status_number, status_name FROM status WHERE status_number = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, statusNumber);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Status status = new Status(rs.getInt("status_number"),
                        rs.getString("status_name"));

                return status;
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
