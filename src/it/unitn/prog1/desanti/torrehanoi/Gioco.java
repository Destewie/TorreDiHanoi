/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Des
 */
public class Gioco extends StackPane
{
    public static final int ALTEZZA = 300;
    public static final int LARGHEZZA = 501;
    
    public TorreDiHanoi tdh;
    
    public Alert alert;
    
    public Palo from = null, to = null;
    
    public Rectangle sfondo = new Rectangle(LARGHEZZA, ALTEZZA);

    public Palo p1 = new Palo(this, "Palo 1");
    public Palo p2 = new Palo(this, "Palo 2");
    public Palo p3 = new Palo(this, "Palo 3");
    HBox pali = new HBox(p1,p2,p3);
    
    public Disco d1 = new Disco(26);
    public Disco d2 = new Disco(40);
    public Disco d3 = new Disco(56);
    public Disco d4 = new Disco(70);
    
    public Gioco(TorreDiHanoi tdh)
    {
        this.tdh = tdh;
        
        sfondo.setFill(Color.LIGHTGRAY);
        pali.setAlignment(Pos.CENTER);
        
        this.getChildren().add(sfondo);
        this.getChildren().add(pali);
        
        p1.AggiungiDisco(d4);
        p1.AggiungiDisco(d3);
        p1.AggiungiDisco(d2);
        p1.AggiungiDisco(d1);
        
    }
    
    public void Reset()
    {
       tdh.btnClear.fireEvent(new ActionEvent());
       p1.dischi.clear();
       p2.dischi.clear();
       p3.dischi.clear();
       
       p1.AggiungiDisco(d4);
       p1.AggiungiDisco(d3);
       p1.AggiungiDisco(d2);
       p1.AggiungiDisco(d1);        
     
    }
    
    public void CreateWarning(String infoMessage, String titleBar, String headerMessage)
    {
        alert = new Alert(AlertType.WARNING);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
        
        tdh.btnClose.setDisable(false);
    }

    
}
