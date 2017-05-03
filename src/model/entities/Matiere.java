package model.entities;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

// GROS JAVA
@SuppressWarnings("serial")

// LBK
@ToString
@EqualsAndHashCode(of = { "nom" })
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Matiere implements Serializable {

	@Getter
	@Setter
	String nom;


	@Getter
	@Setter
	Integer coef;

	@Getter
	@Setter
	LocalDate date;
}