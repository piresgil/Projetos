/*
 * @ Daniel Gil
 */

package entities;

public class Employee {
    /*
     * Class Employee
     */
    public String name;
    public double grossSalary;
    public double tax;

    public double NetSalary() {
        return grossSalary - tax;
    }

    public void IncreaseSalary(double percentage) {
        this.grossSalary += grossSalary * percentage / 100;
    }

    public String ToString() {
        return name
                + ", $ "
                + String.format("%.2f", NetSalary());
    }
}