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
public class HandlerClose implements EventHandler<ActionEvent>
{
    Gioco g;
    
    public HandlerClose(Gioco g)
    {
        this.g = g;
    }
    
    @Override
    public void handle(ActionEvent event) 
    {
        g.tdh.btnClose.setDisable(true);
        if(Gioco.alert.isShowing())
        {
            Gioco.alert.close();
        }
    }
}
