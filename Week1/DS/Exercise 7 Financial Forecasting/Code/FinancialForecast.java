public class FinancialForecast {
    // Method to calculate future value using recursion
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if no periods left, return the present value
        if (periods <= 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for one less period
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;  // Initial investment
        double growthRate = 0.05;      // Growth rate of 5%
        int periods = 10;              // Number of periods

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.println("Future Value: $" + String.format("%.2f", futureValue));
    }
}
