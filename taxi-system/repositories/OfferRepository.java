package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Clients;
import com.company.entities.Offers;
import com.company.repositories.interfaces.IOfferRepository;

import java.sql.*;

public class OfferRepository implements IOfferRepository {
    private final IDB db;

    public OfferRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean addOffer(Offers offer) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO offers(order_status, client, driver, car, driver_status, address_from, address_to, order_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setBoolean(1, offer.isOrderStatus());
            st.setInt(2, offer.getClient());
            st.setDouble(3, offer.getDriver());
            st.setDouble(4, offer.getCar());
            st.setDouble(5, offer.getDriverStatus());
            st.setString(6, offer.getAddressFrom());
            st.setString(7, offer.getAddressTo());
            st.setString(8, offer.getOrderDate());

            return st.execute();
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

        return false;
    }

    @Override
    public Offers getOffer(int orderId) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT order_id, order_status, client, driver, car, driver_status, address_from, address_to, order_date FROM offers WHERE order_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, orderId);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Offers offer = new Offers(rs.getInt("tariff_id"),
                        rs.getString("service_name"),
                        rs.getDouble("cost_per_km"),
                        rs.getInt("order_id"),
                        rs.getBoolean("order_status"),
                        rs.getInt("client"),
                        rs.getDouble("driver"),
                        rs.getDouble("car"),
                        rs.getDouble("driver_status"),
                        rs.getString("address_from"),
                        rs.getString("address_to"),
                        rs.getString("order_date"));

                return offer;
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
    public int updateOfferAddressFrom(Offers offer) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE address_from FROM offers WHERE order_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, offer.getAddressFrom());
            st.setInt(2, offer.getOrderId());

            return st.executeUpdate();
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

        return 0;
    }

    @Override
    public int updateOfferAddressTo(Offers offer) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "UPDATE address_to FROM offers WHERE order_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, offer.getAddressTo());
            st.setInt(2, offer.getOrderId());

            return st.executeUpdate();
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

        return 0;
    }

    @Override
    public int deleteOffer(Offers offer) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM offers WHERE order_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, offer.getOrderId());

            return st.executeUpdate();
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

        return 0;
    }

    @Override
    public Offers getOfferId() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT order_id FROM offers ORDER BY order_id DESC LIMIT 1";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                Offers offer = new Offers(rs.getInt("order_id"));

                return offer;
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
