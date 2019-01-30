package View;

import Controller.Controller;
import Model.*;

import java.io.FilterInputStream;
import java.util.ArrayList;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class View extends Application
{
    private Controller controller=new Controller();
    ChickenView chickenView;
    CowView cowView;
    SheepView sheepView;
    ArrayList<ChickenView> chickenViews = new ArrayList<>();
    ArrayList<CowView> cowViews = new ArrayList<>();
    ArrayList<SheepView> sheepViews=new ArrayList<>();
    ArrayList<String> warehouseaddeditems = new ArrayList<>();
    ArrayList<String> sellingitems = new ArrayList<>();
    boolean eggflag = false;
    boolean dressflag = false;
    boolean fiberflag = false;
    boolean clothflag = false;
    boolean cottonflag = false;
    boolean flourflag = false;
    int  finalpriceofsell =0;


        @Override
        public void start(Stage stage) throws FileNotFoundException {

        Image image = new Image(new FileInputStream("image/background.png"));

        ImageView imageView = new ImageView(image);

        imageView.setX(0);
        imageView.setY(0);

        imageView.setFitHeight(1000);
        imageView.setFitWidth(1000);

        Group root = new Group(imageView);

        Scene scene = new Scene(root, 1000, 1000);

        stage.setTitle("THIS IS FARM CRAZY!!");

        stage.setScene(scene);




        Image background = new Image(new FileInputStream("image/frobuy2 copy.png"));
        ImageView shapebg = new ImageView(background);
        shapebg.setX(-100);
        shapebg.setY(-120);
        shapebg.setFitHeight(300);
        shapebg.setFitWidth(300);
        root.getChildren().add(shapebg);

        Text chickencost = new Text("100");
        chickencost.setFont(Font.font("Marker Felt"  , 13));
        chickencost.setX(40);
        chickencost.setY(85);
        root.getChildren().add(chickencost);



        Circle chicken=new Circle(50,50,30);
        Image img=new Image(new FileInputStream("image/chicken.png"));
        chicken.setFill(new ImagePattern(img));
        root.getChildren().add(chicken);


            Image cowbackground = new Image(new FileInputStream("image/frobuy2 copy.png"));
            ImageView cowshapebg = new ImageView(cowbackground);
            cowshapebg.setX(-19);
            cowshapebg.setY(-120);
            cowshapebg.setFitHeight(300);
            cowshapebg.setFitWidth(300);
            root.getChildren().add(cowshapebg);

            Text cowcost = new Text("200");
            cowcost.setFont(Font.font("Marker Felt"  , 13));
            cowcost.setX(120);
            cowcost.setY(85);
            root.getChildren().add(cowcost);


            Circle cow = new Circle(130,50,30);
            Image img1 = new Image(new FileInputStream("image/down 1 copy.png"));
            cow.setFill(new ImagePattern(img1));
            root.getChildren().add(cow);

            Image sheepbackground = new Image(new FileInputStream("image/frobuy2 copy.png"));
            ImageView sheepbg = new ImageView(sheepbackground);
            sheepbg.setX(59);
            sheepbg.setY(-121);
            sheepbg.setFitHeight(300);
            sheepbg.setFitWidth(300);
            root.getChildren().add(sheepbg);

            Text sheepcost = new Text("150");
            sheepcost.setFont(Font.font("Marker Felt"  , 13));
            sheepcost.setX(195);
            sheepcost.setY(83);
            root.getChildren().add(sheepcost);


        Circle sheep = new Circle(210,50,30);
        Image img2 = new Image(new FileInputStream("image/sheep.png"));
        sheep.setFill(new ImagePattern(img2));
        root.getChildren().add(sheep);

        //@@@@ draw warehouse////

        Image warehouseimage = new Image(new FileInputStream("image/warehouselvl0.png"));
        ImageView warehouseimg = new ImageView(warehouseimage);
        warehouseimg.setX(350);
        warehouseimg.setY(780);
        warehouseimg.setFitWidth(300);
        warehouseimg.setFitHeight(199);
        root.getChildren().add(warehouseimg);


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
            public void handle(MouseEvent event)
            {
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



        warehouseimg.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            HBox inlineitem = null;
            @Override
            public void handle(MouseEvent event)
            {

                Image depotshow = null;

                try
                {
                    depotshow = new Image(new FileInputStream("image/depotshow.png"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                ImageView depot = new ImageView(depotshow);
                depot.setX(5);
                depot.setY(10);
                depot.setFitWidth(1000);
                depot.setFitHeight(1000);
               root.getChildren().add(depot);

                /// %%%%%%%% TO SHOW THE WAREHOUSE ARRAYLIST
///////////////////////////////////////////////////////////////


                VBox showitems = new VBox();
                showitems.setPadding(new Insets(250 , 25 ,12 ,300));
                showitems.setAlignment(Pos.CENTER);

                HBox attribute = new HBox();
                Text itemname= new Text("NAME");
                itemname.setFont(Font.font("Marker Felt" , 20));
                itemname.setFill(Color.rgb(79, 39, 35));
                Text numberofitem = new Text("Counts");
                attribute.getChildren().add(itemname);
                numberofitem.setFont(Font.font("Marker Felt"));
                itemname.setFill(Color.rgb(79, 39, 35));
                numberofitem.setFill(Color.rgb(79 , 39 ,35));

                numberofitem.setFont(Font.font("Marker Felt" , 20));

                Text costitem = new Text("Cost");
                costitem.setFill(Color.rgb(79, 39, 35));

                costitem.setFont(Font.font("Marker Felt" , 20 ));
                attribute.getChildren().add(costitem);
                attribute.getChildren().add(numberofitem);

                attribute.setPadding(new Insets(50  , 0 ,0 ,60));
                attribute.setSpacing(30);
                showitems.getChildren().add(attribute);



                for (int  i = controller.getMap().getWarehouse().getWarehouseItems().size()-1; i >=0 ; i--)
                {
                    if (controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals("flour")) {
                       if (flourflag == false) {
                            Image flouimg = null;
                            try {
                                flouimg = new Image(new FileInputStream("image/EggPowder.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView flourimage;
                            flourimage = new ImageView(flouimg);

                            inlineitem = new HBox();
                            inlineitem.setAlignment(Pos.CENTER);
                            inlineitem.getChildren().add(flourimage);


                            Text name = new Text();
                            name.setText(controller.getMap().getWarehouse().getWarehouseItems().get(i).getType());
                            name.setFont(Font.font("Marker Felt", 20));


                            inlineitem.getChildren().add(name);

                            Text count = new Text();
                            count.setText(Integer.toString(controller.getMap().getWarehouse().countof("flour")));
                            count.setFont(Font.font("Marker Felt", 22));

                            Text cost = new Text();
                            cost.setText(Integer.toString(controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost()));
                            cost.setFont(Font.font("Marker Felt", 22));
                            inlineitem.getChildren().add(cost);

                            Text addfunc = new Text();
                            addfunc.setText("     Add for sell");
                            addfunc.setFont(Font.font("Marker Felt", 18));

                            addfunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event)
                                {


                                if (controller.getMap().getTruck().Travel
                                (controller.getMap().getFarm().getCageanimal(), controller.getMap().getWarehouse().getWarehouseItems(), "flour"))
                                    {
                                        sellingitems.add("flour");
                                        calcfianlpriceforsell("flour");
                                    }
                                }
                            });


                            inlineitem.getChildren().add(count);
                            inlineitem.spacingProperty();

                            inlineitem.getChildren().add(addfunc);
                            inlineitem.setSpacing(30);

                            showitems.getChildren().add(inlineitem);
                               flourflag = true;
                       }

                    }

                    if (controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals("dress")) {
                        HBox inlineitem = new HBox();
                       if (dressflag == false) {
                            Image dressimg = null;
                            try {
                                dressimg = new Image(new FileInputStream("image/dress.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView dressimage = new ImageView(dressimg);

                            Text name = new Text();
                            name.setText("dress");
                            name.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(dressimage);
                            inlineitem.getChildren().add(name);

                            Text cost = new Text();
                            cost.setText(Integer.toString(controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost()));
                            cost.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(cost);


                            Text count = new Text();
                            inlineitem.getChildren().add(count);

                            count.setText(Integer.toString(controller.getMap().getWarehouse().countof("dress")));
                            count.setFont(Font.font("Marker Felt", 20));


                            Text addfunc = new Text();
                            addfunc.setText("     Add for sell");
                            addfunc.setFont(Font.font("Marker Felt", 18));


                            addfunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event)
                                {
                                    if (controller.getMap().getTruck().Travel
                                  (controller.getMap().getFarm().getCageanimal(), controller.getMap().getWarehouse().getWarehouseItems(),"dress"))
                                    {
                                        sellingitems.add("dress");
                                        calcfianlpriceforsell("dress");
                                    }
                                }
                            });

                            inlineitem.getChildren().add(addfunc);
                            inlineitem.setSpacing(35);

                            showitems.getChildren().add(inlineitem);
                               dressflag = true;
                       }

                    }

                    if (controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals("egg")) {

                        HBox inlineitem = new HBox();

                        if (eggflag == false) {



                            Image eggimg = null;
                            try {
                                eggimg = new Image(new FileInputStream("image/egg.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView eggimage = new ImageView(eggimg);

                            Text name = new Text();
                            name.setText("egg");
                            name.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(eggimage);

                            inlineitem.getChildren().add(name);

                            Text cost = new Text();
                            cost.setText(Integer.toString(controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost()));
                            cost.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(cost);


                            Text count = new Text();
                            inlineitem.getChildren().add(count);

                            count.setText(Integer.toString(controller.getMap().getWarehouse().countof("egg")));
                            count.setFont(Font.font("Marker Felt", 20));


                            Text addfunc = new Text();
                            addfunc.setText("     Add for sell");
                            addfunc.setFont(Font.font("Marker Felt", 18));

                            addfunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {

                                    if (controller.getMap().getTruck().Travel
                                            (controller.getMap().getFarm().getCageanimal(), controller.getMap().getWarehouse().getWarehouseItems(),"egg"))
                                    {
                                        sellingitems.add("egg");
                                        calcfianlpriceforsell("egg");
                                    }
                                }
                            });
                            inlineitem.getChildren().add(addfunc);
                            inlineitem.setSpacing(35);

                            showitems.getChildren().add(inlineitem);
                            eggflag = true;
                        }

                    }





                    if (controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals("fiber")) {
                       if (fiberflag == false) {
                            Image fiberimg = null;
                            try {
                                fiberimg = new Image(new FileInputStream("image/fiber.png"));
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            ImageView fiberimage = new ImageView(fiberimg);
                            HBox inlineitem = new HBox();

                            Text name = new Text();
                            name.setText("fiber");
                            name.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(fiberimage);

                            inlineitem.getChildren().add(name);

                            Text cost = new Text();
                            cost.setText(Integer.toString(controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost()));
                            cost.setFont(Font.font("Marker Felt", 20));
                            inlineitem.getChildren().add(cost);


                            Text count = new Text();
                            inlineitem.getChildren().add(count);

                            count.setText(Integer.toString(controller.getMap().getWarehouse().countof("fiber")));
                            count.setFont(Font.font("Marker Felt", 20));


                            Text addfunc = new Text();
                            addfunc.setText("     Add for sell");
                            addfunc.setFont(Font.font("Marker Felt", 18));

                            addfunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    if (controller.getMap().getTruck().Travel
                                            (controller.getMap().getFarm().getCageanimal(), controller.getMap().getWarehouse().getWarehouseItems(),"fiber")) {
                                        sellingitems.add("fiber");
                                        calcfianlpriceforsell("fiber");
                                    }

                                }
                            });
                            inlineitem.getChildren().add(addfunc);
                            inlineitem.setSpacing(35);

                            showitems.getChildren().add(inlineitem);
                               fiberflag  = true;
                        }


                    }
                    if (controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals("cloth")) {

                    if (clothflag == false) {

                    Image clothimg = null;
                    try
                    {
                        clothimg = new Image(new FileInputStream("image/cloth.png"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    ImageView clothimage = new ImageView(clothimg);
                    HBox inlineitem = new HBox();

                    Text name = new Text();
                    name.setText("cloth");
                    name.setFont(Font.font("Marker Felt", 20));
                    inlineitem.getChildren().add(clothimage);

                    inlineitem.getChildren().add(name);

                    Text cost = new Text();
                    cost.setText(Integer.toString(controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost()));
                    cost.setFont(Font.font("Marker Felt", 20));
                    inlineitem.getChildren().add(cost);


                    Text count = new Text();
                    inlineitem.getChildren().add(count);

                    count.setText(Integer.toString(controller.getMap().getWarehouse().countof("cloth")));
                    count.setFont(Font.font("Marker Felt", 20));


                    Text addfunc = new Text();
                    addfunc.setText("     Add for sell");
                    addfunc.setFont(Font.font("Marker Felt", 18));

                    addfunc.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (controller.getMap().getTruck().Travel
                                    (controller.getMap().getFarm().getCageanimal(), controller.getMap().getWarehouse().getWarehouseItems(),"cloth")) {
                                sellingitems.add("cloth");
                                calcfianlpriceforsell("cloth");

                            }
                            for (int j = 0; j <sellingitems.size() ; j++)
                            {
                                System.out.println("itemsforsells"+ sellingitems);
                                System.out.println("finalpriceofsell"+finalpriceofsell);
                            }


                        }
                    });


                    inlineitem.getChildren().add(addfunc);
                    inlineitem.setSpacing(35);

                    showitems.getChildren().add(inlineitem);
                    //                 clothflag = true;
                    root.getChildren().add(showitems);
                      }

                }

                        ///// for the exit



                }
                Image exitdepot = null;

                try
                {
                    exitdepot = new Image(new FileInputStream("image/exitdepot.png"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                ImageView exitofdepot = new ImageView(exitdepot);
                exitofdepot.setX(380);
                exitofdepot.setY(50);
                exitofdepot.setFitWidth(510);
                exitofdepot.setFitHeight(300);
                exitofdepot.setOpacity(0.0);
                root.getChildren().add(exitofdepot);



                Rectangle okdepot = new Rectangle(450, 760 , 100 , 50);
                okdepot.setFill(Color.RED);
                okdepot.setOpacity(0.0);
                root.getChildren().add(okdepot);


                Text text = new Text();
                text.setText("WAREHOUSE");
                text.setX(400);
                text.setY(200);
                text.setFill(Color.rgb(74,51,59));
                text.setFont(Font.font("Marker Felt", FontWeight.EXTRA_BOLD, FontPosture.ITALIC, 35));



                    Text sell = new Text();
                    sell.setText("Sell");
                    sell.setX(330);
                    sell.setY(770);
                    sell.setFont(Font.font("Marker Felt" ,FontWeight.EXTRA_BOLD , FontPosture.ITALIC , 25));

                    root.getChildren().add(text);
                    root.getChildren().add(sell);





                okdepot.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        root.getChildren().remove(depot);
                        root.getChildren().remove(text);
                        root.getChildren().remove(showitems);
                        root.getChildren().remove(sell);
                    }
                });


                exitofdepot.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event) {
                        root.getChildren().remove(depot);
                        root.getChildren().remove(text);
                        root.getChildren().remove(showitems);
                        root.getChildren().remove(sell);


                    }
                });

                 eggflag = false;
                 dressflag = false;
                 fiberflag = false;
                 clothflag = false;
                 cottonflag = false;
                 flourflag = false;

            }


        });



        //////@@@@@@@@@@@@@@@@@@ draw wellllll

        Image img_ = null;
        try
        {
            img_ = new Image(new FileInputStream("image/animationwell.png"));

        }
        catch (FileNotFoundException e)
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
                            animation.setOnFinished(new EventHandler<ActionEvent>()
                            {
                                @Override
                                public void handle(ActionEvent event) {
                                    Image wellfull = null;
                                    try {
                                        wellfull = new Image(new FileInputStream("image/well is full.png"));
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    ImageView wellisfull = new ImageView(wellfull);
                                    wellisfull.setX(320);
                                    wellisfull.setY(-40);
                                    wellisfull.setFitWidth(400);
                                    wellisfull.setFitHeight(400);
                                    root.getChildren().add(wellisfull);

                                    SequentialTransition sequentialTransition = new SequentialTransition(
                                            createFader(wellisfull)
                                    );
//
                                    sequentialTransition.play();

                                }
                            });



                    }

                }

        });

            ////+++++++++eggtoflur++++++++++++++//
        //////////////////////////////////////////////////////////////



        Image addworkshop1 = new Image(new FileInputStream("image/addworkshosps.png"));
        ImageView addeggtoflour = new ImageView(addworkshop1);
        addeggtoflour.setX(150);
        addeggtoflour.setY(150);
        addeggtoflour.setFitHeight(350);
        addeggtoflour.setFitWidth(350);
        root.getChildren().add(addeggtoflour);
        Text workshop1 = new Text("buy\nEggtpFlour\n workshop");
        workshop1.setFont(Font.font("Marker Felt" , 13));
        workshop1.setX(280);
        workshop1.setY(285);
        root.getChildren().add(workshop1);
        Text costofworkshop = new Text("cost is:"+Integer.toString(controller.getMap().getEggToFlour().getCost()));
        costofworkshop.setFont(Font.font("Marker Felt" , 15));
        costofworkshop.setX(300);
        costofworkshop.setY(330);
        costofworkshop.setFill(Color.rgb(163, 3, 3));
        root.getChildren().add(costofworkshop);



