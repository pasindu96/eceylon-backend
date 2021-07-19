package lk.ac.eceylon.controller;

import lk.ac.eceylon.dto.AdminIncomeDTO;
import lk.ac.eceylon.dto.MonthlyReportDTO;
import lk.ac.eceylon.dto.UserOrdersDTO;
import lk.ac.eceylon.entity.OrderDetails;
import lk.ac.eceylon.entity.Orders;
import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.repository.OrderDetailRepository;
import lk.ac.eceylon.repository.OrderRepository;
import lk.ac.eceylon.service.OrderDetailService;
import lk.ac.eceylon.service.OrderService;
import lk.ac.eceylon.service.ProductService;
import lk.ac.eceylon.service.impl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailService orderDetailService;


    @PostMapping(value ="/order",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Orders saveOrder(@RequestBody Orders order){
        return orderService.saveOrder(order);
    }

    @GetMapping(value ="/orders/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserOrdersDTO> getAllOrders(@PathVariable String email){
        List<Product> productList= productService.getProductByUser(email);
        List<OrderDetails> odList=null;
        List<UserOrdersDTO> orderList=new ArrayList<UserOrdersDTO>();

        for (Product product:productList) {

            odList=orderDetailService.getOrderIDFromProductID(product.getProductID());

            for(OrderDetails od: odList){

                System.out.println(od.getOrder().getOrderid()+" ------");

                for (Orders o :orderService.getOrdersByOrderIDAndStatus(od.getOrder().getOrderid())) {

                    UserOrdersDTO order=new UserOrdersDTO();
                    order.setProductID(product.getProductID());
                    order.setDisplayName(product.getDisplayName());

                    order.setQuantity(od.getQuantity());

                    order.setEmail(o.getUser().getEmail());
                    order.setName(o.getUser().getFullname());
                    order.setAddress(o.getUser().getAddress());
                    order.setMobile(o.getUser().getMobile());

                    order.setOrderID(o.getOrderid());
                    order.setAmount(o.getAmount());
                    order.setDate((Timestamp)o.getDate());

                    orderList.add(order);

                    System.out.println(orderList);

                }
            }
        }
        return orderList;
    }
    @PostMapping(value ="/order/confirm",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean confirmOrder(@RequestBody Orders order){

        System.out.println(order);
        return orderService.confirmOrder(order);
    }

    @GetMapping(value ="/order/income/{period}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminIncomeDTO getOrdersByPeriod(@PathVariable("period")String period){
        return orderService.getIncome(period.replace("period=",""));
    }

    @GetMapping(value="/order/buyer/{email}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Orders> getAllOrdersByEmail(@PathVariable("email") String email){
        return orderService.getOrdersByUserEmail(email.replace("email=",""));
    }

    @GetMapping(value = "/graph",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthlyReportDTO> sample(){
        List<MonthlyReportDTO> list= orderService.getIncomePerMonth();
        Collections.reverse(list);
        return list;
    }

    @GetMapping(value="/order/product/{productid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MonthlyReportDTO> getProductOrdersDuringYear(@PathVariable("productid") String productid){
        productid=productid.replace("productid=","");
        System.out.println(productid);
        return orderDetailService.countOrdersByProductID(Integer.parseInt(productid));

    }

    @GetMapping(value = "/order/seller/income/{email}/{period}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminIncomeDTO getIncomeBySeller(@PathVariable("email")String email,@PathVariable("period") String period){
        email=email.replace("email=","");
        period=period.replace("period=","");
        return orderDetailService.getIncomeBySeller(email,period);
    }

}
