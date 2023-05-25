package com.springJDBCdao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.springJDBCentity.pojo;

public class studentDaoc implements Studentdao {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(pojo p) {
		//insert query
    	String query="insert into jdbc(id,name,city) values(?,?,?)";
    	 int r =this.jdbcTemplate.update(query,p.getId(),p.getName(),p.getCity());
		
		return r;
	}

	public int change(pojo p) {
		// updating data
		String query="update jdbc set name=?,city=? where id=?";
		int r2 = this.jdbcTemplate.update(query,p.getName(),p.getCity(),p.getId());
		return r2;
	}

	public int delete(int pid) {
		// deleting record
		String query="delete from jdbc where id=?";
		int r = this.jdbcTemplate.update(query,pid);
		return r;
	}

	
}
