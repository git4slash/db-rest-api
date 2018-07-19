package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "abf_stand_hausm")
@Entity
public class TableView {
    @Id
    @GeneratedValue
    private Long id;

    private Integer intern;
    private String standort;

    // constructor for JPA && JSON purposes
    public TableView() {}

    public TableView(Integer intern, String standort) {
        this.intern = intern;
        this.standort = standort;
    }

    public void updateWith(TableView entityToUpdate) {
        this.intern = entityToUpdate.intern;
        this.standort = entityToUpdate.standort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIntern() {
        return intern;
    }

    public void setIntern(Integer intern) {
        this.intern = intern;
    }

    public String getStandort() {
        return standort;
    }

    public void setStandort(String standort) {
        this.standort = standort;
    }

    //    private String strasse;
//    private String nr;
//    private Integer plz;
//    private String ort;
//    private String telSek;
//    private String telSek1;
//    private String fax;
//    private String anrede;
//    private String vorname;
//    private String nachname;
//    private String aufgabe;
//    private String telFestnetz;
//    private String telMobil;
//    private String telPrivat;
//    private String bemerkung;

}
