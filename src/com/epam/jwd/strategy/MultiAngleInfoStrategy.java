package com.epam.jwd.strategy;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.Point;

import java.util.Arrays;
import java.util.List;

public class MultiAngleInfoStrategy implements Strategy{
    private static MultiAngleInfoStrategy instance;
    private MultiAngleInfoStrategy(){
    }
    public static MultiAngleInfoStrategy getInstance(){
        if (instance == null){
            instance = new MultiAngleInfoStrategy();
        }
        return instance;
    }

    @Override
    public double findSquare(Figure figure) {
        double square = 0;
        List<Point> points = Arrays.asList(figure.getPoints());
        for (int i = 0; i < points.size()-1; i++){
            square = square + points.get(i).getX() * points.get(i+1).getY() -
            points.get(i).getY() * points.get(i+1).getX();
        }
        return Math.abs(square)/2;
    }

    @Override
    public double findPerimeter(Figure figure) {
        double perimeter = 0;
        List<Point> points = Arrays.asList(figure.getPoints());
        for (int i = 0; i < points.size()-1; i++){
            perimeter += Math.sqrt(Math.pow(points.get(i+1).getX() - points.get(i).getX(), 2) +
                    Math.pow(points.get(i+1).getY() - points.get(i).getY(), 2));
        }
        if (figure.getPoints().length > 2){
            perimeter += Math.sqrt(Math.pow(points.get(points.size()-1).getX() - points.get(0).getX(), 2) +
                    Math.pow(points.get(points.size()-1).getY() - points.get(0).getY(), 2));
        }
        return perimeter;
    }
}
