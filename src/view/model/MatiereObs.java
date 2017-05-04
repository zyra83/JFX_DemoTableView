package view.model;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import model.entities.Matiere;

// GROS JAVA
@SuppressWarnings("serial")

// LBK
@ToString
@EqualsAndHashCode(of = { "nom" })
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatiereObs implements Serializable {

	StringProperty nom = new SimpleStringProperty();

	IntegerProperty coef = new SimpleIntegerProperty();

	ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();

	public String getNom() {
		return nom.get();
	}

	public StringProperty getNomProperty() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom.set(nom);
	}

	public Integer getCoef() {
		return coef.get();
	}

	public IntegerProperty getCoefProperty() {
		return coef;
	}

	public void setCoef(Integer coef) {
		this.coef.set(coef);
	}

	public LocalDate getDate() {
		return date.getValue();
	}

	public ObjectProperty<LocalDate> getDateProperty() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date.set(date);
	}

	public MatiereObs(String nom, Integer coef, LocalDate date) {
		super();
		setNom(nom);
		setCoef(coef);
		setDate(date);
	}

	public MatiereObs(Matiere m) {
		super();
		setNom(m.getNom());
		setCoef(m.getCoef());
		setDate(m.getDate());
	}
}