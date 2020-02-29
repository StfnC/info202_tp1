package ca.qc.bdeb.info202.tp1;

import java.io.*;

public class Tp1 {

    public static final String NOM_FICHIER_GRILLE = "grille.txt";
    public static final String NOM_FICHIER_MOTS = "mots.txt";
    private static final String NOM_FICHIER_INTRUS = "intrus.txt";

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

    public static void creerFichierIntrus(String[] tableauIntrus) {
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

    // TODO: NE PAS OUBLIER DE FAIRE AUTO-EVALUATION DU PROGRAMME

    public static void main(String[] args) {
        // TODO: Test all the edge cases
        if (verifierQueFichierExiste(NOM_FICHIER_GRILLE) && verifierQueFichierExiste(NOM_FICHIER_MOTS)) {
            System.out.println("Démarage");

            String[] tableauGrille = fichierVersTableau(NOM_FICHIER_GRILLE);
            TraiteurGrille traiteurGrille = new TraiteurGrille(tableauGrille);
            System.out.println("Chargement de la grille...OK");

            if (traiteurGrille.validerGrille()) {
                System.out.println("Validation de la grille...OK");

                String[] tableauMots = fichierVersTableau(NOM_FICHIER_MOTS);
                TraiteurMots traiteurMots = new TraiteurMots(tableauMots);
                System.out.println("Chargement de la liste de mots...OK");

                if (traiteurMots.validerMots()) {
                    System.out.println("Validation de la liste de mots...OK");

                    String[] tableauIntrus = traiteurGrille.trouverIntrus(traiteurMots);
                    creerFichierIntrus(tableauIntrus);
                    System.out.println("Recherche des intrus...OK\n" +
                            "Les intrus trouvés sont dans le fichier intrus.txt\n" +
                            "Traitement terminé");
                } else {
                    System.out.println("La liste de mots n'est pas valide");
                }
            } else {
                System.out.println("La grille n'est pas valide");
            }
        } else {
            System.out.println("Un des fichiers n'existe pas");
        }
    }
}
