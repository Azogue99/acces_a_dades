package objects;

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

    // toString method
    @Override
    public String toString() {
        return nom + " (ID: " + id + ")";
    }
}
