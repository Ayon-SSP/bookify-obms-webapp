package com.bookify.model;

public class Genre implements Comparable<Genre> {
    private String genreId;
    private String genreName;
    private String genreDescription;
    private String genreImage;

    public Genre() {
        super();
    }

    public Genre(String genreId, String genreName, String genreDescription, String genreImage) {
        this.genreId = genreId;
        this.genreName = genreName;
        this.genreDescription = genreDescription;
        this.genreImage = genreImage;
    }

    public String getGenreId() {
        return genreId;
    }

    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }

    public String getGenreImage() {
        return genreImage;
    }

    public void setGenreImage(String genreImage) {
        this.genreImage = genreImage;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
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
        Genre other = (Genre) obj;
        if (genreId != other.genreId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Genre [genreId=" + genreId + ", genreName=" + genreName + ", genreDescription=" + genreDescription
                + ", genreImage=" + genreImage + "]";
    }

    @Override
    public int compareTo(Genre o) {
        return Integer.parseInt(this.genreId.substring(2)) - Integer.parseInt(o.genreId.substring(2));
    }
}