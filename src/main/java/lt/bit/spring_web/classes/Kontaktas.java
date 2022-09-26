package lt.bit.spring_web.classes;

import java.util.Objects;

public class Kontaktas {

    public static int nextId = 1;

    private Integer kontId;
    private Integer zmId;
    private String tipas;
    private String reiksme;

    public Kontaktas() {
        this.kontId = nextId++;
    }

    public Kontaktas(Integer zmId, String tipas, String reiksme) {
        this.kontId = nextId++;
        this.zmId = zmId;
        this.tipas = tipas;
        this.reiksme = reiksme;
    }

    public Kontaktas(Integer kontId, Integer zmId, String tipas, String reiksme) {
        this.kontId = kontId;
        this.zmId = zmId;
        this.tipas = tipas;
        this.reiksme = reiksme;
    }

    public Integer getKontId() {
        return kontId;
    }

    public void setKontId(Integer kontId) {
        this.kontId = kontId;
    }

    public Integer getZmId() {
        return zmId;
    }

    public void setZmId(Integer zmId) {
        this.zmId = zmId;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    public String getReiksme() {
        return reiksme;
    }

    public void setReiksme(String reiksme) {
        this.reiksme = reiksme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kontaktas)) return false;
        Kontaktas kontaktas = (Kontaktas) o;
        return Objects.equals(getKontId(), kontaktas.getKontId()) && Objects.equals(getZmId(), kontaktas.getZmId()) && Objects.equals(getTipas(), kontaktas.getTipas()) && Objects.equals(getReiksme(), kontaktas.getReiksme());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKontId(), getZmId(), getTipas(), getReiksme());
    }

    @Override
    public String toString() {
        return "Kontaktas{" +
                "kontId=" + kontId +
                ", zmId=" + zmId +
                ", tipas='" + tipas + '\'' +
                ", reiksme='" + reiksme + '\'' +
                '}';
    }
}
