package co.yedam.topAd.service;

import java.util.List;

import co.yedam.common.SearchVO;
import co.yedam.topAd.vo.TopAdVO;
import co.yedam.topAd.vo.TopAdViewVO;

public interface TopAdService {

	List<TopAdVO> TopAdListPaging(int pageNumInt, SearchVO svo);

	int TopAdListPagingTotalCnt(SearchVO svo);

	List<TopAdVO> TopdisplayPermissList();

	int TopdisplayInsert(TopAdVO vo);

	int TopdisplayDelete(int id);

	int TopdisplayPermiss(int id);

	List<TopAdViewVO> TopdisplayView();


}
