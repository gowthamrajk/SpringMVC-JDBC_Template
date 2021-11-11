package com.gowthamrajk.service;

import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.gowthamrajk.model.User;

@Component
public class UserService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int saveUser(User user) {  
		
	    String insertQuery = "insert into user values('" + user.getUserId() + "','" + user.getUserName() 
	                          + "','" + user.getEmail() + "','" + user.getMobile() + "','" 
	    		              + user.getPassword() + "')"; 
	    
	    return jdbcTemplate.update(insertQuery);  
	}  	
	
	public int updateUser(User user) { 
		
	    String updateQuery = "update user set username = '" + user.getUserName() + "',email = '" 
	                          + user.getEmail() + "',mobile = '" + user.getMobile() + "',password = '" 
	    		              + user.getPassword() + "' where userid = '" + user.getUserId() + "' ";  
	    
	    return jdbcTemplate.update(updateQuery);  
	}  
	
	public int deleteUser(User user) {  
		
	    String deleteQuery="delete from user where userid = '" + user.getUserId() + "' ";  
	    
	    return jdbcTemplate.update(deleteQuery);  
	}  
	
	public List<User> getAllUser() {  
		
	    return jdbcTemplate.query("select * from user", new RowMapper<User>() { 
			 
		    public User mapRow(ResultSet resultSet, int rownumber) throws SQLException {  
		    	
		        User user = new User();  
		        user.setUserId(resultSet.getInt(1));  
		        user.setUserName(resultSet.getString(2));  
		        user.setEmail(resultSet.getString(3));  
		        user.setMobile(resultSet.getLong(4));  
		        user.setPassword(resultSet.getString(5));  
		        return user;  
		    }  
	    });  
    }  
	
    public List<User> getUserById(int userId) {  
		
	    return jdbcTemplate.query("select * from user where userid = " + userId, new RowMapper<User>() { 
			 
		    public User mapRow(ResultSet resultSet, int rownumber) throws SQLException {  
		    	
		        User user = new User();  
		        user.setUserId(resultSet.getInt(1));  
		        user.setUserName(resultSet.getString(2));  
		        user.setEmail(resultSet.getString(3));  
		        user.setMobile(resultSet.getLong(4));  
		        user.setPassword(resultSet.getString(5));  
		        return user;  
		    }  
	    });  
    }

}
