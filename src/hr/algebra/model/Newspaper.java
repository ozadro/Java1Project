/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Korisnik
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"id","title", "journalistID", "articleID","picturePath"})
public class Newspaper {
    
    @XmlElement(name="id")
    private int id;
    @XmlElement(name="title")
    private String title;
    @XmlElement(name="journalistID")
    private int journalistID;
    @XmlElement(name="articleID")
    private int articleID;
    @XmlElement(name="picturePath")
    private String picturePath;

    public Newspaper() {
    }

    public Newspaper(String title, int journalistID, int articleID, String picturePath) {
        this.title = title;
        this.journalistID = journalistID;
        this.articleID = articleID;
        this.picturePath = picturePath;
    }

    public Newspaper(int id, String title, int journalistID, int articleID, String picturePath) {
        this(title,journalistID,articleID,picturePath);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getJournalistID() {
        return journalistID;
    }

    public void setJournalistID(int journalistID) {
        this.journalistID = journalistID;
    }

    public int getArticleID() {
        return articleID;
    }

    public void setArticleID(int articleID) {
        this.articleID = articleID;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

   

    
    @Override
    public String toString() {
        return id + " - " + title +" - " + journalistID + " " + articleID ;
    }
    
    
    
    
    
    
         
}
