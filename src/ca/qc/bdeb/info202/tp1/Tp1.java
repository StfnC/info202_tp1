package ca.qc.bdeb.info202.tp1;

import java.io.*;

public class Tp1 {

    public static final String NOM_FICHIER_GRILLE = "grille.txt";
    public static final String NOM_FICHIER_MOTS = "mots.txt";

    public static boolean verifierQueFichierExiste(String nomFichier) {
        File fichier = new File(nomFichier);
        return fichier.exists();
    }

    public static int nombreLignesFichier(String nomFichier) {
        int nbLignes = 0;
        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne;
            do {
                ligne = br.readLine();
                if (ligne != null) {
                    nbLignes++;
                }
            } while (ligne != null);
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found Exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }
        return nbLignes;
    }

    public static String[] fichierVersTableau(String nomFichier) {
        int nbLignesDansFichier = nombreLignesFichier(nomFichier);
        String[] tableauLignes = new String[nbLignesDansFichier];

        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne;
            int indexLigne = 0;
            do {
                ligne = br.readLine();
                if (ligne != null) {
                    tableauLignes[indexLigne] = ligne;
                    indexLigne++;
                }
            } while (ligne != null);
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File Not Found Exception");
        } catch (IOException ioe) {
            System.out.println("IO Exception");
        }

        return tableauLignes;
    }

    public static void main(String[] args) {
        String mot = "allo";
        int tailleMot = mot.length();
        int ligne = 0;
        int colonne = 0;
        int tailleGrille = 0;

        String[] grille = fichierVersTableau(NOM_FICHIER_GRILLE);
        String[] mots = fichierVersTableau(NOM_FICHIER_MOTS);

        TraiteurGrille tg = new TraiteurGrille(grille);
        TraiteurMots tm = new TraiteurMots(mots);

        for (String ligneGrille : tg.getTableauLignes()) {
            System.out.println(ligneGrille);
        }
        System.out.println();

        tm.enleverEspaces();
        tg.enleverEspaces();

        for (String ligneGrille : tg.getTableauLignes()) {
            System.out.println(ligneGrille);
        }

        boolean diagHautGaucheVersBasDroitePossible = (ligne + tailleMot <= tailleGrille && colonne + tailleMot <= tailleGrille);
        boolean diagBasDroiteVersHautGauchePossible = ((ligne + 1) - tailleMot >= 0 && (colonne + 1) - tailleMot >= 0);
        boolean diagBasGaucheVersHautDroitePossible = ((ligne + 1) - tailleMot >= 0 && colonne + tailleMot <= tailleGrille);
        boolean diagHautDroiteVersBasGauchePossible = (ligne + tailleMot <= tailleGrille && (colonne + 1) - tailleMot >= 0);

        System.out.println(tm.validerSiSeulementLettres());
        System.out.println(tg.validerSiSeulementLettres());

        tg.tableauVersMinuscules();

        for (String ligneGrille : tg.getTableauLignes()) {
            System.out.println(ligneGrille);
        }

        System.out.println(tg.validerCarree());
        System.out.println(tm.validerAuMoinsUnMot());

    }
}
