package editeurDeTexte;

public class RaccourciClavier {
    private Command commande;

    public RaccourciClavier(Command commande) {
        this.commande = commande;
    }

    public void appuyerTouche() {
        commande.executer();
    }
}
