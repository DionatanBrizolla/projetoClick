package dao;

import java.awt.List;

public interface InterfaceDao {

	public Integer add(Object obj);
	
	public List getAll();
	
	public Object getById(Long id);
	
}
