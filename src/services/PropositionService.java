/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Proposition;
import servicesInterface.IPropositionInterface;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author zied007
 */
public class PropositionService extends GenericService implements IPropositionInterface {

    private List<Proposition> allProposition = new ArrayList<>();
    private Proposition proposition;
    private int rowInserted = 0;
    private int rowsDeleted = 0;
    private int rowUpdated = 0;
        private Connection cnx;

    @Override
    public List<Proposition> findPropostionByDate(String date) {
        query = "SELECT * FROM proposition where dateModifaction LIKE \'%" + date + "%\' ORDER BY dateModifaction ASC";

        try {
            cnx = MyDB.getInstance().getCnx();
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                proposition = new Proposition(rs.getInt("id"),
                        rs.getString("propositionTitle"),
                        rs.getString("propostionDescription"),
                        String.valueOf(rs.getDate("dateCreation")),
                        String.valueOf(rs.getDate("dateModifaction")),
                        rs.getInt("nbrLike"),
                        rs.getInt("nbrDisLike"),
                        rs.getInt("employerId")
                );
                allProposition.add(proposition);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return allProposition;
    }

    @Override
    public List<Proposition> findPropostionByTitle(String title) {
        query = "SELECT * FROM proposition where propositionTitle LIKE \'%" + title + "%\' ORDER BY dateModifaction ASC";

        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                proposition = new Proposition(rs.getInt("id"),
                        rs.getString("propositionTitle"),
                        rs.getString("propostionDescription"),
                        String.valueOf(rs.getDate("dateCreation")),
                        String.valueOf(rs.getDate("dateModifaction")),
                        rs.getInt("nbrLike"),
                        rs.getInt("nbrDisLike"),
                        rs.getInt("employerId")
                );
                allProposition.add(proposition);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return allProposition;
    }

    @Override
    public Proposition findById(int id) {

        query = "SELECT * FROM proposition where id = " + id;

        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                proposition = new Proposition(rs.getInt("id"),
                        rs.getString("propositionTitle"),
                        rs.getString("propostionDescription"),
                        String.valueOf(rs.getDate("dateCreation")),
                        String.valueOf(rs.getDate("dateModifaction")),
                        rs.getInt("nbrLike"),
                        rs.getInt("nbrDisLike"),
                        rs.getInt("employerId")
                );

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return proposition;
    }

    @Override
    public List<Proposition> findAll() {

        query = "SELECT * FROM proposition";
        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                proposition = new Proposition(rs.getInt("id"),
                        rs.getString("propositionTitle"),
                        rs.getString("propostionDescription"),
                        String.valueOf(rs.getDate("dateCreation")),
                        String.valueOf(rs.getDate("dateModifaction")),
                        rs.getInt("nbrLike"),
                        rs.getInt("nbrDisLike"),
                        rs.getInt("employerId")
                );
                allProposition.add(proposition);
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return allProposition;
    }

    @Override
    public int create(Proposition entite) {

        query = "INSERT INTO proposition (propositionTitle, propostionDescription, dateCreation, dateModifaction, nbrLike, nbrDisLike, employerId)VALUES (?,?,?,?,?,?,?)";
        try {
            psmt = cnx.prepareStatement(query);
            psmt.setString(1, entite.getPropositionTitle());
            psmt.setString(2, entite.getPropostionDescription());
            Date datecreation = new SimpleDateFormat("MM-dd-yyyy").parse(entite.getDateCreation());
            psmt.setDate(3, new java.sql.Date(datecreation.getTime()));
            psmt.setDate(4, new java.sql.Date(datecreation.getTime()));
            psmt.setInt(5, entite.getNbrLike());
            psmt.setInt(6, entite.getNbrDisLike());
            psmt.setInt(7, entite.getEmployerId());
            rowInserted = psmt.executeUpdate();

            if (rowInserted > 0) {
                System.out.println("A Proposition was created successfully!");
            }
        } catch (ParseException | SQLException e) {
            System.err.println("Error create Propostion !!");
        }
        return rowInserted;
    }

    @Override
    public int edit(Proposition entite) {

        query = "UPDATE proposition SET propositionTitle = ? , propostionDescription = ? , dateModifaction = ? WHERE id = ?";
        try {
            DateFormat ShortDateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
            psmt = cnx.prepareStatement(query);
            psmt.setString(1, entite.getPropositionTitle());
            psmt.setString(2, entite.getPropostionDescription());
            String today = new SimpleDateFormat("MM-dd-yyyy").format(Calendar.getInstance().getTime());
            System.out.println(today);
            Date dateCreation = new SimpleDateFormat("MM-dd-yyyy").parse(today);
            psmt.setDate(3, new java.sql.Date(dateCreation.getTime()));
            psmt.setInt(4, entite.getId());

            rowUpdated = psmt.executeUpdate();

            if (rowUpdated > 0) {
                System.out.println("proposition was updated successfully !!!");
            }
        } catch (ParseException | SQLException e) {
            System.err.println("Error updated proposition !!");
        }
        return rowUpdated;
    }

    @Override
    public int delete(Proposition entite) {
        // TODO Auto-generated method stub

        query = "DELETE FROM proposition WHERE id=?";
        try {

            psmt = cnx.prepareStatement(query);
            psmt.setInt(1, entite.getId());
            rowsDeleted = psmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A Proposition was deleted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error deleted Proposition !!");
        }
        return rowsDeleted;
    }

    @Override
    public List<Integer> getAllIds() {
        List<Integer> allPropositionId = new ArrayList<>();
        query = "SELECT id FROM proposition ORDER BY id ASC";
        try {
            smt = cnx.createStatement();
            rs = smt.executeQuery(query);
            while (rs.next()) {
                allPropositionId.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return allPropositionId;
    }

}
