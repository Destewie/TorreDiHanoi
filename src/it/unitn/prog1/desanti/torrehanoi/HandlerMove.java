/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerMove implements EventHandler<ActionEvent>
{
    Gioco g;
    
    public HandlerMove(Gioco g)
    {
        this.g = g;
    }

    @Override
    public void handle(ActionEvent event) 
    {
        if(g.from != null && g.to != null && g.to.AggiungiDisco(g.from.UltimoDisco()))
        {
            g.from.RimuoviDisco();
            g.tdh.btnClear.fireEvent(new ActionEvent());
        }  
        else
        {
            System.out.println("Devi prima definire entrambi i pali di partenza e arrivo");
        }
    }
}
