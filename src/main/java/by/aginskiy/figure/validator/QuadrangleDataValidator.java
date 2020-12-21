package by.aginskiy.figure.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadrangleDataValidator {

    private static final Pattern QUADRANGLE_VALUES_REGEX = Pattern.compile("-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?\\s" +
            "-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?\\s-?\\d+(\\.\\d+)?");

    public static boolean isQuadrangleDataValid(String quadrangleData) {
        Matcher matcher = QUADRANGLE_VALUES_REGEX.matcher(quadrangleData);
        boolean isMatches = matcher.matches();
        return isMatches;
    }
}
