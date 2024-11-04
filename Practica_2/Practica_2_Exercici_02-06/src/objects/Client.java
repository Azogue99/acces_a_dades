package objects;

// Classe que representa un client amb un identificador i un nom
public class Client {
    private int id;
    private String nom;

    // Constructor
    public Client(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Metode toString per representar el client com a cadena de text
    @Override
    public String toString() {
        return nom + " (ID: " + id + ")";
    }
}
