import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Takes a list of cars and attributes of said cars and analyzes them
// Is built to work with specific text format, is not adaptive
public class GarageCalculator {

    public static void main(String[] args) throws FileNotFoundException {
        // App that lets user write to and from a .txt file
        File file = new File("src/main/java/items.txt");
        System.out.println("Welcome to the garage analyzer program!");
        System.out.println("This program uses the given .txt file provided to analyze.");
        System.out.println("What information about your garage would you like?");
        System.out.println("1. All info \n2. Cars \n3. Horsepower data \n4. Cost analysis");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();

        if(response.equalsIgnoreCase("1")) {
            System.out.println("Cars: " + getCars(file));
            System.out.println("Horsepowers: " + getHorsePowers(file));
            System.out.println("Average horsepower: " + averageHorsePower(getHorsePowers(file)));
            System.out.println("Prices: " + getCarPrices(file));
            System.out.println("Average price: " + averageCost(getCarPrices(file)));
        } else if(response.equalsIgnoreCase("2")) {
            System.out.println("Cars: " + getCars(file));
        } else if (response.equalsIgnoreCase("3")) {
            System.out.println("Horsepowers: " + getHorsePowers(file));
            System.out.println("Average horsepower: " + averageHorsePower(getHorsePowers(file)));
        } else if (response.equalsIgnoreCase("4")) {
            System.out.println("Prices: " + getCarPrices(file));
            System.out.println("Average price: " + averageCost(getCarPrices(file)));
        } else {
            System.out.println("Invalid response, try again.");
        }
        scanner.close();
    }

    public static ArrayList<String> getCars(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int counter = 0;
        int cars = 0;
        ArrayList<String> carArr = new ArrayList<String>();

        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            if(counter > 1 && line.length() > 0) {
                String[] strings = line.split(" ");
                carArr.add(strings[0]);
                cars++;
            }
            counter++;
        }
        return carArr;
    }

    public static ArrayList<Integer> getHorsePowers(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int counter = 0;
        int cars = 0;
        ArrayList<Integer> carArr = new ArrayList<Integer>();

        while(reader.hasNextLine()) {
            String line = reader.nextLine();

            if(counter > 1 && line.length() > 0) {
                String[] strings = line.split(" ");
                String hp = strings[1];
                int val = 0;
                String valS = "";
                for(int i = 0; i < hp.length(); i++) {
                    if(Character.isDigit(hp.charAt(i))) {
                        valS += hp.charAt(i);
                    }
                }
                val = Integer.parseInt(valS);
                carArr.add(val);
                cars++;
            }
            counter++;
        }
        return carArr;
    }

    public static int averageHorsePower(ArrayList<Integer> values) {
        int average = 0;
        for (Integer value : values) {
            average += value;
        }
        return average/values.size();
    }

    public static ArrayList<Integer> getCarPrices(File file) throws FileNotFoundException {
        Scanner reader = new Scanner(file);
        int counter = 0;
        ArrayList<String> carArr = new ArrayList<String>();
        ArrayList<Integer> carValues = new ArrayList<>();

        while(reader.hasNextLine()) {
            String line = reader.nextLine();
            int value = 0;
            if(counter > 1 && line.length() > 0) {

                String[] strings = line.split(" ");
                String curr = strings[2];
                boolean isMillion = false;
                boolean charSeen = false;
                String val = "";

                // String parsing
                for(int i = 0; i < curr.length(); i++) {
                    if(Character.isDigit(curr.charAt(i))) {
                        val += curr.charAt(i);
                    } else {
                        if(!charSeen && curr.charAt(i) == 'm' || curr.charAt(i) == 't') {
                            isMillion = curr.charAt(i) == 'm';
                            charSeen = true;
                        }
                    }
                }
                if(isMillion) val += "00000";
                value = Integer.parseInt(val);
                carValues.add(value);
            }
            counter++;
        }
        return carValues;
    }

    public static int averageCost(ArrayList<Integer> values) {
        int average = 0;
        for(Integer value : values) {
            average += value;
        }
        return average/values.size();
    }

}
