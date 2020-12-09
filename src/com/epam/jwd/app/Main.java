package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.exception.FigureNotExistException;
import com.epam.jwd.model.*;
import com.epam.jwd.strategy.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import com.epam.jwd.factory.FigureFactory;

import java.text.DecimalFormat;

public class Main {

    private static Point[] pointMas;
    private static Figure[] lineMas;
    private static Figure[] triangleMas;
    private static Figure[] squareMas;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        masGeneration();
        cycleInfoOut();
        strategyContextTest();
        multiAngleCreator();
    }

    private static void multiAngleCreator(){
        try {
            Figure fiveAngle = FigureFactory.createFigure(FigureType.MULTIANGLE,
                    PointFactory.createFigure(0, 0),
                    PointFactory.createFigure(1, 5),
                    PointFactory.createFigure(3, 9),
                    PointFactory.createFigure(7, -5),
                    PointFactory.createFigure(9, 4));
            Figure sixAngle = FigureFactory.createFigure(FigureType.MULTIANGLE,
                    PointFactory.createFigure(0, 0),
                    PointFactory.createFigure(1, 5),
                    PointFactory.createFigure(3, 9),
                    PointFactory.createFigure(7, -5),
                    PointFactory.createFigure(9, 4),
                    PointFactory.createFigure(3, -2));
        }
        catch (FigureNotExistException e){
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
        }
    }

    private static void strategyContextTest()
    {
        Strategy currentStrategy = LineInfoStrategy.INSTANCE;
        DecimalFormat dF = new DecimalFormat("##.##");
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(lineMas[0])));
        currentStrategy = TriangleInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(triangleMas[1])));
        currentStrategy = SquareInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findSquare(squareMas[0])));
    }

    private static void masGeneration(){
        ApplicationContext applicationContext = new ApplicationContext();
        com.epam.jwd.factory.FigureFactory figureFactory = applicationContext.createFigureFactory();
        pointMas = new Point[]{
                PointFactory.createFigure(0, 0),
                PointFactory.createFigure(0, 2),
                PointFactory.createFigure(2, 2),
                PointFactory.createFigure(2, 0)
        };
        try {
            lineMas = new Figure[]{
                    figureFactory.createFigure(FigureType.LINE, pointMas[0], pointMas[1]),
                    figureFactory.createFigure(FigureType.LINE, pointMas[1], pointMas[2])
            };
        } catch(FigureException e){
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
            e.printStackTrace();
        }

        try {
            triangleMas = new Figure[]{
                    FigureFactory.createFigure(FigureType.TRIANGLE, pointMas[0], pointMas[1], pointMas[2]),
                    FigureFactory.createFigure(FigureType.TRIANGLE, pointMas[1], pointMas[2], pointMas[3])
            };
        }
        catch(FigureNotExistException e){
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
            e.printStackTrace();
        }

        try {
            squareMas = new Figure[]{
                    FigureFactory.createFigure(FigureType.SQUARE, pointMas[0], pointMas[1], pointMas[2], pointMas[3])
            };
        }
        catch (FigureNotExistException e){
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void cycleInfoOut(){
        int i = 0;
        do {
            logger.log(Level.INFO, "Point #" + (i + 1) + " is " + pointMas[i].toString());
            i++;
        } while(i < 4);

        for (i = 0; i < 2; i++){
            if (lineMas[i].equalityCheck()){
                logger.log(Level.ERROR, "Object " + lineMas[i].toString() + " can't be a figure line");
            } else {
                logger.log(Level.INFO, "Line has points " + lineMas[i].toString());
            }
        }

        for (i = 0; i < 2; i++){
            if ((triangleMas[i].equalityCheck())) {
                logger.log(Level.ERROR, "Object " + triangleMas[i].toString() + " can't be a figure triangle");
            } else {
                if (!triangleMas[i].validationCheck()){
                    logger.log(Level.ERROR, "Triangle " + triangleMas[i].toString() + " can't exist");
                } else {
                    logger.log(Level.INFO, "Triangle has points " + triangleMas[i].toString());
                }
            }
        }

        for (i = 0; i < 1; i++){
            if (squareMas[i].equalityCheck()){
                logger.log(Level.ERROR, "Object " + squareMas[i].toString() + " can't be a figure square");
            } else {
                if (!squareMas[i].validationCheck()){
                    logger.log(Level.ERROR, "Object " + squareMas[i].toString() + " isn't a square");
                } else {
                    logger.log(Level.INFO, "Square has points " + squareMas[i].toString());
                }
            }
        }
    }
}
