package by.aginskiy.figure.model.service.impl;

import by.aginskiy.figure.model.entity.CustomPoint;
import by.aginskiy.figure.model.entity.Quadrangle;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class QuadrangleConditionServiceImplTest {

    private static final QuadrangleConditionServiceImpl conditionService = new QuadrangleConditionServiceImpl();
    private static Quadrangle invalidQuadrangle;
    private static Quadrangle customQuadrangle;
    private static Quadrangle square;

    @BeforeClass
    public void setUp() {
        invalidQuadrangle = new Quadrangle(new CustomPoint(1, 1), new CustomPoint(6, 3),
                new CustomPoint(2, 1), new CustomPoint(3, 1));
        customQuadrangle = new Quadrangle(new CustomPoint(1, 1), new CustomPoint(7, 3),
                new CustomPoint(4, 10), new CustomPoint(2, 7));
        square = new Quadrangle(new CustomPoint(1, 1), new CustomPoint(5, 1),
                new CustomPoint(5, 5), new CustomPoint(1, 5));
    }

    @Test
    public void testIsQuadrangleExists() {
        boolean validResult = conditionService.isQuadrangleExists(customQuadrangle);
        boolean invalidResult = conditionService.isQuadrangleExists(invalidQuadrangle);
        boolean actual = validResult ^ invalidResult;
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRhombus() {
        boolean validResult = conditionService.isRhombus(square);
        boolean invalidResult = conditionService.isRhombus(customQuadrangle);
        boolean actual = validResult ^ invalidResult;
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsRectangle() {
        boolean validResult = conditionService.isRectangle(square);
        boolean invalidResult = conditionService.isRectangle(customQuadrangle);
        boolean actual = validResult ^ invalidResult;
        Assert.assertTrue(actual);
    }

    @Test
    public void testIsSquare() {
        boolean validResult = conditionService.isSquare(square);
        boolean invalidResult = conditionService.isSquare(customQuadrangle);
        boolean actual = validResult ^ invalidResult;
        Assert.assertTrue(actual);
    }
}