import com.dao.IDao;

module com.app {
	requires com.dao;
	requires com.moel;
	
	uses IDao;
}