package dao;

import java.util.List;

import model.GoodsInfo;
public interface GoodsInfoDaoI 
{//定义对GoodsInfoDao表数据库操作方法的接口
	List<GoodsInfo> queryAllResult();//顺序查询
	List<GoodsInfo> searchByName(String name);//商品名称条件模糊查询
	List<GoodsInfo> searchById(String id);//商品编号条件精确查询
	boolean deleteById(String id);//根据商品编号删除数据
	boolean insertGoodsInfo(GoodsInfo GI);//插入数据
	boolean updateGoodsInfo(GoodsInfo GI);//修改数据
}
