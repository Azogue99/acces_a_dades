package objects;

import java.sql.Date;

// Classe que representa una comanda amb un identificador i una data
public class Comanda {
    private int id;
    private Date dataComanda;

    // Constructor amb només l'ID
    public Comanda(int id) {
        this.id = id;
    }

    // Constructor amb l'ID i la data de la comanda
    public Comanda(int id, Date dataComanda) {
        this.id = id;
        this.dataComanda = dataComanda;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Date getDataComanda() {
        return dataComanda;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDataComanda(Date dataComanda) {
        this.dataComanda = dataComanda;
    }

    // Metode toString per representar la comanda com a cadena
    @Override
    public String toString() {
        return "Comanda ID: " + id;
    }
}
