package com.company.controllers;

import com.company.entities.Clients;
import com.company.repositories.interfaces.IClientRepository;

public class ClientController {
    private IClientRepository repo;

    public ClientController(IClientRepository repo) {
        this.repo = repo;
    }

    public String clientSignIn(String login, String password) {
        Clients client = repo.clientSignIn(login, password);

        return (client == null ? "Client was not found (Your login or password is incorrect)" : ( "Client was found. You are signed in as " + login) );
    }

    public String addClient(String login, String clientFirstName, String clientLastName, long phoneNumber, String password) {
        Clients client = new Clients(login, clientFirstName, clientLastName, phoneNumber, password);

        boolean added = repo.addClient(client);

        return (added ? "Client addition was failed!" : ("Client was added successfully!\n" + repo.getClient()));
    }
}
