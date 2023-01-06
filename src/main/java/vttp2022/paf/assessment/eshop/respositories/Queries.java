package vttp2022.paf.assessment.eshop.respositories;

public class Queries {
    public static final String SQL_FIND_CUSTOMERS_BY_NAME = "SELECT * FROM CUSTOMER WHERE name = ?";
    public static String SQL_INSERT_LINE_ITEM = "insert into line_item(item, quantity, order_id, order_date) values (?, ?, ?)";
}
