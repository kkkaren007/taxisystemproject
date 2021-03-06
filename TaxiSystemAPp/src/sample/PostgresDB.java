package sample;


import java.sql.*;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432//taxisystem";
        try {
            //Loading the driver and the driver automatically register itself with JDBC
            Class.forName("org.postgresql.Driver");
            //Establish the Connection
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "Shameless1821");
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    private final IDB db = null;
    public boolean addClient(Clients client) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO clients (login, client_first_name, client_last_name, client_phone_number, password) VALUES(?, ?, ?, ?, ?)";
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

    public Clients getClient(int personId) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT login, client_first_name, client_last_name, client_phone_number, password FROM clients WHERE client_id = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, personId);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                Clients client = new Clients(rs.getInt("client_id"),
                        rs.getString("login"),
                        rs.getString("client_first_name"),
                        rs.getString("client_last_name"),
                        rs.getLong("client_phone_number"),
                        rs.getString("password"));

                return client;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

   /* public java.util.List<Clients> getAllClients() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT * FROM clients";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);

            List<Clients> clients = new LinkedList<>();

            while (rs.next()) {
                Clients client = new Clients(rs.getInt("client_id"),
                        rs.getString("login"),
                        rs.getString("client_first_name"),
                        rs.getString("client_last_name"),
                        rs.getLong("client_phone_number"),
                        rs.getString("password"));

                clients.add(client);
            }

            return clients;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

   /* public void signUpUser(String login, String personFN, String personLN, int personPN, String personPassword){
        String insert = "INSERT INTO " + Const.CLIENT_TABLE + "VALUES ("
                + Const.CLIENTS_LOGIN + ", " + Const.CLIENTS_FN + ", "
                + Const.CLIENTS_LN + ", " + Const.CLIENTS_PN + ", "
                + Const.CLIENTS_PASSWORD + ")";
        try {
            PreparedStatement prSt = getConnection().prepareStatement(insert);
            prSt.setString(1, login);
            prSt.setString(2, personFN);
            prSt.setString(3, personLN);
            prSt.setString(4, String.valueOf(personPN));
            prSt.setString(5, personPassword);

            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/
}

