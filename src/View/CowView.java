package View;

import Model.Cow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CowView  extends ImageView {
    Cow cow_;
    public CowView(Cow cow_) throws FileNotFoundException {
        super();
        Image cow = new Image(new FileInputStream("image/down 1 copy.png"));
        super.setImage(cow);
        this.cow_ = cow_;
        super.setFitHeight(100);
        super.setFitWidth(100);
    }

    public void updateLocation()
    {
        System.out.println("cow x is "+ cow_.getX());
        System.out.println("cow y is"+ cow_.getY());
        super.setX(cow_.getX());
        super.setY(cow_.getY());
        cow_.Move(700,700);
    }
}
