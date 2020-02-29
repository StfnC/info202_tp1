package ca.qc.bdeb.info202.tp1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TraiteurGrille extends TraiteurFichier {
    private static final String NOM_FICHIER_INTRUS = "intrus.txt";

    private char[][] matriceCaracteresGrille;

    public TraiteurGrille(String[] tableauLignes) {
        super(tableauLignes);

        creerMatriceCaracteresGrille();
    }

    public boolean validerGrille() {
        int drapeauValidation = 0;

        if (!this.validerSiSeulementLettres()) {
            drapeauValidation++;
        }

        if (!validerCarree()) {
            drapeauValidation++;
        }
        // Si une des conditions de validation n'est pas valide, un drapeau aura ete emis et la grille n'est pas validee
        return drapeauValidation == 0;
    }

    public boolean trouverMotDansGrille(String mot) {
        int tailleMot = mot.length();
        int tailleGrille = this.matriceCaracteresGrille.length;
        int drapeauMotDansGrille = 0;

        for (int ligne = 0; ligne < tailleGrille; ligne++) {
            for (int colonne = 0; colonne < tailleGrille; colonne++) {
                if (this.matriceCaracteresGrille[ligne][colonne] == mot.charAt(0)) {
                    boolean diagHautGaucheVersBasDroitePossible = (ligne + tailleMot <= tailleGrille && colonne + tailleMot <= tailleGrille);
                    boolean diagBasDroiteVersHautGauchePossible = ((ligne + 1) - tailleMot >= 0 && (colonne + 1) - tailleMot >= 0);
                    boolean diagBasGaucheVersHautDroitePossible = ((ligne + 1) - tailleMot >= 0 && colonne + tailleMot <= tailleGrille);
                    boolean diagHautDroiteVersBasGauchePossible = (ligne + tailleMot <= tailleGrille && (colonne + 1) - tailleMot >= 0);

                    if (diagHautGaucheVersBasDroitePossible) {
                        if (chercherDiagHautGaucheVersBasDroite(mot, ligne, colonne)) {
                            drapeauMotDansGrille++;
                        }
                    }
                    if (diagBasDroiteVersHautGauchePossible) {
                        if (chercherDiagBasDroiteVersHautGauche(mot, ligne, colonne)) {
                            drapeauMotDansGrille++;
                        }
                    }
                    if (diagBasGaucheVersHautDroitePossible) {
                        if (chercherDiagBasGaucheVersHautDroite(mot, ligne, colonne)) {
                            drapeauMotDansGrille++;
                        }
                    }
                    if (diagHautDroiteVersBasGauchePossible) {
                        if (chercherDiagHautDroiteVersBasGauche(mot, ligne, colonne)) {
                            drapeauMotDansGrille++;
                        }
                    }
                }

            }
        }
        return drapeauMotDansGrille > 0;
    }

    public boolean chercherDiagHautGaucheVersBasDroite(String mot, int lignePremiereLettre, int colonnePremiereLettre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append(this.matriceCaracteresGrille[lignePremiereLettre + i][colonnePremiereLettre + i]);
        }
        String motTrouve = sb.toString();

        return motTrouve.equalsIgnoreCase(mot);
    }

    public boolean chercherDiagBasDroiteVersHautGauche(String mot, int lignePremiereLettre, int colonnePremiereLettre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append(this.matriceCaracteresGrille[lignePremiereLettre - i][colonnePremiereLettre - i]);
        }
        String motTrouve = sb.toString();
        return motTrouve.equalsIgnoreCase(mot);
    }

    public boolean chercherDiagBasGaucheVersHautDroite(String mot, int lignePremiereLettre, int colonnePremiereLettre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append(this.matriceCaracteresGrille[lignePremiereLettre - i][colonnePremiereLettre + i]);
        }
        String motTrouve = sb.toString();
        return motTrouve.equalsIgnoreCase(mot);
    }

    public boolean chercherDiagHautDroiteVersBasGauche(String mot, int lignePremiereLettre, int colonnePremiereLettre) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            sb.append(this.matriceCaracteresGrille[lignePremiereLettre + i][colonnePremiereLettre - i]);
        }
        String motTrouve = sb.toString();
        return motTrouve.equalsIgnoreCase(mot);
    }

    public String[] trouverIntrus(TraiteurMots traiteurMots) {
        // On cree une liste qui peut contenir autant d'intrus qu'il y a de mots dans la liste
        String[] tableauIntrus = new String[traiteurMots.getNbLignes()];
        int indexIntrus = 0;

        for (String mot : traiteurMots.getTableauLignes()) {
            if (!trouverMotDansGrille(mot)) {
                tableauIntrus[indexIntrus] = mot;
                indexIntrus++;
            }
        }
        return tableauIntrus;
    }

    public void creerFichierIntrus(String[] tableauIntrus) {
        try {
            FileOutputStream fo = new FileOutputStream(NOM_FICHIER_INTRUS, false);
            PrintWriter pw = new PrintWriter(fo);

            if (tableauIntrus[0] == null) {
                pw.println("Aucun intrus");
            } else {
                String motIntrus;
                int indexIntrus = 0;

                do {
                    motIntrus = tableauIntrus[indexIntrus];

                    if (motIntrus != null) {
                        pw.println(motIntrus);
                        indexIntrus++;
                    }
                } while (motIntrus != null);
            }
            pw.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found Exception");
        }
    }

    public void traiterGrillePourIntrus(TraiteurMots traiteurMots) {
        String[] intrus = trouverIntrus(traiteurMots);
        creerFichierIntrus(intrus);
    }

    public boolean validerCarree() {
        boolean grilleCarree = false;
        for (String ligne : this.getTableauLignes()) {
            grilleCarree = ligne.length() == this.getNbLignes();
            if (!grilleCarree) {
                return false;
            }
        }
        return grilleCarree;
    }

    public void creerMatriceCaracteresGrille() {
        char[][] matriceCaracteresGrille = new char[this.getNbLignes()][this.getNbLignes()];
        for (int i = 0; i < matriceCaracteresGrille.length; i++) {
            // Chaque ligne de la matrice contient les lettres qui composent la ligne
            matriceCaracteresGrille[i] = this.getTableauLignes()[i].toCharArray();
        }
        this.matriceCaracteresGrille = matriceCaracteresGrille;
    }

}
