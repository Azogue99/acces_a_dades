package objects;

// Classe que representa un producte amb un identificador, nom, preu i categoria
public class Producte {
    private int id;
    private String nom;
    private double preu;
    private String categoria;

    // Constructor per inicialitzar un producte amb nom, preu i categoria
    public Producte(String nom, double preu, String categoria) {
        this.nom = nom;
        this.preu = preu;
        this.categoria = categoria;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public double getPreu() {
        return preu;
    }

    public String getCategoria() {
        return categoria;
    }

    // Metode toString per retornar el nom del producte
    @Override
    public String toString() {
        return nom;
    }
}