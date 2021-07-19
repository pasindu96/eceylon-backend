package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.dto.*;

import java.math.BigInteger;

import lk.ac.eceylon.entity.OrderDetails;
import lk.ac.eceylon.entity.Orders;
import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.repository.OrderDetailRepository;
import lk.ac.eceylon.repository.ProductRepository;
import lk.ac.eceylon.service.OrderDetailService;
import lk.ac.eceylon.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class OrderDetailServiceImpl implements OrderDetailService {
    private final long day=1000*60*60*24;
    private final long week=1000*60*60*24*7;
    private final long month=1000*60*60*24*30L;
    private final long year=1000*60*60*24*365L;
    @Autowired
    OrderDetailRepository repository;
    @Autowired
    ProductRepository productRepository;

    OrderServiceImpl od=new OrderServiceImpl();

    @Override
    public boolean saveOrderDetails(OrderDetails od) {
        if(repository.save(od)!=null)
            return true;
        else
            return false;
    }

    @Override
    public OrderDetails saveOrderDetail(OrderDetails od) {
        return repository.save(od);
    }

    @Override
    public List<OrderDetails> getOrderIDFromProductID(int productID) {
        return repository.findOrderDetailsByProductProductID(productID);
    }

    @Override
    public PopularDataDTO mostPopularSeller() {
        List<Integer> productList= repository.getProductID();
        int productCount=0;
        int maxCount=0;
        int productID=1;

        for (int pid:productList) {
            productCount=repository.countOrderDetailsByProductProductIDEquals(pid);
            if(maxCount<productCount){
                productID=pid;
                maxCount=productCount;
            }
        }
        Product product=productRepository.findById(productID).get();
//        System.out.println(product.getDisplayName()+" "+product.getUser().getFullname());
        return new PopularDataDTO(product.getUser().getFullname(),product.getDisplayName());
    }

    @Override
    public List<MonthlyReportDTO> countOrdersByProductID(int productID) {
        Timestamp endDate=new Timestamp(System.currentTimeMillis());
        int daysCount=endDate.getDate();
        Timestamp startDate=new Timestamp(System.currentTimeMillis()-(day*daysCount));
        List<MonthlyReportDTO> report=new ArrayList<MonthlyReportDTO>();

        for(int i=0;i<12;i++){
            report.add(new MonthlyReportDTO(od.getMonth(endDate.getMonth()+1),repository.countOrderDetailsByProductProductIDEquals(productID,startDate,endDate)));
            endDate=startDate;
            daysCount+=startDate.getDate();
            startDate=new Timestamp(System.currentTimeMillis()-day*daysCount);
        }
        return report;
    }

    @Override
    public AdminIncomeDTO getIncomeBySeller(String email, String duration) {
        Timestamp startTime=new Timestamp(System.currentTimeMillis()- od.getTimeDuration(duration));
        Timestamp endTime=new Timestamp(System.currentTimeMillis());

        List<Object[]> o =repository.getIncome(email,startTime,endTime);
        for (Object sa[] : o) {
            System.out.println(sa[0]+" "+ sa[1]);
            return new AdminIncomeDTO(((BigInteger) sa[0]).intValue(),(sa[1]!=null ? (double)sa[1]:0.0),startTime.toString().substring(0,19)+" to " + endTime.toString().substring(0,19));
        }

        return new AdminIncomeDTO(0,0.0,startTime.toString().substring(0,19)+" to " + endTime.toString().substring(0,19));
    }

    @Override
    public List<OrderProductDetailDTO> getOrderDetails(int productid) {
        List<Object[]> list= repository.getProductList(productid);
        List<OrderProductDetailDTO> information=new ArrayList<OrderProductDetailDTO>();
        for (Object data[] : list) {
            information.add(new OrderProductDetailDTO(data[0].toString(),(Integer.parseInt(data[1].toString())),Double.parseDouble(data[2].toString())));
        }
        System.out.println(information);
        return information;
    }
}
