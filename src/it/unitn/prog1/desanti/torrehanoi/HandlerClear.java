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
public class HandlerClear implements EventHandler<ActionEvent>
{
    Gioco g;
    
    public HandlerClear(Gioco g)
    {
        this.g = g;
    }

    
    @Override
    public void handle(ActionEvent event) 
    {
        g.from = null;
        g.tdh.lblFrom.setText("");
        
        g.to = null;
        g.tdh.lblTo.setText("");
    }
    
}
