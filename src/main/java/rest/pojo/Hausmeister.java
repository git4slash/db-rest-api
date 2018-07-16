package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hausmeister {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer f_int_nr;

    private String f_anrede;

    private String f_vorname;

    private String f_name;

    private String f_aufgabe;

    private String f_festnetz_pv;

    private String f_dienstlich;

    private String f_privat;

    private String f_bemerkung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getF_int_nr() {
        return f_int_nr;
    }

    public void setF_int_nr(Integer f_int_nr) {
        this.f_int_nr = f_int_nr;
    }

    public String getF_anrede() {
        return f_anrede;
    }

    public void setF_anrede(String f_anrede) {
        this.f_anrede = f_anrede;
    }

    public String getF_vorname() {
        return f_vorname;
    }

    public void setF_vorname(String f_vorname) {
        this.f_vorname = f_vorname;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_aufgabe() {
        return f_aufgabe;
    }

    public void setF_aufgabe(String f_aufgabe) {
        this.f_aufgabe = f_aufgabe;
    }

    public String getF_festnetz_pv() {
        return f_festnetz_pv;
    }

    public void setF_festnetz_pv(String f_festnetz_pv) {
        this.f_festnetz_pv = f_festnetz_pv;
    }

    public String getF_dienstlich() {
        return f_dienstlich;
    }

    public void setF_dienstlich(String f_dienstlich) {
        this.f_dienstlich = f_dienstlich;
    }

    public String getF_privat() {
        return f_privat;
    }

    public void setF_privat(String f_privat) {
        this.f_privat = f_privat;
    }

    public String getF_bemerkung() {
        return f_bemerkung;
    }

    public void setF_bemerkung(String f_bemerkung) {
        this.f_bemerkung = f_bemerkung;
    }
}
