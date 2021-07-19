package lk.ac.eceylon.controller;

import lk.ac.eceylon.EceylonApplication;
import lk.ac.eceylon.dto.OrderDetailDTO;
import lk.ac.eceylon.dto.OrderProductDetailDTO;
import lk.ac.eceylon.dto.PopularDataDTO;
import lk.ac.eceylon.entity.OrderDetails;
import lk.ac.eceylon.entity.Orders;
import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.repository.OrderDetailRepository;
import lk.ac.eceylon.service.OrderDetailService;
import lk.ac.eceylon.service.ShoppingCartService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class OrderDetailsController {
    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    private ShoppingCartService cartService;

    @PostMapping(value ="/orderdetail",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveOrder(@RequestBody OrderDetailDTO order){
        Product p=new Product();
        p.setProductID(order.getProductid());
        Orders o=new Orders();
        o.setOrderid(order.getOrderid());

        OrderDetails od=new OrderDetails();
        od.setProduct(p);
        od.setOrder(o);
        od.setQuantity(order.getQuantity());

//        System.out.println(od);
//        return true;
        cartService.updateCart(order.getCartid());
        return orderDetailService.saveOrderDetails(od);
    }

    @GetMapping(value ="/orderdetail/report",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PopularDataDTO getPopularProductAndSeller(){
        return orderDetailService.mostPopularSeller();
    }

    @GetMapping(value = "/orderdetail/view/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderProductDetailDTO> getOrderDetails(@PathVariable String orderid){
        System.out.println( orderDetailService.getOrderDetails(Integer.parseInt(orderid)));
        return orderDetailService.getOrderDetails(Integer.parseInt(orderid));
    }
}
