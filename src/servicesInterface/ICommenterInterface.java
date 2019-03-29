package servicesInterface;

import entitys.Commenter;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zied007
 */
public interface ICommenterInterface extends IGenericServices<Commenter>{
    List<Commenter> findPropostionByDate(String date);
    
}
