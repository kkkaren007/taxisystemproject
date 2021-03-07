# taxisystemproject
Description
The Taxi System Application is designed to order a taxi from the user's side. Before a user orders a taxi, he must have an account in this application, otherwise he will register. Then he orders a taxi, chooses the speed at which he will drive, enters the start and end points, and the program calculates the distance from point A to point B, and based on the distance and cost of travel, the program calculates the cost of the trip. Also, the user can see the status of the order, data of the taxi driver, car and driver's actions. If necessary, he can also cancel the order.
Classes
There are 6 types of classes:
1. Data: this class is used to make a connection with Database PostgreSQL;
2. Entities: this package consists of classes which are the concatenation of the key and value class fields previously defined for each store;
3. Repositories: there are classes that are used for implementation of basic CRUD operations using JDBC;
4. Controllers: these classes are used to pass values from Class Application to the repository classes;
5. Application: this class is used to work with users;
6. Main: To get access to the class Application
7. Application: it is needed for a rough understanding of how the future application will look like
