package pl.coderslab.library.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Employee employee;

    public Borrowing() {
    }

    public Borrowing(Integer id, LocalDateTime rentalDate, LocalDateTime returnDate) {
        this.id = id;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDateTime rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
