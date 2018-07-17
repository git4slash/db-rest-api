package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//@Entity
public class Standorte {
    @Id
    @GeneratedValue
    private Integer id;
    
    private Integer f_int_nummer;

    private Integer f_schulnummer;

    private String f_name;

    private String f_strasse;

    private String f_hnummer;

    private Integer f_plz;

    private String f_ort;

    private String f_tel1;

    private String f_tel2;

    private String f_fax;

    private String f_mail;

    private String f_hmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getF_int_nummer() {
        return f_int_nummer;
    }

    public void setF_int_nummer(Integer f_int_nummer) {
        this.f_int_nummer = f_int_nummer;
    }

    public Integer getF_schulnummer() {
        return f_schulnummer;
    }

    public void setF_schulnummer(Integer f_schulnummer) {
        this.f_schulnummer = f_schulnummer;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getF_strasse() {
        return f_strasse;
    }

    public void setF_strasse(String f_strasse) {
        this.f_strasse = f_strasse;
    }

    public String getF_hnummer() {
        return f_hnummer;
    }

    public void setF_hnummer(String f_hnummer) {
        this.f_hnummer = f_hnummer;
    }

    public Integer getF_plz() {
        return f_plz;
    }

    public void setF_plz(Integer f_plz) {
        this.f_plz = f_plz;
    }

    public String getF_ort() {
        return f_ort;
    }

    public void setF_ort(String f_ort) {
        this.f_ort = f_ort;
    }

    public String getF_tel1() {
        return f_tel1;
    }

    public void setF_tel1(String f_tel1) {
        this.f_tel1 = f_tel1;
    }

    public String getF_tel2() {
        return f_tel2;
    }

    public void setF_tel2(String f_tel2) {
        this.f_tel2 = f_tel2;
    }

    public String getF_fax() {
        return f_fax;
    }

    public void setF_fax(String f_fax) {
        this.f_fax = f_fax;
    }

    public String getF_mail() {
        return f_mail;
    }

    public void setF_mail(String f_mail) {
        this.f_mail = f_mail;
    }

    public String getF_hmail() {
        return f_hmail;
    }

    public void setF_hmail(String f_hmail) {
        this.f_hmail = f_hmail;
    }
}
