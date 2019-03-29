/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import utils.MyDB;

/**
 *
 * @author zied007
 */
public class GenericService {
    
    protected	Statement smt = null;
    protected	PreparedStatement psmt = null;
    protected	ResultSet rs = null;
    protected	Connection cnx = MyDB.getInstance().getCnx();
    protected   String query ;
    
}
