package habens.parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by habens on 11/26/14.
 */
abstract public class Parser<T> {
    public List<T> parseFromFile(String filePath) {
        List<T> parseList = new LinkedList<T>();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(filePath)));
            parseList = parseFromBuffer(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return parseList;
        }
    }

    public List<T> parseFromBuffer(BufferedReader reader) {
        List<T> parseList = new LinkedList<T>();
        try {
            String line = reader.readLine();
            while (line != null) {
                T tmp = convert(line);
                parseList.add(tmp);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return parseList;
        }
    }

    abstract protected T convert(String line);
}
