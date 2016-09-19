package onlinecurriculum.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import onlinecurriculum.model.OnlineCurriculumDBBean;  

public class OnlineCurriculumMybatis{
	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ����
			Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
			// 1.SqlMapConfig.xml
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	
	public static OnlineCurriculumDBBean getCurriculum(int num) {
		// TODO Auto-generated method stub
		return null;
	}
	public static List<OnlineCurriculumDBBean> listCurriculum() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void insertCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void updateCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void deleteCurriculum(OnlineCurriculumDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

}
