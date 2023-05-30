package co.yedam.trip.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.trip.mapper.TripMapper;
import co.yedam.trip.service.TripService;
import co.yedam.trip.vo.TripVO;

public class TripServiceImplMybatis implements TripService {
	SqlSession session = DataSource.getInstance().openSession(true);
	TripMapper mapper = session.getMapper(TripMapper.class);

	@Override
	public List<TripVO> tripList() {
		return mapper.tripList();
	}

	@Override
	public int tripAdd(TripVO vo) {
		return mapper.tripAdd(vo);
	}

	@Override
	public TripVO tripSearch(int tpId) {
		return mapper.tripSearch(tpId);
	}

	@Override
	public int tripUpdate(TripVO vo) {
		return mapper.tripUpdate(vo);
	}

	@Override
	public List<TripVO> tripMyList(String mbId) {
		return mapper.tripMyList(mbId);
	}

	@Override
	public int tripDel(int tpId) {
		return mapper.tripDel(tpId);
	}

	@Override
	public List<TripVO> tripKeywordSearch(TripVO vo) {
		// TODO Auto-generated method stub
		return mapper.tripKeywordSearch(vo);
	}

	@Override
	public List<TripVO> packageList(TripVO vo) {
		return mapper.packageList(vo);
	}

	@Override
	public TripVO packageView(int tpId) {
		return mapper.packageView(tpId);
	}

	@Override
	public List<TripVO> recommandList() {
		return mapper.recommandList();
	}

	@Override
	public List<TripVO> tripProductSearch(int tpId) {
		return mapper.tripProductSearch(tpId);
	}

	@Override
	public List<TripVO> tripTheme() {
		// TODO Auto-generated method stub
		return mapper.tripTheme();
	}

	@Override
	public List<TripVO> tripArea() {
		// TODO Auto-generated method stub
		return mapper.tripArea();
	}
}