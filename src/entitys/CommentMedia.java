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
public class CommentMedia {
    private int idMedia;
    private int idUser;
    private String comment;
    private int idCommentMedia;
    private Timestamp date;
    
    public CommentMedia()
    {}

    public CommentMedia(int idMedia, int idUser, String comment) {
        this.idMedia = idMedia;
        this.idUser = idUser;
        this.comment = comment;
        this.date=new  Timestamp(new java.util.Date().getTime());
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getIdCommentMedia() {
        return idCommentMedia;
    }

    public void setIdCommentMedia(int idComment) {
        this.idCommentMedia = idComment;
    }

    @Override
    public String toString() {
        return "Comment{" + "idMedia=" + idMedia + ", idUser=" + idUser + ", comment=" + comment + ", idComment=" + idCommentMedia + ", date=" + date + '}';
    }

    
}
