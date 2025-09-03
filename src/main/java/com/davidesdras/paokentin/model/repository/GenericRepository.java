package com.davidesdras.paokentin.model.repository;

import java.sql.SQLException;
import java.util.List;

public interface GenericRepository <T, I>{
	public void create(T t) throws SQLException;
	public void update(T t);
	public T read(I key);
	public void delete(I key);
	public List<T> readAll();
}

