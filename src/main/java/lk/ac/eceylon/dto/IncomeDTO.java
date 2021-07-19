package lk.ac.eceylon.dto;

public class IncomeDTO {
    private int count;
    private double amounnt;

    public IncomeDTO(int count, double amounnt) {
        this.count = count;
        this.amounnt = amounnt;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getAmounnt() {
        return amounnt;
    }

    public void setAmounnt(double amounnt) {
        this.amounnt = amounnt;
    }

    @Override
    public String toString() {
        return "IncomeDTO{" +
                "count=" + count +
                ", amounnt=" + amounnt +
                '}';
    }
}
