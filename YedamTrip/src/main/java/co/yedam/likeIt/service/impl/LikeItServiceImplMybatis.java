package co.yedam.likeIt.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSource;
import co.yedam.common.LikeItPageInfo;
import co.yedam.likeIt.mapper.LikeItMapper;
import co.yedam.likeIt.service.LikeItService;
import co.yedam.likeIt.vo.LikeItVO;

public class LikeItServiceImplMybatis implements LikeItService {
	SqlSession session = DataSource.getInstance().openSession(true);
	LikeItMapper mapper = session.getMapper(LikeItMapper.class);
	@Override
	public int likeItAdd(LikeItVO vo) {
		return mapper.likeItAdd(vo);
	}
	@Override
	public LikeItVO likeItSearch(LikeItVO vo) {
		return mapper.likeItSearch(vo);
	}
	@Override
	public int likeItListPagingTotalCnt(String mbId) {
		return mapper.likeItListPagingTotalCnt(mbId);
	}
	@Override
	public List<LikeItVO> likeItList(int pageNum, LikeItVO vo) {
		LikeItPageInfo cri = new LikeItPageInfo(pageNum, 5);
		cri.setMbId(vo.getMbId());
		return mapper.likeItList(cri);
	}
	@Override
	public int likeItDelete(LikeItVO vo) {
		return mapper.likeItDelete(vo);
	}
}
