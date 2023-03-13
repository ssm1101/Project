package com.yedam.rental;

public class Rental {
	// member_id varchar2(30) references member(member_id)
	// book_no number(6) references book(book_no)
	// rent_date date
	// rent_return date

	private String memberId;
	private String bookNo;
	private String rentDate;
	private String returnDate;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBookNo() {
		return bookNo;
	}

	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

}
