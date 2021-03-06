package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OrderingTaxi {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button econom;

    @FXML
    private Button comfort;

    @FXML
    private Button comfortplus;

    @FXML
    private Button minivan;

    @FXML
    private Button cargo;

    @FXML
    private Button quick;

    @FXML
    void initialize() {
        econom.setOnAction(event ->{
            econom.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/addresses.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }
}
