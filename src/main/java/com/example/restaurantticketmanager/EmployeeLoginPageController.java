package com.example.restaurantticketmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EmployeeLoginPageController {
    @FXML Button backspaceButton;

    @FXML
    private TextField passwordDisplay;

    @FXML
    private void numKeyboardListener(ActionEvent event) {
        Button buttonCliked = (Button) event.getSource();
        String buttonText = buttonCliked.getText();

        passwordDisplay.setText(passwordDisplay.getText() + buttonText);
    }

    @FXML
    private void backspaceButton(ActionEvent event) {
        passwordDisplay.setText(passwordDisplay.getText().substring(0, passwordDisplay.getText().length() - 1));
    }
}
