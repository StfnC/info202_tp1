package ca.qc.bdeb.info202.tp1;

public class Tp1 {

    public static void main(String[] args) {
        String mot = "allo";
        int tailleMot = mot.length();
        int ligne = 0;
        int colonne = 0;
        int tailleGrille = 0;

        boolean diagHautGaucheVersBasDroitePossible = (ligne + tailleMot <= tailleGrille && colonne + tailleMot <= tailleGrille);
        boolean diagBasDroiteVersHautGauchePossible = ((ligne + 1) - tailleMot >= 0 && (colonne + 1) - tailleMot >= 0);
        boolean diagBasGaucheVersHautDroitePossible = ((ligne + 1) - tailleMot >= 0 && colonne + tailleMot <= tailleGrille);
        boolean diagHautDroiteVersBasGauchePossible = (ligne + tailleMot <= tailleGrille && (colonne + 1) - tailleMot >= 0);

    }
}
