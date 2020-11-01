package pl.glegola.vaadinproject.model;

public class Town {
    private String name;
    private Voivodeship voivodeship;
    private int citizens;
    private boolean city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    public double getCitizens() {
        return citizens;
    }

    public void setCitizens(int citizens) {
        this.citizens = citizens;
    }

    public boolean isCity() {
        return city;
    }

    public void setCity(boolean city) {
        this.city = city;
    }
}
