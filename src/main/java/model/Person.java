package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase Persona
 */
public class Person {
    private static AtomicInteger personSequence = new AtomicInteger(0);
    private int personId;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    /**
     * Un enum para las categorías de edad
     */
    public enum AgeCategory {
        BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
    }

    /**
     * Constructor vacío de persona
     */
    public Person() {
        this(null, null, null);
    }

    /**
     * Constructor con parámetros de persona
     *
     * @param firstName nombre
     * @param lastName apellidos
     * @param birthDate fecha de nacimiento
     */
    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    /**
     * Getter para el id de persona
     *
     * @return id de persona
     */
    public int getPersonId() {
        return personId;
    }

    /**
     * Setter para el id de persona
     *
     * @param personId nuevo id de persona
     */
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    /**
     * Getter para el nombre de persona
     *
     * @return nombre de persona
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter para el nombre de persona
     *
     * @param firstName nuevo nombre de persona
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter para el apellido de persona
     *
     * @return apellido de persona
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter para el apellido de persona
     *
     * @param lastName nuevo apellido de persona
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter para fecha nacimiento de persona
     *
     * @return fecha nacimiento de persona
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Setter para fecha nacimiento de persona
     *
     * @param birthDate nuevo fecha nacimiento de persona
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Función que comprueba si la persona tiene una fecha de nacimiento válida
     *
     * @param bdate fecha de nacimiento
     * @return true/false
     */
    public boolean isValidBirthDate(LocalDate bdate) {
        return isValidBirthDate(bdate, new ArrayList<>());
    }

    /**
     * Función que comprueba si la persona tiene una fecha de nacimiento válida
     *
     * @param bdate fecha de nacimiento
     * @param errorList lista de errores
     * @return true/false
     */
    public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
        if (bdate == null) {
            return true;
        }
        // Birth date cannot be in the future
        if (bdate.isAfter(LocalDate.now())) {
            errorList.add("Birth date must not be in future.");
            return false;
        }
        return true;
    }

    /**
     * Función que comprueba si una persona es válida
     *
     * @param errorList lista de errores
     * @return true/false
     */
    public boolean isValidPerson(List<String> errorList) {
        return isValidPerson(this, errorList);
    }

    /**
     * Función que comprueba si una persona es válida
     *
     * @param p persona
     * @param errorList lista de errores
     * @return true/false
     */
    public boolean isValidPerson(Person p, List<String> errorList) {
        boolean isValid = true;
        String fn = p.getFirstName();
        if (fn == null || fn.trim().length() == 0) {
            errorList.add("First name must contain minimum one character.");
            isValid = false;
        }
        String ln = p.getLastName();
        if (ln == null || ln.trim().length() == 0) {
            errorList.add("Last name must contain minimum one character.");
            isValid = false;
        }
        if (!isValidBirthDate(this.getBirthDate(), errorList)) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * Función que categoriza a la persona según su fecha de nacimiento
     *
     * @return AgeCategory de la persona
     */
    public AgeCategory getAgeCategory() {
        if (birthDate == null) {
            return AgeCategory.UNKNOWN;
        }
        long years = ChronoUnit.YEARS.between(birthDate, LocalDate.now());
        if (years >= 0 && years < 2) {
            return AgeCategory.BABY;
        } else if (years >= 2 && years < 13) {
            return AgeCategory.CHILD;
        } else if (years >= 13 && years <= 19) {
            return AgeCategory.TEEN;
        } else if (years > 19 && years <= 50) {
            return AgeCategory.ADULT;
        } else if (years > 50) {
            return AgeCategory.SENIOR;
        } else {
            return AgeCategory.UNKNOWN;
        }
    }

    /**
     * Función que almacena a la persona si esta es válida
     *
     * @param errorList lista de errores
     * @return si la persona se ha guardado o no
     */
    public boolean save(List<String> errorList) {
        boolean isSaved = false;
        if (isValidPerson(errorList)) {
            System.out.println("Saved " + this.toString());
            isSaved = true;
        }
        return isSaved;
    }

    /**
     * ToString de objeto persona
     * @return descripción de la persona
     */
    @Override
    public String toString() {
        return "[personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" +
                birthDate + "]";
    }
}
