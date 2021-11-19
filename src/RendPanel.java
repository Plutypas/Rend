import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class RendPanel extends JPanel{

    private ArrayList<int[][]> points;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.BLACK);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        g2D.setStroke(new BasicStroke(1));

        for (int[][] point: this.points) {
            //int[] x = {point[0][0], point[1][0], point[2][0]};
            //int[] y = {point[0][1], point[1][1], point[2][1]};
            for (int i = 0; i < 3; i++) {
                g2D.drawLine(point[(i+1)%3][0], point[(i+1)%3][1], point[(i)%3][0], point[(i)%3][1]);
            }
            //g2D.fillPolygon(new Polygon(x, y, 3));
        }
        g2D.setColor(Color.WHITE);
        g2D.drawLine(400, 0, 400, 400);
        g2D.drawLine(0, 200, 800, 200);
    }

    public RendPanel(ArrayList<int[][]> points) {
        this.points=points;
    }

    public void updatePoints(ArrayList<int[][]> points) {
        this.points=points;
    }
}
