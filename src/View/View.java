package View;

import Controller.Controller;
import Model.*;

import java.sql.Time;
import java.util.ArrayList;

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

import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class View extends Application {
    private Controller controller=new Controller();
    ChickenView chickenView;
    CowView cowView;
    SheepView sheepView;
    ArrayList<ChickenView> chickenViews = new ArrayList<>();
    ArrayList<CowView> cowViews = new ArrayList<>();
    ArrayList<SheepView> sheepViews=new ArrayList<>();
    ArrayList<String> warehouseaddeditems = new ArrayList<>();

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        //Creating an image
        Image image = new Image(new FileInputStream("image/background.png"));

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
        stage.setTitle("FARM CRAZY!!");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        Circle chicken=new Circle(50,50,30);
        Image img=new Image(new FileInputStream("image/chicken.png"));
        chicken.setFill(new ImagePattern(img));
        root.getChildren().add(chicken);

        Circle cow = new Circle(130,50,30);
        Image img1 = new Image(new FileInputStream("image/down 1 copy.png"));
        cow.setFill(new ImagePattern(img1));
        root.getChildren().add(cow);

        Circle sheep = new Circle(210,50,30);
        Image img2 = new Image(new FileInputStream("image/sheep.png"));
        sheep.setFill(new ImagePattern(img2));
        root.getChildren().add(sheep);
        ///draw well//////

//        Image wellimage=new Image(new FileInputStream("image/well.png"));
//        ImageView wellimg=new ImageView(wellimage);
//        wellimg.setX(370);
//        wellimg.setY(150);
//        root.getChildren().add(wellimg);

        ////drae eggtoflur//////
//        Image eggtoflurimage = new Image(new FileInputStream("image/eggtoflur.png"));
//        ImageView eggtoflurimg = new ImageView(eggtoflurimage);
//        eggtoflurimg.setX(180);
//        eggtoflurimg.setY(250);
//        root.getChildren().add(eggtoflurimg);

//        eggtoflurimg.setFitWidth(180);
//        eggtoflurimg.setFitHeight(190);





        //draw warehouse///

        Image warehouseimage = new Image(new FileInputStream("image/warehouselvl0.png"));
        ImageView warehouseimg = new ImageView(warehouseimage);
        warehouseimg.setX(350);
        warehouseimg.setY(780);
        warehouseimg.setFitWidth(300);
        warehouseimg.setFitHeight(199);
        root.getChildren().add(warehouseimg);

        warehouseimg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                Rectangle depot = new Rectangle(200 , 230 ,600 ,400);
                depot.setArcHeight(35);
                depot.setArcWidth(35);
                depot.setFill(Color.rgb(242, 217, 181));
                root.getChildren().add(depot);
//              *******Fadind*****/////
//                FadeTransition ft = new FadeTransition(Duration.millis(3000), depot);
//                ft.setFromValue(1.0);
//                ft.setToValue(0.1);
//                ft.setCycleCount(Timeline.INDEFINITE);
//                ft.setAutoReverse(true);
//                ft.play();
            }
        });

        Image img_ = null;
        try {
            img_ = new Image(new FileInputStream("image/animationwell.png"));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        final ImageView wellView = new ImageView(img_);

        int COLUMNS = 8;
        int COUNT = 2;
        int OFFSET_X = 10;
        int OFFSET_Y = 10;
        int WIDTH = 150;
        int HEIGHT = 150;
        wellView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, WIDTH, HEIGHT));
        wellView.setX(380);
        wellView.setY(150);
        root.getChildren().add(wellView);

        ///+++++++++++++wWELL++++++/////

        wellView.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                    if (controller.FillWell())
                    {
                        System.out.println("in if");

                            final Animation animation = new SpriteAnimation(
                                    wellView,
                                    Duration.millis(1000),
                                    COUNT, COLUMNS,
                                    OFFSET_X, OFFSET_Y,
                                    WIDTH, HEIGHT
                            );
                            animation.setCycleCount(5);

                            //root.getChildren().remove(wellimg);
                            animation.play();


                    }
                }
//                Text text=new Text(400,150,"well is full");
//                root.getChildren().add(text);

        });

