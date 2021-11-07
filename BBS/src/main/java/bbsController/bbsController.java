package bbsController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbsService.bbsService;
import bbsVO.bbsVO;
import bbsVO.guestVO;
import bbsVO.memberVO;

public class bbsController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		String command = req.getParameter("cmd");
		String url = "./bbs/fail.jsp";
		boolean flag = false;
		bbsService service = new bbsService();
		RequestDispatcher rd = null;
		boolean isAjax = false;
		
		
		if(command.equals("create")) {
			String name = req.getParameter("name");
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String email = req.getParameter("email");
			memberVO vo = new memberVO(name,id,pwd,email);
			flag = service.create(vo);
			if(flag) {
				url = "/bbs/main.jsp";
				System.out.println("아이디 생성 성공");
			} else {
				System.out.println("아이디 생성 실패");
			}
			
		} else if(command.equals("join")) {
			url="/bbs/join.jsp";
			
		} else if(command.equals("find")) {
			url="/bbs/findPwd.jsp";
			
		} else if(command.equals("showPwd")) {
			String id = req.getParameter("findPwd");
			memberVO vo = service.findPwd(id);
			HttpSession session = req.getSession();
			if(vo!=null) {
				session.setAttribute("vo", vo);
				url="./bbs/yourPwd.jsp";
			} else {
				url="./bbs/fail.jsp";
			}
		} else if(command.equals("signout")) {
			url="./bbs/signout.jsp";
			
		} else if(command.equals("delete")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			boolean del = false;
			del = service.signOut(id,pwd);
			if(del) {
				url="./bbs/goodbye.jsp";
				System.out.println("탈퇴완료");
			}
		
		} else if(command.equals("logIn")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			flag = service.login(id,pwd);
			if(flag) {
				
				HttpSession session = req.getSession();
				ArrayList<bbsVO> list = null;
				list = service.getMessages();
				
				session.setAttribute("id",id);
				session.setAttribute("pwd",pwd);
				session.setAttribute("list",list);
				url="./bbs/bbs_login.jsp";
				System.out.println("로그인+게시판 불러오기 성공");
				
			} else {
				System.out.println("로그인 실패");
			}
			
		} else if(command.equals("bbsg")) {
			HttpSession session = req.getSession();
			ArrayList<guestVO> list = null;
			list = service.getMessagesG();
			session.setAttribute("list",list);
			url="./bbs/bbs_guest.jsp";
			
		} else if(command.equals("postl")) {
			url="./bbs/bbs_writel.jsp";
			
		} else if(command.equals("writel")) {
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String title = req.getParameter("title");
			String message = req.getParameter("message");
			bbsVO vo = new bbsVO(id, title, message);
			flag = service.writebbs(vo);
			
			if(flag) {
				req.setAttribute("id", id);
				req.setAttribute("pwd", pwd);
				url="./CmdController?cmd=logIn";
			}
			
		} else if(command.equals("postg")) {
			url="./bbs/bbs_writeg.jsp";
			
		} else if(command.equals("writeg")) {
			String title = req.getParameter("title");
			String message = req.getParameter("message");
			guestVO vo = new guestVO(title, message);
			flag = service.writeguest(vo);
			if(flag) {
				url="./CmdController?cmd=bbsg";
			}
			
		} else if(command.equals("checkId")) {
			String id = req.getParameter("checkId");
			flag = service.checkId(id);
			if(id!="") {
				if(flag) {
					isAjax = true;
					resp.getWriter().print("사용할 수 있는 아이디입니다: "+id);
				} else {
					isAjax = true;
					resp.getWriter().print(id+" 아이디가 이미 존재합니다.");
				}
			} else {
				isAjax = true;
				resp.getWriter().print("아이디를 입력해주세요");
				
			}
		}
		
//		resp.sendRedirect(url);
		if(!isAjax) {
			rd = req.getRequestDispatcher(url);
			rd.forward(req,resp);
		}
	}
}
