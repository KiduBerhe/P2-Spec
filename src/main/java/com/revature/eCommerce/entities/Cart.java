package com.revature.eCommerce.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @Column(name = "cart_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private List<Item> item;

    @Column
    private int quantity;

    @Column
    @Temporal(TemporalType.DATE)
    private Date checkOutDate;

    public Cart() {
    }

    public Cart(Customer customer, List<Item> item, int quantity, Date checkOutDate) {
        this.customer = customer;
        this.item = item;
        this.quantity = quantity;
        this.checkOutDate = checkOutDate;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return quantity == cart.quantity && Objects.equals(cartId, cart.cartId) && Objects.equals(customer, cart.customer) && Objects.equals(item, cart.item) && Objects.equals(checkOutDate, cart.checkOutDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, customer, item, quantity, checkOutDate);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", customer=" + customer +
                ", item=" + item +
                ", quantity=" + quantity +
                ", checkOutDate=" + checkOutDate +
                '}';
    }
}
