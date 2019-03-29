/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicesInterface;

import entitys.Proposition;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zied007
 */
public interface IPropositionInterface extends IGenericServices<Proposition>{
    
    List<Proposition> findPropostionByDate(String date);
    
    List<Proposition> findPropostionByTitle(String title);
    
    List<Integer> getAllIds();
    
}
