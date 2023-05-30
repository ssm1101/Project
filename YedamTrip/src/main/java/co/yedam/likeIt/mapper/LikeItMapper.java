package co.yedam.likeIt.mapper;

import java.util.List;

import co.yedam.common.LikeItPageInfo;
import co.yedam.likeIt.vo.LikeItVO;

public interface LikeItMapper {
	//찜 추가
	public int likeItAdd(LikeItVO vo);
	//찜 검색
	public LikeItVO likeItSearch(LikeItVO vo);
	//찜 목록 수
	public int likeItListPagingTotalCnt(String mbId);
	//찜 목록
	public List<LikeItVO> likeItList(LikeItPageInfo cri);
	//찜 삭제
	public int likeItDelete(LikeItVO vo);
}
