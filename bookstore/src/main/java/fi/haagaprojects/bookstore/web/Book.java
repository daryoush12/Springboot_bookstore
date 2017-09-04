package fi.haagaprojects.bookstore.web;

public class Book {
String title;
String Author;
long year;
String isbn;
double price;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return Author;
}
public void setAuthor(String author) {
	Author = author;
}
public long getYear() {
	return year;
}
public void setYear(long year) {
	this.year = year;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Book(String title, String author, long year, String isbn, double price) {
	super();
	this.title = title;
	Author = author;
	this.year = year;
	this.isbn = isbn;
	this.price = price;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
}
