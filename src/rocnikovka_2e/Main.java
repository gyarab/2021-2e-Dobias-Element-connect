/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocnikovka_2e;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Petr6505
 */
public class Main extends Application {

    boolean playArea1 = true;
    int playAreaObjects = 0;

    boolean water = false;
    boolean fire = false;
    boolean air = false;
    boolean earth = false;
    boolean steam = false;
    boolean dust = false;//
    boolean glass = false;//
    boolean iron = false;//
    boolean lava = false;//
    boolean sand = false;//

    @Override
    public void start(Stage primaryStage) {

//Creating panes
        StackPane stackPane = new StackPane();
        SplitPane splitPane = new SplitPane();
        TabPane tabPane = new TabPane();
        GridPane gridPane1 = new GridPane();
        Pane pane = new Pane();

//Creating play area
        Rectangle rectangle1 = new Rectangle(100, 100, Color.DARKBLUE);
        Rectangle rectangle2 = new Rectangle(100, 100, Color.DARKBLUE);
        Label label = new Label("+");
        label.setStyle("-fx-text-fill:BLACK; -fx-font-size: 60;");
        Button mergeBtn = new Button("MERGE");
        Button clearBtn = new Button("CLEAR");
        ToggleButton labelsBtn = new ToggleButton("LABELS");

        pane.getChildren().addAll(clearBtn, label, mergeBtn, labelsBtn, rectangle1, rectangle2);

        rectangle1.setLayoutX(100);
        rectangle2.setLayoutX(300);
        label.setLayoutX(230);
        labelsBtn.setLayoutX(120);
        labelsBtn.setLayoutY(200);
        mergeBtn.setLayoutX(220);
        mergeBtn.setLayoutY(200);
        clearBtn.setLayoutX(320);
        clearBtn.setLayoutY(200);

//Creating boxes        
        VBox vBox = new VBox(tabPane);

//Creating tabs     
        Tab tab1 = new Tab("1", gridPane1);
        tab1.setClosable(false);

//Creating rectangles
        Rectangle waterR = new Rectangle(70, 70);
        Rectangle fireR = new Rectangle(70, 70);
        Rectangle airR = new Rectangle(70, 70);
        Rectangle earthR = new Rectangle(70, 70);
        Rectangle steamR = new Rectangle(70, 70);
        Rectangle dustR = new Rectangle(70, 70);
        Rectangle glassR = new Rectangle(70, 70);
        Rectangle lavaR = new Rectangle(70, 70);
        Rectangle ironR = new Rectangle(70, 70);
        Rectangle sandR = new Rectangle(70, 70);

//Creating labels
        Label waterL = new Label("water");
        Label fireL = new Label("fire");
        Label airL = new Label("air");
        Label earthL = new Label("earth");
        Label steamL = new Label("steam");
        Label dustL = new Label("dust");
        Label glassL = new Label("glass");
        Label lavaL = new Label("lava");
        Label ironL = new Label("iron");
        Label sandL = new Label("sand");

//Hiding rectangles
        steamR.setVisible(false);
        dustR.setVisible(false);
        glassR.setVisible(false);
        lavaR.setVisible(false);
        ironR.setVisible(false);
        sandR.setVisible(false);

//Creating images     
        Image waterI = new Image("file:images\\water.jpg");
        Image fireI = new Image("file:images\\fire.jpg");
        Image airI = new Image("file:images\\air.jpg");
        Image earthI = new Image("file:images\\earth.jpg");
        Image steamI = new Image("file:images\\steam.jpg");
        Image dustI = new Image("file:images\\dust.jpg");
        Image glassI = new Image("file:images\\glass.jpg");
        Image lavaI = new Image("file:images\\lava.jpg");
        Image ironI = new Image("file:images\\iron.jpg");
        Image sandI = new Image("file:images\\sand.jpg");

//Adding images to rectangles        
        waterR.setFill(new ImagePattern(waterI));
        fireR.setFill(new ImagePattern(fireI));
        airR.setFill(new ImagePattern(airI));
        earthR.setFill(new ImagePattern(earthI));
        steamR.setFill(new ImagePattern(steamI));
        dustR.setFill(new ImagePattern(dustI));
        glassR.setFill(new ImagePattern(glassI));
        lavaR.setFill(new ImagePattern(lavaI));
        ironR.setFill(new ImagePattern(ironI));
        sandR.setFill(new ImagePattern(sandI));

//Adding tabs
        tabPane.getTabs().add(tab1);

//XXX panes
        stackPane.setMaxSize(800, 300);
        pane.setMinSize(500, 300);
        pane.setMaxSize(500, 300);

//XXX gridPanes
        gridPane1.setHgap(5);
        gridPane1.setVgap(5);

//Adding to panes
        splitPane.getItems().addAll(pane, vBox);
        stackPane.getChildren().add(splitPane);

//Adding to gridpanes
        gridPane1.add(waterR, 0, 0);
        gridPane1.add(fireR, 1, 0);
        gridPane1.add(airR, 2, 0);
        gridPane1.add(earthR, 3, 0);
        gridPane1.add(steamR, 0, 1);
        gridPane1.add(dustR, 1, 1);
        gridPane1.add(glassR, 2, 1);
        gridPane1.add(lavaR, 3, 1);
        gridPane1.add(ironR, 0, 2);
        gridPane1.add(sandR, 1, 2);

//Rectangle methods
        //Water
        waterR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(waterR);
                if (playArea1 == true) {
                    waterR.setLayoutX(115);
                    waterR.setLayoutY(12.5);
                } else {
                    waterR.setLayoutX(315);
                    waterR.setLayoutY(12.5);
                }
                playArea1 = false;
                water = true;
                playAreaObjects++;
            }
        });

        //Fire
        fireR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(fireR);
                if (playArea1 == true) {
                    fireR.setLayoutX(115);
                    fireR.setLayoutY(12.5);
                } else {
                    fireR.setLayoutX(315);
                    fireR.setLayoutY(12.5);
                }
                playArea1 = false;
                fire = true;
                playAreaObjects++;
            }
        });

        //Air
        airR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(airR);
                if (playArea1 == true) {
                    airR.setLayoutX(115);
                    airR.setLayoutY(12.5);
                } else {
                    airR.setLayoutX(315);
                    airR.setLayoutY(12.5);
                }
                playArea1 = false;
                air = true;
                playAreaObjects++;
            }
        });

        //Earth
        earthR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(earthR);
                if (playArea1 == true) {
                    earthR.setLayoutX(115);
                    earthR.setLayoutY(12.5);
                } else {
                    earthR.setLayoutX(315);
                    earthR.setLayoutY(12.5);
                }
                playArea1 = false;
                earth = true;
                playAreaObjects++;
            }
        });

        //Steam
        steamR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(steamR);
                if (playArea1 == true) {
                    steamR.setLayoutX(115);
                    steamR.setLayoutY(12.5);
                } else {
                    steamR.setLayoutX(315);
                    steamR.setLayoutY(12.5);
                }
                playArea1 = false;
                steam = true;
                playAreaObjects++;
            }
        });

        //Dust
        dustR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(dustR);
                if (playArea1 == true) {
                    dustR.setLayoutX(115);
                    dustR.setLayoutY(12.5);
                } else {
                    dustR.setLayoutX(315);
                    dustR.setLayoutY(12.5);
                }
                playArea1 = false;
                dust = true;
                playAreaObjects++;
            }
        });

        //Glass
        glassR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(glassR);
                if (playArea1 == true) {
                    glassR.setLayoutX(115);
                    glassR.setLayoutY(12.5);
                } else {
                    glassR.setLayoutX(315);
                    glassR.setLayoutY(12.5);
                }
                playArea1 = false;
                glass = true;
                playAreaObjects++;
            }
        });

        //Lava
        lavaR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(lavaR);
                if (playArea1 == true) {
                    lavaR.setLayoutX(115);
                    lavaR.setLayoutY(12.5);
                } else {
                    lavaR.setLayoutX(315);
                    lavaR.setLayoutY(12.5);
                }
                playArea1 = false;
                lava = true;
                playAreaObjects++;
            }
        });

        //Iron
        ironR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(ironR);
                if (playArea1 == true) {
                    ironR.setLayoutX(115);
                    ironR.setLayoutY(12.5);
                } else {
                    ironR.setLayoutX(315);
                    ironR.setLayoutY(12.5);
                }
                playArea1 = false;
                iron = true;
                playAreaObjects++;
            }
        });

        //Sand
        sandR.setOnMouseClicked(e -> {
            if (playAreaObjects < 2) {
                pane.getChildren().add(sandR);
                if (playArea1 == true) {
                    sandR.setLayoutX(115);
                    sandR.setLayoutY(12.5);
                } else {
                    sandR.setLayoutX(315);
                    sandR.setLayoutY(12.5);
                }
                playArea1 = false;
                sand = true;
                playAreaObjects++;
            }
        });

