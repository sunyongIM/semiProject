package bbsService;

import java.util.ArrayList;

import bbsDAO.bbsDAO;
import bbsVO.bbsVO;
import bbsVO.guestVO;
import bbsVO.memberVO;

public class bbsService {
	boolean isSuccess = false;
	bbsDAO dao = new bbsDAO();
	
	public boolean login(String id, String pwd) {
		this.isSuccess = dao.selectID(id, pwd);
		return this.isSuccess;
	}
	
	public boolean create(memberVO vo) {
		this.isSuccess = dao.insertID(vo);
		return this.isSuccess;
	}
	
	public memberVO findPwd(String id) {
		memberVO vo = null;
		vo = dao.selectPwd(id);
		return vo;
	}
	
	public boolean signOut(String id,String pwd) {
		this.isSuccess = dao.deleteId(id,pwd);
		return this.isSuccess;
	}
	
	public ArrayList<bbsVO> getMessages() {
		ArrayList<bbsVO> vo = null;
		vo = dao.selectAllb();
		return vo;
	}
	
	public boolean writebbs(bbsVO vo) {
		this.isSuccess = dao.insertb(vo);
		return isSuccess;
	}
	
	public ArrayList<guestVO> getMessagesG() {
		ArrayList<guestVO> vo = null;
		vo = dao.selectAllg();
		return vo;
	}
	
	public boolean writeguest(guestVO vo) {
		this.isSuccess = dao.insertg(vo);
		return this.isSuccess;
	}
	
	public boolean checkId(String id) {
		this.isSuccess = dao.validateId(id);
		return this.isSuccess;
	}
}
