package lottery.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Remco on 15-11-2015.
 */
public abstract class EJB {

    @PersistenceContext
    protected EntityManager em;
}
