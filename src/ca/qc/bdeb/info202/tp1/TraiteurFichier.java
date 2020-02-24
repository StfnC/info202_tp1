package ca.qc.bdeb.info202.tp1;

import java.io.*;

public class TraiteurFichier {
    private String nomFichier;

    public TraiteurFichier(String nomFichier) {

    }

    public int nombreLignesFichier() {
        int nbLignes = 0;
        try {
            FileReader fr = new FileReader(this.nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne = br.readLine();
            while (ligne != null) {
                nbLignes++;
                ligne = br.readLine();
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("Wrong filename lmao");
        } catch (IOException ioe) {
            System.out.println("I don't even know lol");
        }
        return nbLignes;
    }

    public char[][] fichierVersMatrice() {
        int nbLignesDansFichier = this.nombreLignesFichier();
        char[][] matriceLignes = new char[nbLignesDansFichier][nbLignesDansFichier];

        try {
            FileReader fr = new FileReader(this.nomFichier);
            BufferedReader br = new BufferedReader(fr);

            String ligne;
            int indexLigne = 0;
            do {
                ligne = br.readLine();
                if (ligne != null) {
                    matriceLignes[indexLigne] = ligne.toCharArray();
                    indexLigne++;
                }
            } while (ligne != null);

        } catch (FileNotFoundException fnfe) {
            System.out.println("Wrong filename lmao");
        } catch (IOException ioe) {
            System.out.println("I don't even know lol");
        }

        return matriceLignes;
    }

    public String getNomFichier() {
        return this.nomFichier;
    }

    public void enleverEspaces() {

    }

    public void validerSiSeulementLettres() {

    }

    public void fichierVersLowerCase() {

    }

}
