package ca.qc.bdeb.info202.tp1;

public class TraiteurGrille extends TraiteurFichier {

    public TraiteurGrille(String[] matriceLignes) {
        super(matriceLignes);
    }

    // TODO: validerCarree est la derniere validation a faire, il faut enlever les espaces et s'assurer qu'il y a juste des lettres avant

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
