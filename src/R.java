import java.io.*;
import java.util.TreeMap;

public class R {

    BufferedReader reader;
    File file;

    public R(String text){

        try {

            reader = new BufferedReader(new FileReader(text));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }

    public TreeMap read(String s) {

        TreeMap<Double, Short> temp1 = new TreeMap();
        TreeMap<Double, Double> temp2 = new TreeMap();

        String line;
        String[] lines;
        try {

            line = reader.readLine();
            while (line != null) {
                lines = line.split(" ");
                // конешно работает только если никто не влезет в файл.
                // не хочу пилить защиту, для себя проект
                if (s.equals("short"))
                    temp1.put(Double.parseDouble(lines[0]), Short.valueOf(lines[1]));
                else if (s.equals("double"))
                    temp2.put(Double.parseDouble(lines[0]), Double.parseDouble(lines[1]));
                line = reader.readLine();
            }

        } catch (IOException e) {

            e.printStackTrace();
        }

        try {

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
        if (s.equals("short"))
            return temp1;
        else if (s.equals("double"))
            return temp2;
        else
            return null;
    }
}
