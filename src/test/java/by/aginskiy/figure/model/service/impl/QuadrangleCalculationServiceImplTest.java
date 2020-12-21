package by.aginskiy.figure.model.service.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleCalculationServiceImplTest {

    private static final QuadrangleCalculationServiceImpl calculationService = new QuadrangleCalculationServiceImpl();
    private static Quadrangle square;

    @BeforeClass
    public void setUp() {
        square = new Quadrangle(new CustomPoint(1, 1), new CustomPoint(5, 1),
                new CustomPoint(5, 5), new CustomPoint(1, 5));
    }

    @Test
    public void testCalculateSidesLengths() {
        final double squareSideLength = 4.0;
        List<Double> squareLengths = calculationService.calculateSidesLengths(square);
        boolean result;
        result = (squareLengths.get(0).equals(squareSideLength))
                 && (squareLengths.get(1).equals(squareSideLength))
                 && (squareLengths.get(2).equals(squareSideLength))
                 && (squareLengths.get(3).equals(squareSideLength));
        Assert.assertTrue(result);
    }

    @Test
    public void testCalculateDiagonals() {
        List<Double> actual = calculationService.calculateDiagonals(square);
        List<Double> expected = new ArrayList<>();
        expected.add(Math.sqrt(32));
        expected.add(Math.sqrt(32));
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculatePerimeter() {
        double actual = calculationService.calculatePerimeter(square);
        double expected = 16.0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculateArea() {
        double actual = Math.round(calculationService.calculateArea(square));
        double expected = 16.0;
        assertEquals(actual, expected);
    }
}