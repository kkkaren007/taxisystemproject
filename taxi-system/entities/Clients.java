package com.company.entities;

public class Clients {
    private int clientId;
    private String login;
    private String clientFirstName;
    private String clientLastName;
    private long phoneNumber;
    private String password;

    public Clients(int clientId, String login, String clientFirstName, String clientLastName, long phoneNumber, String password) {
        this.clientId = clientId;
        this.login = login;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Clients(String login, String clientFirstName, String clientLastName, long phoneNumber, String password) {
        this.login = login;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public Clients(int clientId) {
        this.clientId = clientId;
    }

    public Clients(String login) {
        this.login = login;
    }

    public Clients(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClientFirstName() {
        return clientFirstName;
    }

    public void setClientFirstName(String clientFirstName) {
        this.clientFirstName = clientFirstName;
    }

    public String getClientLastName() {
        return clientLastName;
    }

    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Your ID " + clientId;
//        return "Clients[" +
//                "clientId=" + clientId +
//                ", clientFirstName='" + clientFirstName + '\'' +
//                ", clientLastName='" + clientLastName + '\'' +
//                ", phoneNumber=" + phoneNumber +
//                ", password='" + password + '\'' +
//                ']';
    }
}
