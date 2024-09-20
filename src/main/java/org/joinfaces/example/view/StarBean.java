package org.joinfaces.example.view;



import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.application.FacesMessage;

import java.util.ArrayList;
import java.util.List;

@ManagedBean("starBean")
@RequestScoped
public class StarBean {

    private Star star = new Star();
    private static List<Star> starList = new ArrayList<>(); // In-memory storage

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public void submit() {
        System.out.println("submit button clicked");
        determineStarClass();
        saveStar(star);
        System.out.println("mass: " + star.getMass() + ", Star Class: " + star.getStarClass() + ", Name: " + star.getName()+",size : "+star.getSize());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Star data submitted successfully"));
        star = new Star(); // Reset the form after submission
    }

    private void determineStarClass() {
        if (star.getTemperature() < 3000) {
            star.setStarClass("M");
        } else if (star.getTemperature() < 5000) {
            star.setStarClass("K");
        } else if (star.getTemperature() < 6000) {
            star.setStarClass("G");
        } else if (star.getTemperature() < 7500) {
            star.setStarClass("F");
        } else if (star.getTemperature() < 10000) {
            star.setStarClass("A");
        } else if (star.getTemperature() < 30000) {
            star.setStarClass("B");
        } else {
            star.setStarClass("O");
        }
    }

    private void saveStar(Star star) {
        starList.add(star);
    }

    public List<Star> getAllStars() {
        return starList;
    }
}






//
//package org.joinfaces.example.view;
//
//import jakarta.annotation.ManagedBean;
//import jakarta.inject.Named;
//import jakarta.enterprise.context.RequestScoped;
//import jakarta.faces.context.FacesContext;
//import jakarta.faces.application.FacesMessage;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.transaction.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@ManagedBean("starBean")
//@RequestScoped
//public class StarBean {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private Star star = new Star();
//    private static List<Star> starList = new ArrayList<>(); // In-memory storage
//
//
//    public Star getStar() {
//        return star;
//    }
//
//    public void setStar(Star star) {
//        this.star = star;
//    }
//
//    @Transactional
//    public void submit() {
//        System.out.println("submit button clicked");
//        determineStarClass();
//        saveStar(star);
//        System.out.println("ID: " + star.getId() + ", Star Class: " + star.getStarClass() + ", Name: " + star.getName());
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Star data submitted successfully"));
//        star = new Star(); // Reset the form after submission
//    }
//
//    private void determineStarClass() {
//        if (star.getTemperature() < 3000) {
//            star.setStarClass("M");
//        } else if (star.getTemperature() < 5000) {
//            star.setStarClass("K");
//        } else if (star.getTemperature() < 6000) {
//            star.setStarClass("G");
//        } else if (star.getTemperature() < 7500) {
//            star.setStarClass("F");
//        } else if (star.getTemperature() < 10000) {
//            star.setStarClass("A");
//        } else if (star.getTemperature() < 30000) {
//            star.setStarClass("B");
//        } else {
//            star.setStarClass("O");
//        }
//    }
//
//    private void saveStar(Star star) {
//        starList.add(star);
//    }
//
////    @Transactional
////    private void saveStar(Star star) {
////        entityManager.persist(star);
////    }
//
//    public List<Star> getAllStars() {
//        return entityManager.createQuery("SELECT s FROM Star s", Star.class).getResultList();
//    }
//}
