/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2017_01_12_sem;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author Tomáš
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();

        pane.setPadding(new Insets(0, 100, 0, 100));

        final ComboBox období = new ComboBox();
        období.getItems().addAll(
                "Jaro",
                "Léto",
                "Podzim",
                "Zima"
        );

        období.setValue("Období");
        období.setTooltip(new Tooltip("Zvolit roční období"));
        ;
        období.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                String img = t1;
            }
        });
        final ComboBox nálada = new ComboBox();
        nálada.getItems().addAll(
                "Radost",
                "Smutek"
        );
        nálada.setValue("Nálada");
        nálada.setTooltip(new Tooltip("Zvolit náladu"));
        
        
        final Button button = new Button("Vyhledat");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (období.getValue() != "Jaro"
                        && !období.getValue().toString().isEmpty()) {

                    období.setValue(null);

                }
            }
        });

        javafx.scene.image.Image img1 = new javafx.scene.image.Image("File:img/sky.jpeg");
        final ImageView sky = new ImageView();
        sky.setImage(img1);
        sky.setFitWidth(150);
        sky.setFitHeight(150);

        final HBox pictureRegion = new HBox();

        pictureRegion.getChildren().add(sky);
        pane.add(pictureRegion, 3, 50);

        pane.setVgap(4);
        pane.setHgap(10);
        pane.setPadding(new Insets(20, 0, 0, 0));
        pane.add(období, 3, 5);
        pane.add(nálada, 5, 5);
        pane.add(button, 3, 10);
        pane.getChildren().add(new ImageView(img1));

        Scene scene = new Scene(pane, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
