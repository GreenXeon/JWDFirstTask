package com.epam.jwd.model;

public class Point{
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return this.x + "," + this.y;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Point)) {
            return false;
        }
        Point object = (Point)obj;
        return (this.getX() == object.getX()) && (this.getY() == object.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
