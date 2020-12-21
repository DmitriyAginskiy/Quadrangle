package by.aginskiy.figure.reader;

import by.aginskiy.figure.exception.FileReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class QuadrangleReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "src\\main\\resources\\data.txt";

    public List<String> readFromFile(String path) throws FileReadingException {
        if(!Files.exists(Path.of(path))) {
            path = DEFAULT_PATH;
        }
        List<String> quadrangles = null;
        try {
            quadrangles = Files.readAllLines(Path.of(path));
        } catch(IOException e) {
            logger.error("Unable to read from file. Filepath: " + path);
            throw new FileReadingException("Unable to read from File");
        }
        return quadrangles;
    }
}
