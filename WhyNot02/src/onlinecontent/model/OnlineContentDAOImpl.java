package onlinecontent.model;

import java.util.List;

import onlinecontent.mybatis.OnlineContentMybatis;

public class OnlineContentDAOImpl implements OnlineContentDAO {

	@Override
	public OnlineContentDBBean getContent(int num) {
		// TODO Auto-generated method stub
		OnlineContentDBBean dto=new OnlineContentDBBean();
		dto=OnlineContentMybatis.getContent(num);
		return dto;
	}

	@Override
	public List<OnlineContentDBBean> listOnlineContent() {
		// TODO Auto-generated method stub
		return null;
	
	}

	@Override
	public void insertContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
//OnlineContentDBBean
		System.out.println(dto.getFiledir()+", "+num);
		OnlineContentMybatis.insertContent(dto,num);//��� �� dao�� ���̹�Ƽ���� ���鼭 ��� �Ǵ� �κ���! 
		//�׳� ������ �� �� ��
	}

	@Override
	public void updateContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sanctionsContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteContent(OnlineContentDBBean dto, int num) {
		// TODO Auto-generated method stub
		
	}


}