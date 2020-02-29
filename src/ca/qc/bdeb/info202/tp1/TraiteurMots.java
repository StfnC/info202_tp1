package ca.qc.bdeb.info202.tp1;

public class TraiteurMots extends TraiteurFichier {

    public TraiteurMots(String[] tableauLignes) {
        super(tableauLignes);
    }

    public boolean validerMots() {
        int drapeauValidation = 0;

        if (!this.validerSiSeulementLettres()) {
            drapeauValidation++;
        }

        if (!validerAuMoinsUnMot()) {
            drapeauValidation++;
        }
        // Si une des conditions de validation n'est pas valide, un drapeau aura ete emis et la liste de mots n'est pas validee
        return drapeauValidation == 0;
    }

    public boolean validerAuMoinsUnMot() {
        // Le fichier contient un mot s'il n'est pas vide et si la 1ere ligne contient plus d'une lettre
        return (this.getTableauLignes().length > 0 && this.getTableauLignes()[0].length() > 1);
    }

}
