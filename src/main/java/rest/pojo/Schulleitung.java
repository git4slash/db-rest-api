package rest.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Schulleitung {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer f_int_nummer;

    private String f_ltg_an;

    private String f_ltg_vn;

    private String f_ltg_nn;

    private String f_ltg_priv;

    private String f_ltg_bem;

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

    public String getF_ltg_an() {
        return f_ltg_an;
    }

    public void setF_ltg_an(String f_ltg_an) {
        this.f_ltg_an = f_ltg_an;
    }

    public String getF_ltg_vn() {
        return f_ltg_vn;
    }

    public void setF_ltg_vn(String f_ltg_vn) {
        this.f_ltg_vn = f_ltg_vn;
    }

    public String getF_ltg_nn() {
        return f_ltg_nn;
    }

    public void setF_ltg_nn(String f_ltg_nn) {
        this.f_ltg_nn = f_ltg_nn;
    }

    public String getF_ltg_priv() {
        return f_ltg_priv;
    }

    public void setF_ltg_priv(String f_ltg_priv) {
        this.f_ltg_priv = f_ltg_priv;
    }

    public String getF_ltg_bem() {
        return f_ltg_bem;
    }

    public void setF_ltg_bem(String f_ltg_bem) {
        this.f_ltg_bem = f_ltg_bem;
    }
}
