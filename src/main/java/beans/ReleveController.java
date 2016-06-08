package beans;

import model.Releve;
import dao.util.JsfUtil;
import dao.util.JsfUtil.PersistAction;
import session.ReleveFacade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Criteria;

@Named("releveController")
@SessionScoped
public class ReleveController implements Serializable {

    @EJB
    private session.ReleveFacade ejbFacade;
    private List<Releve> items = null;
    private List<String> listeAnnee = null;
    private Releve selected;
    
    private String annee;

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public List<String> getListeAnnee() {
        if (listeAnnee == null) {
            listeAnnee = new ArrayList<String>();
            List<Releve> list = getFacade().findAll();
            for(Releve r : list){
                listeAnnee.add(r.getAnneeUniversitaire());
                System.out.println("*********************************************************");
                System.out.println("Annee : " + r.getAnneeUniversitaire());
            }
        }
        return listeAnnee;
    }
    
    public void updateSemestre(AjaxBehaviorEvent event){
        if(annee != null){
            items = getReleverAnnee(annee);
        }
    }

    public ReleveController() {
    }

    public Releve getSelected() {
        return selected;
    }

    public void setSelected(Releve selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ReleveFacade getFacade() {
        return ejbFacade;
    }

    public Releve prepareCreate() {
        selected = new Releve();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ReleveCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ReleveUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ReleveDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Releve> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Releve getReleve(java.lang.Integer id) {
        return getFacade().find(id);
    }
    
    public List<Releve> getReleverAnnee(String annee){
        CriteriaBuilder builder = getFacade().getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Releve> cr = builder.createQuery(Releve.class);
        Root<Releve> releveRoot = cr.from(Releve.class);
        cr.select(releveRoot).where(builder.equal(releveRoot.get("anneeUniversitaire"), annee));
        TypedQuery<Releve> q = getFacade().getEntityManager().createQuery(cr);
        return q.getResultList();
    }

    public List<Releve> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Releve> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Releve.class)
    public static class ReleveControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ReleveController controller = (ReleveController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "releveController");
            return controller.getReleve(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Releve) {
                Releve o = (Releve) object;
                return getStringKey(o.getIdRelever());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Releve.class.getName()});
                return null;
            }
        }

    }

}
