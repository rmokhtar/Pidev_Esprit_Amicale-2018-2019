/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesInterface;

import java.util.List;

/**
 *
 * @author zied007
 */
public interface IGenericServices<T> {

    T findById(int id);

    List<T> findAll();

    int create(T entite);

    int edit(T entite);

    int delete(T entite);

}
