/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.orlando.facade;

import java.time.Duration;
import java.time.LocalDateTime;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.orlando.model.Event;

/**
 *
 * @author java
 */
@Stateless
public class EventFacade extends AbstractFacade<Event> {

    @PersistenceContext(unitName = "com.mycompany_calendar_jsf_batty_orlando_war_0.1-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EventFacade() {
        super(Event.class);
    }
    

    
}
