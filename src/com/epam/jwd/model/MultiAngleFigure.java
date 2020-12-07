package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {
    private final Point[] points;

    MultiAngleFigure(Point ... points){
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public int numOfPoints(){
        return points.length;
    }
}
