/*
 * @ Daniel Gil
 */

package entities;

public class Aluno {
    /*
     * 
     */
    public String name;
    public double trimestre1;
    public double trimestre2;
    public double trimestre3;

    public double FinalGrade() {
        return trimestre1 + trimestre2 + trimestre3;
    }

    public double MissingPoints() {
        if (FinalGrade() < 60.0) {
            return 60.0 - FinalGrade();
        } else {
            return 0.0;
        }
    }
}