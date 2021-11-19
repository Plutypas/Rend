import javax.swing.*;
import java.util.ArrayList;


public class RendFrame extends JFrame {

    private RendPanel panel;
    private ArrayList<int[][]> points;
    public RendFrame() {
        this.setSize(800, 438);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.points = new ArrayList<>();

        //points.add(new int[][]{{100, 20},{120, 10},{150, 50}});

        this.panel = new RendPanel(points);
        this.add(this.panel);
        this.setVisible(true);
    }

    public void updatePoints(ArrayList<int[][]> points) {
        this.panel.updatePoints(points);
    }

    public void refresh() {
        this.panel.revalidate();
        this.panel.repaint();
    }
}
