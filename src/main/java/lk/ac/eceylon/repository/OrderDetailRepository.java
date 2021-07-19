package lk.ac.eceylon.repository;

import lk.ac.eceylon.dto.IncomeDTO;
import lk.ac.eceylon.dto.OrderProductDetailDTO;
import lk.ac.eceylon.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetails,Integer> {
    List<OrderDetails> findOrderDetailsByProductProductID(@Param("productID")int productID);
    List<OrderDetails> findOrderDetailsByOrderOrderid(@Param("orderid")int orderid);
    @Query(value="select distinct(productID) from order_details", nativeQuery=true)
    List<Integer> getProductID();

//    @Query(value="select count(orderid) from order_details where product", nativeQuery=true)
    int countOrderDetailsByProductProductIDEquals(int productID);

    @Query(value="select count(odID) from order_details,orders where orders.orderid=order_details.orderid AND productID=? AND orders.orderdate BETWEEN ? AND ?", nativeQuery=true)
    int countOrderDetailsByProductProductIDEquals(@Param("productID")int productID, Timestamp start, Timestamp end);

    @Query(value="select count(order_details.orderid) as count, sum(order_details.quantity*product.unit_price) as amount from order_details,orders,product where orders.orderid=order_details.orderid AND order_details.productid=product.productid AND product.email=? AND orders.orderdate BETWEEN ? AND ?", nativeQuery=true)
    List<Object[]> getIncome(@Param("email")String email, Timestamp start, Timestamp end);

    @Query(value="select product.display_name,order_details.quantity,(product.unit_price*order_details.quantity) from order_details,product where order_details.productid=product.productid AND order_details.orderid= ?", nativeQuery=true)
    List<Object[]> getProductList(@Param("orderid")int orderid);
}
