package org.example.ws.db.helper;

import java.util.List;

public interface DBProxy<T,K> {
	T save(T entity);
	void delete(K id);
	List<T> get();
	T get(K id);
}
