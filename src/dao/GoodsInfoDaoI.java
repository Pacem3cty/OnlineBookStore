package dao;

import java.util.List;

import model.GoodsInfo;
public interface GoodsInfoDaoI 
{//�����GoodsInfoDao�����ݿ���������Ľӿ�
	List<GoodsInfo> queryAllResult();//˳���ѯ
	List<GoodsInfo> searchByName(String name);//��Ʒ��������ģ����ѯ
	List<GoodsInfo> searchById(String id);//��Ʒ���������ȷ��ѯ
	boolean deleteById(String id);//������Ʒ���ɾ������
	boolean insertGoodsInfo(GoodsInfo GI);//��������
	boolean updateGoodsInfo(GoodsInfo GI);//�޸�����
}
