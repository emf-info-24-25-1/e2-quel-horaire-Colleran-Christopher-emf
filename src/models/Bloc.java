package models;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

public class Bloc {
    //MR Il y a 10 jours et non 9
    public static final int NBRE_DEMI_JOURS_SEMAINE = 9;

    private final String nom;
    private final ModuleInfo[] modules;

    public Bloc(String nom) {
        this.nom = nom;
        this.modules = new ModuleInfo[NBRE_DEMI_JOURS_SEMAINE];
        modules[0] = new ModuleInfo("Matu");
        modules[1] = new ModuleInfo("Matu");
        modules[2] = new ModuleInfo("Matu");
    }

    public boolean planifierModule(ModuleInfo module) {
        boolean reussi = false;
        int compteur = 0;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                compteur++;
            }
        }
        if (compteur >= 3) {
            int compteur2 = 0;
            for (int i = 0; i < modules.length; i++) {
                if (modules[i] == null) {
                    modules[i] = module;
                    compteur2++;
                }
                if (compteur2 == 3) {
                    reussi = true;
                    break;
                }
            }
        }
        return reussi;
    }

    public void afficherHoraire() {
        //MR Pas d'utilisation de boucle, mais fonctionnel Top !
        System.out.println(DayOfWeek.values()[0].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[0]);
        System.out.println(" après-midi : " + modules[1]);

        System.out.println(DayOfWeek.values()[1].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[2]);
        System.out.println(" après-midi : " + modules[3]);

        System.out.println(DayOfWeek.values()[2].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[3]);
        System.out.println(" après-midi : " + modules[4]);

        System.out.println(DayOfWeek.values()[3].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[5]);
        System.out.println(" après-midi : " + modules[6]);

        System.out.println(DayOfWeek.values()[4].getDisplayName(TextStyle.FULL, Locale.FRANCE));
        System.out.println(" matin : " + modules[7]);
        System.out.println(" après-midi : " + modules[8]);
    }

    public boolean estTotalementPlanifie() {
        boolean toutplanifier = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == null) {
                toutplanifier = false;
                break;
            }
            toutplanifier = true;
        }
        return toutplanifier;
    }

    public boolean contientModule(ModuleInfo module) {
        boolean planifier = false;
        for (int i = 0; i < modules.length; i++) {
            if (modules[i] == module) {
                planifier = true;
                break;
            }
        }
        return planifier;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
