package lk.ac.eceylon.service;

import lk.ac.eceylon.dto.AdminIncomeDTO;
import lk.ac.eceylon.dto.MonthlyReportDTO;
import lk.ac.eceylon.dto.OrderProductDetailDTO;
import lk.ac.eceylon.dto.PopularDataDTO;
import lk.ac.eceylon.entity.OrderDetails;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDetailService {

    public boolean saveOrderDetails(OrderDetails od);
    public OrderDetails saveOrderDetail(OrderDetails od);
    public List<OrderDetails> getOrderIDFromProductID(int productID);
    public PopularDataDTO mostPopularSeller();
    public List<MonthlyReportDTO> countOrdersByProductID(int productID);
    public AdminIncomeDTO getIncomeBySeller(String email, String duration);
    public List<OrderProductDetailDTO> getOrderDetails(int productid);
}
