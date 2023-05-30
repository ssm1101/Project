package com.ohnong.app.customer.mapper;

import java.util.List;

import com.ohnong.app.customer.service.CustomerVO;

public interface CustomerMapper {

	// 거래처 목록
	public List<CustomerVO> getcustomerList(String userId);
	
	// 거래처 정보
	public List<CustomerVO> getAccountList(String userId,String businessName);

	// 거래처 수정
	public int customerUpdate(CustomerVO customerVO);

	// 거래처 등록
	public int insertCustomer(CustomerVO customerVO);

	// 거래처 삭제
	public int deleteCustomer(int customerId);

	// 거래처 중복 확인
	public int checkCustomer(String customer, String userId);

}
