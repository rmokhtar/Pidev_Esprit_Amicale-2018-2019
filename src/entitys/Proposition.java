/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author zied007
 */
public class Proposition {

    private int id;
    private String propositionTitle;
    private String propostionDescription;
    private String dateCreation;
    private String dateModifaction;
    private int nbrLike;
    private int nbrDisLike;
    private int employerId;
    private List<Commenter> commentList;
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    private final int LIKE_INISALITATION = 0;

    public Proposition(int id, String propositionTitle, String propostionDescription, String dateCreation, String dateModifaction, int nbrLike, int nbrDisLike, int employerId) {
        this.id = id;
        this.propositionTitle = propositionTitle;
        this.propostionDescription = propostionDescription;
        this.dateCreation = dateCreation;
        this.dateModifaction = dateModifaction;
        this.nbrLike = nbrLike;
        this.nbrDisLike = nbrDisLike;
        this.employerId = employerId;
    }

    public Proposition(String propositionTitle, String propostionDescription, int employerId) {
        this.propositionTitle = propositionTitle;
        this.propostionDescription = propostionDescription;
        this.nbrLike = LIKE_INISALITATION;
        this.nbrDisLike = LIKE_INISALITATION;
        this.dateCreation = sdf.format(new Date());
        this.dateModifaction = sdf.format(new Date());
        this.employerId = employerId;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return the propositionTitle
     */
    public String getPropositionTitle() {
        return propositionTitle;
    }

    /**
     * @param propositionTitle the propositionTitle to set
     */
    public void setPropositionTitle(String propositionTitle) {
        this.propositionTitle = propositionTitle;
    }

    /**
     * @return the propostionDescription
     */
    public String getPropostionDescription() {
        return propostionDescription;
    }

    /**
     * @param propostionDescription the propostionDescription to set
     */
    public void setPropostionDescription(String propostionDescription) {
        this.propostionDescription = propostionDescription;
    }

    /**
     * @return the dateCreation
     */
    public String getDateCreation() {
        return dateCreation;
    }

    /**
     * @param dateCreation the dateCreation to set
     */
    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * @return the dateModifaction
     */
    public String getDateModifaction() {
        return dateModifaction;
    }

    /**
     * @param dateModifaction the dateModifaction to set
     */
    public void setDateModifaction(String dateModifaction) {
        this.dateModifaction = dateModifaction;
    }

    /**
     * @return the nbrLike
     */
    public int getNbrLike() {
        return nbrLike;
    }

    /**
     * @param nbrLike the nbrLike to set
     */
    public void setNbrLike(int nbrLike) {
        this.nbrLike = nbrLike;
    }

    /**
     * @return the nbrDisLike
     */
    public int getNbrDisLike() {
        return nbrDisLike;
    }

    /**
     * @param nbrDisLike the nbrDisLike to set
     */
    public void setNbrDisLike(int nbrDisLike) {
        this.nbrDisLike = nbrDisLike;
    }

    /**
     * @return the employerId
     */
    public int getEmployerId() {
        return employerId;
    }

    /**
     * @param employerId the employerId to set
     */
    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    /**
     * @return the commentList
     */
    public List<Commenter> getCommentList() {
        return commentList;
    }

    /**
     * @param commentList the commentList to set
     */
    public void setCommentList(List<Commenter> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "Proposition{" + "id=" + id + ", propositionTitle=" + propositionTitle + ", propostionDescription=" + propostionDescription + ", dateCreation=" + dateCreation + ", dateModifaction=" + dateModifaction + ", nbrLike=" + nbrLike + ", nbrDisLike=" + nbrDisLike + ", employerId=" + employerId + '}';
    }

    
}
