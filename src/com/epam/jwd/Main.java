package com.epam.jwd;

import com.epam.model.Line;
import com.epam.model.Point;
import com.epam.model.Square;
import com.epam.model.Triangle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Point[] pointMas;
    private static Line[] lineMas;
    private static Triangle[] triangleMas;
    private static Square[] squareMas;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        masGeneration();
        cycleInfoOut();
    }

    private static void masGeneration(){
        pointMas = new Point[]{
                new Point(0,0),
                new Point(1,-1),
                new Point(-1,1),
                new Point(-1,6)
        };
        logger.log(Level.INFO, "ok");
        lineMas = new Line[]{
                new Line(pointMas[0], pointMas[1]),
                new Line(pointMas[2], pointMas[3]),
        };
        triangleMas = new Triangle[]{
                new Triangle(pointMas[0], pointMas[1], pointMas[2]),
                new Triangle(pointMas[1], pointMas[2], pointMas[3])
        };
        squareMas = new Square[]{
                new Square(pointMas[0], pointMas[1], pointMas[2], pointMas[3])
        };

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
                    logger.log(Level.INFO, "Square has points " + triangleMas[i].toString());
                }
            }
        }
    }
}
