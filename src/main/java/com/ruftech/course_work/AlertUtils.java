package com.ruftech.course_work;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertUtils {

    public static void showAlert(AlertType alertType, String title, String headerText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void showInfoAlert(String title, String headerText, String contentText) {
        showAlert(AlertType.INFORMATION, title, headerText, contentText);
    }

    public static void showErrorAlert(String title, String headerText, String contentText) {
        showAlert(AlertType.ERROR, title, headerText, contentText);
    }

    public static void showWarningAlert(String title, String headerText, String contentText) {
        showAlert(AlertType.WARNING, title, headerText, contentText);
    }

    public static void showConfirmationAlert(String title, String headerText, String contentText) {
        showAlert(AlertType.CONFIRMATION, title, headerText, contentText);
    }
}