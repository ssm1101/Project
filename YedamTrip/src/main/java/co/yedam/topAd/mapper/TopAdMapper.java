package co.yedam.topAd.mapper;

import java.util.List;

import co.yedam.common.Criteria;
import co.yedam.common.SearchVO;
import co.yedam.topAd.vo.TopAdVO;
import co.yedam.topAd.vo.TopAdViewVO;

public interface TopAdMapper {

	List<TopAdVO> TopAdListPaging(Criteria cri);

	int TopAdListPagingTotalCnt(SearchVO svo);

	List<TopAdVO> TopdisplayPermissList();

	int TopdisplayInsert(TopAdVO vo);

	int TopdisplayDelete(int id);

	int TopdisplayPermiss(int id);

	List<TopAdViewVO> TopdisplayView();

}

