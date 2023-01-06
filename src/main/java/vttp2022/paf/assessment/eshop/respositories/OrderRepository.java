package vttp2022.paf.assessment.eshop.respositories;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import vttp2022.paf.assessment.eshop.models.LineItem;
import vttp2022.paf.assessment.eshop.models.Order;

@Repository
public class OrderRepository {
	// TODO: Task 3
	@Autowired
	private JdbcTemplate template;

	public void addLineItem(Order order){
		Date date = new Date();
		String strDateFormat = "DD:MM:YYYY";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String orderDate= dateFormat.format(date);
		System.out.println("current date: " + orderDate);

		try {
			order.setOrderDate(dateFormat.parse(orderDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String oid = UUID.randomUUID().toString().substring(0, 8); //to create a random id for the order
		order.setOrderId(oid);
		addLineItem(order.getLineItems(), order.getName(), date);
		
       }
//items wanted name, item, quantity, date, randomized uuid for orderid
       public void addLineItem(List<LineItem> lineItems, String orderId, Date orderDate) {
        List<Object[]> data = lineItems.stream() //using stream to map out the purchase order details
                .map(li -> {
                    Object[] l = new Object[3];
                    l[0] = li.getItem();//to set up in form of array for mysql
                    l[1] = li.getQuantity();
                    l[2] = orderId;
					l[3] = orderDate;
                    return l;
                })
                .toList();

        // Batch update
        template.batchUpdate(Queries.SQL_INSERT_LINE_ITEM, data);//queries model call not needed under normal circumstance due to jdbc template
    }
	public boolean saveOrderDetails(Order o){//create an update function for orders
        return template.update(Queries.SQL_INSERT_PURCHASE_ORDER, o.getOrderId(), o.getName()) > 0;
    }
}
