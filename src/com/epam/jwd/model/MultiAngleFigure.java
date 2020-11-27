package com.epam.jwd.model;

public class MultiAngleFigure extends Figure {
    private Point firstP, secondP, thirdP, fourthP, fifthP, sixthP;

    public MultiAngleFigure(Point firstP, Point secondP, Point thirdP, Point fourthP) {
        this.firstP = firstP;
        this.secondP = secondP;
        this.thirdP = thirdP;
        this.fourthP = fourthP;
    }

    public MultiAngleFigure(Point firstP, Point secondP, Point thirdP, Point fourthP, Point fifthP) {
        this.firstP = firstP;
        this.secondP = secondP;
        this.thirdP = thirdP;
        this.fourthP = fourthP;
        this.fifthP = fifthP;
    }

    public MultiAngleFigure(Point firstP, Point secondP, Point thirdP, Point fourthP, Point fifthP, Point sixthP) {
        this.firstP = firstP;
        this.secondP = secondP;
        this.thirdP = thirdP;
        this.fourthP = fourthP;
        this.fifthP = fifthP;
        this.sixthP = sixthP;
    }
}
