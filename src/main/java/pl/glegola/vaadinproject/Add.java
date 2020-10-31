package pl.glegola.vaadinproject;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.glegola.vaadinproject.model.Town;
import pl.glegola.vaadinproject.model.Voivodeship;

import java.util.List;

@Route("aa")
public class Add extends HorizontalLayout {

    @Autowired
    public void add(TownList townList) {
        TextField fieldCityName = new TextField("City name: ");
        NumberField fieldNumberOfCitizens = new NumberField("Number of citizens: ");

        ComboBox<Voivodeship> voivodeshipComboBox = new ComboBox<>("Select Voivodeship: ", Voivodeship.values());

        Checkbox checkboxCityStatus = new Checkbox("Has city status?");
        checkboxCityStatus.setValue(false);

        Button buttonAdd = new Button("Add new city!");

        buttonAdd.addClickListener(clickEvent -> {
            Town town = new Town();
            town.setName(fieldCityName.getValue());
            town.setCitizens(fieldNumberOfCitizens.getValue());
            town.setCity(checkboxCityStatus.getValue());
            town.setVoivodeship(voivodeshipComboBox.getValue());
            townList.getTownList().add(town);

            Notification notification = new Notification("Town succesfully added!", 3000);
            notification.open();

            UI.getCurrent().getPage().reload();
        });

        VerticalLayout verticalLayout = new VerticalLayout(fieldCityName, voivodeshipComboBox, fieldNumberOfCitizens, checkboxCityStatus, buttonAdd);
        verticalLayout.setWidth("30%");
        add(verticalLayout);
    }

    @Autowired
    public void grid(TownList townlist) {
        List<Town> townListFull = townlist.getTownList();

        Grid<Town> grid = new Grid<>(Town.class);
        grid.setItems(townListFull);

        HorizontalLayout horizontalLayout = new HorizontalLayout(grid);
        horizontalLayout.setSizeFull();

        add(horizontalLayout);
    }
}
