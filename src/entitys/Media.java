/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;
 
import java.sql.Timestamp;

/**
 *
 * @author ibrah
 */
public class Media {
    private int idMedia;
    private int idUser;
    private int idEvent;
    private String mediaName;
    private String mediaDescription;
    private Timestamp date;

    public Media()
    {}
    public Media(int idUser, int idEvent, String mediaName, String mediaDescription) {
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.mediaName = mediaName;
        this.mediaDescription = mediaDescription;
        this.date=new Timestamp(new java.util.Date().getTime());
    }

    public int getIdMedia() {
        return idMedia;
    }

    public void setIdMedia(int idMedia) {
        this.idMedia = idMedia;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaDescription() {
        return mediaDescription;
    }

    public void setMediaDescription(String mediaDescription) {
        this.mediaDescription = mediaDescription;
    }
    
    public Timestamp  getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Media{" + "idMedia=" + idMedia + ", idUser=" + idUser + ", idEvent=" + idEvent + ", mediaName=" + mediaName + ", mediaDescription=" + mediaDescription + ", date=" + date + '}';
    }

    
}
