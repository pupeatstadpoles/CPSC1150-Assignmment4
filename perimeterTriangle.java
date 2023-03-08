
/**
 * Program Name: perimeterTriangle
 * Author: Pup Abdulgapul
 * Student ID: 100362791
 * Date: Oct 7, 2022
 * Course: CPSC1150-03
 * Professor: Hengameh Hamavand
 */

import java.util.Scanner;

public class perimeterTriangle { // Program to calculate and output the perimeter of a triangle given the coordinates of the points.
    public static void main(String[] args) { // main method
        int pointA_x, pointA_y, pointB_x, pointB_y, pointC_x, pointC_y;
        double perim;
        boolean valid;

        Scanner input = new Scanner(System.in);
        //repeat = true;

        do {
            System.out.println("This program calculates the perimeter of a triangle.");

            // Get coordinates of first point
            System.out.println("Please enter the x-coordinate of point A: ");
            pointA_x = input.nextInt();
            System.out.println("Please enter the y-coordinate of point A: ");
            pointA_y = input.nextInt();

            // Get coordinates of second point
            System.out.println("Please enter the x-coordinate of point B: ");
            pointB_x = input.nextInt();
            System.out.println("Please enter the y-coordinate of point B: ");
            pointB_y = input.nextInt();

            // Get coordinates of third point
            System.out.println("Please enter the x-coordinate of point C: ");
            pointC_x = input.nextInt();
            System.out.println("Please enter the y-coordinate of point C: ");
            pointC_y = input.nextInt();

            valid = verify_input(pointA_x, pointA_y, pointB_x, pointB_y, pointC_x, pointC_y);

            if (valid) {
                perim = calculate_perimeter(pointA_x, pointA_y, pointB_x, pointB_y, pointC_x, pointC_y);
                System.out.println("The perimeter of a Triangle with point A (" + pointA_x + "," + pointA_y + "), point 2 (" + pointB_x + "," + pointB_y + "), and pointC (" + pointC_x + "," + pointC_y + ") is " + perim);
            }
            else { // should run this if valid=false
                System.out.println("Error, invalid input. X and Y coordinates must be positive integers and between 0-40, and they should not be in a line!");
            }
            // check if user desires repeat
            System.out.println("Would you like to repeat the program? Please press 1 for Yes and 2 for No.");
            int answer = input.nextInt();
            if ((answer != 1) && (answer != 2)) {
                while ((answer != 1) && (answer != 2)) {
                    System.out.println("Error, invalid input. Please press 1 for Yes and 2 for No.");
                    answer = input.nextInt();
                }
            }
            /*switch (answer) {// should run this instead if answer is 1 or 2
                case 1:
                    System.out.println();
                    break;
                case 2:
                    repeat = false;
                    break;
            }*/
            if (answer==2){
                break;
            }
        } while (true); //should go back to the start of the do loop
        System.out.println("Ending program.");
        input.close();
    }

    /**
     * 
     * @param ax
     * @param ay
     * @param bx
     * @param by
     * @param cx
     * @param cy
     * @return
     */

    public static boolean verify_input(int ax, int ay, int bx, int by, int cx, int cy) {
        if (point_in_bounds(ax, ay) && point_in_bounds(bx, by) && point_in_bounds(cx, cy)) { // call point_in_bounds
            // check if area is 0, if its 0 then its a line
            int area = ((ax * (by - cy)) + (bx * (cy - ay)) + (cx * (ay - by))) / 2;
            if (area != 0) {
                return true;
            } 
        }
        return false;
    }

    /**
     * 
     * @param ax
     * @param ay
     * @param bx
     * @param by
     * @param cx
     * @param cy
     * @return
     */
    public static double calculate_perimeter(int ax, int ay, int bx, int by, int cx, int cy) {
        double lengthAB = distance(ax-bx, ay-by);
        double lengthBC = distance(bx-cx, by-cy);
        double lengthAC = distance(ax-cx, ay-cy);
        double sum = lengthAB + lengthAC + lengthBC;
        return sum;
    }

    /**
     * 
     * @param x is the x-coordinate of a point
     * @param y is the y-coordinate of a point
     * @return
     */
    public static boolean point_in_bounds(int x, int y) { // check if all of them are within 0-40
        return (x > 0) && (x <= 40) && (y > 0) && (y <= 40);
    }

    /**
     * pythagoras to get the length
     * @param x
     * @param y
     * @return
     */
    public static double distance(int x, int y) {
        return Math.sqrt((x*x)+(y*y));
    }
}
