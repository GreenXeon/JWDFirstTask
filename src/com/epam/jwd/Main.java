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
                new Point(2,2),
                new Point(2,0),
                new Point(0,2)
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
            System.out.println(pointMas[i]);
            i++;
        } while(i < 4);

        for (i = 0; i < 2; i++){
            if (lineMas[i].getFirstPoint().equals(lineMas[i].getSecondPoint())){
                System.out.println("odinakovyi line");
            } else {
                System.out.println(lineMas[i].getFirstPoint().toString() + " " + lineMas[i].getSecondPoint().toString());
            }
        }

        for (i = 0; i < 2; i++){
            if ((triangleMas[i].getFirstPoint().equals(triangleMas[i].getSecondPoint()))
            || (triangleMas[i].getFirstPoint().equals(triangleMas[i].getThirdPoint()))
            || (triangleMas[i].getSecondPoint().equals(triangleMas[i].getThirdPoint()))) {
                System.out.println("odinakovyi triangle");
            } else {
                if (!triangleMas[i].validationCheck()){
                    System.out.println("ne proxodit");
                } else {
                    System.out.println("nu norm triangle");
                }
            }
        }

        for (i = 0; i < 1; i++){
            if ((squareMas[i].getFirstPoint().equals(squareMas[i].getSecondPoint()))
            || (squareMas[i].getFirstPoint().equals(squareMas[i].getThirdPoint()))
            || (squareMas[i].getFirstPoint().equals(squareMas[i].getFourthPoint()))
            || (squareMas[i].getSecondPoint().equals(squareMas[i].getThirdPoint()))
            || (squareMas[i].getSecondPoint().equals(squareMas[i].getFourthPoint()))
            || (squareMas[i].getThirdPoint().equals(squareMas[i].getFourthPoint()))){
                System.out.println("odinakovyi square");
            } else {
                if (!squareMas[i].validationCheck()){
                    System.out.println("bad square");
                } else {
                    System.out.println("norm square");
                }

            }

        }
    }
}
