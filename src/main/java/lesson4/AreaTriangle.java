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


   public static void main(String[] args) {
        System.out.println(heronsFormula(16, 22, 16));
        System.out.println(heronsFormula(3, 4, 5));
        System.out.println(heronsFormula(200, 0, 200));
       System.out.println(heronsFormula(169, 202, 136));
    }

}
