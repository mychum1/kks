package onlinecontent.mybatis;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import onlinecontent.model.OnlineContentDBBean;

public class OnlineContentMybatis {
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
		} catch (Exception e) {
			// Fail fast.
			e.printStackTrace();
			throw new RuntimeException("Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}
	public static OnlineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
		int mnum=num;
		OnlineContentDBBean dto=new OnlineContentDBBean();
		
		SqlSession session=sqlMapper.openSession();
		dto=(OnlineContentDBBean)session.selectOne("getContent",mnum);
		session.commit();
		System.out.println("session get");
		session.close();
		return dto;
	}
	public static List<OnlineContentDBBean> listOnlineContent() {
		// TODO Auto-generated method stub
		return null;
		
/*		  List list=null;
		  SqlSession session=sqlMapper.openSession();
		  list=session.selectList("listBoard");
		  session.close();
		  return list;
		  List list=null;
		  try{
			  list=sqlMapper.queryForList("listBoard");
		  }catch(SQLException e){
			  System.out.println("listBoard ���� ����");
		  }
	    return list;*/
		
		//�̷�������.
	}
	public static void insertContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		SqlSession session=sqlMapper.openSession();
/*		Map map=new HashMap();
		map.put("mnum", dto.getMnum());
		map.put("vdnum",dto.getVdnum());
		map.put("filedir", dto.getFiledir());
		map.put("filename", dto.getFilename());
		map.put("num", num);*/
		session.insert("insertContent",dto);
		session.commit();
		System.out.println("session insert");
		session.close();
		
	}
	public static void updateContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void sanctionsContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
	public static void deleteContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}
}