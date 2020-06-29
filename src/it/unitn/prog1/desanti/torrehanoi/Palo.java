/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Des
 */
public class Palo extends AnchorPane
{
    public static final int ALTEZZA = 110;
    public static final int LARGHEZZA = 10;
    
    Rectangle rectSfondoInvisibile = new Rectangle(Gioco.LARGHEZZA/3, Gioco.ALTEZZA);
    Rectangle rectPalo = new Rectangle(LARGHEZZA, ALTEZZA);
    
    String id;
    
    ArrayList<Disco> dischi = new ArrayList<Disco>();
    
    
    public Palo(Gioco g, String id)
    {
        this.id = id;
        this.addEventHandler(MouseEvent.MOUSE_CLICKED, new HandlerFromTo(g));
        DisegnaBase();
    }
    
    /**
     * Serve per trovare il disco con la larghezza minima su questo palo
     * @return la larghezza minima del disco trovato
     */
    public int LarghezzaMinima()
    {        
        int larghezzaMin = 1000;
        
        for(Disco d : dischi)
        {
            if(d.larghezza < larghezzaMin)
                larghezzaMin = d.larghezza;
        }
        
        return larghezzaMin;
    }
    
    /**
     * Controlla la possibilità ed eventualmente aggiunge un disco a questo palo
     * @param d Il disco che andrebbe eventualmente aggiunto a questo palo
     * @return L'esito dell'operazione
     */
    public boolean AggiungiDisco(Disco d)
    {
        boolean riuscito = true;
        int larghezzaMin = LarghezzaMinima(); //la larghezza del disco più in alto su questo palo
        
        if(d.larghezza < larghezzaMin)
        {
            dischi.add(d);
            DisegnaDischi();
        }
        else
        {
            riuscito = false;
        }

        return riuscito; 
    }
    
    
    /**
     * Toglie il disco più in cima di questo palo
     * @return Il disco più in cima di questo palo
     */
    public void RimuoviDisco()
    {
        dischi.remove(dischi.get(dischi.size()-1));
        DisegnaDischi();
    }
    
    /**
     * Prende in prestito una copia del disco più in cima da questo palo
     * Serve per vedere se è possibile spostarlo in un altro palo
     * @return 
     */
    public Disco UltimoDisco()
    {
        return dischi.get(dischi.size()-1);
    }
    
    /**
     * Si occupa della parte grafica relativa ai dischi
     * Deve essere chiamata ogniqualvolta un disco viene rimosso/aggiunto ad un palo
     */
    public void DisegnaDischi()
    {
        Collections.sort(dischi);
        
        this.getChildren().clear();
        
        DisegnaBase();
        
        for(int i = 0; i < dischi.size(); i++)
        {
            Disco temp = dischi.get(i);
            this.getChildren().add(temp);
            
            AnchorPane.setLeftAnchor(temp, (double)(Gioco.LARGHEZZA/6 - temp.larghezza/2));
            AnchorPane.setTopAnchor(temp, (double)(Gioco.ALTEZZA/2 + this.ALTEZZA/2 - Disco.ALTEZZA*ContaDischiDisegnati()));
        }
    }
    
    public int ContaDischiDisegnati()
    {
        int cont = 0;
        
        for(Node d : this.getChildren())
        {
            if(d instanceof Disco)
                cont++;
        }
        
        return cont;
    }
    
    /**
     * Si occupa della parte grafica di base, quindi disegna lo sfondo fittizio e il palo senza dischi
     */
    public void DisegnaBase()
    {
        rectSfondoInvisibile.setFill(Color.LIGHTGREY);
        
        this.getChildren().add(rectSfondoInvisibile);
        this.getChildren().add(rectPalo);
        
        AnchorPane.setLeftAnchor(rectPalo, (double)(Gioco.LARGHEZZA/6 - this.LARGHEZZA/2) );
        AnchorPane.setTopAnchor(rectPalo, (double)(Gioco.ALTEZZA/2 - this.ALTEZZA/2) );
    }
    

}
