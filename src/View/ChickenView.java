package View;

import Model.Chicken;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ChickenView extends ImageView{

    Chicken chicken_;
    Image chicken = new Image(new FileInputStream("image/chicken.png"));
    public ChickenView(Chicken chicken_) throws FileNotFoundException {
        super();
        super.setImage(chicken);
        this.chicken_=chicken_;
        super.setFitHeight(100);
        super.setFitWidth(100);
    }

    public void updateLocation()
    {


        System.out.println("x is "+chicken_.getX());
        System.out.println("y is"+chicken_.getY());
        super.setX(chicken_.getX());
        super.setY(chicken_.getY());
        chicken_.Move(700,700);
    }
}