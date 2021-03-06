package com.company;

import com.company.controllers.*;
import com.company.repositories.interfaces.*;
import com.company.entities.Offers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Application {
    private final CarController carCont;
    private final ClientController clientCont;
    private final DriverController driverCont;
    private final OfferController offerCont;
    private final StatusController statusCont;
    private final TariffController tariffCont;
    private final Scanner scanner;
    private final IOfferRepository repo;

    public Application(ICarRepository carRepository, IClientRepository clientRepository, IDriverRepository driverRepository, IOfferRepository offerRepository, IStatusRepository statusRepository, ITariffRepository tariffRepository, IOfferRepository repo) {
        carCont = new CarController(carRepository);
        clientCont = new ClientController(clientRepository);
        driverCont = new DriverController(driverRepository);
        offerCont = new OfferController(offerRepository);
        statusCont = new StatusController(statusRepository);
        tariffCont = new TariffController(tariffRepository);
        scanner = new Scanner(System.in);
        this.repo = repo;
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to the Taxi System");
            System.out.println("Do you have already a profile?");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("0. Exit");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    clientSignIn();
                } else if (option == 2) {
                    clientSignUp();
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("*************************");
        }
    }

    public void clientSignIn() {
        System.out.println("Enter your login");
        scanner.nextLine();
        String login = scanner.next();

        System.out.println("Enter your password");
        scanner.nextLine();
        String password = scanner.next();

        String response = clientCont.clientSignIn(login, password);
        System.out.println(response);

        if (response.equals("Client was found. You are signed in as " + login)) {
            System.out.println("Do you want to place an order?");
            System.out.println("1. YES");
            System.out.println("2. NO");
            try {
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addOffer();
                } else {
                    start();
                }
            } catch (InputMismatchException e) {
                System.out.println("Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            clientSignIn();
        }
    }

    public void addOffer() {
        System.out.println("Choose a tariff");
        System.out.println(tariffCont.getAllTariff());
        int tariffId = scanner.nextInt();

        System.out.println("Enter your ID: ");
        int client = scanner.nextInt();

        double driver = Math.random();
        driver = Math.floor(driver * 10) + 1;
        double car = driver;

        double driverStatus =  Math.random();
        driverStatus = Math.floor(driverStatus * 6) + 1;

        System.out.println("Enter address from: ");
        scanner.nextLine();
        String addressFrom = scanner.nextLine();

        System.out.println("Enter address to: ");
        scanner.next();
        String addressTo = scanner.next();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date orderDate = new Date();

        String response = offerCont.addOffer(tariffId, client, driver, car, driverStatus, addressFrom, addressTo, dateFormat.format(orderDate));
        System.out.println(response);

        System.out.print("If you want to see a driver, a car and a status of your order, please, enter 1, else 2: ");
        int option = scanner.nextInt();
        if (option == 1) {
            getDriver();
            getCar();
            getStatus();
            System.out.print("If you want to delete the offer, enter A, else B: ");
            char choice = scanner.next().charAt(0);
            if (choice == 'A') {
                deleteOffer();
            } else if (choice == 'B') {
                start();
            }
        } else if (option == 2){
            System.out.print("If you want to delete the offer, enter A, else B: ");
            char choice = scanner.next().charAt(0);
            if (choice == 'A') {
                deleteOffer();
            } else if (choice == 'B') {
                start();
            }
        }
        char choice = scanner.next().charAt(0);
        if (choice == 'A') {
            deleteOffer();
        } else if (choice == 'B') {
            start();
        }
    }

    public void deleteOffer() {
        System.out.println("Your trip ID " + repo.getOfferId());

        System.out.print("Enter offer ID: ");
        int offerId = scanner.nextInt();

        String response = offerCont.deleteOffer(offerId);
        System.out.println(response);
        start();
    }

    public void getDriver() {
        System.out.print("Enter driver ID: ");
        int driverId = scanner.nextInt();

        String response = driverCont.getDriver(driverId);
        System.out.println(response);
    }

    public void getCar() {
        System.out.print("Enter car ID: ");
        int carId = scanner.nextInt();

        String response = carCont.getCar(carId);
        System.out.println(response);
    }

    public void getStatus() {
        System.out.print("Enter status ID: ");
        int statusNumber = scanner.nextInt();

        String response = statusCont.getStatus(statusNumber);
        System.out.println(response);
    }


    public void clientSignUp() {
        System.out.println("Enter your login: ");
        scanner.nextLine();
        String login = scanner.next();

        System.out.println("Enter your first name: ");
        scanner.nextLine();
        String clientFirstName = scanner.next();

        System.out.println("Enter your last name: ");
        scanner.nextLine();
        String clientLastName = scanner.next();

        System.out.println("Enter your phone number: ");
        long phoneNumber = scanner.nextLong();

        System.out.println("Enter your password: ");
        scanner.nextLine();
        String password = scanner.next();

        String response = clientCont.addClient(login, clientFirstName, clientLastName, phoneNumber, password);
        System.out.println(response);
    }
}
