package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AbfStandHausm {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer intern;
    private String standort;

    // constructor for JPA && JSON purposes
    public AbfStandHausm() {}

    public AbfStandHausm(Integer intern, String standort) {
        this.intern = intern;
        this.standort = standort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
