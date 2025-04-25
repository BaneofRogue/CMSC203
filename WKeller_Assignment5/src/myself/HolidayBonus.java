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

public class HolidayBonus {

    // Constant values for the bonus amounts
    public static final double HIGHEST_BONUS = 5000;
    public static final double LOWEST_BONUS = 1000;
    public static final double OTHER_BONUS = 2000;

    // Method to calculate holiday bonuses for all stores
    public static double[] calculateHolidayBonus(double[][] sales) {
        double[] bonuses = new double[sales.length];

        for (int i = 0; i < sales.length; i++) {
            // If the store's sales are all zero or negative, it doesn't qualify for a bonus
            boolean isEligible = false;
            for (int j = 0; j < sales[i].length; j++) {
                if (sales[i][j] > 0) {
                    isEligible = true;
                    break;
                }
            }
            if (!isEligible) {
                bonuses[i] = 0;
                continue;
            }

            // Check if the store is the only one with sales in this category
            boolean isOnlyOneStore = true;
            for (int j = 0; j < sales.length; j++) {
                boolean hasSales = false;

                for (double sale : sales[j]) {
                    if (sale > 0) {
                        hasSales = true;
                        break;
                    }
                }

                if (j != i && hasSales) {
                    isOnlyOneStore = false;
                    break;
                }
            }
            if (isOnlyOneStore) {
                bonuses[i] = HIGHEST_BONUS;
                continue;
            }

            // Find the highest and lowest sales across all stores using getRowTotal
            double highest = Double.MIN_VALUE;
            double lowest = Double.MAX_VALUE;
            for (int j = 0; j < sales.length; j++) {
                boolean hasSales = false;

                for (double sale : sales[j]) {
                    if (sale > 0) {
                        hasSales = true;
                        break;
                    }
                }

                if (hasSales) {
                    double storeHighest = TwoDimRaggedArrayUtility.getHighestInRow(sales, j);
                    double storeTotal = TwoDimRaggedArrayUtility.getRowTotal(sales, j);
                    double storeLowest = storeTotal; // Using the row total to represent the lowest
                    highest = Math.max(highest, storeHighest);
                    lowest = Math.min(lowest, storeTotal); // Store the lowest total sales
                }
            }

            // Assign bonuses based on sales
            double storeSales = TwoDimRaggedArrayUtility.getHighestInRow(sales, i);  // Use the highest sales value for the store
            System.out.println("The store sales are: " + storeSales);
            if (storeSales == highest) {
                bonuses[i] = HIGHEST_BONUS;
            } else if (storeSales == lowest) {
                bonuses[i] = LOWEST_BONUS;
            } else {
                bonuses[i] = OTHER_BONUS;
            }
        }
        return bonuses;
    }

    // Method to calculate the total holiday bonuses for all stores
    public static double calculateTotalHolidayBonus(double[][] sales) {
        double[] bonuses = calculateHolidayBonus(sales);
        double total = 0;
        for (double bonus : bonuses) {
            total += bonus;
        }
        return total;
    }
}
