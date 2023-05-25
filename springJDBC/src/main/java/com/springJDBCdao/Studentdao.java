package com.springJDBCdao;

import com.springJDBCentity.pojo;

public interface Studentdao {

	public int insert(pojo p);
	public int change(pojo p);
	public int delete(int pid);
}
