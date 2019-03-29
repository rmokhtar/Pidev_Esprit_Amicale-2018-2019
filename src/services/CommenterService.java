/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Commenter;
import servicesInterface.ICommenterInterface;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zied007
 */
public class CommenterService extends GenericService implements ICommenterInterface {
    private List<Commenter> allCommenter = new ArrayList<>();
    private Commenter commenter = null;
    private int rowInserted = 0;
    private int rowsDeleted = 0;

    @Override
    public List<Commenter> findPropostionByDate(String date) {
         
        query = "SELECT * FROM commenter where dateCommenter LIKE \'%" + date +"%\' ORDER BY dateCommenter ASC";

        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                commenter = new Commenter(rs.getInt("id"),
                        rs.getString("commentDescription"),
                        rs.getString("dateCommenter"),
                        rs.getInt("proposition_id"),
                        rs.getInt("user_id")
                );
                allCommenter.add(commenter);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return allCommenter;
    }


    @Override
    public Commenter findById(int id) {
        query = "SELECT * FROM commenter where id = " + id;

        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                        commenter = new Commenter(rs.getInt("id"),
                        rs.getString("commentDescription"),
                        rs.getString("dateCommenter"),
                        rs.getInt("proposition_id"),
                        rs.getInt("user_id")
                );
                
               

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return commenter;
    }

    @Override
    public List<Commenter> findAll() {
        query = "SELECT * FROM commenter";

        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                commenter = new Commenter(rs.getInt("id"),
                        rs.getString("commentDescription"),
                        rs.getString("dateCommenter"),
                        rs.getInt("proposition_id"),
                        rs.getInt("user_id")
                );
                allCommenter.add(commenter);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return allCommenter;
    }

    @Override
    public int create(Commenter entite) {
        query = "INSERT INTO commenter (commentDeiscription, dateCommenter, proposition_id, user_id)VALUES (?,?,?,?)";
        try {
            psmt = cnx.prepareStatement(query);
            psmt.setString(1, entite.getComment());
            psmt.setString(2, entite.getDateCommenter());
            psmt.setInt(3, entite.getPropostionId());
            psmt.setInt(4, entite.getUserId());
            rowInserted = psmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("A commenter was created successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error create commenter !!");
        }
        return rowInserted;
    }

    @Override
    public int edit(Commenter entite) {
       

        query = "INSERT INTO commenter (commentDeiscription, dateCommenter, proposition_id, user_id)VALUES (?,?,?,?)";
        try {
            psmt = cnx.prepareStatement(query);
            psmt.setString(1, entite.getComment());
            psmt.setString(2, entite.getDateCommenter());
            psmt.setInt(3, entite.getPropostionId());
            psmt.setInt(4, entite.getUserId());
            rowInserted = psmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("A commenter was created successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error create commenter !!");
        }
        return rowInserted;
    }

    @Override
    public int delete(Commenter entite) {
        query = "DELETE FROM commenter WHERE id=?";
        try {

            psmt = cnx.prepareStatement(query);
            psmt.setInt(1, entite.getId());
            rowsDeleted = psmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Commenter was deleted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error deleted Commenter !!");
        }
        return rowsDeleted;
    }

}
