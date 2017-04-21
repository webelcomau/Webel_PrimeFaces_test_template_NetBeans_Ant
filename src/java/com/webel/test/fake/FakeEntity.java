package com.webel.test.fake;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A "fake" JPA entity for populating JSF components for simple web app tests.
 * <p>
 * Target of queries from the database-less {@link FakeQuery}.
 * <p>
 * Can be upgraded to be a real JPA entity
 * (but there is little point for the purposes of this mini test web app).
 * <p>
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
     * <p>
     * POLICY: The resulting fake entity will be marked as {@link #detached},
     * <p>
     * Any sub-class fake entities should likewise implement a deep cloning
     * constructor for use in their {@link #clone()} re-implementation,
     * which should at least call this parent deep clone constructor
     * (which also ensures the {@link #detached} policy is enforced).
     * <p>
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
     * <p>
     * It's only here to help support mimicking detachment in {@link FakeQuery}.
     * <p>
     * Sub-classes should similarly re-implement this to return their own deep clone via a deep copy constructor.
     * <p>
     * You can spend a life-time reading articles about the pros and cons of various cloning strategies for Java;
     * using a deep-cloning copy constructor is perfectly adequate for this test app.
     * <p>
     * Just don't use {@link Object#clone()} !
     * <p>
     * If you really insist on getting fancy, alternatives include:
     * <ul>
     * <li>
     * <a href="http://commons.apache.org/proper/commons-lang/javadocs/api-release/org/apache/commons/lang3/SerializationUtils.html">Deep clone an Object using serialization with
     * the Apache Commons SerializationUtils</a>.
     * </li>
     * <li>
     * The <a href="https://github.com/kostaskougios/cloning">Java Cloning Library</a> on GitHub.
     * </li>
     * </ul>
     * Both of course require including yet another library JAR in your test app.
     * <p>
     * Besides, if you are going to go that far you might as well just use
     * actual JPA and an <a href="https://db.apache.org/derby/papers/DerbyTut/embedded_intro.html">
     * an Embedded Derby DB</a>
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
