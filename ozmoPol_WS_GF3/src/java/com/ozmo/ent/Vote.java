/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ozmo.ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sav
 */
@Entity
@Table(name = "Vote")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vote.findAll", query = "SELECT v FROM Vote v"),
    @NamedQuery(name = "Vote.findByPkVoteId", query = "SELECT v FROM Vote v WHERE v.pkVoteId = :pkVoteId"),
    @NamedQuery(name = "Vote.findByVoteValue", query = "SELECT v FROM Vote v WHERE v.voteValue = :voteValue")})
public class Vote implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "pk_vote_id")
    private String pkVoteId;
    @Column(name = "vote_value")
    private Boolean voteValue;
    @JoinColumn(name = "fk_vote_post_id", referencedColumnName = "pk_post_id")
    @ManyToOne(optional = false)
    private Post fkVotePostId;
    @JoinColumn(name = "fk_vote_user_id", referencedColumnName = "pk_user_id")
    @ManyToOne(optional = false)
    private User fkVoteUserId;

    public Vote() {
    }

    public Vote(String pkVoteId) {
        this.pkVoteId = pkVoteId;
    }

    public String getPkVoteId() {
        return pkVoteId;
    }

    public void setPkVoteId(String pkVoteId) {
        this.pkVoteId = pkVoteId;
    }

    public Boolean getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Boolean voteValue) {
        this.voteValue = voteValue;
    }

    public Post getFkVotePostId() {
        return fkVotePostId;
    }

    public void setFkVotePostId(Post fkVotePostId) {
        this.fkVotePostId = fkVotePostId;
    }

    public User getFkVoteUserId() {
        return fkVoteUserId;
    }

    public void setFkVoteUserId(User fkVoteUserId) {
        this.fkVoteUserId = fkVoteUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVoteId != null ? pkVoteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.pkVoteId == null && other.pkVoteId != null) || (this.pkVoteId != null && !this.pkVoteId.equals(other.pkVoteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ozmo.ent.Vote[ pkVoteId=" + pkVoteId + " ]";
    }
    
}
