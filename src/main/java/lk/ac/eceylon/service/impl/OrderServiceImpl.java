package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.dto.AdminIncomeDTO;
import lk.ac.eceylon.dto.MonthlyReportDTO;
import lk.ac.eceylon.entity.OrderDetails;
import lk.ac.eceylon.entity.Orders;
import lk.ac.eceylon.repository.OrderDetailRepository;
import lk.ac.eceylon.repository.OrderRepository;
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
public class OrderServiceImpl implements OrderService {

    private final long day=1000*60*60*24;
    private final long week=1000*60*60*24*7;
    private final long month=1000*60*60*24*30L;
    private final long year=1000*60*60*24*365L;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Orders> getOrdersByOrderIDAndStatus(int orderid) {
        return orderRepository.findOrdersByOrderidAndStatus(orderid,"Not confirmed");
//        return orderRepository.findOrdersByOrderid(orderid);

    }

    @Override
    public boolean confirmOrder(Orders order) {
        Orders orderToUpdate=orderRepository.getOne(order.getOrderid());
        orderToUpdate.setStatus("Confirmed");

        List<OrderDetails> toMail=orderDetailRepository.findOrderDetailsByOrderOrderid(order.getOrderid());
        new MailServiceImpl().sendEMail(toMail.get(0));

        //Return the boolean result
        if(orderRepository.save(orderToUpdate)!=null)
            return true;
        else
            return false;
    }


    @Override
    public List<Orders> getOrdersByDateBetween(String duration) {

        return orderRepository.findByOrderdateBetween(new Timestamp(System.currentTimeMillis()-getTimeDuration(duration)),new Timestamp(System.currentTimeMillis()));

    }

    @Override
    public AdminIncomeDTO getIncome(String duration) {
        Timestamp startTime=new Timestamp(System.currentTimeMillis()-getTimeDuration(duration));
        Timestamp endTime=new Timestamp(System.currentTimeMillis());
        double income=0.0;
        int orderCount=0;

        for (Orders order:orderRepository.findByOrderdateBetween(startTime,endTime)) {
            orderCount++;
            income+=order.getAmount();
        }

        return new AdminIncomeDTO(orderCount,income,startTime.toString().substring(0,19)+" to " + endTime.toString().substring(0,19));
    }

    @Override
    public List<Orders> getOrdersByUserEmail(String email) {
        return orderRepository.findOrdersByUserEmail(email);
    }

    long getTimeDuration(String duration){
        switch(duration){
            case("daily"):return day;
            case("weekly"):return week;
            case("monthly"):return month;
            case("yearly"):return year;
            default:return 1000;
        }
    }

    String getMonth(int month){
        switch (month){
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
//            case 0: return "December";
            default: return "December";
        }
    }

    @Override
    public List<MonthlyReportDTO> getIncomePerMonth() {
        Timestamp endDate=new Timestamp(System.currentTimeMillis());
        int daysCount=endDate.getDate();
        Timestamp startDate=new Timestamp(System.currentTimeMillis()-(day*daysCount));
        double income=0.0;
        System.out.println(getMonth(endDate.getMonth()));
        System.out.println((endDate));
        System.out.println((endDate.getMonth()));


        List<MonthlyReportDTO> report=new ArrayList<MonthlyReportDTO>();

        for(int i=0;i<12;i++){
            for (Orders order:orderRepository.findByOrderdateBetween(startDate,endDate)) {
                income+=order.getAmount();
            }
            report.add(new MonthlyReportDTO(getMonth(endDate.getMonth()+1),income));
            System.out.println(income);
            income=0.0;
//            System.out.println(endDate.getMonth());

            endDate=startDate;
            daysCount+=startDate.getDate();
            startDate=new Timestamp(System.currentTimeMillis()-day*daysCount);
        }
        return report;
    }
}
