package lt.bit.spring_web.classes;

import java.util.Objects;

public class Zmogus {

    public static int nextId = 1;

    private Integer id;
    private String vardas;
    private String pavarde;
    private Float amzius;

    public Zmogus() {
        this.id = nextId++;
    }

    public Zmogus(String vardas,String pavarde, Float amzius) {
        this.id = nextId++;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
    }

    public Zmogus(Integer id, String vardas, String pavarde, Float amzius) {
        this.id = id;
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVardas() {
        return vardas;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    public Float getAmzius() {
        return amzius;
    }

    public void setAmzius(Float amzius) {
        this.amzius = amzius;
    }

    public void  assignId() {
        this.id = nextId++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zmogus)) return false;
        Zmogus zmogus = (Zmogus) o;
        return Objects.equals(getId(), zmogus.getId()) && Objects.equals(getVardas(), zmogus.getVardas()) && Objects.equals(getPavarde(), zmogus.getPavarde()) && Objects.equals(getAmzius(), zmogus.getAmzius());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVardas(), getPavarde(), getAmzius());
    }

    @Override
    public String toString() {
        return "Zmogus{" +
                "id=" + id +
                ", vardas='" + vardas + '\'' +
                ", pavarde='" + pavarde + '\'' +
                ", amzius=" + amzius +
                '}';
    }
}
