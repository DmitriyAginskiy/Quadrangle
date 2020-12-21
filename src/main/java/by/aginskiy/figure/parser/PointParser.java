package by.aginskiy.figure.parser;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.validator.QuadrangleDataValidator;

import java.util.ArrayList;
import java.util.List;

public class PointParser {

    private static final String SPLIT_REGEX = " ";
    private static final int POINTS_NUMBER = 8;

    public List<CustomPoint> parsePoints(String pointsLine) {
        ArrayList<CustomPoint> result = new ArrayList<>();
        if(QuadrangleDataValidator.isQuadrangleDataValid(pointsLine)) {
            String[] points = pointsLine.split(SPLIT_REGEX);
            for(int i = 0; i < points.length / 2; i++) {
                double x = Double.parseDouble(points[i]);
                double y = Double.parseDouble(points[i + 1]);
                result.add(new CustomPoint(x, y));
            }
        }
        return result;
    }
}
