package ca.qc.bdeb.info202.tp1;

import java.io.File;

public class TraiteurFichier {
    private String nomFichier;

    public TraiteurFichier(String nomFichier) {
        // TODO -S'assurer que le fichier existe
        /*
        File fichier = new File(nomFichier);
        if (fichier.exists()) {
            ...
        } else {
            ...
        }
        */
        this.nomFichier = nomFichier;
    }

    public String getNomFichier() {
        return this.nomFichier;
    }

    public void enleverEspaces() {

    }

    public void validerSiSeulementLettres() {

    }


}
