package member.model;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberDAOImpl implements MemberDAO {
	
	//�̰� ���ϱ� 500 ������... 
/*	private static SqlSessionFactory sqlMapper;
	static {
		try {
			// Reader = ��ġ ����
			Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
			// ������ ���� ���� ������
			sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
			reader.close();
		} catch (IOException e) {
			// Fail fast.
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}*/
	
	@Override
	public MemberDBBean getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertMember(MemberDBBean dto) {
		// TODO Auto-generated method stub
		System.out.println("MemberDAO_insertMember() ����");
		/*SqlSession session = sqlMapper.openSession();
		session.insert("insertMember");*/
	}

	@Override
	public void deleteMember(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMember(MemberDBBean dto, String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberDBBean> listMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sanctionsMember(MemberDBBean dto, int mnum) {
		// TODO Auto-generated method stub
		
	}



}
