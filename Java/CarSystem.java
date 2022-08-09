import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        String response = "";


        while(!response.equalsIgnoreCase("end")) {

            System.out.println("Would you like to create a new car or an existing one? Otherwise type 'end'");
            response = sc.nextLine();

            if(response.equalsIgnoreCase("new")) {
                System.out.println("Ok! Racecar or normal?");
                String carType = sc.nextLine();
                if(carType.equalsIgnoreCase("racecar")) {

                    System.out.println("What is the make of the racecar?");
                    String carMake = sc.nextLine();
                    System.out.println("What is the model of the racecar?");
                    String carModel = sc.nextLine();
                    System.out.println("Would you like to make a custom license plate or auto-generate one?");
                    String carPlate = sc.nextLine();
                    System.out.println("What is the name of your racecar?");
                    String carName = sc.nextLine();
                    vehicles.add(new RaceCar(carPlate, carMake, carModel, carName, 0, 0));

                } else if(carType.equalsIgnoreCase("normal")) {

                    System.out.println("What is the make of the car?");
                    String carMake = sc.nextLine();
                    System.out.println("What is the model of the car?");
                    String carModel = sc.nextLine();
                    System.out.println("Would you like to make a custom license plate or auto-generate one?");
                    String carPlate = sc.nextLine();
                    System.out.println("What is the name of your car?");
                    String carName = sc.nextLine();
                    vehicles.add(new Vehicle(carPlate, carMake, carModel, carName, 0));

                } else {
                    System.out.println("That was not a valid option, try again!");
                }

            } else if(response.equalsIgnoreCase("existing")) {
                System.out.println("Working on that ");

            } else if(response.equalsIgnoreCase("racecar")) {

            }

        }

        for(int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i).getVehicleInformation());
        }

        sc.close();
    }
}

public class Vehicle {

    protected final String licensePlate;
    protected final String make;
    protected final String model;
    protected final String name;
    protected int milesDriven = 0;

    public Vehicle(String licensePlate, String make, String model, String name, int milesDriven) {
        this.licensePlate = licensePlate;
        this.make = make;
        this.model = model;
        this.name = name;
        this.milesDriven = milesDriven;
    }

    public void makeNewVehicle() {

    }

    public String getVehicleInformation() {
        return "Name: " + name + "\nMake: " + make + "\nModel: " + model + "\nLicense Plate: " + licensePlate + "\n";
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }

    public String getName() {
        return name;
    }

}

public class RaceCar extends Vehicle {

    public int getNitrous() {
        return nitrous;
    }

    public void setNitrous(int nitrous) {
        this.nitrous = nitrous;
    }

    public int nitrous;

    public RaceCar(String licensePlate, String make, String model, String name, int milesDriven, int nitrous) {
        super(licensePlate, make, model, name, milesDriven);
    }

    @Override
    public String getVehicleInformation() {
        return "Name: " + name + "\nMake: " + make + "\nModel: " + model + "\nLicense Plate: "
                + licensePlate + "\nNitro: " + nitrous + "\n";
    }
}

