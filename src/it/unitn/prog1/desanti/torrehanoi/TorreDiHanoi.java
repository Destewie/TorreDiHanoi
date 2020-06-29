/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Des
 */
public class TorreDiHanoi extends Application 
{
    public Label lblFrom, lblTo;
    public Button btnClear, btnClose, btnReset, btnMove;
    
    @Override
    public void start(Stage primaryStage) 
    {
        //parte CENTER
        Gioco game = new Gioco(this);
        
        //parte TOP
        Label lblFromText = new Label("From :");
        lblFrom = new Label("");
        HBox hbFrom = new HBox(lblFromText, lblFrom);
        
        Label lblToText = new Label("To :");
        lblTo = new Label("");
        HBox hbTo = new HBox(lblToText, lblTo);
        
        btnClear = new Button("Clear");
        btnClear.setOnAction(new HandlerClear(game));
        
        HBox hbTop = new HBox(hbFrom, hbTo, btnClear);
        hbTop.setSpacing(50);
        hbTop.setAlignment(Pos.CENTER);
        
        //parte LEFT
        btnClose = new Button("Close");
        
        //parte RIGHT
        btnReset = new Button("Reset");
        btnReset.setAlignment(Pos.CENTER);
        
        //parte BOTTOM
        btnMove = new Button("Move");
        btnMove.setOnAction(new HandlerMove(game));
        btnMove.setAlignment(Pos.CENTER);
  
        
        //Metto tutti i pezzi nel borderpane
        BorderPane bp = new BorderPane();
        bp.setTop(hbTop);
        bp.setLeft(btnClose);
        bp.setRight(btnReset);
        bp.setBottom(btnMove);
        bp.setCenter(game);
        
        BorderPane.setAlignment(btnClose, Pos.CENTER);
        BorderPane.setAlignment(btnMove, Pos.CENTER);
        BorderPane.setAlignment(btnReset, Pos.CENTER);

        Scene scene = new Scene(bp, 620, 380);
        
        primaryStage.setTitle("Torre di Hanoi");
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
