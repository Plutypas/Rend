package Entities;
import java.util.ArrayList;
import Entities.Descriptional.DimensionalPoint;
import Entities.Descriptional.Location;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Model {

    private ArrayList<DimensionalPoint> points;
    private ArrayList<Face> faces;
    private Location location;

    public ArrayList<DimensionalPoint> getPoints() {
        return points;
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public DimensionalPoint getLocation() {
        return this.location.getLocation();
    }

    public void setLocation(Location location) {
        this.location=location;
    }

    public Model(String file) {
        try {
            this.location = new Location(new DimensionalPoint(0,0,0));
            this.points = new ArrayList<DimensionalPoint>();
            this.faces = new ArrayList<Face>();
            File obj = new File(file);
            Scanner reader = new Scanner(obj);
            while (reader.hasNextLine()) {
                String[] line=reader.nextLine().split(" ");
                switch (line[0]) {
                    case "v" -> {
                        this.points.add(new DimensionalPoint(Double.parseDouble(line[1]),
                                Double.parseDouble(line[2]), Double.parseDouble(line[3])));
                    }
                    case "f" -> {
                        this.faces.add(new Face(Integer.parseInt(line[1])-1, Integer.parseInt(line[2])-1, Integer.parseInt(line[3])-1));
                    }
                    case "" -> {}
                    case "#" -> {}
                    default -> { System.out.println("Unexpected operand read, no action taken."); }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("Object not found.");
        }
    }

    public DimensionalPoint[] getFacePoints(Face face) {
        DimensionalPoint[] returnPoint = new DimensionalPoint[3];
        int[] pointRefs = face.getPoints();
        for (int i = 0; i < 3; i++) {
            returnPoint[i] = this.points.get(pointRefs[i]);
        }
        return returnPoint;
    }
}
