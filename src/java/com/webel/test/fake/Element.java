package com.webel.test.fake;

import java.util.logging.Logger;

/**
 * Extends a fake entity with an extra field.
 * 
 * Illustrates simply deep-cloning copy constructor recipe.
 * 
 * @author Originally: Darren Kelly (Webel IT Australia)
 */
public class Element extends FakeEntity {

    private static final Logger logger = Logger.getLogger(Element.class.getName());

    public Element() {
    }

    /**
     * @param deepCloneMe
     */
    public Element(Element deepCloneMe) {
        super(deepCloneMe);
        setFloatValue(deepCloneMe.getFloatValue());
    }

    @Override
    public Element clone() throws CloneNotSupportedException {
        return new Element(this);
    }
    
    private Float floatValue = 0.0f;

    public Float getFloatValue() {
        return floatValue;
    }

    public void setFloatValue(Float floatValue) {
        this.floatValue = floatValue;
    }    

    @Override
    public String toString() {
        return this.getClass().getSimpleName() 
                + " [" + getId() + "] '" + getName() + "' "
                + "{ detached=" + isDetached() 
                + ", stringValue=" + getStringValue() 
                + ", integerValue=" + getIntegerValue() 
                + ", floatValue=" + getFloatValue() 
                + "}";
    }
    
    

}
