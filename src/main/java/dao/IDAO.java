package dao;

import java.util.List;

public interface IDAO<T> {
	
	public void create(T entity);
	public T read(Long id);
	public void update(T entity);
	public void delete(T entity);
	public List<T> readAll();

}
