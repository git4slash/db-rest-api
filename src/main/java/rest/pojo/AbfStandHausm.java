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
    private String strasse;
    private String nr;
    private Integer plz;
    private String ort;
    private String telSek;
    private String telSek1;
    private String fax;
    private String anrede;
    private String vorname;
    private String nachname;
    private String aufgabe;
    private String telFestnetz;
    private String telMobil;
    private String telPrivat;
    private String bemerkung;

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

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getTelSek() {
        return telSek;
    }

    public void setTelSek(String telSek) {
        this.telSek = telSek;
    }

    public String getTelSek1() {
        return telSek1;
    }

    public void setTelSek1(String telSek1) {
        this.telSek1 = telSek1;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAufgabe() {
        return aufgabe;
    }

    public void setAufgabe(String aufgabe) {
        this.aufgabe = aufgabe;
    }

    public String getTelFestnetz() {
        return telFestnetz;
    }

    public void setTelFestnetz(String telFestnetz) {
        this.telFestnetz = telFestnetz;
    }

    public String getTelMobil() {
        return telMobil;
    }

    public void setTelMobil(String telMobil) {
        this.telMobil = telMobil;
    }

    public String getTelPrivat() {
        return telPrivat;
    }

    public void setTelPrivat(String telPrivat) {
        this.telPrivat = telPrivat;
    }

    public String getBemerkung() {
        return bemerkung;
    }

    public void setBemerkung(String bemerkung) {
        this.bemerkung = bemerkung;
    }
}
