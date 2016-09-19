package login.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import member.model.MemberDBBean;

public class LoginMybatis {
	//SqlMapConfig.xml�� ��ϵ� �͵��� java�ڵ�� ����� �� �ֵ��� ���ִ� ��
		private static SqlSessionFactory sqlMapper;
		static {
			try {
				// Reader = ��ġ ���� 
				Reader reader = Resources.getResourceAsReader("sqlmapconfig/SqlMapConfig.xml");
				// ������ ���� ���� ������
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				// ���̹�Ƽ���� �ٲ�鼭 ����Ÿ������ ó���� ���ְ� ��
				reader.close();
			} catch (IOException e) {
				// Fail fast.
				throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
			}
		}
		public static MemberDBBean chkLogin(MemberDBBean dto) {
			System.out.println("LoginMybatis_ chkLogin()����");
			SqlSession session = sqlMapper.openSession();
			MemberDBBean resDTO = session.selectOne("loginChk", dto);
			session.close();
			return resDTO;
		}

	}

