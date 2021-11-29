import com.dao.IDao;
import com.dao.IQuizDao;
import com.dao.IUser;

module com.app {
	requires com.dao;
	requires com.moel;
	
	uses IDao;
	uses IUser;
	uses IQuizDao;
}