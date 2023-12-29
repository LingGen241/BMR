import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BMR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to FitApp");

        System.out.print("May we know your name? ");
        String name = scanner.nextLine();
        System.out.println();

        System.out.println("Hi" + " " + name);
        System.out.println("Welcome" + " " + name + " " + "to our team");

        intro();

        System.out.println("Could we know your age, wegith, and gender? ");
        int age;
        double weight;
        double height;
        String gender;
        String check = scanner.next();
        if (check.equalsIgnoreCase("No")) {
            System.out.println("Sorry, to see you go.");
        } else {
            try {
                System.out.println("Great");
                System.out.println("What is your age? ");
                age = scanner.nextInt();

                System.out.println("What is your weight? ");
                weight = scanner.nextDouble();

                System.out.println("What is your height?");
                height = scanner.nextDouble();

                 System.out.println("What is your gender? ");
                 gender = scanner.next();
                
                System.out.println("Your age is: " + " " + age + " " + "your weight is: " + weight + " " + "kg" + " "
                        + "and your heigth is:" + " " + height + " " + "cm"+ " "+ gender);
                bmi(weight, height, gender);
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values for age and weight.");
            }
        }
        
    }
    
    public static void bmi(double weitgt, double height, String gender) {
        System.out.println("Base on your gender, age, and heigth.");
        double bmindex = (weitgt / Math.pow(height / 100, 2));
       // System.out.printf("Your BMI will be %.1f \n", bmindex);

        String category;
        
        if (gender.equals('M')) {
            if (bmindex < 20) {
                category = "Underweight";
            } else if (bmindex < 25) {
                category = "Normal weight";
            } else if (bmindex < 30) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }
        } else {
            if (bmindex < 19) {
                category = "Underweight";
            } else if (bmindex < 24) {
                category = "Normal weight";
            } else if (bmindex < 30) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }
        }
        System.out.printf("Your BMI will be %.1f and your category is: %s\n", bmindex, category);

    }

    public static void intro() {
        System.out.println("This app is builded by Seth and Huy ");
        dalay();
        System.out.println("The goal is to help people on their journey to meet their calories goals.");
        dalay();
        System.out.println();
    }


    public static void dalay() {
        try {
            Thread.sleep(1000); // wait for 1 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
     
}
