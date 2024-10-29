
package models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuaris")
public class Usuari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "correu", nullable = false)
    private String correu;

    public Usuari() {}

    public Usuari(String nom, String correu) {
        this.nom = nom;
        this.correu = correu;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    @Override
    public String toString() {
        return "Usuari [id=" + id + ", nom=" + nom + ", correu=" + correu + "]";
    }
}
