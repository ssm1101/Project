package com.ohnong.app.notice.service;

import lombok.Data;

@Data
public class ProjectVO {
	
//	seq				String	공통	게시글 순번
//	typeDv			String	공통	게시글 타입(edu교육, policy사업)
//	title			String	공통	제목
//	contents		String	공통	내용
//	applStDt		String	공통	신청시작일
//	appEdDt			String	공통	신청마감일
//	eduTarget		String	공통	지원대상 / 교육대상
//	area1Nm			String	공통	지역명(도)
//	area2Nm			String	공통	지역명(시군구)
//	chargeAgency	String	공통	담당기관 / 주관기관
//	chargeDept		String	공통	담당부서
//	chargeTel		String	공통	담당부서 전화번호
//	infoUrl			String	공통	공고 URL
//	eduStDt			String	교육	교육신청시작일
//	eduEdDt			String	교육	교육신청마감일
//	eduTime			String	교육	교육시간
//	eduCnt			String	교육	교육인원
//	totQuantity		String	사업	총 수량
//	price			String	사업	지원 금액
	String	seq;
	String	typeDv;
	String	title;
	String	contents;
	String	applStDt;
	String	applEdDt;
	String	eduTarget;
	String	area1Nm;
	String	area2Nm;
	String	chargeAgency;
	String	chargeDept;
	String	chargeTel;
	String	infoUrl;
	String	eduStDt;
	String	eduEdDt;
	String	eduTime;
	String	eduCnt;
	String	totQuantity;
	String	price;
	
	@Override
	public String toString() {					
		return "ProjectVO [ seq="+seq+"typeDv"+typeDv+"title"+title+"contents"+contents+	
		"applStDt"+applStDt+"appEdDt"+applEdDt+"eduTarget"+eduTarget+"area1Nm"+area1Nm+"area2Nm"+area2Nm	+
		"chargeAgency"+chargeAgency+"chargeDept"+chargeDept+"vchargeTel"+chargeTel+"infoUrl"+infoUrl+
		"eduStDt"+eduStDt+"eduEdDt"+eduEdDt+"eduTime"+eduTime+"eduCnt"+eduCnt+"totQuantity"+totQuantity+"price"+price+ "]";	
	}				
					
					



}

