/*
 * Progetto di Des :)
 */
package it.unitn.prog1.desanti.torrehanoi;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Des
 */
public class HandlerFromTo implements EventHandler<MouseEvent> 
{
    Gioco g;
    
    public HandlerFromTo(Gioco g)
    {
        this.g = g;
    }
    
    @Override
    public void handle(MouseEvent event) 
    {
        Palo source = ((Palo)event.getSource());
        if(source.dischi.size() == 0 && g.from == null)
        {
            Gioco.CreateWarning("Il palo di partenza deve avere almeno un disco", "WARNING!", "Non posso partire da questo palo");
        }
        else if(source.dischi.size() > 0 && g.from == null)
        {
            g.from = source;
            g.tdh.lblFrom.setText(source.id);
        }
        else if(g.from != null && g.to == null)
        {
            if(g.from.LarghezzaMinima() < source.LarghezzaMinima())
            {
                g.to = source;
                g.tdh.lblTo.setText(source.id);
            }
            else if(g.from == source)
                Gioco.CreateWarning("Che senso ha prendere un disco in mano e rimetterlo sullo stesso palo?!?!", "WARNING!", "Sei forse poco dotato?!");
            else
                Gioco.CreateWarning("Il disco di partenza non può essere più grande di quello di arrivo", "WARNING!", "Dimensioni incompatibili");
        } 
    }
    
}
