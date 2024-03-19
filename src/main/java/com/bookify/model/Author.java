package com.bookify.model;

public class Author implements Comparable<Author> {
    private String authorId;
    private String authorName;
    private String authorBio;
    private double authorScore;
    private String authorImage;
    private String authorBirthDate;

    public Author() {
        super();
    }

    public Author(String authorId, String authorName, String authorBio, double authorScore, String authorImage, String authorBirthDate) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authorBio = authorBio;
        this.authorScore = authorScore;
        this.authorImage = authorImage;
        this.authorBirthDate = authorBirthDate;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    public void setAuthorBio(String authorBio) {
        this.authorBio = authorBio;
    }

    public double getAuthorScore() {
        return authorScore;
    }

    public void setAuthorScore(double authorScore) {
        this.authorScore = authorScore;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }

    public String getAuthorBirthDate() {
        return authorBirthDate;
    }

    public void setAuthorBirthDate(String authorBirthDate) {
        this.authorBirthDate = authorBirthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Author other = (Author) obj;
        if (authorId != other.authorId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Author [authorId=" + authorId + ", authorName=" + authorName + ", authorBio=" + authorBio + ", authorScore="
                + authorScore + ", authorImage=" + authorImage + ", authorBirthDate=" + authorBirthDate + "]";
    }

    @Override
    public int compareTo(Author o) {
        return Integer.parseInt(this.authorId.substring(2)) - Integer.parseInt(o.authorId.substring(2));
    }
    

}
