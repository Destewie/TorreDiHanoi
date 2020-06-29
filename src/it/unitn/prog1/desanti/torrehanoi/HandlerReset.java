/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Des
 */
class HandlerReset implements EventHandler<ActionEvent>
{
    Gioco g;
    
    public HandlerReset(Gioco g)
    {
        this.g = g;
    }
    
    @Override
    public void handle(ActionEvent event) 
    {
        g.Reset();
    }
}

    




