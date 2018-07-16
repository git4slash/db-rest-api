package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Telekom {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer f_int_nummer;

    private Integer f_bkto;

    private Integer f_zugangsnr;

    private String f_leitungstyp;

    private Integer f_kundennummer;

    private String f_bemerkung;

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

    public Integer getF_bkto() {
        return f_bkto;
    }

    public void setF_bkto(Integer f_bkto) {
        this.f_bkto = f_bkto;
    }

    public Integer getF_zugangsnr() {
        return f_zugangsnr;
    }

    public void setF_zugangsnr(Integer f_zugangsnr) {
        this.f_zugangsnr = f_zugangsnr;
    }

    public String getF_leitungstyp() {
        return f_leitungstyp;
    }

    public void setF_leitungstyp(String f_leitungstyp) {
        this.f_leitungstyp = f_leitungstyp;
    }

    public Integer getF_kundennummer() {
        return f_kundennummer;
    }

    public void setF_kundennummer(Integer f_kundennummer) {
        this.f_kundennummer = f_kundennummer;
    }

    public String getF_bemerkung() {
        return f_bemerkung;
    }

    public void setF_bemerkung(String f_bemerkung) {
        this.f_bemerkung = f_bemerkung;
    }
}
