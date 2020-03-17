import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class Test {
    public static void main(final String[] args) {
        final File file = new File("./A.txt");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (final FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        final Reader reader = new InputStreamReader(inputStream);
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String buffer;
        int count = 0;
        try {
            while ((buffer = bufferedReader.readLine()) != null) {
                if ((count % 6) == 0) {
                    System.out.println("\"" + buffer + "\",");
                }
                count++;
            }
        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}