workshop1.setOnMouseClicked(new EventHandler<MouseEvent>() {




    @Override
    public void handle(MouseEvent event) {

        if (controller.getMap().addworkshop("eggtoflour")) {
            Image img1_ = null;
            try {
                img1_ = new Image(new FileInputStream("image/animatedeggtoflurlvl0.png"));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final ImageView eggtoflurview = new ImageView(img1_);
            int COLUMNS1 = 8;
            int COUNT1 = 3;
            int OFFSET_X1 = 10;
            int OFFSET_Y1 = 10;
            int WIDTH1 = 131;
            int HEIGHT1 = 100;
            eggtoflurview.setViewport(new Rectangle2D(OFFSET_X1, OFFSET_Y1, WIDTH1, HEIGHT1));

            eggtoflurview.setX(210);
            eggtoflurview.setY(275);
            root.getChildren().add(eggtoflurview);


            eggtoflurview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.getMap().getEggToFlour().canproduce(controller.getMap().getWarehouse().getWarehouseItems())) {
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
                                ImageView flourview = new ImageView(flour);
                                flourview.setX(320);
                                flourview.setY(300);
                                root.getChildren().add(flourview);
                                flourview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    Image flouricon = null;

                                    @Override
                                    public void handle(MouseEvent event) {
                                        warehouseaddeditems.add("flour");
                                        if (controller.getMap().getWarehouse().AddItem(warehouseaddeditems)) {

                                            try {
                                                flouricon = new Image(new FileInputStream("image/EggPowder.png"));
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }


                                            Rectangle rec = new Rectangle(400, 900, 25, 25);
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
            root.getChildren().remove(addeggtoflour);
            root.getChildren().remove(costofworkshop);
            root.getChildren().remove(workshop1);


        }
        else
        {
            try
            {
                Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                ImageView Nomoney = new ImageView(nomoney);
                Nomoney.setY(-50);
                Nomoney.setX(300);
                Nomoney.setFitWidth(800);
                Nomoney.setFitHeight(600);



                Path path = new Path();
                path.getElements().add(new MoveTo(20,20));
                path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                PathTransition pathTransition = new PathTransition();
                pathTransition.setDuration(Duration.millis(4000));
                pathTransition.setPath(path);
                pathTransition.setNode(Nomoney);
                pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                pathTransition.setCycleCount(1);
                pathTransition.setAutoReverse(true);
                pathTransition.play();

                pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        FadeTransition fader = createFader(Nomoney);

                        SequentialTransition blinkThenFade = new SequentialTransition(
                                Nomoney,
                                fader
                        );
                        blinkThenFade.play();
                    }
                });


                root.getChildren().add(Nomoney);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
});



        ///+++++++++++++++bakecake++++++++//////




        Image addworkshop2 = new Image(new FileInputStream("image/addworkshosps.png"));

        ImageView addbakecake = new ImageView(addworkshop2);
        addbakecake.setX(520);
        addbakecake.setY(100);
        addbakecake.setFitHeight(350);
        addbakecake.setFitWidth(350);
        root.getChildren().add(addbakecake);

        Text workshop2 = new Text("buy\nBakeCake\n workshop");
        workshop2.setFont(Font.font("Marker Felt" , 13));
        workshop2.setX(670);
        workshop2.setY(235);
        root.getChildren().add(workshop2);

        Text costofworkshop2 = new Text("cost is:"+ Integer.toString(controller.getMap().getBakeCake().getCost()));
        costofworkshop2.setFont(Font.font("Marker Felt" , 15));
        costofworkshop2.setX(670);
        costofworkshop2.setY(280);
        costofworkshop2.setFill(Color.rgb(163, 3, 3));
        root.getChildren().add(costofworkshop2);

        workshop2.setOnMouseClicked(new EventHandler<MouseEvent>()
        {

            @Override
            public void handle(MouseEvent event)
            {
                if (controller.getMap().addworkshop("bakecake"))
                {
                    Image img2_ = null;
                    try {
                        img2_ = new Image(new FileInputStream("image/bakecakelvl0.png"));

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    final ImageView bakecake = new ImageView(img2_);
                    int COLUMNS2 = 8;
                    int COUNT2 = 3;
                    int OFFSET_X2 = 10;
                    int OFFSET_Y2 = 10;
                    int WIDTH2 = 135;
                    int HEIGHT2 = 130;
                    bakecake.setViewport(new Rectangle2D(OFFSET_X2, OFFSET_Y2, WIDTH2, HEIGHT2));

                    bakecake.setX(650);
                    bakecake.setY(230);
                    root.getChildren().add(bakecake);


                    bakecake.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            if (controller.getMap().getBakeCake().canproduce(controller.getMap().getWarehouse().getWarehouseItems())) {


                                final Animation animation = new SpriteAnimation(
                                        bakecake,
                                        Duration.millis(1000),
                                        COUNT2, COLUMNS2,
                                        OFFSET_X2, OFFSET_Y2,
                                        WIDTH2, HEIGHT2
                                );

                                animation.setCycleCount(5);
                                ///produce cake///
                                animation.setOnFinished(new EventHandler<ActionEvent>() {

                                    Image cake = null;

                                    public void handle(ActionEvent event) {

                                        try {
                                            cake = new Image(new FileInputStream("image/Cake.png"));
                                        } catch (FileNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                        ImageView cakeview = new ImageView(cake);
                                        cakeview.setX(630);
                                        cakeview.setY(350);
                                        root.getChildren().add(cakeview);
                                        cakeview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                            Image cakeicon = null;

                                            @Override
                                            public void handle(MouseEvent event) {

                                                warehouseaddeditems.add("cake");
                                                if (controller.getMap().getWarehouse().AddItem(warehouseaddeditems)) {

                                                    try {
                                                        cakeicon = new Image(new FileInputStream("image/Cake.png"));
                                                    } catch (FileNotFoundException e) {
                                                        e.printStackTrace();
                                                    }


                                                    Rectangle rec = new Rectangle(400, 900, 25, 25);
                                                    rec.setFill(new ImagePattern(cakeicon));

                                                    root.getChildren().add(rec);
                                                    root.getChildren().remove(cakeview);

                                                }
                                            }
                                        });

                                    }
                                });
                                animation.play();


                            }
                        }
                    });
                    root.getChildren().remove(workshop2);
                    root.getChildren().remove(costofworkshop2);
                    root.getChildren().remove(addbakecake);

                }
                else
                {
                    try
                    {
                        Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                        ImageView Nomoney = new ImageView(nomoney);
                        Nomoney.setY(-50);
                        Nomoney.setX(300);
                        Nomoney.setFitWidth(800);
                        Nomoney.setFitHeight(600);



                        Path path = new Path();
                        path.getElements().add(new MoveTo(20,20));
                        path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                        PathTransition pathTransition = new PathTransition();
                        pathTransition.setDuration(Duration.millis(4000));
                        pathTransition.setPath(path);
                        pathTransition.setNode(Nomoney);
                        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                        pathTransition.setCycleCount(1);
                        pathTransition.setAutoReverse(true);
                        pathTransition.play();

                        pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                FadeTransition fader = createFader(Nomoney);

                                SequentialTransition blinkThenFade = new SequentialTransition(
                                        Nomoney,
                                        fader
                                );
                                blinkThenFade.play();
                            }
                        });


                        root.getChildren().add(Nomoney);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }


                }


            }

});



        ///+++++++++++++++fibertocloth++++++++//////

            Image addworkshop3 = new Image(new FileInputStream("image/addworkshosps.png"));
            ImageView addfibertocloth = new ImageView(addworkshop3);

            addfibertocloth.setX(550);
            addfibertocloth.setY(300);
            addfibertocloth.setFitHeight(350);
            addfibertocloth.setFitWidth(350);
            root.getChildren().add(addfibertocloth);
            Text workshop3 = new Text("buy\nFibertoCloth\n workshop");
            workshop3.setFont(Font.font("Marker Felt" , 13));
            workshop3.setX(680);
            workshop3.setY(440);
            root.getChildren().add(workshop3);
            Text costofworkshop3 = new Text("cost is:"+Integer.toString(controller.getMap().getFiberToCloth().getCost()));
            costofworkshop3.setFont(Font.font("Marker Felt" , 15));
            costofworkshop3.setX(690);
            costofworkshop3.setY(483);
            costofworkshop3.setFill(Color.rgb(163, 3, 3));
            root.getChildren().add(costofworkshop3);
            workshop3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.getMap().addworkshop("fibertocloth")) {
                        Image img5_ = null;
                        try {
                            img5_ = new Image(new FileInputStream("image/fibertoclothlvl0.png"));

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                        final ImageView fibertocloth = new ImageView(img5_);
                        int COLUMNS5 = 8;
                        int COUNT5 = 2;
                        int OFFSET_X5 = 3;
                        int OFFSET_Y5 = 4;
                        int WIDTH5 = 157;
                        int HEIGHT5 = 110;
                        fibertocloth.setViewport(new Rectangle2D(OFFSET_X5, OFFSET_Y5, WIDTH5, HEIGHT5));

                        fibertocloth.setX(650);
                        fibertocloth.setY(500);
                        root.getChildren().add(fibertocloth);


                        fibertocloth.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                if (controller.getMap().getBakeCake().canproduce(controller.getMap().getWarehouse().getWarehouseItems())) {


                                    final Animation animation = new SpriteAnimation(
                                            fibertocloth,
                                            Duration.millis(1000),
                                            COUNT5, COLUMNS5,
                                            OFFSET_X5, OFFSET_Y5,
                                            WIDTH5, HEIGHT5
                                    );

                                    animation.setCycleCount(5);
                                    ///produce cake///
                                    animation.setOnFinished(new EventHandler<ActionEvent>() {

                                        Image cloth = null;

                                        public void handle(ActionEvent event) {

                                            try {
                                                cloth = new Image(new FileInputStream("image/cloth.png"));
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            ImageView clothview = new ImageView(cloth);
                                            clothview.setX(630);
                                            clothview.setY(570);
                                            root.getChildren().add(clothview);
                                            clothview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                Image clothicon = null;

                                                @Override
                                                public void handle(MouseEvent event) {

                                                    warehouseaddeditems.add("cloth");
                                                    if (controller.getMap().getWarehouse().AddItem(warehouseaddeditems)) {

                                                        try {
                                                            clothicon = new Image(new FileInputStream("image/cloth.png"));
                                                        } catch (FileNotFoundException e) {
                                                            e.printStackTrace();
                                                        }


                                                        Rectangle rec = new Rectangle(400, 900, 25, 25);
                                                        rec.setFill(new ImagePattern(clothicon));

                                                        root.getChildren().add(rec);
                                                        root.getChildren().remove(clothview);

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
                        root.getChildren().remove(workshop3);
                        root.getChildren().remove(costofworkshop3);
                        root.getChildren().remove(addfibertocloth);

                    } else {
                        try {
                            Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                            ImageView Nomoney = new ImageView(nomoney);
                            Nomoney.setY(-50);
                            Nomoney.setX(300);
                            Nomoney.setFitWidth(800);
                            Nomoney.setFitHeight(600);


                            Path path = new Path();
                            path.getElements().add(new MoveTo(20, 20));
                            path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(4000));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Nomoney);
                            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                            pathTransition.setCycleCount(1);
                            pathTransition.setAutoReverse(true);
                            pathTransition.play();

                            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    FadeTransition fader = createFader(Nomoney);

                                    SequentialTransition blinkThenFade = new SequentialTransition(
                                            Nomoney,
                                            fader
                                    );
                                    blinkThenFade.play();
                                }
                            });


                            root.getChildren().add(Nomoney);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }

            });



        ///+++++++++++++++clothtodress++++++++//////



            Image addworkshop4 = new Image(new FileInputStream("image/addworkshosps.png"));
            ImageView addclothtodress = new ImageView(addworkshop4);

            addclothtodress.setX(80);
            addclothtodress.setY(285);
            addclothtodress.setFitHeight(350);
            addclothtodress.setFitWidth(350);
            root.getChildren().add(addclothtodress);
            Text workshop4 = new Text("buy\nClothtoDress\n workshop");
            workshop4.setFont(Font.font("Marker Felt" , 13));
            workshop4.setX(210);
            workshop4.setY(418);
            root.getChildren().add(workshop4);
            Text costofworkshop4 = new Text("cost is:" + Integer.toString(controller.getMap().getClothToDress().getCost()));
            costofworkshop4.setFont(Font.font("Marker Felt" , 15));
            costofworkshop4.setX(210);
            costofworkshop4.setY(463);
            costofworkshop4.setFill(Color.rgb(163, 3, 3));
            root.getChildren().add(costofworkshop4);



            workshop4.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.getMap().addworkshop("clothtodress")) {
                        Image img3_ = null;
                        try {
                            img3_ = new Image(new FileInputStream("image/clothtodresslvl0.png"));

                        } catch (FileNotFoundException e) {
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
                            public void handle(MouseEvent event) {
                                if (controller.getMap().getClothToDress().canproduce(controller.getMap().getWarehouse().getWarehouseItems())) {


                                    final Animation animation = new SpriteAnimation(
                                            clothtodress,
                                            Duration.millis(1000),
                                            COUNT3, COLUMNS3,
                                            OFFSET_X3, OFFSET_Y3,
                                            WIDTH3, HEIGHT3
                                    );

                                    animation.setCycleCount(5);
                                    animation.setOnFinished(new EventHandler<ActionEvent>() {

                                        Image dress = null;

                                        public void handle(ActionEvent event) {

                                            try {
                                                dress = new Image(new FileInputStream("image/dress.png"));
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            ImageView dressview = new ImageView(dress);
                                            dressview.setX(300);
                                            dressview.setY(505);
                                            root.getChildren().add(dressview);
                                            dressview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                Image dressicon = null;

                                                @Override
                                                public void handle(MouseEvent event) {

                                                    warehouseaddeditems.add("dress");
                                                    if (controller.getMap().getWarehouse().AddItem(warehouseaddeditems)) {

                                                        try {
                                                            dressicon = new Image(new FileInputStream("image/dress.png"));
                                                        } catch (FileNotFoundException e) {
                                                            e.printStackTrace();
                                                        }


                                                        Rectangle rec = new Rectangle(420, 900, 25, 25);
                                                        rec.setFill(new ImagePattern(dressicon));

                                                        root.getChildren().add(rec);
                                                        root.getChildren().remove(dressview);

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
                        root.getChildren().remove(workshop4);
                        root.getChildren().remove(addclothtodress);
                        root.getChildren().remove(costofworkshop4);
                    }
                    else
                    {
                        try {
                            Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                            ImageView Nomoney = new ImageView(nomoney);
                            Nomoney.setY(-50);
                            Nomoney.setX(300);
                            Nomoney.setFitWidth(800);
                            Nomoney.setFitHeight(600);


                            Path path = new Path();
                            path.getElements().add(new MoveTo(20, 20));
                            path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(4000));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Nomoney);
                            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                            pathTransition.setCycleCount(1);
                            pathTransition.setAutoReverse(true);
                            pathTransition.play();

                            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    FadeTransition fader = createFader(Nomoney);

                                    SequentialTransition blinkThenFade = new SequentialTransition(
                                            Nomoney,
                                            fader
                                    );
                                    blinkThenFade.play();
                                }
                            });


                            root.getChildren().add(Nomoney);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });



        ///+++++++++++++++cottontofiber++++++++//////



            Image addworkshop5 = new Image(new FileInputStream("image/addworkshosps.png"));
            ImageView addcottontofiber = new ImageView(addworkshop5);

            addcottontofiber.setX(35);
            addcottontofiber.setY(497);
            addcottontofiber.setFitHeight(350);
            addcottontofiber.setFitWidth(350);
            root.getChildren().add(addcottontofiber);
            Text workshop5 = new Text("buy\nClothtoDress\n workshop");
            workshop5.setFont(Font.font("Marker Felt" , 13));
            workshop5.setX(160);
            workshop5.setY(632);
            root.getChildren().add(workshop5);
            Text costofworkshop5 = new Text("cost is:" + Integer.toString(controller.getMap().getClothToDress().getCost()));
            costofworkshop5.setFont(Font.font("Marker Felt" , 15));
            costofworkshop5.setX(180);
            costofworkshop5.setY(675);
            costofworkshop5.setFill(Color.rgb(163, 3, 3));
            root.getChildren().add(costofworkshop5);


            workshop5.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    if(controller.getMap().addworkshop("cottontofiber"))
                    {
                        Image img4_ = null;
                        try {
                            img4_ = new Image(new FileInputStream("image/cottontofiberlvl0.png"));

                        } catch (FileNotFoundException e)
                        {
                            e.printStackTrace();
                        }
                        final ImageView cottontofiber = new ImageView(img4_);
                        int COLUMNS4 = 8;
                        int COUNT4 = 6;
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
                                    animation.setOnFinished(new EventHandler<ActionEvent>() {

                                        Image fiber = null;
                                        public void handle(ActionEvent event) {

                                            try {
                                                fiber = new Image(new FileInputStream("image/cloth.png"));
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                            ImageView fiberview  = new ImageView(fiber);
                                            fiberview.setX(240);
                                            fiberview.setY(740);
                                            fiberview.setFitHeight(40);
                                            fiberview.setFitWidth(40);

                                            root.getChildren().add(fiberview);
                                            fiberview.setOnMouseClicked(new EventHandler<MouseEvent>()
                                            {
                                                Image fibericon = null;

                                                @Override
                                                public void handle(MouseEvent event)
                                                {

                                                    warehouseaddeditems.add("dress");
                                                    if( controller.getMap().getWarehouse().AddItem(warehouseaddeditems))
                                                    {

                                                        try
                                                        {
                                                            fibericon = new Image(new FileInputStream("image/cloth.png"));
                                                        } catch (FileNotFoundException e)
                                                        {
                                                            e.printStackTrace();
                                                        }

                                                        Rectangle rec = new Rectangle(420 ,900 , 25 , 25 );
                                                        rec.setFill(new ImagePattern(fibericon));

                                                        root.getChildren().add(rec);
                                                        root.getChildren().remove(fiberview);

                                                    }
                                                }
                                            });

                                        }
                                    });
                                    animation.play();


                                }
                            }
                        });
                        root.getChildren().remove(workshop5);
                        root.getChildren().remove(addcottontofiber);
                        root.getChildren().remove(costofworkshop5);

                    }
                    else
                    {


                        try {
                            Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                            ImageView Nomoney = new ImageView(nomoney);
                            Nomoney.setY(-50);
                            Nomoney.setX(300);
                            Nomoney.setFitWidth(800);
                            Nomoney.setFitHeight(600);


                            Path path = new Path();
                            path.getElements().add(new MoveTo(20, 20));
                            path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                            PathTransition pathTransition = new PathTransition();
                            pathTransition.setDuration(Duration.millis(4000));
                            pathTransition.setPath(path);
                            pathTransition.setNode(Nomoney);
                            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                            pathTransition.setCycleCount(1);
                            pathTransition.setAutoReverse(true);
                            pathTransition.play();

                            pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    FadeTransition fader = createFader(Nomoney);

                                    SequentialTransition blinkThenFade = new SequentialTransition(
                                            Nomoney,
                                            fader
                                    );
                                    blinkThenFade.play();
                                }
                            });


                            root.getChildren().add(Nomoney);
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }



                    }




                }
            });



        ///////**************flour to bread/********/////



            Image addworkshop6 = new Image(new FileInputStream("image/addworkshosps.png"));
            ImageView addflourtobread = new ImageView(addworkshop6);

            addflourtobread.setX(570);
            addflourtobread.setY(497);
            addflourtobread.setFitHeight(350);
            addflourtobread.setFitWidth(350);
            root.getChildren().add(addflourtobread);
            Text workshop6 = new Text("buy\nFlourtoBread\n workshop");
            workshop6.setFont(Font.font("Marker Felt" , 13));
            workshop6.setX(700);
            workshop6.setY(632);
            root.getChildren().add(workshop6);
            Text costofworkshop6 = new Text("cost is:" + Integer.toString(controller.getMap().getClothToDress().getCost()));
            costofworkshop6.setFont(Font.font("Marker Felt" , 15));
            costofworkshop6.setX(700);
            costofworkshop6.setY(675);
            costofworkshop6.setFill(Color.rgb(163, 3, 3));
            root.getChildren().add(costofworkshop6);

