package com.bookify.model;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Represents a Customer model.
 * 
 * @Author @Ayon-SSP
 * 
 * @Entity
 * @Table(name = "tbl_customer")
 * 
 * @methods getCustomerId, setCustomerId, getCustomerName, setCustomerName, getCustomerEmail, setCustomerEmail, getCustomerPhone1, setCustomerPhone1, getCustomerPassword, setCustomerPassword, getCustomerAddresses, setCustomerAddresses, addCustomerAddress, removeCustomerAddress, getCustomerAddress, getShopingCart, setShopingCart, addCartItem, removeCartItem, clearShopingCart, getCartTotal, getWishlists, setWishlists, addWishlist, removeWishlist, clearWishlists, getSubscriptionLogHistory, setSubscriptionLogHistory, addSubscriptionLogHistory, removeSubscriptionLogHistory.
 * @throws Exception if any of the CRUD operations fail.
 */
public class Customer implements Comparable<Customer> {
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerPhone1;
    private String customerPassword;

    // create a hashmap with if <CustomerAddress.addressType, CustomerAddress> //
    // notGoodPractice? all
    /*
     * 'Home' -> customerAddress1
     * 'Office' -> customerAddress2
     */
    Map<String, CustomerAddress> customerAddresses = new HashMap<>();

    // shoping cart list of books
    ArrayList<ShoppingCartItem> shopingCart = new ArrayList<>(); // customer.shopingCart.add(new ShoppingCartItem(book, quantity))

    // List of all Wishlists
    ArrayList<Wishlist> wishlists = new ArrayList<>();

    /*
    list of subscription log history of a customer eg.
    [
        subscriptionLogHistory1[subscriptionLogId, customer, subscription, subscriptionStartDate, subscriptionEndDate],
        subscriptionLogHistory2[subscriptionLogId, customer, subscription, subscriptionStartDate, subscriptionEndDate],
        ...
    ]
    */
    ArrayList<SubscriptionLogHistory> subscriptionLogHistory = new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer(String customerId, String customerName, String customerEmail, String customerPhone1,
            String customerPassword) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone1 = customerPhone1;
        this.customerPassword = customerPassword;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone1() {
        return customerPhone1;
    }

    public void setCustomerPhone1(String customerPhone1) {
        this.customerPhone1 = customerPhone1;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Map<String, CustomerAddress> getCustomerAddresses() {
        return customerAddresses;
    }

    public void setCustomerAddresses(Map<String, CustomerAddress> customerAddresses) {
        this.customerAddresses = customerAddresses;
    }

    public void addCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddresses.put(customerAddress.getAddressType(), customerAddress);
    }

    public void removeCustomerAddress(String addressType) {
        this.customerAddresses.remove(addressType);
    }

    public CustomerAddress getCustomerAddress(String addressType) {
        return this.customerAddresses.get(addressType);
    }

    public ArrayList<ShoppingCartItem> getShopingCart() {
        return shopingCart;
    }

    public void setShopingCart(ArrayList<ShoppingCartItem> shopingCart) {
        this.shopingCart = shopingCart;
    }

    public void addCartItem(ShoppingCartItem cartItem) {
        this.shopingCart.add(cartItem);
    }

    public void removeCartItem(ShoppingCartItem cartItem) {
        this.shopingCart.remove(cartItem);
    }

    public void clearShopingCart() {
        this.shopingCart.clear();
    }

    // to remove if notGoodPractice?
    // public double getCartTotal() {
    //     double total = 0;
    //     for (ShoppingCartItem cartItem : this.shopingCart) {
    //         total += (cartItem.getBookId().getBookPrice() * (1 - cartItem.getBookId().getBookDiscount()))
    //                 * cartItem.getQuantity();
    //     }
    //     return total;
    // }

    public ArrayList<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(ArrayList<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    public void addWishlist(Wishlist wishlist) {
        this.wishlists.add(wishlist);
    }

    public void removeWishlist(Wishlist wishlist) {
        this.wishlists.remove(wishlist);
    }

    public void clearWishlists() {
        this.wishlists.clear();
    }

    public ArrayList<SubscriptionLogHistory> getSubscriptionLogHistory() {
        return subscriptionLogHistory;
    }

    public void setSubscriptionLogHistory(ArrayList<SubscriptionLogHistory> subscriptionLogHistory) {
        this.subscriptionLogHistory = subscriptionLogHistory;
    }

    public void addSubscriptionLogHistory(SubscriptionLogHistory subscriptionLogHistory) {
        this.subscriptionLogHistory.add(subscriptionLogHistory);
    }

    public void removeSubscriptionLogHistory(SubscriptionLogHistory subscriptionLogHistory) {
        this.subscriptionLogHistory.remove(subscriptionLogHistory);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
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
        Customer other = (Customer) obj;
        if (customerId != other.customerId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Customer [customerEmail=" + customerEmail + ", customerId=" + customerId + ", customerName="
                + customerName
                + ", customerPassword=" + customerPassword + ", customerPhone1=" + customerPhone1 + "]";
    }

    // FIXME: Implement the compareTo method LIKE return
    // this.stringValue.compareTo(other.stringValue);
    @Override
    public int compareTo(Customer o) {
        return Integer.parseInt(this.customerId.substring(2)) - Integer.parseInt(o.customerId.substring(2));
    }
}
