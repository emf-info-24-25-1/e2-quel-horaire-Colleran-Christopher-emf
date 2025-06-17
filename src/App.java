import models.*;
import services.ServiceFormationMaitres;

public class App {

    public static final String[] NOMS_MODULES = { "G300", "187", "162", "123", "293", "117", "164", "216", "106", "231",
            "122", "431" };

    public static void main(String[] args) {
        Horaire horaire = new Horaire();
        ModuleInfo[] modules1ere = new ModuleInfo[12];
        for (int i = 0; i < modules1ere.length; i++) {
            modules1ere[i] = new ModuleInfo(NOMS_MODULES[i]);
        }
        Professeur[] profs = new Professeur[5];
        profs[0] = new Professeur("Diego", "Chanez");
        profs[1] = new Professeur("Christopher", "Colleran");
        profs[2] = new Professeur("Mario", "Ramallo");
        profs[3] = new Professeur("David", "Getta");
        profs[4] = new Professeur("Jean", "Ferdandez");
        boolean tousmodulesSontCouvert;
        do {
            ServiceFormationMaitres.attribuerModule(profs, modules1ere);
            tousmodulesSontCouvert = ServiceFormationMaitres.tousModulesCouvert(profs, modules1ere);
        } while (!tousmodulesSontCouvert);
        System.out.println("L'école a engagé les professeurs suivants");
        for (int i = 0; i < profs.length; i++) {
            System.out.print("- " + profs[i] + " peut enseigner les modules :");
            for (int j = 0; j < profs[i].getModulesEnseignes().length; j++) {
                System.out.print(" " + profs[i].getModulesEnseignes()[j].getNom());
            }
            System.out.println();
        }
        System.out.println("\nll est temps de préparer l'horaire- \n");
        boolean succes = horaire.planifier(modules1ere, profs);
        if (succes) {
            System.out.println("Modules planifiés avec sucès!");
            horaire.afficherHoraire();
        } else {
            System.out.println("Problème de planification");
        }
    }

}
