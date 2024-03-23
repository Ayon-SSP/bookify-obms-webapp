package com.bookify.model;

/*
 * Represents a ShoppingCartItem model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_shopping_cart")
 * 
 * @methods getCustomerId, setCustomerId, getBook, setBook, getQuantity, setQuantity.
 * @throws Exception if any of the CRUD operations fail.
 */
public class ShoppingCartItem implements Comparable<ShoppingCartItem> {
    private String customerId;
    private Book book;
    private int quantity;

    public ShoppingCartItem() {
        super();
    }

    public ShoppingCartItem(String customerId, Book book, int quantity) {
        this.customerId = customerId;
        this.book = book;
        this.quantity = quantity;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        result = prime * result + ((book == null) ? 0 : book.hashCode());
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
        ShoppingCartItem other = (ShoppingCartItem) obj;
        if (customerId != other.customerId)
            return false;
        if (book != other.book)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem [book=" + book + ", customerId=" + customerId + ", quantity=" + quantity + "]";
    }

    @Override
    public int compareTo(ShoppingCartItem o) {
        return Integer.parseInt(this.customerId.substring(2)) - Integer.parseInt(o.customerId.substring(2));
    }
}
