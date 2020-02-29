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

    public boolean validerSiSeulementLettres() {
        boolean seulementLettres = true;
        for (String ligne : this.tableauLignes) {
            char[] caracteresLigne = ligne.toCharArray();
            for (char caractere : caracteresLigne) {
                seulementLettres = Character.isLetter(caractere);
                if (!seulementLettres) {
                    return false;
                }
            }
        }
        return seulementLettres;
    }

    public void fichierVersMinuscules() {
        for (int i = 0; i < this.nbLignes; i++) {
            this.tableauLignes[i] = this.tableauLignes[i].toLowerCase();
        }
    }

    public String[] getTableauLignes() {
        return this.tableauLignes;
    }

}
