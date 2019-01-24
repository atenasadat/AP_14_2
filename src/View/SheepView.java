package View;

import Model.Cow;
import Model.Sheep;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SheepView extends ImageView {
    Sheep sheep_;
    public SheepView(Sheep sheep_) throws FileNotFoundException {
        super();
        Image sheep = new Image(new FileInputStream("image/downofsheep.png"));
        super.setImage(sheep);
        this.sheep_ = sheep_;
        super.setFitHeight(100);
        super.setFitWidth(100);
    }

    public void updateLocation()
    {
        System.out.println("sheep x is "+ sheep_.getX());
        System.out.println("sheep y is"+ sheep_.getY());
        super.setX(sheep_.getX());
        super.setY(sheep_.getY());
        sheep_.Move(700,700);
    }
}
