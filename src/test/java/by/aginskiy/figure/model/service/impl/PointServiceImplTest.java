package by.aginskiy.figure.model.service.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.aginskiy.figure.model.entity.CustomPoint;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class PointServiceImplTest {

    private static final PointServiceImpl pointService = new PointServiceImpl();
    private static CustomPoint[] points = new CustomPoint[3];

    @BeforeClass
    public void setUp() {
        for(int i = 0; i < points.length; i++) {
            points[i] = new CustomPoint(i, i + i * i);
        }
    }

    @Test
    public void testCalculateDistanceBetweenPoints() {
        double result = pointService.calculateDistanceBetweenPoints(points[0], points[1]);
        double expected = Math.sqrt(5);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testCalculateVectorCoordinates() {
        List<Double> result = pointService.calculateVectorCoordinates(points[0], points[1]);
        List<Double> expected = new ArrayList<>();
        expected.add(1.0);
        expected.add(2.0);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void testIsThreePointsOnLine() {
        boolean result = pointService.isThreePointsOnLine(points[0], points[1], points[2]);
        Assert.assertFalse(result);
    }
}