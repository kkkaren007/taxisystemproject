package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Clients;
import com.company.repositories.interfaces.IClientRepository;

import java.sql.*;

public class ClientRepository implements IClientRepository {
    private final IDB db;

    public ClientRepository(IDB db) {
        this.db = db;
    }

    @Override
    public Clients clientSignIn(String login, String password) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT login FROM clients WHERE login = ? AND password = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, login);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Clients client = new Clients(rs.getString("login"));

                return client;
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
    public boolean addClient(Clients client) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO clients(login, client_first_name, client_last_name, client_phone_number, password) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, client.getLogin());
            st.setString(2, client.getClientFirstName());
            st.setString(3, client.getClientLastName());
            st.setLong(4, client.getPhoneNumber());
            st.setString(5, client.getPassword());

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
    public Clients getClient() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT client_id FROM clients ORDER BY client_id DESC LIMIT 1";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                Clients client = new Clients(rs.getInt("client_id"));

                return client;
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
