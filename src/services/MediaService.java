/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entitys.Media;
import servicesInterface.IMediaService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author ibrah
 */
public class MediaService implements IMediaService{
        	/* Method to Extract a Media Type from result set passed in parameters */
    private Connection cnx;
	 
	 public ArrayList<Media> getAllMediasByEvent(int idEvent) {
        ArrayList<Media> medias= new ArrayList<>();
        cnx = MyDB.getInstance().getCnx();
        String req="SELECT * FROM media WHERE idEvent="+idEvent;
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while(rs.next()){
                Media c = new Media();
                c.setMediaName(rs.getString("mediaName"));
                c.setMediaDescription(rs.getString("mediaDescription"));
                c.setIdUser(rs.getInt("idUser")); 
                c.setIdEvent(rs.getInt("idEvent"));
                c.setIdMedia(rs.getInt("idMedia"));
                c.setDate(rs.getTimestamp("date"));
                medias.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MediaService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return medias;
        
    }

	 
	public boolean insertMedia(Media media) {
		cnx = MyDB.getInstance().getCnx();

		try {

			PreparedStatement ps = cnx.prepareStatement("INSERT INTO media VALUES (null,?,?,?,?,?)");

			ps.setString(1, media.getMediaName());
                        ps.setString(2, media.getMediaDescription());
                        ps.setTimestamp(3, media.getDate());
                        ps.setInt(4, media.getIdUser());
                        ps.setInt(5, media.getIdEvent());

			int i = ps.executeUpdate();

			if (i == 1) {

				return true;

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		return false;

	}
 
	public boolean deleteMedia(Media media) {

		
		cnx = MyDB.getInstance().getCnx();

		try {

			PreparedStatement ps = cnx.prepareStatement("DELETE FROM media WHERE idMedia= (?)");

			ps.setInt(1, media.getIdMedia());

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
