package com.webel.test.fake;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 * Simulates basic queries and CRUD operations on {@link FakeEntity} items with no actual database.
 * <p>
 * All read queries return deep clones to partially simulate JPA entity detachment.
 * <p>
 * You can use this fake query strategy to sensibly populate
 * and test most JSF components and to support many JSF user
 * interaction cases. Just create one directly in your JSF
 * backing bean and use it as if you had injected an EJB.
 * <p>
 * If it really does not meet your needs
 * consider using actual JPA and an <a href="https://db.apache.org/derby/papers/DerbyTut/embedded_intro.html">
 * Embedded Derby DB</a> database together with EJBs and/or CDI.
 * <p>
 * But remember, the more moving parts you have, and the more your
 * test app depends on a Java EE container, the more likely
 * it is that a support team will not be able to reproduce your
 * setup exactly when you submit a test case to them.
 * <p>
 * Are you testing Java EE or JSF ?
 *
 * @author Originally: Darren Kelly (Webel IT Australia)
 */
public class FakeQuery implements Serializable {

    private static final Logger logger = Logger.getLogger(FakeQuery.class.getName());

    /**
     * Constructs without an fake entity initialisation.
     * <p>
     */
    public FakeQuery() {
    }

    /**
     * Constructs with optional fake ntity initialisation.
     *
     * @param init Whether to also invoke {@link  #initEntities()}.
     */
    public FakeQuery(boolean init) {
        if (init) {
            initEntities();
        }
    }

    static private Map<Long, FakeEntity> entities = new HashMap<>();

    /**
     * Queries for all fake entities.
     *
     * @return A (possibly empty but non-null) list of "detached" deep clones of all fake entities.
     */
    public List<FakeEntity> getEntities() {
        List<FakeEntity> l = new ArrayList<>();
        for (Long id : entities.keySet()) {
            try {
                FakeEntity clone = entities.get(id).clone();
                clone.setDetached(true);
                l.add(clone);
            } catch (CloneNotSupportedException ex) {
                logger.log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }

    static private Long id = 0L;

    /**
     * Simulates persisting the given fake entity to database (actually just stores it in a map).
     * <p>
     * Assigns a new id (and over-writes any existing one).
     * <p>
     * The given fake entity will be marked as NOT "detached".
     * <p>
     * If the given fake entity has a non-null id and the map already 
     * contains a fake entity with the same id, it will not add the 
     * entity (just logs a warning).
     *
     * @param fe A fake entity to "persist" (to the underlying map).
     */
    public void persist(FakeEntity fe) {
        if (fe.getId() != null && entities.containsKey(fe.getId())) {
            logger.warning("SKIPPING: have existing entity with same key:" + fe.getId());
        } else {
            fe.setId(id++);
            fe.setDetached(false);
            entities.put(fe.getId(), fe);
        }
    }

    /**
     * Fake merge, adds a deep clone to an underlying map OR
     * overwrites any existing entity with a matching key.
     * <p>
     * Throws an exception if the given entity is null
     * or if there is no existing map key matching its id.
     * <p>
     * On merge the deep clone of the fake entity will be marked as NOT 'detached';
     * the given fake entity will remain in whatever 'detached' state it was when passed in.
     *
     * @param entity The non-null fake entity to "merge".
     */
    public void merge(FakeEntity entity) {
        if (entity == null) {
            throw new IllegalArgumentException("null entity !");
        }
        if (entity.getId() == null) {
            throw new IllegalArgumentException("Can't merge entity with null id !");
        }
        if (!entities.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Can't merge entity with unknown id(" + entity.getId() + ") !");
        }
        try {
            FakeEntity clone = entity.clone(); //! deep clone
            clone.setDetached(false);
            entities.put(clone.getId(), clone);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(FakeQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Finds a fake entity in the underlying map, returning a deep clone if found.
     * <p>
     * Logs a warning if no match is found (and returns null).
     * <p>
     * If it finds a match, the returned clone will be set 'detached'.
     *
     * @param id The id of the fake entity to find.
     * @return A deep clone of the fake entity with the given id, or null if no match found.
     */
    public FakeEntity find(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("null id !");
        }
        FakeEntity found = entities.get(id);
        if (found == null) {
            logger.warning("No entity found with id(" + id + "). Returning null !");
        }
        try {
            FakeEntity clone = found.clone();
            clone.setDetached(true);
            return clone;
        } catch (CloneNotSupportedException ex) {
            logger.log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Initialises some test fake entities; copy and adapt or extend and override as required for tests.
     * <p>
     * Can be invoked explicitly via {@link #FakeQuery(boolean)}
     * or using @PostConstruct if using CDI injection.
     * <p>
     * Visit also:
     * <ul>
     * <li>
     * <a href="https://docs.oracle.com/javaee/7/tutorial/cdi-basic014.htm">Java EE 7 tutorial: Using the @PostConstruct and @PreDestroy Annotations with CDI Managed Bean
     * Classes</a></li>
     * <li>
     * <a href="http://stackoverflow.com/questions/3406555/why-use-postconstruct">Why use @PostConstruct?
     * </a></li>
     * </ul>
     */
    @PostConstruct
    protected void initEntities() {

        if (entities.isEmpty()) {

            FakeEntity e1 = new FakeEntity();
            e1.setName("e1");
            e1.setStringValue("stringValue.1");
            e1.setIntegerValue(1);
            persist(e1);

            FakeEntity e2 = new FakeEntity();
            e2.setName("e2");
            e2.setStringValue("stringValue.2");
            e2.setIntegerValue(2);
            persist(e2);

            Element e3 = new Element();
            e3.setName("e3");
            e3.setStringValue("stringValue.3");
            e3.setIntegerValue(3);
            e3.setFloatValue(3.3f);
            persist(e3);
        }
    }

}
