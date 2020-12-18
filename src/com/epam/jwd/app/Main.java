package com.epam.jwd.app;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.ApplicationContext;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.model.PointFactory;
import com.epam.jwd.service.impl.FigureCriteria;
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
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Point> pointList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static ApplicationContext applicationContext = new ApplicationContext();
    private static FigureFactory figureFactory = applicationContext.createFigureFactory();
    private static FigureCrudService storage = FigureCrudService.getInstance();

    public static void main(String[] args) {
        dataGeneration();
        strategyContextTest();
        //Figure sample = figureCrudService.findById(0);
    }

    private static void dataGeneration() {
        pointList.add(PointFactory.createFigure(0, 0));
        pointList.add(PointFactory.createFigure(0, 2));
        pointList.add(PointFactory.createFigure(2, 2));
        pointList.add(PointFactory.createFigure(2, 0));

        try {
            storage.createFigure(figureFactory, FigureType.LINE, pointList.get(0), pointList.get(1));
            storage.createFigure(figureFactory, FigureType.LINE, pointList.get(1), pointList.get(2));

            storage.createFigure(figureFactory, FigureType.TRIANGLE, pointList.get(0),
                    pointList.get(1), pointList.get(2));
            storage.createFigure(figureFactory, FigureType.TRIANGLE, pointList.get(1),
                    pointList.get(2), pointList.get(3));
            storage.createFigure(figureFactory, FigureType.SQUARE, pointList.get(0),
                    pointList.get(1), pointList.get(2), pointList.get(3));

            storage.createFigure(figureFactory, FigureType.MULTIANGLE, pointList.get(0),
                    pointList.get(1), pointList.get(2), pointList.get(3), PointFactory.createFigure(3, 9));

            storage.createMultiFigure(3, figureFactory, FigureType.LINE, pointList.get(0), pointList.get(1));

            System.out.println(storage.getFigureStorage());
            Figure sampleFigure = storage.findById(2);
            storage.updateFigure(1, pointList.get(1), pointList.get(3));
            System.out.println(storage.getFigureStorage());

            System.out.println(storage.findById(2));

            List<Figure> sampleList = storage.findByCriteria(
                    new FigureCriteria.CriteriaBuilder()
                    .hasPoints(Arrays.asList(pointList.get(0), pointList.get(1), pointList.get(2)))
                    .hasFigureType(FigureType.LINE)
                    .hasStrategy(LineInfoStrategy.INSTANCE)
                    .build()
            );

            System.out.println(sampleList);
        } catch (FigureException e) {
            logger.log(Level.ERROR, "Exception has been raised: " + e.toString());
            e.printStackTrace();
        }
    }

    private static void strategyContextTest() {
        Strategy currentStrategy = LineInfoStrategy.INSTANCE;
        DecimalFormat dF = new DecimalFormat("##.##");
        Map<Integer, Figure> figureMap = storage.getFigureStorage();
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(figureMap.get(0))));
        currentStrategy = TriangleInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findPerimeter(figureMap.get(2))));
        currentStrategy = SquareInfoStrategy.getInstance();
        logger.log(Level.INFO, dF.format(currentStrategy.findSquare(figureMap.get(4))));
        logger.log(Level.INFO, dF.format(MultiAngleInfoStrategy.getInstance().findPerimeter(figureMap.get(5))));
    }
}


