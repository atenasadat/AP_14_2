package View;

import Controller.Controller;
import Model.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*public class View {
    public static void main(String[] args) {
        System.out.printf("hi");
        View view=new View();
        view.ReadInput();
    }

    public void ReadInput(){
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        String input=scanner.nextLine();
        while (!input.equals("end")) {
            input=scanner.nextLine();
            String commands[]=input.split(" ");
            controller.CommandAnalyzer(commands);
        }
    }

}*/

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class View extends Application {
    private Controller controller=new Controller();
    ChickenView chickenView;
    ArrayList<ChickenView> chickens = new ArrayList<>();

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Creating an image
        Image image = new Image(new FileInputStream("/Users/atena/Desktop/back.png"));

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(0);
        imageView.setY(0);

        //setting the fit height and width of the image view
        imageView.setFitHeight(1000);
        imageView.setFitWidth(1000);

        //Setting the preserve ratio of the image view
        // imageView.setPreserveRatio(true);


        //Creating a Group object
        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 1000, 1000);

        //Setting title to the Stage
        stage.setTitle("Loading an image");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        Circle chicken=new Circle(50,50,30);
        Image img=new Image(new FileInputStream("/Users/atena/Desktop/test.png"));
        chicken.setFill(new ImagePattern(img));
        root.getChildren().add(chicken);

        Circle caw = new Circle(130,50,30);
        Image img1 = new Image(new FileInputStream("/Users/atena/Desktop/test.png"));
        caw.setFill(new ImagePattern(img1));
        root.getChildren().add(caw);

        Circle sheep = new Circle(210,50,30);
        Image img2 = new Image(new FileInputStream("/Users/atena/Desktop/test.png"));
        sheep.setFill(new ImagePattern(img2));
        root.getChildren().add(sheep);
///draw well
        Image wellimage=new Image(new FileInputStream("/Users/atena/Desktop/well.png"));
        ImageView wellimg=new ImageView(wellimage);
        wellimg.setX(380);
        wellimg.setY(150);
        root.getChildren().add(wellimg);

        wellimg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                int COLUMNS  =  4;
                int COUNT    =  5;
                int OFFSET_X =  20;
                int OFFSET_Y =  20;
                int WIDTH    = 67;
                int HEIGHT   = 90;
                if(controller.FillWell()){
                    Image IMAGE = null;
                    try {
                        IMAGE = new Image(new FileInputStream("/Users/atena/Desktop/01.png"));

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                    final WellView imageView = new WellView(IMAGE);
                    imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));

                    final Animation animation = new SpriteAnimation(
                            imageView,
                            Duration.millis(1000),
                            COUNT, COLUMNS,
                            OFFSET_X, OFFSET_Y,
                            WIDTH, HEIGHT
                    );
                    animation.setCycleCount(Animation.INDEFINITE);
                    animation.play();
                    root.getChildren().add(imageView);

                }
            }
        });


//        Rectangle plantGrass=new Rectangle(600,600);
//        plantGrass.setTranslateX(300);
//        plantGrass.setTranslateY(300);
//        plantGrass.setFill(Color.BLUE);
//        root.getChildren().add(plantGrass);


        chicken.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (controller.addChicken()) {
                    int size  = controller.getMap().getFarm().getAnimalArrayList().size();

                    System.out.println( controller.getMap().getFarm().getAnimalArrayList().size());

                    try
                    {
                        chickenView = new ChickenView((Chicken)(controller.getMap().getFarm().getAnimalArrayList().get(size-1)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    chickenView.updateLocation();


                    root.getChildren().add(chickenView);
                    chickens.add(chickenView);
                }

            }
        });



        caw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.addCow();
            }
        });
        sheep.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.addSheep();
            }
        });


//        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//                System.out.println("salam");
//
//                chickenView.updateLocation();
//            }
//        });

        Timeline animation;
        animation = new Timeline(new KeyFrame(Duration.seconds(0.1), e -> updateLocations()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        stage.show();



    }

    public static void main(String[] args)
    {

        launch(args);
    }

    public void updateLocations()
    {
        for (int i = 0; i < chickens.size() ; i++) {

            if(controller.getMap().getFarm().getAnimalArrayList().get(i) instanceof Chicken)
            {
                chickens.get(i).updateLocation();
            }
        }
    }





}





