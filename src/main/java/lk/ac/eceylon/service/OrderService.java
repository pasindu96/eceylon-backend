package lk.ac.eceylon.service;

import lk.ac.eceylon.dto.AdminIncomeDTO;
import lk.ac.eceylon.dto.MonthlyReportDTO;
import lk.ac.eceylon.entity.Orders;

import java.sql.Timestamp;
import java.util.List;

public interface OrderService {
    public Orders saveOrder(Orders order);
    public List<Orders> getOrdersByOrderIDAndStatus(int orderid);
    public boolean confirmOrder(Orders order);
    public List<Orders> getOrdersByDateBetween(String duration);
    public AdminIncomeDTO getIncome(String duration);
    public List<Orders> getOrdersByUserEmail(String email);
    public List<MonthlyReportDTO> getIncomePerMonth();
}
