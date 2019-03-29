/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author zied007
 */
public class Commenter {

    private int id;
    private String comment;
    private String dateCommenter;
    private int propostionId;
    private int userId;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");

    public Commenter(int id, String comment, String dateCommenter, int propostionId, int userId) {
        this.id = id;
        this.comment = comment;
        this.dateCommenter = dateCommenter;
        this.propostionId = propostionId;
        this.userId = userId;
    }

    public Commenter(String comment, int propostionId, int userId) {
        this.comment = comment;
        this.dateCommenter = sdf.format(new Date());
        this.propostionId = propostionId;
        this.userId = userId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the propostionId
     */
    public int getPropostionId() {
        return propostionId;
    }

    /**
     * @param propostionId the propostionId to set
     */
    public void setPropostionId(int propostionId) {
        this.propostionId = propostionId;
    }

    /**
     * @return the dateCommenter
     */
    public String getDateCommenter() {
        return dateCommenter;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

}
