import java.util.*;

/*
    Line
    Owen Wang
    Last modified: 2022-04-29
    Calculate different properties of lines.
*/
public class Line {

    /*
     * double length(int x1, int y1, int x2, int y2)
     * returns double - length of line segment
     * int x1, y1, x2, y2 - coordinates of line
     * This method takes in the position of a line and outputs length.
     */
    public static double length(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    /*
     * double slope(int x1, int y1, int x2, int y2)
     * returns double - slope of line segment
     * int x1, y1, x2, y2 - coordinates of line
     * This method takes in the position of a line and outputs slope.
     */
    public static double slope(int x1, int y1, int x2, int y2) {
        return (Math.abs(y2 - y1)) / (Math.abs(x2 - x1));
    }

    public static void main(String[] args) {
    }
}
