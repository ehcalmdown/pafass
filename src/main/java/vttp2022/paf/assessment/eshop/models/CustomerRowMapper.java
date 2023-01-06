package vttp2022.paf.assessment.eshop.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;



public class CustomerRowMapper implements RowMapper<Customer>{

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        // TODO Auto-generated method stub
        Customer c = new Customer();
        c.setAddress(rs.getString("address"));
        c.setEmail(rs.getString("email"));
        c.setName(rs.getString("name"));
        return null;
    }
    
}
