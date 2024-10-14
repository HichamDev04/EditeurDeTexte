package editeurDeTexte;

public class PressePapier {
    private String contenu;

    public PressePapier() {
        this.contenu = "";  // Chaîne vide par défaut
    }

    public void copier(String texte) {
        if (texte != null && !texte.isEmpty()) {
            this.contenu = texte;
        } else {
            System.out.println("Erreur : contenu invalide (vide ou null) pour le presse-papier.");
        }
    }

    public String coller() {
        if (!estVide()) {
            return this.contenu;
        } else {
            System.out.println("Le presse-papier est vide.");
            return "";
        }
    }

    public boolean estVide() {
        return this.contenu == null || this.contenu.isEmpty();
    }

    // Méthode ajoutée pour obtenir le contenu du presse-papier
    public String obtenirContenu() {
        return this.contenu;
    }
}
