package com.ruftech.course_work;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginButton;

    @FXML
    private TextField loginLoginField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private Label loginWarnings;

    private User user;

    @FXML
    void initialize() {
        loginButton.setOnAction(e -> {
            if (loginLoginField.getText().trim().isEmpty() || loginPasswordField.getText().trim().isEmpty()) {
                AlertUtils.showErrorAlert("Error", "Error", "Complete all fields");
                return;
            }
            try {
                user = new User(loginLoginField.getText().trim(), loginPasswordField.getText().trim());
                DataBase dataBase = new DataBase(user);
                if(dataBase.connection.isValid(Connection.TRANSACTION_SERIALIZABLE)) {
                    loginWarnings.setText("Good");
//                    Thread.sleep(1000);
                    String form = switch (user.getLogin()) {
                        case "admin" -> "main";
                        case "seller" -> "seller";
                        default -> "";
                    };
                    //                    load main scene
                    FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource(form + ".fxml"));
                    Parent root = fxmlLoader.load();
                    Scene scene = new Scene(root, 1366 , 768);

                    serializeUser(user);

                    Stage stage = new Stage();
                    stage.setTitle("Airlines");
                    stage.setScene(scene);
                    stage.show();

// hide login window
                    loginButton.getScene().getWindow().hide();
                }
            } catch (SQLException ex) {
                loginWarnings.setText("Bad");
                AlertUtils.showErrorAlert("Error", "Login Error", ex.getMessage());
//                throw new RuntimeException(ex);
            } catch (IOException ex) {
                AlertUtils.showErrorAlert("Error", "Login Error", ex.getMessage());
//                throw new RuntimeException(ex);
            }
        });
    }

    public void serializeUser(User user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
