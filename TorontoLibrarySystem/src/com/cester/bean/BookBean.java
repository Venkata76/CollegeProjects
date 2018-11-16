package com.cester.bean;

public class BookBean {
	String bookId,bookName,author;
	int quantity;
	public BookBean(String bookId, String bookName, String author, int quantity) {
		this.bookId=bookId;
		this.bookName=bookName;
		this.author=author;
		this.quantity=quantity;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
