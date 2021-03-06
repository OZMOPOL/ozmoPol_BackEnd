/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import OzClass.OzPost;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author amind
 */
@Entity
@Table(name = "Post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findByPkPostId", query = "SELECT p FROM Post p WHERE p.pkPostId = :pkPostId"),
    @NamedQuery(name = "Post.findByPostTitle", query = "SELECT p FROM Post p WHERE p.postTitle = :postTitle"),
    @NamedQuery(name = "Post.findByPostCDate", query = "SELECT p FROM Post p WHERE p.postCDate = :postCDate"),
    @NamedQuery(name = "Post.findByPostEDate", query = "SELECT p FROM Post p WHERE p.postEDate = :postEDate"),
    @NamedQuery(name = "getPostContents", query = "SELECT p FROM Post p WHERE p.fkPostPrntId.pkPostId = :parentId"),
    @NamedQuery(name = "getRoomContents", query = "SELECT p FROM Post p WHERE p.fkPostRoomId.pkRoomId = :roomId AND p.postTitle IS NOT NULL")}) 
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "pk_post_id")
    private String pkPostId;
    @Size(max = 256)
    @Column(name = "post_title")
    private String postTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "post_content")
    private String postContent;
    @Column(name = "post_c_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postCDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_e_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postEDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVotePostId")
    private Collection<Vote> voteCollection;
    @JoinColumn(name = "fk_post_user_id", referencedColumnName = "pk_user_id")
    @ManyToOne(optional = false)
    private User fkPostUserId;
    @JoinColumn(name = "fk_post_room_id", referencedColumnName = "pk_room_id")
    @ManyToOne(optional = false)
    private Room fkPostRoomId;
    @OneToMany(mappedBy = "fkPostPrntId")
    private Collection<Post> postCollection;
    @JoinColumn(name = "fk_post_prnt_id", referencedColumnName = "pk_post_id")
    @ManyToOne
    private Post fkPostPrntId;

    
  
    public Post() {
    }

    public Post(String pkPostId) {
        this.pkPostId = pkPostId;
    }

    public Post(String pkPostId, String postContent, Date postEDate) {
        this.pkPostId = pkPostId;
        this.postContent = postContent;
        this.postEDate = postEDate;
    }

    public String getPkPostId() {
        return pkPostId;
    }

    public void setPkPostId(String pkPostId) {
        this.pkPostId = pkPostId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostCDate() {
        return postCDate;
    }

    public void setPostCDate(Date postCDate) {
        this.postCDate = postCDate;
    }

    public Date getPostEDate() {
        return postEDate;
    }

    public void setPostEDate(Date postEDate) {
        this.postEDate = postEDate;
    }

    @XmlTransient
    public Collection<Vote> getVoteCollection() {
        return voteCollection;
    }

    public void setVoteCollection(Collection<Vote> voteCollection) {
        this.voteCollection = voteCollection;
    }

    public User getFkPostUserId() {
        return fkPostUserId;
    }

    public void setFkPostUserId(User fkPostUserId) {
        this.fkPostUserId = fkPostUserId;
    }

    public Room getFkPostRoomId() {
        return fkPostRoomId;
    }

    public void setFkPostRoomId(Room fkPostRoomId) {
        this.fkPostRoomId = fkPostRoomId;
    }

    @XmlTransient
    public Collection<Post> getPostCollection() {
        return postCollection;
    }

    public void setPostCollection(Collection<Post> postCollection) {
        this.postCollection = postCollection;
    }

    public Post getFkPostPrntId() {
        return fkPostPrntId;
    }

    public void setFkPostPrntId(Post fkPostPrntId) {
        this.fkPostPrntId = fkPostPrntId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkPostId != null ? pkPostId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.pkPostId == null && other.pkPostId != null) || (this.pkPostId != null && !this.pkPostId.equals(other.pkPostId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Post[ pkPostId=" + pkPostId + " ]";
    }
    
}
