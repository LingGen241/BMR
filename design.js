console.log("Welcome to FitApp");
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question("May we know your name? ", function(name) {
    console.log();
    console.log("Hi" + " " + name);
    console.log("Welcome" + " " + name.toUpperCase() + " " + "to our team");
    intro();
    console.log("Could we know your age, weight, height, and gender? ");

    let age;
    let weight;
    let height;
    let gender;
    
    rl.question("", function(check) {
        if (check.toLowerCase() === "no") {
            console.log("Sorry, to see you go.");
            rl.close();
        } else {
            try {
                console.log();
                console.log("Great");
                console.log();
                rl.question("What is your age? ", function(ageInput) {
                    age = parseInt(ageInput);
                    rl.question("What is your weight? kg ", function(weightInput) {
                        weight = parseFloat(weightInput);
                        rl.question("What is your height? cm ", function(heightInput) {
                            height = parseFloat(heightInput);
                            while (age <= 0 || weight <= 0 || height <= 0) {
                                if (age <= 0) {
                                    console.log("Invalid age. Please try again.");
                                    age = parseInt(rl.question(""));
                                }
                                if (weight <= 0) {
                                    console.log("Invalid weight. Please try again.");
                                    weight = parseFloat(rl.question(""));
                                }
                                if (height <= 0) {
                                    console.log("Invalid height. Please try again.");
                                    height = parseFloat(rl.question(""));
                                }
                            }
                            console.log("What is your gender? ");
                            rl.question("", function(genderInput) {
                                gender = genderInput.toLowerCase();
                                if (gender !== "m" && gender !== "f" && gender !== "male" && gender !== "female") {
                                    throw new Error("Invalid gender: " + gender + ". Gender must be M/F or Male/Female");
                                }
                                console.log();
                                delay();
                                console.log("Your age is: " + " " + age);
                                delay();
                                console.log("Your weight is: " + " " + weight);
                                delay();
                                console.log("Your height is: " + " " + height);
                                delay();
                                console.log("Your gender is: " + " " + gender.toUpperCase());
                                delay();
                                console.log();
                                delay();
                                bmi(weight, height, gender);
                                delay();
                                console.log("What is your exercise level? 1 - 5");
                                let totalBmr;
                                rl.question("", function(userInput) {
                                    userInput = parseInt(userInput);
                                    if (userInput === 1) {
                                        totalBmr = calories(weight, age, height, gender) * 1.2;
                                    } else if (userInput === 2) {
                                        totalBmr = calories(weight, age, height, gender) * 1.375;
                                    } else if (userInput === 3) {
                                        totalBmr = calories(weight, age, height, gender) * 1.55;
                                    } else if (userInput === 4) {
                                        totalBmr = calories(weight, age, height, gender) * 1.725;
                                    } else {
                                        totalBmr = calories(weight, age, height, gender) * 1.9;
                                    }
                                    let carb = ((totalBmr * 50) / 100) / 4;
                                    let protein = (totalBmr * 0.35) / 4;
                                    let fat = (totalBmr * 0.2) / 9;
                                    console.log("What is your goals? 1. To Lose Weight | 2. To Maintain Weight | 3. To Gain Muscles and Lose Body Fat");
                                    rl.question("", function(userDecision) {
                                        userDecision = parseInt(userDecision);
                                        while (true) {
                                            if (userDecision < 1 || userDecision > 3) {
                                                console.log("Invalid input.");
                                                userDecision = parseInt(rl.question(""));
                                            }
                                            if (userDecision === 1) {
                                                delay();
                                                console.log("Your BMR is " + (totalBmr - 500));
                                                delay();
                                                console.log("You need " + Math.round(carb) + " grams of carbohydrates per day.");
                                                delay();
                                                console.log("You need " + Math.round(protein) + " grams of protein per day.");
                                                delay();
                                                console.log("You need " + Math.round(fat) + " grams of fat per day.");
                                                delay();
                                                break;
                                            }
                                            if (userDecision === 2) {
                                                delay();
                                                console.log("Your BMR is " + totalBmr);
                                                delay();
                                                console.log("You need " + Math.round(carb) + " grams of carbohydrates per day.");
                                                delay();
                                                console.log("You need " + Math.round(protein) + " grams of protein per day.");
                                                delay();
                                                console.log("You need " + Math.round(fat) + " grams of fat per day.");
                                                delay();
                                                break;
                                            }
                                            if (userDecision === 3) {
                                                delay();
                                                console.log("Your BMR is " + (totalBmr + 150));
                                                delay();
                                                console.log("You need " + Math.round(carb) + " grams of carbohydrates per day.");
                                                delay();
                                                console.log("You need " + Math.round(protein + 75) + " grams of protein per day.");
                                                delay();
                                                console.log("You need " + Math.round(fat) + " grams of fat per day.");
                                                delay();
                                                break;
                                            }
                                        }
                                        rl.close();
                                    });
                                });
                            });
                        });
                    });
                });
            } catch (error) {
                console.log("Invalid input. Please enter numeric values for age and weight.");
                rl.close();
            }
        }
    });
});

function bmi(weight, height, gender) {
    console.log("Based on your gender, age, and height.");
    let bmindex = (weight / Math.pow(height / 100, 2));
    let category;
    if (gender !== "m" && gender !== "male") {
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
    delay();
    console.log("Your BMI will be " + bmindex.toFixed(1) + " and your category is: " + category);
}

function intro() {
    console.log("This app is built by Seth and Huy ");
    delay();
    console.log("The goal is to help people on their journey to meet their calories goals.");
    delay();
    console.log();
}

function calories(weight, age, height, gender) {
    if (gender === "m" || gender === "male") {
        return (weight * 10) + (6.25 * height) - 5 * age + 5;
    } else {
        return (weight * 10) + (6.25 * height) - 5 * age - 161;
    }
}

function delay() {
    const sleep = (milliseconds) => {
        return new Promise(resolve => setTimeout(resolve, milliseconds))
    }
    sleep(200);
}


