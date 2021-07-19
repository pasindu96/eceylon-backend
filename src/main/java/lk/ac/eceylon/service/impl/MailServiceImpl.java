package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.entity.OrderDetails;
import lk.ac.eceylon.entity.Orders;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class MailServiceImpl {

    //Create a public method to send emails
    public String sendEMail(OrderDetails order){
        //Set Properties for the email sending
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        //Create a new Session
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eceylonlk@gmail.com", "eceylon123");
            }
        });

        Message msg = new MimeMessage(session);
        try {

            msg.setFrom(new InternetAddress("eceylonlk@gmail.com", false));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getOrder().getUser().getEmail()));
            msg.setSubject("Your order has been Confirmed.");
            msg.setContent("Your order has been Confirmed.", "text/html");
            msg.setSentDate(new Date());
            //------------------------------------------
            String mailContent="Order ID : "+order.getOrder().getOrderid()
                    +", \n"+"Product Name : "+order.getProduct().getDisplayName()
                    +", \n"+ "Order Quantity : "+order.getQuantity()
                    +", \n"+"Amount : " +order.getOrder().getAmount()
                    +", \n"+"Seller Name : "+ order.getProduct().getUser().getFullname()
                    +", \n"+"Seller Mobile : "+ order.getProduct().getUser().getMobile();
//            System.out.println(mailContent);
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mailContent, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            msg.setContent(multipart);
            Transport.send(msg);

            return "Email send Successfully..";

        } catch (MessagingException e) {
            e.printStackTrace();
            return "Email error occurred.";
        }
    }
}
