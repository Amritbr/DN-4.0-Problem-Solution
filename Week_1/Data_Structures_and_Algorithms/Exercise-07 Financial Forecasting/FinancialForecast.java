public class FinancialForecast {

    public static double forecastRecursive(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return forecastRecursive(principal, rate, years - 1) * (1 + rate);
    }

    public static double forecastMemoized(double principal, double rate, int years, Double[] memo) {
        if (years == 0) return principal;
        if (memo[years] != null) return memo[years];
        memo[years] = forecastMemoized(principal, rate, years - 1, memo) * (1 + rate);
        return memo[years];
    }

    public static void main(String[] args) {
        double principal = 10000;  
        double rate = 0.08;        
        int years = 5;            

        System.out.println("Recursive Forecast:");
        double futureValue = forecastRecursive(principal, rate, years);
        System.out.printf("Future value after %d years: Rs%.2f\n", years, futureValue);

        System.out.println("\nMemoized Forecast:");
        Double[] memo = new Double[years + 1];
        double futureValueMemo = forecastMemoized(principal, rate, years, memo);
        System.out.printf("Future value after %d years (optimized): Rs%.2f\n", years, futureValueMemo);
    }
}