//+++++++++eggtoflur++++++++++++++//
        Image img1_ = null;
       // ImageView flourview = null;
        try {
            img1_ = new Image(new FileInputStream("image/animatedeggtoflurlvl0.png"));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        final ImageView eggtoflurview = new ImageView(img1_);
        int COLUMNS1 = 8;
        int COUNT1 = 3;
        int OFFSET_X1 = 10;
        int OFFSET_Y1 = 10;
        int WIDTH1= 131;
        int HEIGHT1 = 100;
        eggtoflurview.setViewport(new Rectangle2D(OFFSET_X1, OFFSET_Y1, WIDTH1, HEIGHT1));

        eggtoflurview.setX(210);
        eggtoflurview.setY(275);
        root.getChildren().add(eggtoflurview);



        eggtoflurview.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                if (controller.getMap().getEggToFlour().canproduce(controller.getMap().getWarehouse().getWarehouseItems()))
                {


                    final Animation animation = new SpriteAnimation(
                            eggtoflurview,
                            Duration.millis(1000),
                            COUNT1, COLUMNS1,
                            OFFSET_X1, OFFSET_Y1,
                            WIDTH1, HEIGHT1
                    );

                    animation.setCycleCount(5);
                    animation.setOnFinished(new EventHandler<ActionEvent>() {

                        Image flour = null;
                        public void handle(ActionEvent event) {

                            try {
                                flour = new Image(new FileInputStream("image/EggPowder.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView flourview  = new ImageView(flour);
                            flourview.setX(320);
                            flourview.setY(300);
                            root.getChildren().add(flourview);
                            flourview.setOnMouseClicked(new EventHandler<MouseEvent>()
                            {
                                Image flouricon = null;

                                @Override
                                public void handle(MouseEvent event)
                                {
                                    warehouseaddeditems.add("flour");
                                    if( controller.getMap().getWarehouse().AddItem(warehouseaddeditems))
                                    {

                                        try {
                                            flouricon = new Image(new FileInputStream("image/EggPowder.png"));
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }



                                    Rectangle rec = new Rectangle(400 ,900 , 25 , 25 );
                                     rec.setFill(new ImagePattern(flouricon));

                                    root.getChildren().add(rec);
                                    root.getChildren().remove(flourview);

                                     }
                                }
                            });

                        }
                    });
                    //root.getChildren().remove(eggtoflurimg);
                    animation.play();


               }

            }

        });

        ////???????BUG???????///




        ///+++++++++++++++bakecake++++++++//////


        Image img2_ = null;
        try {
            img2_ = new Image(new FileInputStream("image/bakecakelvl0.png"));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        final ImageView bakecake = new ImageView(img2_);
        int COLUMNS2 = 8;
        int COUNT2 = 3;
        int OFFSET_X2 = 10;
        int OFFSET_Y2 = 10;
        int WIDTH2= 135;
        int HEIGHT2 = 130;
        bakecake.setViewport(new Rectangle2D(OFFSET_X2, OFFSET_Y2, WIDTH2, HEIGHT2));

        bakecake.setX(650);
        bakecake.setY(230);
        root.getChildren().add(bakecake);


        bakecake.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
             if (controller.getMap().getBakeCake().canproduce(controller.getMap().getWarehouse().getWarehouseItems()))
               {


                    final Animation animation = new SpriteAnimation(
                            bakecake,
                            Duration.millis(1000),
                            COUNT2, COLUMNS2,
                            OFFSET_X2, OFFSET_Y2,
                            WIDTH2, HEIGHT2
                    );

                    animation.setCycleCount(5);
                    //root.getChildren().remove(eggtoflurimg);
                    animation.play();


                }
            }
        });
