/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Des
 */
public class Disco extends Rectangle implements Comparable
{
    public static final int ALTEZZA  = 13;
    
    int larghezza;
    int gerarchia;  //la posizione rispetto agli altri dischi sullo stesso palo -> 1: disco più in basso; 2: se è sopra il livello 1 ecc..
    
    public Disco(int w)  //w = larghezza
    {
        this.larghezza = w;
        
        this.setWidth(larghezza);
        this.setHeight(ALTEZZA);
        this.setFill(Color.DARKRED);
        this.setStroke(Color.BLACK);
    }

    @Override
    public int compareTo(Object o) 
    {
        if(o instanceof Disco)
        {
            if(this.larghezza > ((Disco)o).larghezza)   //li ordino dal più grande al più piccolo per comodità
                return -1;
            else
                return 1;
        }
        else
            return 1;
    }
}
