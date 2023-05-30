package com.ohnong.app.stock.mapper;

import java.util.List;

import com.ohnong.app.stock.service.Criteria_3;
import com.ohnong.app.stock.service.OtherVO;

public interface SeedMapper {
	
	//종묘목록 리스트(페이징) 조회
	public List<OtherVO> getSeedListWithPaging(Criteria_3 cri);
	//종묘목록 개수 조회
	public int getTotalCount(Criteria_3 cri);
	//종묘 수정
	public int seedUpdate(OtherVO vo);
	//종묘 삭제
	public int seedDelete(OtherVO vo);
	//종묘 등록
	public int seedInsert(OtherVO vo);
	//소분류 검색
	public OtherVO findSubdivision(OtherVO vo);
	//등록된 종묘 리스트
	public List<OtherVO> seedListWithMiddle(OtherVO vo);
	//종묘 기존품목 등록
	public int seednotInsert(OtherVO vo);
	//종묘 개수 검색
	public OtherVO getCount(OtherVO vo);
}
