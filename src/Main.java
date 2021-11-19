import Entities.Descriptional.DimensionalPoint;
import Entities.Descriptional.Location;
import Entities.Model;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Graphics;
import java.math.*;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        Environment env = new Environment();
        env.addModel("C:\\Users\\gabri\\IdeaProjects\\Rend\\Models\\Ruler.obj");
        env.addModel("C:\\Users\\gabri\\IdeaProjects\\Rend\\Models\\Cube.obj");
        env.render();
        java.util.Timer t = new java.util.Timer();
        t.schedule(new TimerTask() {
            double inc=-8;
            @Override
            public void run() {
                env.updateModelLocation(0, new Location(new DimensionalPoint(0,-3,10)));
                env.updateModelLocation(1, new Location(new DimensionalPoint(2,-1.75,inc)));
                env.render();
                inc=inc+0.001;
            }
        }, 0, 1);
    }
}
