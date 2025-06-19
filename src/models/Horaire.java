package models;

public class Horaire {
    public static final int NBRE_DE_BLOCS = 6;

    private final Bloc[] blocs;

    public Horaire() {
        this.blocs = new Bloc[NBRE_DE_BLOCS];
        blocs[0] = new Bloc("B1S1");
        blocs[1] = new Bloc("B2S1");
        blocs[2] = new Bloc("B3S1");
        blocs[3] = new Bloc("B4S2");
        blocs[4] = new Bloc("B5S2");
        blocs[5] = new Bloc("B6S2");
    }

    public boolean planifier(ModuleInfo[] modules, Professeur[] profs) {
        //MR Tu aurais dû faire en deux étapes setProfesseur, puis ensuite planifierModule dans une autre (pas de boucle imbriquée)
        boolean reussi = false;

        for (int i = 0; i < modules.length; i++) {
            for (int j = 0; j < profs.length; j++) {
                if (profs[j].enseigneCeModule(modules[i].getNom())) {
                    modules[i].setProfesseur(profs[j]);
                    for (int l = 0; l < blocs.length; l++) {
                        if (!blocs[l].estTotalementPlanifie()) {
                            if (blocs[l].planifierModule(modules[i])) {
                                reussi = true;
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        return reussi;
    }

    public void afficherHoraire() {
        for (int i = 0; i < blocs.length; i++) {
            System.out.println();
            System.out.println(blocs[i].getNom());
            System.out.println("-----------------");
            blocs[i].afficherHoraire();
        }
    }

    public Bloc moduleDansQueBloc(ModuleInfo module) {
        //MR Attention au accent pour les variables
        Bloc trouvé = null;
        for (int i = 0; i < blocs.length; i++) {
            if (blocs[i].contientModule(module)) {
                trouvé = blocs[i];
            }
        }
        return trouvé;
    }
}
