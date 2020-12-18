package com.epam.jwd.service.impl;

import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.strategy.Strategy;

import java.util.List;

public class FigureCriteria {
    FigureType figureType;
    List<Point> points;
    Strategy figureStrategy;

    public FigureType getFigureType() {
        return figureType;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Strategy getFigureStrategy() {
        return figureStrategy;
    }

    public static class CriteriaBuilder{
        private final FigureCriteria figureCriteria;

        public CriteriaBuilder(){
            figureCriteria = new FigureCriteria() ;
        }

        public CriteriaBuilder hasFigureType(FigureType type){
            figureCriteria.figureType = type;
            return this;
        }

        public CriteriaBuilder hasPoints(List<Point> points){
            figureCriteria.points = points;
            return this;
        }

        public CriteriaBuilder hasStrategy(Strategy strategy){
            figureCriteria.figureStrategy = strategy;
            return this;
        }

        public FigureCriteria build(){
            return figureCriteria;
        }
    }
}
