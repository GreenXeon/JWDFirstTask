package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.PointFactory;
import com.epam.jwd.service.impl.FigureCrudService;
import com.epam.jwd.strategy.LineInfoStrategy;
import com.epam.jwd.strategy.MultiAngleInfoStrategy;
import com.epam.jwd.strategy.SquareInfoStrategy;
import com.epam.jwd.strategy.Strategy;
import com.epam.jwd.strategy.TriangleInfoStrategy;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Point> pointList = new ArrayList<>();
    private static List<Figure> figureList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static ApplicationContext applicationContext = new ApplicationContext();
    private static FigureFactory figureFactory = applicationContext.createFigureFactory();
    private static FigureCrudService figureCrudService = FigureCrudService.getInstance();

    public static void main(String[] args) {
        dataGeneration();
        strategyContextTest();
        //Figure sample = figureCrudService.findById(0);
    }

    private static void strategyContextTest()
    {
        Strategy currentStrategy = LineInfoStrategy.INSTANCE;
        DecimalFormat dF = new DecimalFormat("##.##");
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(figureList.get(0))));
        currentStrategy = TriangleInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(figureList.get(2))));
        currentStrategy = SquareInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findSquare(figureList.get(4))));
        logger.log(Level.INFO, dF.format(MultiAngleInfoStrategy.getInstance().findPerimeter(figureList.get(5))));
    }

    private static void dataGeneration(){
        pointList.add(PointFactory.createFigure(0, 0));
        pointList.add(PointFactory.createFigure(0, 2));
        pointList.add(PointFactory.createFigure(2, 2));
        pointList.add(PointFactory.createFigure(2, 0));

        try{
            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.LINE, pointList.get(0), pointList.get(1)));
            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.LINE, pointList.get(1), pointList.get(2)));

            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.TRIANGLE, pointList.get(0),
                    pointList.get(1), pointList.get(2)));
            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.TRIANGLE, pointList.get(1),
                    pointList.get(2), pointList.get(3)));
            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.SQUARE, pointList.get(0),
                    pointList.get(1), pointList.get(2), pointList.get(3)));

            figureList.add(figureCrudService.createFigure(figureFactory, FigureType.MULTIANGLE, pointList.get(0),
                    pointList.get(1), pointList.get(2), pointList.get(3)));

            //figureList.add(figureCrudService.createMultiFigure(3, figureFactory, FigureType.LINE, pointList.get(1), pointList.get(2)));
        } catch(FigureException e) {
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
            e.printStackTrace();
        }
    }
}
