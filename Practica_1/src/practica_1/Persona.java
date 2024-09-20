package practica_1;

import java.io.Serializable;

public class Persona implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // Perque com es un objecte serialitzable ha de tenir un numero de serie
	private String nom;
	private int edat;
	
	public Persona(String nom, int edat) {
		this.nom = nom;
		this.edat = edat;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	@Override
	public String toString() {
		return "Persona [nom=" + nom + ", edat=" + edat + "]";
	}
	
}
