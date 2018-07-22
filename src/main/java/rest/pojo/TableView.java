package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "abf_stand_hausm")
@Entity
public class TableView {
    @Id
    @GeneratedValue
    private Long id;

    private String anrede;
    private String aufgabe;
    private String bemerkung;
    private String fax;
    private Integer intern;
    private String nachname;
    private String nr;
    private String ort;
    private Integer plz;
    private String standort;
    private String strasse;
    private String telFestnetz;
    private String telMobil;
    private String telPrivat;
    private String telSek;
    private String telSek1;
    private String vorname;

    // constructor for JPA && JSON purposes
    public TableView() {}

    public TableView(Integer intern, String standort, String strasse, String nr, Integer plz, String ort, String telSek, String telSek1, String fax, String anrede, String vorname, String nachname, String aufgabe, String telFestnetz, String telMobil, String telPrivat, String bemerkung) {
        this.intern = intern;
        this.standort = standort;
        this.strasse = strasse;
        this.nr = nr;
        this.plz = plz;
        this.ort = ort;
        this.telSek = telSek;
        this.telSek1 = telSek1;
        this.fax = fax;
        this.anrede = anrede;
        this.vorname = vorname;
        this.nachname = nachname;
        this.aufgabe = aufgabe;
        this.telFestnetz = telFestnetz;
        this.telMobil = telMobil;
        this.telPrivat = telPrivat;
        this.bemerkung = bemerkung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableView tableView = (TableView) o;
        return Objects.equals(getIntern(), tableView.getIntern()) &&
                Objects.equals(getStandort(), tableView.getStandort()) &&
                Objects.equals(getStrasse(), tableView.getStrasse()) &&
                Objects.equals(getNr(), tableView.getNr()) &&
                Objects.equals(getPlz(), tableView.getPlz()) &&
                Objects.equals(getOrt(), tableView.getOrt()) &&
                Objects.equals(getTelSek(), tableView.getTelSek()) &&
                Objects.equals(getTelSek1(), tableView.getTelSek1()) &&
                Objects.equals(getFax(), tableView.getFax()) &&
                Objects.equals(getAnrede(), tableView.getAnrede()) &&
                Objects.equals(getVorname(), tableView.getVorname()) &&
                Objects.equals(getNachname(), tableView.getNachname()) &&
                Objects.equals(getAufgabe(), tableView.getAufgabe()) &&
                Objects.equals(getTelFestnetz(), tableView.getTelFestnetz()) &&
                Objects.equals(getTelMobil(), tableView.getTelMobil()) &&
                Objects.equals(getTelPrivat(), tableView.getTelPrivat()) &&
                Objects.equals(getBemerkung(), tableView.getBemerkung());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIntern(), getStandort(), getStrasse(), getNr(), getPlz(), getOrt(), getTelSek(), getTelSek1(), getFax(), getAnrede(), getVorname(), getNachname(), getAufgabe(), getTelFestnetz(), getTelMobil(), getTelPrivat(), getBemerkung());
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
