package com.onndoo.book.jakarta10.recipes.chapter6.entity.key;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "AUTHOR_WORK")
@NamedQueries({
        @NamedQuery(name = "AuthorWork.findAll", query = "SELECT a FROM AuthorWork a")})
public class AuthorWorkEmbedded<BookAuthor06> implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    private BigDecimal id;
    @Column(name = "BOOK_ID")
    private BigInteger bookId;
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private BookAuthor06 authorId;
    private static final long serialVersionUID = 1L;

    // You can use an embedded ID in-place of a standard Id if a table
    // contains more than one column to compose a primary key.  Comment
    // out along with the getters and setters to use a non-embeddable primary key.
    @EmbeddedId
    private AuthorWorkPKEmbedded embeddedId;

    public AuthorWorkEmbedded() {
    }

    public AuthorWorkEmbedded(BigInteger bookId, BigInteger authorId) {
        this.embeddedId = new AuthorWorkPKEmbedded(bookId, authorId);
    }


    /**
     * @return the embeddedId
     */
    public AuthorWorkPKEmbedded getEmbeddedId() {
        return embeddedId;
    }

    /**
     * @param embeddedId the embeddedId to set
     */
    public void setEmbeddedId(AuthorWorkPKEmbedded embeddedId) {
        this.embeddedId = embeddedId;
    }

    public AuthorWorkEmbedded(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getBookId() {
        return bookId;
    }

    public void setBookId(BigInteger bookId) {
        this.bookId = bookId;
    }

    public BookAuthor06 getAuthorId() {
        return authorId;
    }

    public void setAuthorId(BookAuthor06 authorId) {
        this.authorId = authorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorWorkEmbedded)) {
            return false;
        }
        AuthorWorkEmbedded other = (AuthorWorkEmbedded) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.jakartaeerecipes.chapter06.entity.AuthorWorkEmbedded[ id=" + id + " ]";
    }

}