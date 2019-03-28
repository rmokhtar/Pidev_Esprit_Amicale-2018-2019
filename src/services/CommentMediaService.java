/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.ResultSet;
import java.sql.SQLException;
import entitys.CommentMedia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;
import servicesInterface.ICommentMediaService;

/**
 *
 * @author ibrah
 */
public class CommentMediaService implements ICommentMediaService{
    	/* Method to Extract a Comment Type from result set passed in parameters */

    private Connection cnx;
	 
	 public ArrayList<CommentMedia> getAllCommentsByMedia(int idCommentMedia) {
        ArrayList<CommentMedia> comments= new ArrayList<>();
        cnx = MyDB.getInstance().getCnx();
        String req="SELECT * FROM commentMedia WHERE idCommentMedia="+idCommentMedia;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                CommentMedia c = new CommentMedia();
                c.setComment(rs.getString("comment"));
                c.setIdUser(rs.getInt("idUser"));
                c.setIdMedia(rs.getInt("idMedia"));
                c.setIdCommentMedia(rs.getInt("idCommentMedia"));
                c.setDate(rs.getTimestamp("date"));
                comments.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentMediaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comments;
        
    }

	 
	public boolean insertCommentMedia(CommentMedia comment) {
		cnx = MyDB.getInstance().getCnx();

		try {

			PreparedStatement ps = cnx.prepareStatement("INSERT INTO commentMedia VALUES (null,?,?,?,?)");

			ps.setString(1, comment.getComment());
                        ps.setTimestamp(2, comment.getDate());
                        ps.setInt(3, comment.getIdUser());
                        ps.setInt(4, comment.getIdMedia());

			int i = ps.executeUpdate();

			if (i == 1) {

				return true;

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return false;

	}

	
	public boolean updateCommentMedia(CommentMedia comment,String newComment) {
		cnx = MyDB.getInstance().getCnx();

		try {

			PreparedStatement ps = cnx.prepareStatement("UPDATE commentMedia SET comment=? WHERE idCommentMedia=?");

			ps.setString(1,newComment);

			ps.setInt(2, comment.getIdCommentMedia());

			int i = ps.executeUpdate();

			if (i == 1) {

				return true;

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return false;
	}
 
	public boolean deleteCommentMedia(CommentMedia comment) {

		
		cnx = MyDB.getInstance().getCnx();

		try {

			PreparedStatement ps = cnx.prepareStatement("DELETE FROM commentMedia WHERE idCommentMedia= (?)");

			ps.setInt(1, comment.getIdCommentMedia());

			int i = ps.executeUpdate();

			if (i == 1) {

				return true;

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return false;
	}

}

