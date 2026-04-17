/*
 * @ Daniel Gil
 */

package entities;

import java.util.Date;

public class HourContract {
    private Date moment;
    private Double valuePerHour;
    private Integer hours;

    public HourContract() {
    }

    public HourContract(Date moment, Double valuePerHour, Integer hours) {
        this.moment = moment;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "HourContract [moment=" + moment + ", valuePerHour=" + valuePerHour + ", hours=" + hours + "]";
    }

    /*------------------------------------------------------------------------------------------ */

    public Double totalValue() {
        return valuePerHour * hours;
    };

}
