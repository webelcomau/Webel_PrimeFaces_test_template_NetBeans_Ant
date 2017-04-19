package com.webel.test.fake;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Simulates basic queries and CRUD operations with a {@link FakeEntity}.
 * 
 * All read queries return deep clones to partially simulate JPA entity detachment.
 * 
 * @author Originally: Darren Kelly (Webel IT Australia)
 */
public class FakeQuery implements Serializable {

    private static final Logger logger = Logger.getLogger(FakeQuery.class.getName());
    
    public FakeQuery() {
        initEntities();
    }

    static private Map<Long, FakeEntity> entities = new HashMap<>();

    /**
     * Fake entity query.
     * 
     * @return A list of "detached" deep clones of all fake entities.
     */
    public List<FakeEntity> getEntities() {
        List<FakeEntity> l = new ArrayList<>();
        for (Long id : entities.keySet()) {
            l.add(new FakeEntity(entities.get(id)));
        }
        return l;
    }

    static private Long id = 0L;

    /**
     * Simulates persisting the given fake entity to database.
     * 
     * Assigns an id (and ignores any existing one).
     * 
     * The fake entity will be marked as NOT detached.
     *
     * @param fe A fake entity to "persist".
     */
    public void persist(FakeEntity fe) {
        fe.setId(id++);
        fe.setDetached(false);
        entities.put(fe.getId(), fe);
    }

    private void initEntities() {

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
        }
    }

    /**
     * Fake merge, adds a deep clone to an underlying map OR 
     * overwrites any existing entity with a matching key.
     * 
     * Throws an exception if the given entity is null
     * or if there is no existing map key matching its id.
     * 
     * On merge the deep clone of the fake entity will be marked as NOT 'detached';
     * the given FakeEntity will remain 'detached'.
     *
     * @param entity The non-null fake entity to "merge".
     */
    public void merge(FakeEntity entity) {
        if (entity==null) throw new IllegalArgumentException("null entity !");
        if (entity.getId()==null) throw new IllegalArgumentException("Can't merge entity with null id !");
        if (!entities.containsKey(entity.getId())) throw new IllegalArgumentException("Can't merge entity with unknown id("+entity.getId()+ ") !");
        FakeEntity clone = new FakeEntity(entity);//! deep clone
        clone.setDetached(false);
        entities.put(clone.getId(), clone);
    }
    
    /**
     * Finds a fake entity (as a deep clone) in the underlying map.
     * 
     * @param id The id of the fake entity to find.
     * @return A deep clone of the fake entity with the given id, or null if no match found.
     */
    public FakeEntity find(Long id) {
        if (id==null) throw new IllegalArgumentException("null id !");        
        FakeEntity found = entities.get(id);
        if (found==null) {
            logger.warning("No entity found with id("+id+"). Returning null !");
        }
        return new FakeEntity(found);
    }
}
