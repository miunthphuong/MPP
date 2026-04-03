public class Paycheck {
    private final double grossPay;
    private final double fica;
    private final double state;
    private final double local;
    private final double medicare;
    private final double socialSecurity;

    public Paycheck(double grossPay) {
        this.grossPay = grossPay;

        // Simple tax calculations (example)
        this.fica = grossPay * 0.0765;
        this.state = grossPay * 0.05;
        this.local = grossPay * 0.02;
        this.medicare = grossPay * 0.0145;
        this.socialSecurity = grossPay * 0.062;
    }

    public double getNetPay() {
        return grossPay - (fica + state + local + medicare + socialSecurity);
    }

    public void print() {
        System.out.println("Gross Pay: " + grossPay);
        System.out.println("Net Pay: " + getNetPay());
    }
}