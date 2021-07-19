package lk.ac.eceylon.dto;

public class AdminIncomeDTO {
    private int orders;
    private double income;
    private String timePeriod;

    public AdminIncomeDTO() {
    }
    public AdminIncomeDTO(int orders, double income, String timePeriod) {
        this.orders = orders;
        this.income = income;
        this.timePeriod = timePeriod;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public String toString() {
        return "AdminIncomeDTO{" +
                "orders=" + orders +
                ", income='" + income + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                '}';
    }
}
