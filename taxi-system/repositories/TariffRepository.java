package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Tariff;
import com.company.repositories.interfaces.ITariffRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TariffRepository implements ITariffRepository {
    private final IDB db;

    public TariffRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Tariff getTariff(int tariffId) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT tariff_id, service_name, cost_per_km WHERE tariff_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setLong(1, tariffId);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Tariff tariff = new Tariff(rs.getInt("tariff_id"),
                        rs.getString("service_name"),
                        rs.getDouble("cost_per_km"));

                return tariff;
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

    @Override
    public List<Tariff> getAllTariff() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM tariff ORDER BY tariff_id ASC";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Tariff> tariffs = new LinkedList<Tariff>();

            while (rs.next()) {
                Tariff tariff = new Tariff(rs.getInt("tariff_id"),
                        rs.getString("service_name"),
                        rs.getDouble("cost_per_km"));

                tariffs.add(tariff);
            }

            return tariffs;
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