//Button methods
        //Merge button
        mergeBtn.setOnAction(e -> {
            if (water == true && fire == true) {
                steamR.setVisible(true);
            }

            if (air == true && earth == true) {
                dustR.setVisible(true);
            }

            if (water == true && dust == true) {
                sandR.setVisible(true);
            }

            if (sand == true && fire == true) {
                glassR.setVisible(true);
            }

            if (dust == true && fire == true) {
                ironR.setVisible(true);
            }

            if (fire == true && earth == true) {
                lavaR.setVisible(true);
            }
        });

        //Clear button
        clearBtn.setOnAction(e -> {
            if (water == true) {
                gridPane1.add(waterR, 0, 0);
                water = false;
            }
            if (fire == true) {
                gridPane1.add(fireR, 1, 0);
                fire = false;
            }
            if (air == true) {
                gridPane1.add(airR, 2, 0);
                air = false;
            }
            if (earth == true) {
                gridPane1.add(earthR, 3, 0);
                earth = false;
            }
            if (steam == true) {
                gridPane1.add(steamR, 0, 1);
                steam = false;
            }
            if (dust == true) {
                gridPane1.add(dustR, 1, 1);
                dust = false;
            }
            if (glass == true) {
                gridPane1.add(glassR, 2, 1);
                glass = false;
            }
            if (lava == true) {
                gridPane1.add(lavaR, 3, 1);
                lava = false;
            }
            if (iron == true) {
                gridPane1.add(ironR, 0, 2);
                iron = false;
            }
            if (sand == true) {
                gridPane1.add(sandR, 1, 2);
                sand = false;
            }

            playAreaObjects = 0;
            playArea1 = true;

        });

        //Labels button
        labelsBtn.setOnAction(e -> {
            
            //showing labels 
            if (labelsBtn.isSelected() == true) {
                waterL.setVisible(true);
                fireL.setVisible(true);
                airL.setVisible(true);
                earthL.setVisible(true);
                steamL.setVisible(true);
                dustL.setVisible(true);
                glassL.setVisible(true);
                lavaL.setVisible(true);
                ironL.setVisible(true);
                sandL.setVisible(true);
                
            //water
                if (water == false) {
                    gridPane1.add(waterL, 0, 0);
                } else {
                    pane.getChildren().add(waterL);
                    waterL.setLayoutX(waterR.getLayoutX());
                    waterL.setLayoutY(waterR.getLayoutY());
                }
                
            //fire
                if (fire == false) {
                    gridPane1.add(fireL, 1, 0);
                } else {
                    pane.getChildren().add(fireL);
                    fireL.setLayoutX(fireR.getLayoutX());
                    fireL.setLayoutY(fireR.getLayoutY());
                }
                
            //air
                if (air == false) {
                    gridPane1.add(airL, 2, 0);
                } else {
                    pane.getChildren().add(airL);
                    airL.setLayoutX(airR.getLayoutX());
                    airL.setLayoutY(airR.getLayoutY());
                }
                
            //earth
                if (earth == false) {
                    gridPane1.add(earthL, 3, 0);
                } else {
                    pane.getChildren().add(earthL);
                    earthL.setLayoutX(earthR.getLayoutX());
                    earthL.setLayoutY(earthR.getLayoutY());
                }
                
            //steam
                if (steamR.isVisible() == true){    //TODO
                if (steam == false) {
                    gridPane1.add(steamL, 0, 1);
                } else {
                    pane.getChildren().add(steamL);
                    steamL.setLayoutX(steamR.getLayoutX());
                    steamL.setLayoutY(steamR.getLayoutY());
                }
                }
                
            //dust
                if (dustR.isVisible() == true){
                if (dust == false) {
                    gridPane1.add(dustL, 1, 1);
                } else {
                    pane.getChildren().add(dustL);
                    dustL.setLayoutX(dustR.getLayoutX());
                    dustL.setLayoutY(dustR.getLayoutY());
                }
                }
                
            //glass
                if (glassR.isVisible() == true){
                if (glass == false) {
                    gridPane1.add(glassL, 2, 1);
                } else {
                    pane.getChildren().add(glassL);
                    glassL.setLayoutX(glassR.getLayoutX());
                    glassL.setLayoutY(glassR.getLayoutY());
                }
                }
                
            //lava
                if (lavaR.isVisible() == true){
                if (lava == false) {
                    gridPane1.add(lavaL, 3, 1);
                } else {
                    pane.getChildren().add(lavaL);
                    lavaL.setLayoutX(lavaR.getLayoutX());
                    lavaL.setLayoutY(lavaR.getLayoutY());
                }
                }
                
            //iron
                if (ironR.isVisible() == true){
                if (iron == false) {
                    gridPane1.add(ironL, 0, 2);
                } else {
                    pane.getChildren().add(ironL);
                    ironL.setLayoutX(ironR.getLayoutX());
                    ironL.setLayoutY(ironR.getLayoutY());
                }
                }
                
            //sand
                if (sandR.isVisible() == true){
                if (sand == false) {
                    gridPane1.add(sandL, 1, 2);
                } else {
                    pane.getChildren().add(sandL);
                    sandL.setLayoutX(sandR.getLayoutX());
                    sandL.setLayoutY(sandR.getLayoutY());
                }
                }
                
            //hiding labels    
            } else {
                waterL.setVisible(false);
                fireL.setVisible(false);
                airL.setVisible(false);
                earthL.setVisible(false);
                steamL.setVisible(false);
                dustL.setVisible(false);
                glassL.setVisible(false);
                lavaL.setVisible(false);
                ironL.setVisible(false);
                sandL.setVisible(false);
            }

        });

//seting stage
        Scene scene = new Scene(stackPane, 800, 600);

        primaryStage.setTitle("Element connect");
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
