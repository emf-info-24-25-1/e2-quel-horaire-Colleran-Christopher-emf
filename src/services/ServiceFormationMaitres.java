package services;

import models.ModuleInfo;
import models.Professeur;

public class ServiceFormationMaitres {
    public static void attribuerModule(Professeur[] professeurs, ModuleInfo[] modules) {
        for (int i = 0; i < professeurs.length; i++) {
            int nbre = (int) (Math.random() * ((modules.length - 1) - 0 + 1)) + 0;
            if (!professeurs[i].enseigneCeModule(modules[nbre].getNom()) && modules[nbre].getProfesseur() == null) {
                professeurs[i].ajouterModuleEnseigne(modules[nbre]);
                //MR Le setProfesseur se fait dans la planification et pas encore ici
                modules[nbre].setProfesseur(professeurs[i]);
            }
        }
    }

    public static boolean tousModulesCouvert(Professeur[] profs, ModuleInfo[] modules) {
        boolean réponse = false;
        for (int i = 0; i < modules.length; i++) {
            //MR Ici c'est la méthode PeutEnseigneCeModule (on est pas encore dans la planification)
            if (modules[i].getProfesseur() == null) {
                réponse = false;
                break;
            }
            réponse = true;
        }
        return réponse;
    }
}
