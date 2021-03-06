package controllers;

import com.company.entities.Status;
import com.company.repositories.interfaces.IStatusRepository;

public class StatusController {
    private IStatusRepository repo;

    public StatusController(IStatusRepository repo) {
        this.repo = repo;
    }

    public String getStatus(int statusNumber) {
        Status status = repo.getStatus(statusNumber);

        return (status == null ? "Status was not found" : status.toString());
    }
}
