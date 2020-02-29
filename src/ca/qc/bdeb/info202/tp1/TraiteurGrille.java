package ca.qc.bdeb.info202.tp1;

public class TraiteurGrille extends TraiteurFichier {

    public TraiteurGrille(String[] matriceLignes) {
        super(matriceLignes);
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

}
