package com.bookify.dao;

import java.util.List;

/**
 * Represents a generic DAO interface.
 * 
 * @author @Ayon-SSP
 * 
 * @param <T> The type of the object to be persisted.
 * @methods create, update, delete, findOne, findAll.
 * @throws Exception if any of the CRUD operations fail.
 */
public interface IDao<T> {
    T create(T t) throws Exception;
    boolean update(String id, T t) throws Exception;
    boolean delete(String id) throws Exception;
    T findOne(String id) throws Exception;
    List<T> findAll() throws Exception;
}