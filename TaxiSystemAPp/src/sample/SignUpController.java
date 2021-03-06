package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField personFN;

    @FXML
    private TextField personPN;

    @FXML
    private PasswordField personPassword;

    @FXML
    private TextField personLN;

    @FXML
    private TextField personLogin;

    @FXML
    private Button letsgo;

    @FXML
    void initialize() {
        letsgo.setOnAction(event -> {
            String personlogin = personLogin.getText().trim();
            String personpassword = personPassword.getText().trim();
            String personfn = personFN.getText().trim();
            String personln = personLN.getText().trim();
            String personpn = personPN.getText().trim();

            if(!personlogin.equals("") && !personpassword.equals("") && !personfn.equals("") && !personln.equals("") && !personpn.equals("")){
                loginsignup(personlogin, personpassword, personfn, personln, personpn);
                letsgo.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/ordering.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }else{
                System.out.println("Error");
            }
        });
    }
    private void loginsignup(String personlogin, String personpassword, String personfn, String personln, String personpn) {
    }
}
