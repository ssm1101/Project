package com.yedam.book;

public class Book {

//	  book_no number(6) primary key
//	  book_title varchar2(100) 
//	  book_aut varchar2(60) 
//	  book_pub varchar2(60) 
//	  book_price number(6) 

	private String bookNo;
	private String bookTitle;
	private String bookAut;
	private String bookPub;
	private int bookPrice;

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAut() {
		return bookAut;
	}

	public void setBookAut(String bookAut) {
		this.bookAut = bookAut;
	}

	public String getBookPub() {
		return bookPub;
	}

	public void setBookPub(String bookPub) {
		this.bookPub = bookPub;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

}
