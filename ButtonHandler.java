package com.example.tictactoe;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class ButtonHandler implements EventHandler<ActionEvent> {

    public void handle(ActionEvent event){

        String button = ((Button) event.getSource()).getText();
        if(button.equals(" "))
            ((Button) event.getSource()).setText("X");
        if(button.equals("X"))
            ((Button) event.getSource()).setText("O");
        if(button.equals("O"))
            ((Button) event.getSource()).setText(" ");

    }

}