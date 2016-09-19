package onlinecurriculum.model;

import java.util.List;

public interface OnlineCurriculumDAO {
	public OnlineCurriculumDBBean getCurriculum(int num); //���ǽ�
	public List<OnlineCurriculumDBBean> listCurriculum(); //������ ��page���� Ŀ��ŧ�� ���
	public void insertCurriculum(OnlineCurriculumDBBean dto ,int num); //���
	public void updateCurriculum(OnlineCurriculumDBBean dto ,int num); //����
	public void deleteCurriculum(OnlineCurriculumDBBean dto ,int num); //����
}