//        Rectangle plantGrass=new Rectangle(600,600);
//        plantGrass.setTranslateX(300);
//        plantGrass.setTranslateY(300);
//        plantGrass.setFill(Color.BLUE);
//        root.getChildren().add(plantGrass);


        ///+++++++++++++++clothtodress++++++++//////


        Image img3_ = null;
        try {
            img3_ = new Image(new FileInputStream("image/clothtodresslvl0.png"));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        final ImageView clothtodress = new ImageView(img3_);
        int COLUMNS3 = 8;
        int COUNT3 = 2;
        int OFFSET_X3 = 0;
        int OFFSET_Y3 = 5;
        int WIDTH3 = 170;
        int HEIGHT3 = 120;
        clothtodress.setViewport(new Rectangle2D(OFFSET_X3, OFFSET_Y3, WIDTH3, HEIGHT3));

        clothtodress.setX(176);
        clothtodress.setY(425);
        root.getChildren().add(clothtodress);


        clothtodress.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                if (controller.getMap().getClothToDress().canproduce(controller.getMap().getWarehouse().getWarehouseItems()))
                {


                    final Animation animation = new SpriteAnimation(
                            clothtodress,
                            Duration.millis(1000),
                            COUNT3, COLUMNS3,
                            OFFSET_X3, OFFSET_Y3,
                            WIDTH3, HEIGHT3
                    );

                    animation.setCycleCount(5);
                    //root.getChildren().remove(eggtoflurimg);
                    animation.play();


                }
            }
        });

        ///+++++++++++++++cottontofiber++++++++//////


        Image img4_ = null;
        try {
            img4_ = new Image(new FileInputStream("image/cottontofiberlvl0.png"));

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        final ImageView cottontofiber = new ImageView(img4_);
        int COLUMNS4 = 8;
        int COUNT4 = 2;
        int OFFSET_X4 = 0;
        int OFFSET_Y4 = 5;
        int WIDTH4 = 130;
        int HEIGHT4 = 100;
        cottontofiber.setViewport(new Rectangle2D(OFFSET_X4, OFFSET_Y4, WIDTH4, HEIGHT4));

        cottontofiber.setX(130);
        cottontofiber.setY(670);
        root.getChildren().add(cottontofiber);


        cottontofiber.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
               if (controller.getMap().getCottonToFiber().canproduce(controller.getMap().getWarehouse().getWarehouseItems()))
                {


                    final Animation animation = new SpriteAnimation(
                            cottontofiber,
                            Duration.millis(1000),
                            COUNT4, COLUMNS4,
                            OFFSET_X4, OFFSET_Y4,
                            WIDTH4, HEIGHT4
                    );

                    animation.setCycleCount(5);
                    //root.getChildren().remove(eggtoflurimg);
                    animation.play();


                }
            }
        });












        chicken.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (controller.addChicken())
                {
                    int size  = controller.getMap().getFarm().getAnimalArrayList().size();

                    System.out.println( "number of animals:"+controller.getMap().getFarm().getAnimalArrayList().size());
                    try
                    {
                        chickenView = new ChickenView((Chicken)(controller.getMap().getFarm().getAnimalArrayList().get(size-1)));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    chickenView.updateLocation();
                    root.getChildren().add(chickenView);
                    chickenViews.add(chickenView);
                }
            }
        });

        cow.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event)
            {
                if(controller.addCow())
               {
                   int size  = controller.getMap().getFarm().getAnimalArrayList().size();

                   try
                   {
                       cowView = new CowView((Cow)(controller.getMap().getFarm().getAnimalArrayList().get(size-1)));

                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   }
                   cowView.updateLocation();

                   root.getChildren().add(cowView);
                   cowViews.add(cowView);
               }
            }
        });
////************** here is sheep

        sheep.setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event) {
              if(controller.addSheep())
              {
                  int size  = controller.getMap().getFarm().getAnimalArrayList().size();
                  try {
                      sheepView = new SheepView((Sheep)(controller.getMap().getFarm().getAnimalArrayList().get(size-1)));
                  } catch (FileNotFoundException e) {
                      e.printStackTrace();
                  }
                    sheepView.updateLocation();
                    root.getChildren().add(sheepView);
                    sheepViews.add(sheepView);

              }
            }
        });


        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                controller.getMap().getWell().Fill();
            }
        };


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
        for (int i = 0; i < chickenViews.size(); i++) {
            chickenViews.get(i).updateLocation();
        }
        for (int i = 0; i < cowViews.size(); i++) {
            cowViews.get(i).updateLocation();
        }

        for (int i = 0; i <sheepViews.size() ; i++) {
            sheepViews.get(i).updateLocation();

        }
    }
}





