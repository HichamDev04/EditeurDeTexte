package editeurDeTexte;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditeurDeTexteIG extends Application {

    private Buffer buffer = new Buffer();
    private PressePapier pressePapier = new PressePapier();
    private Selection selection = new Selection();
    private EditeurDeTexte editeurDeTexte = new EditeurDeTexte(buffer, pressePapier, selection);
    private TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        textArea = new TextArea();
        textArea.setPrefHeight(200);

        Button couperButton = new Button("Couper");
        Button copierButton = new Button("Copier");
        Button collerButton = new Button("Coller");

        Couper couperCommande = new Couper(buffer, pressePapier, selection);
        Copier copierCommande = new Copier(buffer, pressePapier, selection);
        Coller collerCommande = new Coller(buffer, pressePapier);

        couperButton.setOnAction(e -> {
            int debut = textArea.getSelection().getStart();
            int fin = textArea.getSelection().getEnd();
            if (debut < fin) {
                selection.creerSelection(debut, fin);
                editeurDeTexte.executerCommande(couperCommande);
                textArea.setText(buffer.getContenu());
            } else {
                System.out.println("Erreur : impossible de couper. Sélection invalide.");
            }
        });

        copierButton.setOnAction(e -> {
            int debut = textArea.getSelection().getStart();
            int fin = textArea.getSelection().getEnd();
            if (debut < fin) {
                selection.creerSelection(debut, fin);
                editeurDeTexte.executerCommande(copierCommande);
            } else {
                System.out.println("Erreur : impossible de copier. Sélection invalide.");
            }
        });

        collerButton.setOnAction(e -> {
            if (!pressePapier.estVide()) {
                int position = textArea.getCaretPosition();
                collerCommande.definirPosition(position);
                editeurDeTexte.executerCommande(collerCommande);
                textArea.setText(buffer.getContenu());
            }
        });

        textArea.setOnKeyPressed(e -> {
            if (e.isControlDown()) {
                if (e.getCode() == KeyCode.X) {
                    couperButton.fire();
                } else if (e.getCode() == KeyCode.C) {
                    copierButton.fire();
                } else if (e.getCode() == KeyCode.V) {
                    collerButton.fire();
                }
            }
        });

        HBox boutons = new HBox(10, couperButton, copierButton, collerButton);
        VBox layout = new VBox(10, textArea, boutons);

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Editeur de Texte");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
