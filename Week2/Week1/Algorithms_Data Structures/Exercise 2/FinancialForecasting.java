// Algorithms Data Structures
// Exercise 2: Financial Forecasting

import java.util.HashMap;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValueRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValueRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Memoized (optimized recursive) method
    public static double futureValueMemo(double presentValue, double growthRate, int years, HashMap<Integer, Double> memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double result = futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        memo.put(years, result);
        return result;
    }

    // Iterative method
    public static double futureValueIterative(double presentValue, double growthRate, int years) {
        for (int i = 0; i < years; i++) {
            presentValue *= (1 + growthRate);
        }
        return presentValue;
    }
    
    // Main Method
    public static void main(String[] args) {
        double presentValue = 1000.0;     // Initial amount
        double growthRate = 0.10;         // 10% growth per year
        int years = 5;                    // Forecasting for 5 years

        double resultRecursive = futureValueRecursive(presentValue, growthRate, years);
        double resultMemo = futureValueMemo(presentValue, growthRate, years, new HashMap<>());
        double resultIterative = futureValueIterative(presentValue, growthRate, years);

        System.out.printf("Recursive Future Value after %d years: $%.2f\n", years, resultRecursive);
        System.out.printf("Memoized Future Value after %d years: $%.2f\n", years, resultMemo);
        System.out.printf("Iterative Future Value after %d years: $%.2f\n", years, resultIterative);
    }
}
