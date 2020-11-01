package pl.glegola.vaadinproject;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.glegola.vaadinproject.model.Town;
import pl.glegola.vaadinproject.model.Voivodeship;

import java.util.List;

@Route("")
public class FormularViewGui extends HorizontalLayout {

    @Autowired
    public void formularAndGrid(TownList townList) {

        Span title = new Span("Add your city to list.");
        TextField fieldCityName = new TextField("City name: ");
        ComboBox<Voivodeship> voivodeshipComboBox = new ComboBox<>("Select Voivodeship: ", Voivodeship.values());
        IntegerField fieldNumberOfCitizens = new IntegerField ("Number of citizens: ");
        Checkbox checkboxCityStatus = new Checkbox("Has city status?");
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

        VerticalLayout formular = new VerticalLayout(title, fieldCityName, voivodeshipComboBox, fieldNumberOfCitizens, checkboxCityStatus, buttonAdd);
        formular.setWidth("30%");

        List<Town> townListFull = townList.getTownList();
        Grid<Town> grid = new Grid<>(Town.class);
        grid.addColumn(new ComponentRenderer<>(town -> {
            Button buttonDelete = new Button("Delete");
            buttonDelete.addClickListener(buttonClickEvent -> {
                townListFull.remove(town);
                UI.getCurrent().getPage().reload();
            });
            return buttonDelete;
        }));
        grid.setItems(townListFull);

        HorizontalLayout table = new HorizontalLayout(grid);
        table.setSizeFull();

        add(formular, table);
    }
}