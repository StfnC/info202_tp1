package ca.qc.bdeb.info202.tp1;

public abstract class TraiteurFichier {
    private String[] tableauLignes;
    private int nbLignes;

    public TraiteurFichier(String[] tableauLignes) {
        this.tableauLignes = tableauLignes;
        this.nbLignes = tableauLignes.length;
    }

    public void enleverEspaces() {
        for (int indexLigne = 0; indexLigne < this.nbLignes; indexLigne++) {
            this.tableauLignes[indexLigne] = this.tableauLignes[indexLigne].trim();
        }
    }

    public void validerSiSeulementLettres() {

    }

    public void fichierVersLowerCase() {

    }

    public String[] getTableauLignes() {
        return this.tableauLignes;
    }

}
