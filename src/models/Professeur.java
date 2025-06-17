package models;

public class Professeur {
    private final String nom;
    private final String prenom;
    private ModuleInfo[] modulesEnseignes;

    public Professeur(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.modulesEnseignes = new ModuleInfo[0];
    }

    public boolean enseigneCeModule(String nomDuModule) {
        boolean réponse = false;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            if (modulesEnseignes[i].getNom() == nomDuModule) {
                réponse = true;
                break;
            }
        }
        return réponse;
    }

    public void ajouterModuleEnseigne(ModuleInfo module) {
        ModuleInfo[] temp = new ModuleInfo[modulesEnseignes.length + 1];
        int x = 0;
        for (int i = 0; i < modulesEnseignes.length; i++) {
            temp[x] = modulesEnseignes[i];
            x++;
        }
        temp[temp.length - 1] = module;
        modulesEnseignes = temp;
    }

    public void viderModule() {
        modulesEnseignes = new ModuleInfo[0];
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public ModuleInfo[] getModulesEnseignes() {
        return modulesEnseignes;
    }

    @Override
    public String toString() {
        return prenom + " " + nom.toUpperCase();
    }
}
