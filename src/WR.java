import java.io.*;

public class WR {

    FileWriter writer;
    File file;

    public WR(String text){

        file = new File(text);

    }

    public boolean write(String lvl, String coef) {

        try {

            writer = new FileWriter(file, true);

        } catch (IOException e) {

            e.printStackTrace();
        }

        if (writer != null) {

            try {

                writer.write(lvl + " " + coef + '\n');

            } catch (IOException e) {

                e.printStackTrace();

            }
            try {

                writer.close();

            } catch (IOException e) {

                e.printStackTrace();
            }

            return true;

        } else {

            return false;
        }
    }

    public boolean write(String pokeData) {

        try {

            writer = new FileWriter(file, true);

        } catch (IOException e) {

            e.printStackTrace();
        }

        if (writer != null) {

            try {

                writer.write(pokeData + '\n');

            } catch (IOException e) {

                e.printStackTrace();

            }
            try {

                writer.close();

            } catch (IOException e) {

                e.printStackTrace();
            }

            return true;

        } else {

            return false;
        }
    }
}
