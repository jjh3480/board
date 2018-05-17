package login.service;


import login.dao.LoginDao;
import login.dao.LoginDaoInf;
import login.model.LoginVO;

public class LoginService implements LoginServiceInf {

	private LoginDaoInf dao;
	
	

	public LoginService() {
		dao = new LoginDao();
	}



	@Override
	public LoginVO LoginCheck(String id) {
//		boolean result = false;
//		if(dao.LoginCheck(id) != null){
//			result=true;
//		}
		return dao.LoginCheck(id);
	}
	
}
