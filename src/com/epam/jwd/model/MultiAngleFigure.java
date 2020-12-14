package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {
    private Point[] points;

    MultiAngleFigure(Point ... points){
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public int numOfPoints(){
        return points.length;
    }
}
