package com.bookify.model;

import java.util.ArrayList;

public class Wishlist implements Comparable<Wishlist> {
    private String customerWishlistId;
    private String customerId;
    private String wishlistName;
    private String wishlistDescription;
    private String wishlistImage;

    // one wishlist contains many books // notGoodPractice?
    private ArrayList<Book> wishListItem = new ArrayList<>();

    public Wishlist() {
        super();
    }

    public Wishlist(String customerWishlistId, String customerId, String wishlistName, String wishlistDescription, String wishlistImage) {
        this.customerWishlistId = customerWishlistId;
        this.customerId = customerId;
        this.wishlistName = wishlistName;
        this.wishlistDescription = wishlistDescription;
        this.wishlistImage = wishlistImage;
    }

    public String getCustomerWishlistId() {
        return customerWishlistId;
    }

    public void setCustomerWishlistId(String customerWishlistId) {
        this.customerWishlistId = customerWishlistId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getWishlistName() {
        return wishlistName;
    }

    public void setWishlistName(String wishlistName) {
        this.wishlistName = wishlistName;
    }

    public String getWishlistDescription() {
        return wishlistDescription;
    }

    public void setWishlistDescription(String wishlistDescription) {
        this.wishlistDescription = wishlistDescription;
    }

    public String getWishlistImage() {
        return wishlistImage;
    }

    public void setWishlistImage(String wishlistImage) {
        this.wishlistImage = wishlistImage;
    }

    public ArrayList<Book> getWishListItem() {
        return wishListItem;
    }

    public void setWishListItem(ArrayList<Book> wishListItem) {
        this.wishListItem = wishListItem;
    }

    public void addBook(Book book) {
        wishListItem.add(book);
    }

    public void removeBook(Book book) {
        wishListItem.remove(book);
    }

    public void clearWishlist() {
        wishListItem.clear();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerWishlistId == null) ? 0 : customerWishlistId.hashCode());
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
        Wishlist other = (Wishlist) obj;
        if (customerWishlistId != other.customerWishlistId)
            return false;
        if (customerId != other.customerId)
            return false;
        return true;
    }

    // FIXME: correct the order of display toString
    @Override
    public String toString() {
        // follow the correct order how i created the fields
        return "Wishlist [customerId=" + customerId + ", customerWishlistId=" + customerWishlistId + ", wishlistDescription=" + wishlistDescription + ", wishlistImage=" + wishlistImage + ", wishlistName=" + wishlistName + "]";
    }

    @Override
    public int compareTo(Wishlist o) {
        return Integer.parseInt(this.customerWishlistId.substring(2)) - Integer.parseInt(o.customerWishlistId.substring(2));
    }
}
