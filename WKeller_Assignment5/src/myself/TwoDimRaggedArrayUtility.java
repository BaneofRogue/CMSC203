 /*  Class: CMSC203 CRN 31338
 Program: Assignment #5
 Instructor: Ashique Tanveer
 Summary of Description: 
 Due Date: 04/25/2025
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Student: William Keller
 */
package myself;

import java.io.*;
import java.util.*;

public class TwoDimRaggedArrayUtility {

    // Method to read a file and return a two-dimensional ragged array
	public static double[][] readFile(File selectedFile) {
	    List<List<Double>> list = new ArrayList<>();
	    
	    try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            if (line.trim().isEmpty()) continue; // skip blank lines
	            String[] tokens = line.trim().split("\\s+");
	            List<Double> row = new ArrayList<>();
	            for (int i = 0; i < tokens.length; i++) {
	                row.add(Double.parseDouble(tokens[i]));
	            }
	            list.add(row);
	        }
	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e); // or log it
	    }

	    // Convert List to a 2D array
	    double[][] array = new double[list.size()][];
	    for (int i = 0; i < list.size(); i++) {
	        List<Double> rowList = list.get(i);
	        array[i] = new double[rowList.size()];
	        for (int j = 0; j < rowList.size(); j++) {
	            array[i][j] = rowList.get(j);
	        }
	    }
	    
	    return array;
	}

    // Method to write a 2D array to a file
	public static void writeToFile(double[][] array, File selectedFile) {
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile))) {
	        for (double[] row : array) {
	            for (int i = 0; i < row.length; i++) {
	                writer.write(row[i] + (i == row.length - 1 ? "" : " "));
	            }
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("Error writing to file: " + e.getMessage());
	    }
	}


    // Method to get the total of all elements in the array
    public static double getTotal(double[][] array) {
        double total = 0;
        for (double[] row : array) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    // Method to get the average of all elements in the array
    public static double getAverage(double[][] array) {
        double total = getTotal(array);
        int count = 0;
        for (double[] row : array) {
            count += row.length;
        }
        return total / count;
    }

    // Method to get the total of a specific row
    public static double getRowTotal(double[][] array, int rowIndex) {
        double total = 0;
        for (double value : array[rowIndex]) {
            total += value;
        }
        return total;
    }

    // Method to get the total of a specific column
    public static double getColumnTotal(double[][] array, int columnIndex) {
        double total = 0;
        for (double[] row : array) {
            if (columnIndex < row.length) {
                total += row[columnIndex];
            }
        }
        return total;
    }

    // Method to get the highest value in a specific row
    public static double getHighestInRow(double[][] array, int rowIndex) {
        double highest = array[rowIndex][0];
        for (int i = 1; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] > highest) {
                highest = array[rowIndex][i];
            }
        }
        return highest;
    }

    // Method to get the index of the highest value in a specific row
    public static int getHighestInRowIndex(double[][] array, int rowIndex) {
        double highest = getHighestInRow(array, rowIndex);
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] == highest) {
                return i;
            }
        }
        return -1;
    }

    // Method to get the lowest value in a specific row
    public static double getLowestInRow(double[][] array, int rowIndex) {
        double lowest = array[rowIndex][0];
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] < lowest) {
                lowest = array[rowIndex][i];
            }
        }
        return lowest;
    }

    // Method to get the index of the lowest value in a specific row
    public static int getLowestInRowIndex(double[][] array, int rowIndex) {
        double lowest = getLowestInRow(array, rowIndex);
        for (int i = 0; i < array[rowIndex].length; i++) {
            if (array[rowIndex][i] == lowest) {
                return i;
            }
        }
        return -1;
    }

    // Method to get the highest value in a specific column
    public static double getHighestInColumn(double[][] array, int columnIndex) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            if (columnIndex < row.length && row[columnIndex] > highest) {
                highest = row[columnIndex];
            }
        }
        return highest;
    }

    // Method to get the index of the highest value in a specific column
    public static int getHighestInColumnIndex(double[][] array, int columnIndex) {
        double highest = getHighestInColumn(array, columnIndex);
        for (int i = 0; i < array.length; i++) {
            if (columnIndex < array[i].length && array[i][columnIndex] == highest) {
                return i;
            }
        }
        return -1;
    }

    // Method to get the lowest value in a specific column
    public static double getLowestInColumn(double[][] array, int columnIndex) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            if (columnIndex < row.length && row[columnIndex] < lowest) {
                lowest = row[columnIndex];
            }
        }
        return lowest;
    }

    // Method to get the index of the lowest value in a specific column
    public static int getLowestInColumnIndex(double[][] array, int columnIndex) {
        double lowest = getLowestInColumn(array, columnIndex);
        for (int i = 0; i < array.length; i++) {
            if (columnIndex < array[i].length && array[i][columnIndex] == lowest) {
                return i;
            }
        }
        return -1;
    }

    // Method to get the highest value in the entire array
    public static double getHighestInArray(double[][] array) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    // Method to get the lowest value in the entire array
    public static double getLowestInArray(double[][] array) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : array) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }
}
