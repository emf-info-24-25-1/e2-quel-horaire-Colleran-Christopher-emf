package models;

public class ModuleInfo {
    private final String nom;
    private Professeur professeur;

    public ModuleInfo(String nom) {
        this.nom = nom;
        this.professeur = null;
    }

    public String getNom() {
        return nom;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    @Override
    public String toString() {
        //MR Par rapport aux enseignements EMF, il est mieux d'avoir qu'un return à la fin de la méthode.
        if (getProfesseur() == null) {
            return nom;
        } else {
            return nom + " avec " + professeur;
        }
    }
}
