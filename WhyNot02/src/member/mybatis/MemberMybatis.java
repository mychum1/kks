package member.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import member.model.MemberDBBean;

//SqlMapConfig.xml�� ��ϵ� �͵��� java�ڵ�� ����� �� �ֵ��� ���ִ� ��
public class MemberMybatis  {

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
	public static void insertMember(MemberDBBean dto) {
		System.out.println("MemberMybatis_insertBoard() ����");
		SqlSession session = sqlMapper.openSession();
		session.insert("insertMember", dto);
		session.commit(); // insert�� �ݵ�� commit()�� ����� �����Ͱ� ������
		session.close();
	}
	
	public static MemberDBBean getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	public static void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}
	public static void updateMember(MemberDBBean dto, String id) {
		// TODO Auto-generated method stub
		
	}
	//���̵� �ߺ� Ȯ��
	public static boolean idChk(String id) {
		// TODO Auto-generated method stub
		System.out.println("MemberMybatis_idChk() ����");
		SqlSession session = sqlMapper.openSession();
		boolean res = session.selectOne("idChk", id);
		session.close();
		
		return false;
	}
	public static List<MemberDBBean> listMember() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void sanctionsMember(MemberDBBean dto, int mnum) {
		// TODO Auto-generated method stub
		
	}

	
	

}
