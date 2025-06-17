package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModule(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < professeurs.length; i++) {
            int nbre = (int) (Math.random() * ((modules.length - 1) - 0 + 1)) + 0;
            if (!professeurs[i].enseigneCeModule(modules[nbre].getNom()) && modules[nbre].getProfesseur() == null) {
                professeurs[i].ajouterModuleEnseigne(modules[nbre]);
                modules[nbre].setProfesseur(professeurs[i]);
            }
        }
    }

    public static boolean tousModulesCouvert(Professeur[] profs, ModuleInfo[] modules) {
        boolean réponse = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i].getProfesseur() == null) {
                réponse = false;
                break;
            }
            réponse = true;
        }
        return réponse;
    }
}
