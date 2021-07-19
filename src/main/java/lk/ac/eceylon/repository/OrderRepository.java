package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    String sql="SELECT orderid,amount FROM orders WHERE orderdate >= DATE_SUB(CURDATE(),INTERVAL 7 DAY)";
    List<Orders> findOrdersByOrderidAndStatus(@PathVariable("orderid")int orderid, @PathVariable("status")String status);
    List<Orders> findOrdersByOrderid(@PathVariable("orderid")int orderid);
    List<Orders> findByOrderdateBetween(Timestamp start,Timestamp end);
    List<Orders> findOrdersByUserEmail(String email);

}
