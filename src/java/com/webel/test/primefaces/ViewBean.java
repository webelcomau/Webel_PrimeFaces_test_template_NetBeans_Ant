package com.webel.test.primefaces;

import com.webel.test.fake.FakeEntity;
import com.webel.test.fake.FakeQuery;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.RowEditEvent;

/**
 * A CDI-compliant ViewScoped JSF backing bean for interacting with {@link FakeEntity} test items.
 * 
 * Includes also some convenient formatted logging methods.
 * 
 * @author Originally: Darren Kelly (Webel IT Australia).
 */
@Named
@ViewScoped
public class ViewBean implements Serializable {

    private static final Logger LOGGER = Logger.getLogger(ViewBean.class.getName());

    private static void echo(String method, String name, Object value) {
        LOGGER.log(Level.INFO, "[{0}] {1}({2})", new Object[]{method, name, value});
    }

    private static void echo(String name, Object value) {
        LOGGER.log(Level.INFO, "{0}({1})", new Object[]{name, value});
    }

    private static void echo(String s) {
        LOGGER.info(s);
    }

    private static void warn(String s) {
        LOGGER.warning(s);
    }

    public ViewBean() {
    }

    private FakeQuery query = new FakeQuery();

    private List<FakeEntity> entities;

    /**
     * Gets entity list lazily !
     * 
     * Only fetched via (pretend) query when entities list
     * has been {@link #reset()} to null.
     * 
     * (This is a flexible alternative to the 
     * popular @PostConstruct initialisation approach.)
     * 
     * @return 
     */
    public List<FakeEntity> getEntities() {
        if (entities == null) {
            entities = fetchEntities();
        }
        return entities;
    }

    /**
     * Fetches a fresh list of fake entities from the (pretend) 
     * database using a (pretend) query.
     * 
     * @return A fresh list of fake entities.
     */
    private List<FakeEntity> fetchEntities() {
        echo("fetchEntities");
        return query.getEntities();
    }

    /**
     * Resets entities list to null so {@link #fetchEntities())
     * forced on next {@link #getEntities()}.
     * 
     * Useful as a listener for an f:event and for some 
     * table manipulations such as when adding/removing rows.
     */
    public void reset() {
        entities = null;
        echo("reset");
    }

    /**
     * Simulates a database merge of the currently {@link #selected} entity.
     *
     * Issues faces message diagnostics.
     *
     * If successful, redirects to the standard view page of the entity.
     *
     * @return Redirection outcome for an entity view page by id, or null if fails.
     */
    public String update() {
        String $i = "update";
        if (selected == null) {
            String msg = $i + ": Can't update null selection";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            warn(msg);
            return null;
        } else {
            query.merge(selected);
            String msg = $i + ": merged: entity: " + selected;
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            echo(msg);
            return "view?faces-redirect=true&id=" + selected.getId();
        }
    }

    /**
     * Basic row edit handler for a p:dataTable of {@link FakeEntity} items.
     *
     * @param event
     */
    public void updateRow(RowEditEvent event) {
        String $i = "updateRow";
        if (event.getObject() == null) {
            String msg = $i + ": SKIPPING: no entity object found from row edit event";
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            warn(msg);
        } else {
            FakeEntity e = (FakeEntity) event.getObject();
            query.merge(e);
            String msg = $i + ": merged: entity: " + e;
            FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
            echo(msg);
        }
    }

    /**
     * Input field for a new entity.
     */
    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    /**
     * Input field for a new entity.
     */
    private String newString;

    public String getNewString() {
        return newString;
    }

    public void setNewString(String newString) {
        this.newString = newString;
    }

    /**
     * Input field for a new entity.
     */
    private Integer newInteger;

    public Integer getNewInteger() {
        return newInteger;
    }

    public void setNewInteger(Integer newInteger) {
        this.newInteger = newInteger;
    }

    /**
     * Action for adding a new fake entity with simulated persistence.
     *
     * Assumes some pre-validation of required fields.
     *
     * @return
     */
    public String addNewEntity() {
        String $i = "addNewEntity";
        FakeEntity e = new FakeEntity();
        String name = newName == null || newName.isEmpty() ? "[name]" : newName;
        e.setName(name);
        e.setStringValue(newString);
        e.setIntegerValue(newInteger);
        query.persist(e);
        echo($i, "entity", e);
        String msg = "Added new entity: " + e;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        return null;
    }

    private Long id;

    /**
     * Target this from a view or edit page using f:viewParam.
     *
     * @param id
     */
    public void setId(Long id) {
        String $i = "setId";
        echo($i, "id", id);
        if (id == null) {
            throw new IllegalArgumentException($i + ": null id !");
        }
        selected = query.find(id);
        if (selected != null) {
            echo($i, "selected entity", selected);
            this.id = id;
        } else {
            warn("Could not find entity with id:" + id);
        }
    }

    public Long getId() {
        return id;
    }

    private FakeEntity selected;

    /**
     * The entity "selected" by id using an f:viewParam and {@link #setId(java.lang.Long)}.
     * 
     * @return May be null if there is no valid selection yet.
     */
    public FakeEntity getSelected() {
        return selected;
    }

//    public void setSelected(FakeEntity selected) {
//        echo("setSelected: "+selected);
//        this.selected = selected;
//    }
    
    public void saveSelected() {
        echo("saveSelected", "selected", selected);
        query.merge(selected);
    }

}
