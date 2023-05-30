package com.ohnong.app.customer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ohnong.app.customer.mapper.CustomerMapper;
import com.ohnong.app.customer.service.CustomerService;
import com.ohnong.app.customer.service.CustomerVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerMapper customerMapper;

	// 거래처 목록
	@Override
	public List<CustomerVO> getcustomerList(String userId) {
		return customerMapper.getcustomerList(userId);
	}

	// 거래처 정보
	@Override
	public List<CustomerVO> getAccountList(String userId, String businessName) {
		// TODO Auto-generated method stub
		return customerMapper.getAccountList(userId, businessName);
	}

	// 거래처 수정
	@Override
	public boolean customerMod(CustomerVO customerVO) {
		return customerMapper.customerUpdate(customerVO) == 1 ? true : false;
	}

	// 거래처 등록
	@Override
	public int insertCustomer(CustomerVO customerVO) {
		return customerMapper.insertCustomer(customerVO);
	}

	// 거래처 삭제
	@Override
	public int customerDelete(int customerId) {
		return customerMapper.deleteCustomer(customerId);
	}

	// 거래처 중복 확인
	@Override
	public int checkCustomer(String customer, String userId) {
		return customerMapper.checkCustomer(customer, userId);
	}
}
