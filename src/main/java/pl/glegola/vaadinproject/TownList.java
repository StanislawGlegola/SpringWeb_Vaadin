package pl.glegola.vaadinproject;

import org.springframework.stereotype.Repository;
import pl.glegola.vaadinproject.model.Town;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TownList {

    private List<Town> townList;

    public TownList() {
        this.townList = new ArrayList<>();
    }

    public List<Town> getTownList() {
        return townList;
    }

    public void setTownList(List<Town> townList) {
        this.townList = townList;
    }
}
