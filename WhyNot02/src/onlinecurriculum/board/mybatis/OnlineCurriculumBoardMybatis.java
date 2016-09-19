package onlinecurriculum.board.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import onlinecurriculum.board.model.OnlineCurriculumBoardDBBean;

public class OnlineCurriculumBoardMybatis  {
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ���� 
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			//1.SqlMapConfig.xml 
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public static List<OnlineCurriculumBoardDBBean> list(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void count(int num) {
		// TODO Auto-generated method stub
		
	}
	public static OnlineCurriculumBoardDBBean getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void insertBoard(OnlineCurriculumBoardDBBean dto, int num) {
		// TODO Auto-generated method stub
	}
	public static void deleteBoard(OnlineCurriculumBoardDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void updateBoard(OnlineCurriculumBoardDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	
	
}
