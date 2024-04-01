package com.example.tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    private String player;
    private Button[][] board;
    private int xCount, oCount;
    private Label label;
    private VBox vbox;

    @Override
    public void start(Stage stage) {

        board = new Button[3][3];
        label = new Label("Turn: X");
        Label title = new Label("Tic-Tac-Toe Game");
        label.setFont(Font.font("Monospaced", 40));
        title.setFont(Font.font("Monospaced", 40));
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        player = "X";
        xCount = 0;
        oCount = 0;

        for(int col=0; col<3; col++){
            for(int row=0; row<3; row++){
                Button button = new Button(" ");
                button.setPrefSize(100, 100);
                grid.add(button, col, row);
                board[row][col] = button;
                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if(button.getText().equals(" ")){
                            button.setText(player);
                            if(player.equals("X")){
                                player = "O";
                                xCount++;
                                label.setText("Turn: O");
                                if(xCount > 3){
                                    checkWinner();
                                }
                            }
                            else if(player.equals("O")){
                                player = "X";
                                oCount++;
                                label.setText("Turn: X");
                                if(oCount > 3)
                                    checkWinner();
                            }
                            if(xCount+oCount == 9)
                                endGame();
                        }
                    }
                });
            }
        }

        vbox = new VBox(10, title, grid, label);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(10));
        vbox.setStyle("-fx-background-color: #81b681");

        Scene scene = new Scene(vbox, 700, 700);
        stage.setScene(scene);
        stage.show();

    }

    public void checkWinner() {
        checkRows();
        checkColumns();
        checkLeftDiagonal();
        checkRightDiagonal();
    }

    private void checkRows(){
        for(int row=0; row<3; row++){
            if(board[row][0].getText().equals(board[row][1].getText()) && board[row][0].getText().equals(board[row][2].getText())
                    && !board[row][0].getText().equals(" "))
                endGame();
        }
    }
    private void checkColumns(){
        for(int col=0; col<3; col++){
            if(board[0][col].getText().equals(board[1][col].getText()) && board[0][col].getText().equals(board[2][col].getText())
                && !board[0][col].getText().equals(" "))
                endGame();
        }
    }
    private void checkLeftDiagonal(){
        if(board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText())
            && !board[0][0].getText().equals(" "))
            endGame();
    }
    private void checkRightDiagonal(){
        if(board[0][2].getText().equals(board[1][1].getText()) && board[0][2].getText().equals(board[2][0].getText())
            && !board[0][2].getText().equals(" "))
            endGame();
    }
    private void endGame(){
        label.setText("A winner has been declared!");
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                board[row][col].setDisable(true);
            }
        }

    }

    public static void main(String[] args) {
        launch();
    }
}