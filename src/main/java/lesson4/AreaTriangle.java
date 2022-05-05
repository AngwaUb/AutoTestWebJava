package lesson4;

public class AreaTriangle {
    public static double heronsFormula(int a, int b, int c) {
        if (a < 0 || b < 0 || c < 0) {
            return Double.NaN;
        } else {
            double p = (a + b + c) / 2.0;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
    }
}
