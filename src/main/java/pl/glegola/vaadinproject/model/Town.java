package pl.glegola.vaadinproject.model;

public class Town {
    private String name;
    private Voivodeship voivodeship;
    private double citizens;
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

    public void setCitizens(double citizens) {
        this.citizens = citizens;
    }

    public boolean isCity() {
        return city;
    }

    public void setCity(boolean city) {
        this.city = city;
    }
}
