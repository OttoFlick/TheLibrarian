package pl.coderslab.library.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "borrowing")
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING)
    private BorrowingStatus status = BorrowingStatus.OPEN;

    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;

    public Borrowing() {
    }

    public Borrowing(LocalDate rentalDate, LocalDate returnDate, Book book, Customer customer, Employee employee) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.book = book;
        this.customer = customer;
        this.employee = employee;
    }

    public boolean isOverdue(){
        return LocalDate.now().isAfter(returnDate);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
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

    public BorrowingStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Borrowing{" +
                "id=" + id +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", status=" + status +
                ", book=" + book +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
