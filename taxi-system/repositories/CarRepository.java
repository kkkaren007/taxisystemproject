package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Cars;
import com.company.repositories.interfaces.ICarRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRepository implements ICarRepository {
    private final IDB db;

    public CarRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Cars getCar(int carId) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT car_id, car_brand, car_number, region_number FROM cars WHERE car_id = ? ORDER BY car_id ASC";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, carId);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Cars car = new Cars(rs.getInt("car_id"),
                        rs.getString("car_brand"),
                        rs.getString("car_number"),
                        rs.getInt("region_number"));

                return car;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}
