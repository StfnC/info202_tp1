package ca.qc.bdeb.info202.tp1;

public class TraiteurMots extends TraiteurFichier {

    public TraiteurMots(String[] matriceLignes) {
        super(matriceLignes);
    }

    public boolean validerAuMoinsUnMot() {
        return this.getTableauLignes()[0].length() > 1;
    }

}
