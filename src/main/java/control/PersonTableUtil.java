package control;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Person;

/**
 * Clase con utilidades de JavaFX para personas
 */
public class PersonTableUtil {
    /**
     * Función que genera una lista de personas predeterminada
     *
     * @return lista observable de personas
     */
    public static ObservableList<Person> getPersonList() {
        Person p1 = new Person("Ashwin", "Sharan", LocalDate.of(2012, 10, 11));
        Person p2 = new Person("Advik", "Sharan", LocalDate.of(2012, 10, 11));
        Person p3 = new Person("Layne", "Estes", LocalDate.of(2011, 12, 16));
        Person p4 = new Person("Mason", "Boyd", LocalDate.of(2003, 4, 20));
        Person p5 = new Person("Babalu", "Sharan", LocalDate.of(1980, 1, 10));
        return FXCollections.<Person>observableArrayList(p1, p2, p3, p4, p5);
    }

    /**
     * Función que obtiene el ID de la persona de la tabla
     *
     * @return id de la persona
     */
    public static TableColumn<Person, Integer> getIdColumn() {
        TableColumn<Person, Integer> personIdCol = new TableColumn<>("Id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("personId"));
        return personIdCol;
    }

    /**
     * Función que obtiene el nombre de la persona de la tabla
     *
     * @return nombre de la persona
     */
    public static TableColumn<Person, String> getFirstNameColumn() {
        TableColumn<Person, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return fNameCol;
    }

    /**
     * Función que obtiene el apellido de la persona de la tabla
     *
     * @return apellido de la persona
     */
    public static TableColumn<Person, String> getLastNameColumn() {
        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lastNameCol;
    }

    /**
     * Función que obtiene fecha de nacimiento de la persona de la tabla
     *
     * @return fecha de nacimiento de la persona
     */
    public static TableColumn<Person, LocalDate> getBirthDateColumn() {
        TableColumn<Person, LocalDate> bDateCol = new TableColumn<>("Birth Date");
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        return bDateCol;
    }
}
