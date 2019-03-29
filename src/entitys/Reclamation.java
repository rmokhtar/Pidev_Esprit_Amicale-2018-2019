/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.sql.Timestamp;

/**
 *
 * @author Omar
 */
public class Reclamation {
    private int id;
    private String description;
    private String type;
    private String title;
    private String status;
    private Timestamp date;
    
    

    public Reclamation() {
		
	}

	public Reclamation(int id, String description, String type, String title, String status, Timestamp date) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.title = title;
        this.status = status;
        this.date = date;
    }    

    public Reclamation(String description, String type, String title, String status, Timestamp date) {
		super();
		this.description = description;
		this.type = type;
		this.title = title;
		this.status = status;
		this.date = date;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", description=" + description + ", type=" + type + ", title=" + title + ", status=" + status + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reclamation other = (Reclamation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
}