workshop6.setOnMouseClicked(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event)
    {
        if(controller.getMap().addworkshop("flourtobread")) {
            Image img6_ = null;
            try {
                img6_ = new Image(new FileInputStream("image/flurtobreadlvl0.png"));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            final ImageView flourtobread = new ImageView(img6_);
            int COLUMNS6 = 8;
            int COUNT6 = 2;
            int OFFSET_X6 = 0;
            int OFFSET_Y6 = 5;
            int WIDTH6 = 170;
            int HEIGHT6 = 175;
            flourtobread.setViewport(new Rectangle2D(OFFSET_X6, OFFSET_Y6, WIDTH6, HEIGHT6));

            flourtobread.setX(600);
            flourtobread.setY(610);
            root.getChildren().add(flourtobread);


            flourtobread.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (controller.getMap().getClothToDress().canproduce(controller.getMap().getWarehouse().getWarehouseItems())) {


                        final Animation animation = new SpriteAnimation(
                                flourtobread,
                                Duration.millis(1000),
                                COUNT6, COLUMNS6,
                                OFFSET_X6, OFFSET_Y6,
                                WIDTH6, HEIGHT6
                        );

                        animation.setCycleCount(5);
                        animation.setOnFinished(new EventHandler<ActionEvent>() {

                            Image bread = null;

                            public void handle(ActionEvent event) {

                                try {
                                    bread = new Image(new FileInputStream("image/bread.png"));
                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                }
                                ImageView breadview = new ImageView(bread);
                                breadview.setX(550);
                                breadview.setY(700);
                                root.getChildren().add(breadview);
                                breadview.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                    Image breadicon = null;

                                    @Override
                                    public void handle(MouseEvent event) {

                                        warehouseaddeditems.add("bread");
                                        if (controller.getMap().getWarehouse().AddItem(warehouseaddeditems)) {

                                            try {
                                                breadicon = new Image(new FileInputStream("image/bread.png"));
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }

                                            Rectangle rec = new Rectangle(420, 900, 25, 25);
                                            rec.setFill(new ImagePattern(breadicon));

                                            root.getChildren().add(rec);
                                            root.getChildren().remove(breadview);

                                        }
                                    }
                                });

                            }
                        });
                        animation.play();


                    }
                }
            });
            root.getChildren().remove(workshop6);
            root.getChildren().remove(addflourtobread);
            root.getChildren().remove(costofworkshop6);
        }

        else
            {


                try {
                    Image nomoney = new Image(new FileInputStream("image/nomoney.png"));
                    ImageView Nomoney = new ImageView(nomoney);
                    Nomoney.setY(-50);
                    Nomoney.setX(300);
                    Nomoney.setFitWidth(800);
                    Nomoney.setFitHeight(600);


                    Path path = new Path();
                    path.getElements().add(new MoveTo(20, 20));
                    path.getElements().add(new CubicCurveTo(500, 120, 0, 430, 380, 320));
                    PathTransition pathTransition = new PathTransition();
                    pathTransition.setDuration(Duration.millis(4000));
                    pathTransition.setPath(path);
                    pathTransition.setNode(Nomoney);
                    pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
                    pathTransition.setCycleCount(1);
                    pathTransition.setAutoReverse(true);
                    pathTransition.play();

                    pathTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            FadeTransition fader = createFader(Nomoney);

                            SequentialTransition blinkThenFade = new SequentialTransition(
                                    Nomoney,
                                    fader
                            );
                            blinkThenFade.play();
                        }
                    });


                    root.getChildren().add(Nomoney);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
        }

    }
});

        AnimationTimer animationTimer =
                new AnimationTimer() {
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


    public int calcfianlpriceforsell(String type)
    {
        for (int i = 0; i <controller.getMap().getWarehouse().getWarehouseItems().size() ; i++)
        {
            if(controller.getMap().getWarehouse().getWarehouseItems().get(i).getType().equals(type))
                finalpriceofsell+=controller.getMap().getWarehouse().getWarehouseItems().get(i).getCost();


        }
        return finalpriceofsell;
    }

    private FadeTransition createFader(Node node) {
        FadeTransition fade = new FadeTransition(Duration.seconds(4), node);
        fade.setFromValue(1);
        fade.setToValue(0);

        return fade;
    }






}





