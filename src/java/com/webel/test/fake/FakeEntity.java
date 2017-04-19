package com.webel.test.fake;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Originally: Darren Kelly (Webel IT Australia)
 */
public class FakeEntity implements Serializable {
    
    private static final Logger logger = Logger.getLogger(FakeEntity.class.getName());
    
    public FakeEntity() {        
    }

    /**
     * Constructor that uses a recursive deep clone of a given fake entity.
     * 
     * The resulting fake entity will be marked as {@link #detached}.
     * 
     * @param deepCloneMe 
     */
    public FakeEntity(FakeEntity deepCloneMe) {
        setId(deepCloneMe.getId());
        setName(deepCloneMe.getName());
        setStringValue(deepCloneMe.getStringValue());
        setIntegerValue(deepCloneMe.getIntegerValue());
        setDetached(true);
    }
    
    private Long id;

    final public Long getId() {
        return id;
    }

    final public void setId(Long id) {
        this.id = id;
    }
    
    
    private String name;
    
    final public String getName() {
        return name;
    }

    final public void setName(String name) {
        this.name = name;
    }

    private String stringValue = "[stringValue]";
    
    final public String getStringValue() {
        return stringValue;
    }

    final public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    private Integer integerValue = 0;
    
    final public Integer getIntegerValue() {
        return integerValue;
    }

    final public void setIntegerValue(Integer integerValue) {
        this.integerValue = integerValue;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " ["+id+"] '"+name+"' "+
                "{ detached="+detached+", stringValue="+stringValue+", integerValue="+integerValue+"}";                
    }
    
    final static private boolean DEBUG_DETACHED = true;
    
    private boolean detached = true;
    
    /**
     * Helps track whether this mimics a "detached" JPA entity.
     * 
     * @return 
     */
    public boolean isDetached() {
        return detached;
    }

    final public void setDetached(boolean detached) {
        this.detached = detached;
        if (DEBUG_DETACHED) 
            logger.log(Level.INFO, "DEBUG: Set detached({0}) on fake entity: {1}", new Object[]{detached, this});
    }
    
    
}
