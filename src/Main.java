import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        generateGoodsTxt("Towary.txt", 110000);
    }

    static void generateGoodsTxt(String fileName, int numberOfGoods) {


        try {
            FileWriter writer = new FileWriter(fileName);

            Random randomIds = new Random();
            Random randomWeights = new Random();
            randomIds.ints(1,11000)
                            .limit(numberOfGoods)
                            .boxed()
                            .collect(Collectors.toList());

            //weight in grams
            randomWeights.ints(1, 11000)
                            .limit(numberOfGoods)
                            .boxed()
                            .collect(Collectors.toList());

            for (int i = 0; i < numberOfGoods; i++) {
                writer.write("#" + randomIds.nextInt(11000) + " " + randomWeights.nextInt(100000) + "\n");
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the input file.");
            e.printStackTrace();
        }
    }


}