package objects;

public class Producte {
	private int id;
    private String nom;
    private double preu;
    private String categoria;

    public Producte(String nom, double preu, String categoria) {
        this.nom = nom;
        this.preu = preu;
        this.categoria = categoria;
    }
    
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
    
    @Override
    public String toString() {
        return nom; // Devuelve el nombre del producto
    }
}
