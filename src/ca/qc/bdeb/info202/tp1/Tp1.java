package ca.qc.bdeb.info202.tp1;

import java.io.*;
import java.util.Arrays;

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

            String ligne = br.readLine();
            while (ligne != null) {
                nbLignes++;
                ligne = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found");
        } catch (IOException ioe) {
            System.out.println("I don't even know lol");
        }
        return nbLignes;
    }

    public static int trouverLigneLaPlusLongueDansFichier(String nomFichier) {
        int tailleLignePlusLongue = 0;
        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne = "";
            do {
                ligne = br.readLine();

            } while (ligne != null);

        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found excepion");
        } catch (IOException ioe) {
            System.out.println("IO exception");
        }
        return tailleLignePlusLongue;
    }

    public static String[][] fichierVersMatrice(String nomFichier) {
        int nbLignesDansFichier = nombreLignesFichier(nomFichier);
        String[][] matriceLignes = new String[nbLignesDansFichier][1];

        try {
            FileReader fr = new FileReader(nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne;
            int indexLigne = 0;
            do {
                ligne = br.readLine();
                if (ligne != null) {
                    matriceLignes[indexLigne][indexLigne] = ligne;
                    indexLigne++;
                }
            } while (ligne != null);
            br.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Wrong filename lmao");
        } catch (IOException ioe) {
            System.out.println("I don't even know lol");
        }

        return matriceLignes;
    }

    public static void main(String[] args) {
        String mot = "allo";
        int tailleMot = mot.length();
        int ligne = 0;
        int colonne = 0;
        int tailleGrille = 0;

        String[][] grille = fichierVersMatrice(NOM_FICHIER_GRILLE);

        TraiteurGrille tg = new TraiteurGrille(grille);

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print(grille[i][j]);
            }
            System.out.println();
        }

        boolean diagHautGaucheVersBasDroitePossible = (ligne + tailleMot <= tailleGrille && colonne + tailleMot <= tailleGrille);
        boolean diagBasDroiteVersHautGauchePossible = ((ligne + 1) - tailleMot >= 0 && (colonne + 1) - tailleMot >= 0);
        boolean diagBasGaucheVersHautDroitePossible = ((ligne + 1) - tailleMot >= 0 && colonne + tailleMot <= tailleGrille);
        boolean diagHautDroiteVersBasGauchePossible = (ligne + tailleMot <= tailleGrille && (colonne + 1) - tailleMot >= 0);


    }
}
