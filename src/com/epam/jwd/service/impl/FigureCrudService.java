package com.epam.jwd.service.impl;

import com.epam.jwd.exception.FigureException;
import com.epam.jwd.factory.FigureFactory;
import com.epam.jwd.model.Figure;
import com.epam.jwd.model.FigureType;
import com.epam.jwd.model.Point;
import com.epam.jwd.service.FigureCrud;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public final class FigureCrudService implements FigureCrud {
    private static FigureCrudService instance;
    private FigureCrudService(){
    }
    public static FigureCrudService getInstance(){
        if (instance == null){
            instance = new FigureCrudService();
        }
        return instance;
    }

    private Map<Integer, Figure> figureStorage = new LinkedHashMap<>();
    private int index = 0;

    @Override
    public void createFigure(FigureFactory factory, FigureType type, Point... points) throws FigureException {
        Figure createdFigure = factory.createFigure(type, points);
        figureStorage.put(index, createdFigure);
        index++;
    }

    @Override
    public void createMultiFigure(int amountOfFigures, FigureFactory factory, FigureType type, Point... points) throws FigureException {
        Figure createdFigure;
        createdFigure = factory.createFigure(type, points);
        for (int i = 0; i < amountOfFigures; i++){
            figureStorage.put(index, createdFigure);
            index++;
        }
    }

    @Override
    public void deleteFigure(Figure figure) {
        Integer key = 0;
        for (Map.Entry<Integer, Figure> entry : figureStorage.entrySet()){
            if (figure.equals(entry.getValue())){
                key = entry.getKey();
                break;
            }
        }
        figureStorage.remove(key);
    }

    @Override
    public void updateFigure(int id, Point ... points) throws FigureException {
        Figure figure = figureStorage.get(id);
        if (figure.getPoints().size() != points.length){
            throw new FigureException("Quantities of points are not equal");
        }
        figure.setPoints(Arrays.asList(points));
        figureStorage.put(id, figure);
    }

    @Override
    public List<Figure> findByCriteria(FigureCriteria figureCriteria) {
        return  figureStorage.values()
                .stream()
                .filter(figure -> figure.getPoints().equals(figureCriteria.getPoints()) || figureCriteria.getPoints() == null)
                .filter(figure -> figure.getType().equals(figureCriteria.getFigureType()) || figureCriteria.getFigureType() == null)
                .filter(figure -> figure.getFigurePropertiesStrategy().equals(figureCriteria.getFigureStrategy()) || figureCriteria.getFigureStrategy() == null)
                .collect(Collectors.toList());
    }

    @Override
    public Figure findById(int id) {
        Optional<Figure> figureOptional = figureStorage.entrySet()
                .stream()
                .filter(s -> s.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst();
        return figureOptional.orElseThrow();
    }

    @Override
    public Figure findFigure(Figure figure) {
        Optional <Figure> figureOptional = figureStorage.values()
                .stream()
                .filter(v -> v.equals(figure))
                .findFirst();
        return figureOptional.orElseThrow();
    }


    public Map<Integer, Figure> getFigureStorage() {
        return figureStorage;
    }
}
