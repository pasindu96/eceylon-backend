package lk.ac.eceylon.dto;

public class MonthlyReportDTO {
    private String label;
    private double y;

    public MonthlyReportDTO(String label, double y) {
        this.label = label;
        this.y = y;
    }

    public MonthlyReportDTO() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "MonthlyReportDTO{" +
                "month='" + label + '\'' +
                ", income=" + y +
                '}';
    }
}
