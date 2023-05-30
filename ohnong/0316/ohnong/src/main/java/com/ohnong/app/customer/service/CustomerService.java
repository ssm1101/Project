package com.ohnong.app.customer.service;

import java.util.List;

public interface CustomerService {

	// 거래처 목록
	public List<CustomerVO> getcustomerList(String userId);
	
	// 거래처 정보
	public List<CustomerVO> getAccountList(String userId,String businessName);

	// 거래처 수정
	public boolean customerMod(CustomerVO customerVO);

	// 거래처 등록
	public int insertCustomer(CustomerVO customerVO);

	// 거래처 삭제
	public int customerDelete(int customerId);

	// 거래처 중복 확인
	public int checkCustomer(String customer, String userId);

}
