package ch03.ex03_06;

import java.util.function.BiFunction;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class ColorTransformerBiFunction extends Application{

  /**
   * Transform image using provided operation
   * @param in image to be transformed
   * @param f operation to transform
   * @return transformed image
   */
  public static <T> Image transform(Image in, BiFunction<Color, T, Color> f, T arg) {
    int width = (int) in.getWidth();
    int height = (int) in.getHeight();
    WritableImage out = new WritableImage(width, height);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        out.getPixelWriter().setColor(x,  y, f.apply(in.getPixelReader().getColor(x, y), arg));
      }
    }
    return out;
  }

  public void start(Stage stage) {
    Image image = new Image("ch03/ex03_06/queen-mary.png");
    Image framedImage = transform(image,(c, factor) -> c.deriveColor(0, 1, factor, 1), 1.2);
    stage.setScene(new Scene(new HBox(new ImageView(framedImage))));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
