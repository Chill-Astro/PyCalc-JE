import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class PyCalc_JE {
    private static final String CURRENT_VERSION = "1.1";
    private static final String UPDATE_VERSION_URL = "https://gist.githubusercontent.com/Chill-Astro/e8c32d9a2b30780e3b6fd2819a51b330/raw/PyC_V.txt";

    private static void checkForUpdates() {
        try {
            URI uri = new URI(UPDATE_VERSION_URL); // Use URI to create a URL
            URL url = uri.toURL(); // Convert URI to URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000); // Timeout after 5 seconds
            connection.setReadTimeout(5000);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String latestVersion = reader.readLine().trim();
                reader.close();

                if (latestVersion.compareTo(CURRENT_VERSION) > 0) {
                    System.out.println("--- UPDATE AVAILABLE! ---\n" +
                                       "Yaaay! A NEW version of PyCalc-JE is Available! : " + latestVersion + "\n" +
                                       "Please visit github.com/Chill-Astro/PyCalc-JE to download the latest release!\n" +
                                       "-----------------------");
                } else if (latestVersion.equals(CURRENT_VERSION)) {
                    System.out.println("Hurrah! PyCalc is up to date!");
                } else {
                    System.out.println("WARNING!  This is a DEV. Build of PyCalc!\n");
                }
            } else {
                System.out.println("--- UPDATE CHECK FAILED! ---\n" +
                                   "WARNING! Could not check for updates. Please check your internet connection.\n" +
                                   "------------------------");
            }
        } catch (Exception e) {
            System.out.println("--- UPDATE CHECK FAILED ---\n" +
                               "WARNING! Error occurred while checking for updates.\n" +
                               "Error: " + e.getMessage() + "\n" +
                               "------------------------");
        }
    }
    public static void main(String[] args) {
        checkForUpdates();
        OpenScan sc = new OpenScan();
        System.out.println("PyCalc-JE : A Simple and Lightweight Calculator. Now in Java!\n" +
                           "Version : " + CURRENT_VERSION + "\n");        while (true) {
            System.out.println("Select a Mathematical Operation : \n" +
                               "1. Addition\n" + "2. Subtraction\n" + "3. Multiplication\n" + "4. Division\n" + "5. Exponents (x^y)\n" + "6. Square Root\n" +
                               "7. Cube Root\n" + "8. Approximate / Rounding\n" + "9. Heron's Formula\n" + "10. Simple Interest\n" + "11. Compound Interest\n" + "12. Prime No. Check\n" +
                               "13. Triangle Check\n" + "14. Right Triangle Check\n" + "15. Perimeter [Various Shapes]\n" + "16. Area [Various Shapes]\n" +
                               "17. Volume [Various Shapes]\n" + "18. Surface Area [Various Shapes]\n" + "19. Curved Surface Area [Various Shapes]\n" +
                               "20. Diagonal Calculation [Various Shapes]\n" + "21. Factorial Calculator\n" + "22. Exit PyCalc-JE\n");
            System.out.print("Enter choice [ 1 - 22 ] : ");
            String choice = sc.nextLine();
            System.out.println();
            if (choice.equals("1")) { // Addition
                try {
                    System.out.print("Enter first number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second number : ");
                    double y = sc.nextDouble();
                    System.out.println();
                    System.out.println(x + " + " + y + " = " + (x + y) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("2")) { // Subtraction
                 try {
                    System.out.print("Enter first number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second number : ");
                    double y = sc.nextDouble();
                    System.out.println();
                    System.out.println(x + " - " + y + " = " + (x - y) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("3")) { // Multiplication
                 try {
                    System.out.print("Enter first number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second number : ");
                    double y = sc.nextDouble();
                    System.out.println();
                    System.out.println(x + " * " + y + " = " + (x * y) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("4")) { // Division
                try {
                    System.out.print("Enter first number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second number : ");
                    double y = sc.nextDouble();
                    System.out.println();
                    if (y == 0) {
                        System.out.println("Div. by Zero Not Defined!\n");
                    } else {
                        System.out.println(x + " / " + y + " = " + (x / y) + "\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("5")) { // Exponents
                 try {
                    System.out.print("Enter base number (x) : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter exponent (y) : ");
                    double y = sc.nextDouble();
                    System.out.println();
                    System.out.println(x + " ^ " + y + " = " + Math.pow(x, y) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("6")) { // Square Root
                try {
                    System.out.print("Enter a number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                     if (x < 0) {
                        System.out.println("Square root of a negative number is not real.\n");
                    } else {
                       System.out.println("Root " + x + " = " + Math.sqrt(x) + "\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("7")) { // Cube Root
                 try {
                    System.out.print("Enter a number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.println("C. Root " + x + " = " + Math.cbrt(x) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("8")) { // Rounding
                 try {
                    System.out.print("Enter a number : ");
                    double x = sc.nextDouble();
                    System.out.println();
                    System.out.println(Math.round(x) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("9")) { // Heron's Formula
                try {
                    System.out.println("NOTE: Some Calculations may print 0.0 depending on the values!\n");
                    System.out.print("Enter the first side [a] : ");
                    double a = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the second side [b] : ");
                    double b = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter third side [c] : ");
                    double c = sc.nextDouble();
                    System.out.println();

                    if (a <= 0 || b <= 0 || c <= 0) {
                        System.out.println("Sides must be +ve.\n");
                    } else {
                        double s = (a + b + c) / 2;
                        System.out.println("Perimeter : " + (a + b + c));
                        System.out.println("s = " + s);
                        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
                        System.out.println("Area : " + area);
                        System.out.println();
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("10")) { // Simple Interest
                 try {
                    System.out.print("Enter the Principal : ");
                    double p = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the Rate [ % ] : ");
                    double r = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the Time [ Years ] : ");
                    double t = sc.nextDouble();
                    System.out.println();
                    double si = p * r * t / 100;
                    System.out.println("Simple Interest : " + si + "\nAmount : " + (si + p) + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("11")) { // Compound Interest
                try {
                    System.out.println("Compound Interest Calculation\n");
                    System.out.print("Enter the Principal : ");
                    double p = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the Rate [ % ] : ");
                    double r = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the number of times interest is compounded per year : ");
                    double n = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter the Time [ Years ] : ");
                    double t = sc.nextDouble();
                    System.out.println();
                    double amount = p * Math.pow((1 + r / (100 * n)), n * t);
                    double ci = amount - p;
                    System.out.println("Compound Interest : " + ci + "\nAmount : " + amount + "\n");
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("12")) { // Prime Number Check
                 try {
                    System.out.print("Enter a Number : ");
                    int x = sc.nextInt();
                    System.out.println();
                    boolean isPrime = true;
                    if (x <= 1) {
                        isPrime = false;
                    } else {
                        for (int i = 2; i <= Math.sqrt(x); i++) {
                            if (x % i == 0) {
                                isPrime = false;
                                break;
                            }
                        }
                    }
                    if (isPrime) {
                        System.out.println(x + " is a Prime Number\n");
                    } else {
                        System.out.println(x + " is not a Prime Number\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("13")) { // Triangle Check
                try {
                    System.out.print("Enter first side [a] : ");
                    double a = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second side [b] : ");
                    double b = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter third side [c] : ");
                    double c = sc.nextDouble();
                    System.out.println();

                    if (a <= 0 || b <= 0 || c <= 0) {
                        System.out.println("Sides must be +ve\n");
                    } else if ((a + b > c) && (a + c > b) && (b + c > a)) {
                        System.out.println("Valid Triangle\n");
                    } else {
                        System.out.println("Not a Valid Triangle\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("14")) { // Right Triangle Check
                try {
                    System.out.print("Enter first side [a] : ");
                    double a = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter second side [b] : ");
                    double b = sc.nextDouble();
                    System.out.println();
                    System.out.print("Enter third side [c] : ");
                    double c = sc.nextDouble();
                    System.out.println();

                    if (a <= 0 || b <= 0 || c <= 0) {
                        System.out.println("Sides must be +ve\n");
                    } else if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ||
                               Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2) ||
                               Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
                        System.out.println("Is a Right Triangle\n");
                    } else {
                        System.out.println("Not a Right Triangle.\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("15")) { // Perimeter [Various Shapes]
                System.out.println("Perimeter Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Equilateral Triangle\n" + "2. Isosceles Triangle\n" + "3. Square / Rhombus\n" + "4. Rectangle / Parallelogram\n" + "5. Circle\n");
                System.out.print("Enter shape choice [ 1 - 5 ]: ");
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                    if (shapeChoice.equals("1")) { // Equilateral Triangle
                        System.out.print("Enter Side Length [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        System.out.println("Perimeter : " + (3 * a) + "\n");
                    } else if (shapeChoice.equals("2")) { // Isosceles Triangle
                        System.out.print("Enter Equal Side's Length : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Non-Equal Side's Length : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        System.out.println("Perimeter : " + (2 * a + b) + "\n");
                    } else if (shapeChoice.equals("3")) { // Square / Rhombus
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        System.out.println("Perimeter : " + (4 * a) + "\n");
                    } else if (shapeChoice.equals("4")) { // Rectangle / Parallelogram
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        System.out.println("Perimeter : " + (2 * (l + b)) + "\n");
                    } else if (shapeChoice.equals("5")) { // Circle
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double circumference = 2 * Math.PI * r;
                        System.out.println("Circumference : " + circumference + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Perimeter Calculation ...\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("16")) { // Area [Various Shapes]
                System.out.println("Area Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Equilateral Triangle\n" + "2. Isosceles Triangle\n" + "3. Square\n" + "4. Rectangle / Parallelogram\n" +
                                   "5. Rhombus\n" + "6. Circle\n" + "7. Semi-circle\n");
                System.out.print("Enter shape choice [ 1 - 7 ] : ");
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                    if (shapeChoice.equals("1")) { // Equilateral Triangle
                        System.out.print("Enter Side Length [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double area = (Math.sqrt(3) / 4) * Math.pow(a, 2);
                        System.out.println("Area : " + area + "\n");
                    } else if (shapeChoice.equals("2")) { // Isosceles Triangle
                        System.out.print("Enter Equal Side's Length : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Non-Equal Side's Length : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        // Check if the triangle inequality holds for the base and two equal sides
                        if (2 * a <= b) {
                            System.out.println("Invalid side lengths for an isosceles triangle.\n");
                        } else {
                             double area = (b / 4) * Math.sqrt(4 * Math.pow(a, 2) - Math.pow(b, 2));
                             System.out.println("Area : " + area + "\n");
                        }
                    } else if (shapeChoice.equals("3")) { // Square
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double area = Math.pow(a, 2);
                        System.out.println("Area : " + area + "\n");
                    } else if (shapeChoice.equals("4")) { // Rectangle / Parallelogram
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        double area = l * b;
                        System.out.println("Area : " + area + "\n");
                    } else if (shapeChoice.equals("5")) { // Rhombus
                        System.out.print("Enter Diagonal 1 [d1] : ");
                        double d1 = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Diagonal 2 [d2] : ");
                        double d2 = sc.nextDouble();
                        System.out.println();
                        double area = 0.5 * d1 * d2;
                        System.out.println("Area of Rhombus : " + area + "\n");
                    } else if (shapeChoice.equals("6")) { // Circle
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double area = Math.PI * Math.pow(r, 2);
                        System.out.println("Area : " + area + "\n");
                    } else if (shapeChoice.equals("7")) { // Semi-circle
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double area = 0.5 * Math.PI * Math.pow(r, 2);
                        System.out.println("Area : " + area + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Area Calculation ...\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("17")) { // Volume [Various Shapes]
                 System.out.println("Volume Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Cube\n" + "2. Cuboid\n" + "3. Cylinder\n" + "4. Cone\n" + "5. Sphere\n");
                System.out.print("Enter shape choice [ 1 - 5 ] : ");
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                    if (shapeChoice.equals("1")) { // Cube
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double vol = Math.pow(a, 3);
                        System.out.println("Volume : " + vol + "\n");
                    } else if (shapeChoice.equals("2")) { // Cuboid
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double vol = l * b * h;
                        System.out.println("Volume : " + vol + "\n");
                    } else if (shapeChoice.equals("3")) { // Cylinder
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double vol = Math.PI * Math.pow(r, 2) * h;
                        System.out.println("Volume : " + vol + "\n");
                    } else if (shapeChoice.equals("4")) { // Cone
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double vol = (1.0 / 3.0) * Math.PI * Math.pow(r, 2) * h;
                        System.out.println("Volume : " + vol + "\n");
                    } else if (shapeChoice.equals("5")) { // Sphere
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double vol = (4.0 / 3.0) * Math.PI * Math.pow(r, 3);
                        System.out.println("Volume : " + vol + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Volume Calculation ...\n");
                    }
                 } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("18")) { // Surface Area [Various Shapes]
                 System.out.println("Surface Area Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Cube\n" + "2. Cuboid\n" + "3. Cylinder\n" + "4. Cone\n" + "5. Sphere\n");
                System.out.print("Enter shape choice [ 1 - 5 ] : ");
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                     if (shapeChoice.equals("1")) { // Cube
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double sa = 6 * Math.pow(a, 2);
                        System.out.println("Surface Area : " + sa + "\n");
                    } else if (shapeChoice.equals("2")) { // Cuboid
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double sa = 2 * (l * b + b * h + h * l);
                        System.out.println("Surface Area : " + sa + "\n");
                    } else if (shapeChoice.equals("3")) { // Cylinder
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double sa = 2 * Math.PI * r * (r + h);
                        System.out.println("Surface Area : " + sa + "\n");
                    } else if (shapeChoice.equals("4")) { // Cone
                         System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double sa = Math.PI * r * (r + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)));
                        System.out.println("Surface Area : " + sa + "\n");
                    } else if (shapeChoice.equals("5")) { // Sphere
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double sa = 4 * Math.PI * Math.pow(r, 2);
                        System.out.println("Surface Area : " + sa + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Surface Area Calculation ...\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("19")) { // Curved Surface Area [Various Shapes]
                 System.out.println("Curved Surface Area Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Cylinder\n" + "2. Cone\n" + "3. Sphere\n");
                System.out.print("Enter shape choice [ 1 - 3 ] : ");
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                    if (shapeChoice.equals("1")) { // Cylinder
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double csa = 2 * Math.PI * r * h;
                        System.out.println("Curved Surface Area : " + csa + "\n");
                    } else if (shapeChoice.equals("2")) { // Cone
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter the Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double csa = Math.PI * r * Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2));
                        System.out.println("Curved Surface Area : " + csa + "\n");
                    } else if (shapeChoice.equals("3")) { // Sphere
                        System.out.print("Enter the Radius [r] : ");
                        double r = sc.nextDouble();
                        System.out.println();
                        double csa = 4 * Math.PI * Math.pow(r, 2); // Note: Python code had 2 * pi * r^2, full sphere CSA is 4 * pi * r^2
                        System.out.println("Curved Surface Area : " + csa + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Curved Surface Area Calculation ...");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("20")) { // Diagonal Calculation [Various Shapes]
                System.out.println("Diagonal Calculation [Various Shapes]\n" +
                                   "Select a shape : \n" + "1. Square\n" + "2. Rectangle\n" + "3. Cube\n" + "4. Cuboid\n");
                System.out.print("Enter shape choice [ 1 - 4 ] : "); // Corrected range in prompt
                String shapeChoice = sc.nextLine();
                System.out.println();

                try {
                    if (shapeChoice.equals("1")) { // Square
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double d = Math.sqrt(2) * a;
                        System.out.println("Diagonal : " + d + "\n");
                    } else if (shapeChoice.equals("2")) { // Rectangle
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        double d = Math.sqrt(Math.pow(l, 2) + Math.pow(b, 2));
                        System.out.println("Diagonal : " + d + "\n");
                    } else if (shapeChoice.equals("3")) { // Cube
                        System.out.print("Enter Length of Side [a] : ");
                        double a = sc.nextDouble();
                        System.out.println();
                        double d = Math.sqrt(3) * a;
                        System.out.println("Diagonal : " + d + "\n");
                    } else if (shapeChoice.equals("4")) { // Cuboid
                        System.out.print("Enter Length [l] : ");
                        double l = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Breadth [b] : ");
                        double b = sc.nextDouble();
                        System.out.println();
                        System.out.print("Enter Height [h] : ");
                        double h = sc.nextDouble();
                        System.out.println();
                        double d = Math.sqrt(Math.pow(l, 2) + Math.pow(b, 2) + Math.pow(h, 2));
                        System.out.println("Diagonal : " + d + "\n");
                    } else {
                        System.out.println("Invalid Option! Exiting Diagonal Calculation ...");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter numbers only.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("21")) { // Factorial Calculation
                try {
                    System.out.print("Enter a Number : ");
                    int x = sc.nextInt();
                    System.out.println();

                    if (x < 0) {
                        System.out.println("\nFactorial Not Defined for Negative Numbers!\n");
                    } else if (x == 0 || x == 1) {
                        System.out.println("\nFactorial of " + x + " is 1\n");
                    } else {
                        long fact = 1; // Use long for larger factorials
                        for (int i = 2; i <= x; i++) {
                            fact *= i;
                        }
                        System.out.println("\nFactorial of " + x + " is " + fact + "\n");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.\n");
                    sc.next(); // Consume the invalid input
                }
            } else if (choice.equals("22")) { // Exit Program
                System.out.println("Exiting PyCalc-JE....");
                sc.close(); // Close the sc
                System.exit(0);
            } else { // Default Case
                System.out.println("Please enter a Valid Input! Restarting PyCalc-JE...\n");
            }

            System.out.print("Do you Want to Perform Another Calculation? [y/n]: ");
            String nextCalc = sc.nextLine();
            System.out.println();

            if (nextCalc.equalsIgnoreCase("n") || nextCalc.equalsIgnoreCase("no")) {
                System.out.println("Exiting PyCalc-JE....");
                break; // Exit the while loop
            } else if (!(nextCalc.equalsIgnoreCase("y") || nextCalc.equalsIgnoreCase("yes"))) {
                 System.out.println("Please enter a Valid Input! Restarting PyCalc ...\n");
            }
        }

        sc.close(); // Ensure sc is closed if loop is exited otherwise than System.exit(0)
    }
}