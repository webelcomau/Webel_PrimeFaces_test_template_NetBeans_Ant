package com.webel.test.fake;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A "fake" JPA entity simulation for populating JSF components.
 *
 * Target of queries from the database-less {@link FakeQuery}.
 *
 * Can be upgraded to be a real JPA entity
 * (but there is little point for the purposes of this mini test web app).
 *
 * If you want to extend it with a sub-class with additional properties,
 * please see the remarks under the {@link #FakeEntity(com.webel.test.fake.FakeEntity)}
 * deep-cloning copy constructor and under {@link #clone()}.
 * 
 * @author Originally: Darren Kelly (Webel IT Australia)
 */
public class FakeEntity implements Serializable, Cloneable {

    private static final Logger logger = Logger.getLogger(FakeEntity.class.getName());

    public FakeEntity() {
    }

    /**
     * Constructor that performs a (simple) deep clone of a given fake entity.
     *
     * POLICY: The resulting fake entity will be marked as {@link #detached},
     * 
     * Any sub-class fake entities should likewise implement a deep cloning
     * constructor for use in their {@link #clone()} re-implementation,
     * which should at least call this parent deep clone constructor
     * (which also ensures the {@link #detached policy is enforced).
     * 
     * Please see also the remarks and references under {@link #clone()}.
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

    /**
     * Implemented to use the deep-cloning copy constructor {@link #FakeEntity(com.webel.test.fake.FakeEntity)}.
     * 
     * It's only here to help support mimicking detachment in {@link FakeQuery}.
     * 
     * Sub-classes should similarly re-implement this to return their own deep clone via a deep copy constructor.
     * 
     * You can spend a life-time reading articles about the pros and cons of various cloning strategies for Java; 
     * using a deep-cloning copy constructor is perfectly adequate for this test app.
     * 
     * Just don't use {@link Object#clone()} !
     * 
     * If you really insist on getting fancy, alternatives include:
     * 
     * - <a href="http://commons.apache.org/proper/commons-lang/javadocs/api-release/org/apache/commons/lang3/SerializationUtils.html">Deep clone an Object using serialization with the Apache Commons SerializationUtils</a>.
     * 
     * - The <a href="https://github.com/kostaskougios/cloning">Java Cloning Library</a> on GitHub.
     * 
     * Both of course require including yet another library JAR in your test app.
     * 
     * @return A deep clone.
     * @throws CloneNotSupportedException
     */
    @Override
    public FakeEntity clone() throws CloneNotSupportedException {
        return new FakeEntity(this);
    }

    private Long id;

    final public Long getId() {
        return id;
    }

    final public void setId(Long id) {
        this.id = id;
    }

    private String name = "[name]";

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
        return this.getClass().getSimpleName() + " [" + id + "] '" + name + "' "
                + "{ detached=" + detached + ", stringValue=" + stringValue + ", integerValue=" + integerValue + "}";
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
        if (DEBUG_DETACHED) {
            logger.log(Level.INFO, "DEBUG: Set detached({0}) on fake entity: {1}", new Object[]{detached, this});
        }
    }

}
