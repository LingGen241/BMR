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

        System.out.println("Could we know your age, wegith, height,and gender? ");

        int age;
        double weight;
        double height;
        String gender;
        String check = scanner.next();

        if (check.equalsIgnoreCase("No")) {
            System.out.println("Sorry, to see you go.");
        } else {
            try {
                System.out.println();
                System.out.println("Great");
                System.out.println();
                System.out.println("What is your age? ");
                age = scanner.nextInt();

                if (age <= 0) {
                    throw new Exception("Age must be greater than zero");
                }
                System.out.println("What is your weight? ");
                weight = scanner.nextDouble();

                if (weight <= 0) {
                    throw new Exception("Weight must be greater than zero");
                }

                System.out.println("What is your height? ");
                height = scanner.nextDouble();

                if (height <= 0) {
                    throw new Exception("height must be greater than zero");
                }
                
                System.out.println("What is your gender? ");
                gender = scanner.next();

                System.out.println();
                delay();
                System.out.println("Your age is: " + " " + age);
                delay();
                System.out.println("Your weight is: " + " " + weight);
                delay();
                System.out.println("Your height is: " + " " + height);
                delay();
                System.out.println("Your gender is: " + " " + gender.toUpperCase());
                delay();

                System.out.println();
                bmi(weight, height, gender);
                System.out.println("What is your excercise level? 1 - 5");
                double totalBmr;

                int userInput = scanner.nextInt();

                if (userInput == 1) {
                    totalBmr = calories(weight, age, height, gender) * 1.2;
                } else if (userInput == 2) {
                    totalBmr = calories(weight, age, height, gender) * 1.375;
                } else if (userInput == 3) {
                    totalBmr = calories(weight, age, height, gender) * 1.55;
                } else if (userInput == 4) {
                    totalBmr = calories(weight, age, height, gender) * 1.725;
                } else {
                    totalBmr = calories(weight, age, height, gender) * 1.9;
                }

                double carb = ((totalBmr * 50) / 100) / 4;
                double protein = (totalBmr * 0.35) / 4;
                double fat = (totalBmr * 0.2) / 9;

                delay();
                System.out.printf("Your BMR is %.0f: \n", totalBmr);
                delay();
                System.out.printf("You need %.0f grams of carbohydrates per day.\n", carb);
                delay();
                System.out.printf("You need %.0f grams of protein per day.\n", protein);
                delay();
                System.out.printf("You need %.0f grams of fat per day.\n", fat);
                delay();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numeric values for age and weight.");
            }
        }
    }

    public static void bmi(double weitgt, double height, String gender) {
        System.out.println("Base on your gender, age, and heigth.");
        double bmindex = (weitgt / Math.pow(height / 100, 2));
        String category;

        if (gender.equalsIgnoreCase("M")) {
            if (bmindex < 20) {
                category = "Underweight";
            } else if (bmindex >= 20 && bmindex < 25) {
                category = "Normal weight";
            } else if (bmindex >= 25 && bmindex < 30) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }
        } else {
            if (bmindex < 19) {
                category = "Underweight";
            } else if (bmindex >= 19 && bmindex < 24) {
                category = "Normal weight";

            } else if (bmindex >= 24 && bmindex < 29) {
                category = "Overweight";
            } else {
                category = "Obesity";
            }
        }
        // delay();
        System.out.printf("Your BMI will be %.1f and your category is: %s\n", bmindex, category);
    }

    public static void intro() {
        System.out.println("This app is builded by Seth and Huy ");
        delay();
        System.out.println("The goal is to help people on their journey to meet their calories goals.");
        delay();
        System.out.println();
    }

    public static double calories(double weight, int age, double heigth, String gender) {
        if (gender.equalsIgnoreCase("M")) {
            return (weight * 10) + (6.25 * heigth) - 5 * age + 5;
        } else {
            return (weight * 10) + (6.25 * heigth) - 5 * age - 161;
        }
    }

    public static void delay() {
        try {
            Thread.sleep(1000); // wait for 1 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
