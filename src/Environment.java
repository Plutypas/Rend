import Entities.Camera;
import Entities.Descriptional.DimensionalPoint;
import Entities.Descriptional.Location;
import Entities.Face;
import Entities.Model;

import java.awt.*;
import java.util.ArrayList;

public class Environment {

    private ArrayList<Model> models;
    private Camera camera;
    private RendFrame frame;

    public Environment() {
        this.models = new ArrayList<Model>();
        this.frame = new RendFrame();
        int height = (int) this.frame.getSize().getHeight()/100;
        int width = (int) this.frame.getSize().getWidth()/100;
        this.camera = new Camera(new Location(new DimensionalPoint(0, 0, -10)), 5, new int[]{height, width});
    }

    public void addModel(String file) {
        this.models.add(new Model(file));
    }

    private ArrayList<int[][]> generatePointProjection() {
        ArrayList<int[][]> returnPoints = new ArrayList<>();
        for (Model model:this.models) {
            DimensionalPoint relative = model.getLocation().subtract(camera.getLocation());
            ArrayList<Face> faces = model.getFaces();
            for (Face face:faces) {
                DimensionalPoint[] realPoints = model.getFacePoints(face);
                int[][] faceCoords = new int[3][2];
                for (int i = 0; i < 3; i++) {
                    DimensionalPoint relativePoints = realPoints[i].add(relative);
                    int x = (int) ((this.camera.getDepth()*(relativePoints.getX()/relativePoints.getZ()))*100)+(400);
                    int y = (int) ((this.camera.getDepth()*(relativePoints.getY()/relativePoints.getZ()))*-100)+(200);
                    faceCoords[i]= new int[]{x, y};
                }
                returnPoints.add(faceCoords);
            }
        }
        return returnPoints;
    }

    public void render() {
        this.frame.updatePoints(generatePointProjection());
        this.frame.refresh();
    }

    public void updateModelLocation(int id, Location newLoc) {
        this.models.get(id).setLocation(newLoc);
    }
}
