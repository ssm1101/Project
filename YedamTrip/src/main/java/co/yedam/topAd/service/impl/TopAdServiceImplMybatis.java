package co.yedam.topAd.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.Criteria;
import co.yedam.common.DataSource;
import co.yedam.common.SearchVO;
import co.yedam.topAd.mapper.TopAdMapper;
import co.yedam.topAd.service.TopAdService;
import co.yedam.topAd.vo.TopAdVO;
import co.yedam.topAd.vo.TopAdViewVO;

public class TopAdServiceImplMybatis implements TopAdService {
	SqlSession session = DataSource.getInstance().openSession(true);
	TopAdMapper mapper = session.getMapper(TopAdMapper.class);
	@Override
	public List<TopAdVO> TopAdListPaging(int pageNum, SearchVO svo) {
		// TODO Auto-generated method stub
		Criteria cri = new Criteria(pageNum, 10);
		cri.setSearchCondition(svo.getSearchCondition());
		cri.setKeyword(svo.getKeyword());
		
		return mapper.TopAdListPaging(cri);
	}
	@Override
	public int TopAdListPagingTotalCnt(SearchVO svo) {
		// TODO Auto-generated method stub
		return mapper.TopAdListPagingTotalCnt(svo);
	}
	@Override
	public List<TopAdVO> TopdisplayPermissList() {
		// TODO Auto-generated method stub
		return mapper.TopdisplayPermissList();
	}
	@Override
	public int TopdisplayInsert(TopAdVO vo) {
		// TODO Auto-generated method stub
		return mapper.TopdisplayInsert(vo);
	}
	@Override
	public int TopdisplayDelete(int id) {
		return mapper.TopdisplayDelete(id);		
	}
	
	@Override
	public int TopdisplayPermiss(int id) {
		return mapper.TopdisplayPermiss(id);	
		
	}
	@Override
	public List<TopAdViewVO> TopdisplayView() {
		// TODO Auto-generated method stub
		return mapper.TopdisplayView();
	}



}
