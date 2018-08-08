package LoginTask.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import LoginTask.dao.JdbcTemplateJoinerDao;
import LoginTask.dao.JoinerInterfaceDao;
import LoginTask.model.ConvertJoiner;
import LoginTask.model.Joiner;
import LoginTask.model.MemberListView;

public class MemberListService {

	// 싱글톤
	/*private MemberListService() {
	}

	private static MemberListService instance = new MemberListService();

	public static MemberListService getInstance() {
		return instance;
	}*/
	
	/*@Autowired
	JoinerDao dao;*/
	
	/*@Autowired
	JdbcTemplateJoinerDao dao;*/
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	JoinerInterfaceDao dao;

	// 한 페이지당 보여줄 회원 수
	int memberTotalCount = 0;
	private static final int MEMBER_COUNT_PER_PAGE = 5;
	
	public MemberListView getMemberList(int pageNumber) throws ServiceException, SQLException {
		dao = sqlSessionTemplate.getMapper(JoinerInterfaceDao.class);
		MemberListView memberListView = null;

		// 현재 페이지 넘버 구하기
		int currentPageNumber = 1;

		if (pageNumber > 0) {
			currentPageNumber = pageNumber;
		}

		// 본격 메서드 구하기
		
			// 전체 게시물 수
			memberTotalCount = dao.selectCount();
			
			List<Joiner> memberList = null;
			int firstRow = 0;
			int endRow = 0;

			if (memberTotalCount > 0) {

				firstRow = (currentPageNumber - 1) * MEMBER_COUNT_PER_PAGE;
				endRow = firstRow + MEMBER_COUNT_PER_PAGE - 1;
				memberList = dao.selectList(firstRow, endRow);

			} else {
				currentPageNumber = 0;
				memberList = Collections.emptyList();
			}

			memberListView = new MemberListView(memberTotalCount, memberList, currentPageNumber, MEMBER_COUNT_PER_PAGE,
					firstRow, endRow);

			return memberListView;
	
	}
	

	// ajax로 xml/json 파일을 만들기 위한 메서드
	public List<Joiner> getMemberList2() throws SQLException {

	/*	Connection conn = null;
		JoinerDao dao = null;*/
	/*	try {

			conn = ConnectionProvider.getConnection();*/
		/*	dao = JoinerDao.getInstance();*/

			// 전체 게시물 수
			List<Joiner> memberList = dao.selectAll();

			return memberList;

	/*	} finally {
			JdbcUtil.close(conn);
		}
*/
	}
	
	public List<Joiner> getConvertMemberList1(String from, String to) throws SQLException {
		List<Joiner> memberList = dao.convertedListbyBirth1(from, to);
		return memberList;
	}
	
	//Xml 및 Json 파일로 변환하기 위해 만듬
	public List<ConvertJoiner> getConvertedMemberList() throws SQLException {
		List<ConvertJoiner> memberList = dao.convertedSelectAll();
		return memberList;
	}


	public List<ConvertJoiner> actConvertedMemberList(String from, String to) throws ParseException {
		List<ConvertJoiner> memberList = dao.convertedListbyBirth(from, to);
		return memberList;
	}
	
	

}
