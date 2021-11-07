package bbsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bbsConnection.bbsConnection;
import bbsVO.bbsVO;
import bbsVO.guestVO;
import bbsVO.memberVO;

public class bbsDAO {
	boolean isSuccess = false;
	
	public boolean insertID(memberVO vo) {
		
		Connection con = bbsConnection.getConnection();
		String sql = "insert into bbstbl(user_name,user_id,user_pwd,user_email) values(?,?,?,?)";
		PreparedStatement ppst = null;
		
		try {
			ppst = con.prepareStatement(sql);
			ppst.setString(1, vo.getName());
			ppst.setString(2, vo.getId());
			ppst.setString(3, vo.getPwd());
			ppst.setString(4, vo.getEmail());
			int affected = ppst.executeUpdate();
			if(affected>0) {
				isSuccess = true;
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, ppst, null);
		}
		
		return isSuccess;
	}
	
	public boolean selectID(String id, String pwd) {
		Connection con = bbsConnection.getConnection();
		String sql = "select * from bbstbl where user_id =? and user_pwd=?";
		PreparedStatement ppst = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			ppst = con.prepareStatement(sql);
			ppst.setString(1, id);
			ppst.setString(2, pwd);
			
			rs = ppst.executeQuery();
			while(rs.next()) {
				count++;
			}
			if(count>0) {
				isSuccess = true;
				//System.out.println("select 성공|| 아이디 개수: "+count);
			} else {
				//System.out.println("select 실패|| 아이디 개수: "+count);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, ppst, rs);
		}
		
		
		return isSuccess;
	}

	public memberVO selectPwd(String id) {
		memberVO vo = null;
		Connection con = bbsConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from bbstbl where user_id ='"+id+"'";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String name = rs.getString(2);
				String selectedId = rs.getString(3);
				String pwd = rs.getString(4);
				String email = rs.getString(5);
				vo = new memberVO(name,selectedId,pwd,email);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, stmt, rs);
		}
		
		return vo;
	}
	
	public boolean deleteId(String id,String pwd) {
		Connection con = bbsConnection.getConnection();
		String sql = "delete from bbstbl where user_id=? and user_pwd=?";
		PreparedStatement ppst = null;
		
		if(this.selectID(id, pwd)) {
			
			try {
				ppst = con.prepareStatement(sql);
				ppst.setString(1, id);
				ppst.setString(2, pwd);
				
				int affected = ppst.executeUpdate();
				if(affected>0) {
					isSuccess = true;
					//System.out.println("탈퇴성공");
				} else {
					//System.out.println("탈퇴실패");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else {
			System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		return isSuccess;
	}
	
	public ArrayList<bbsVO> selectAllb(){
		ArrayList<bbsVO> list = new ArrayList<bbsVO>();
		Connection con = bbsConnection.getConnection();
		String sql = "select * from posttbl";
		Statement stmt = null;
		ResultSet rs = null;
		bbsVO vo = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString(2);
				String title = rs.getString(3);
				String message = rs.getString(4);
				vo = new bbsVO(id,title,message);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, stmt, rs);
		}
		
		return list;
	}
	
	public boolean insertb(bbsVO vo) {
		Connection con = bbsConnection.getConnection();
		PreparedStatement ppst = null;
		String sql = "insert into posttbl(user_id,bbsTitle,bbsPost) values(?,?,?)";
		
		try {
			ppst = con.prepareStatement(sql);
			ppst.setString(1, vo.getId());
			ppst.setString(2, vo.getTitle());
			ppst.setString(3, vo.getMessage());
			
			int affected = ppst.executeUpdate();
			if(affected>0) {
				isSuccess = true;
				System.out.println("글올림");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, ppst, null);
		}
		
		return isSuccess;
	}
	
	public boolean insertg(guestVO vo) {
		Connection con = bbsConnection.getConnection();
		PreparedStatement ppst = null;
		String sql = "insert into guesttbl(guestTitle,guestPost) values(?,?)";
		
		try {
			ppst = con.prepareStatement(sql);
			ppst.setString(1, vo.getTitle());
			ppst.setString(2, vo.getMessage());
			
			int affected = ppst.executeUpdate();
			if(affected>0) {
				isSuccess = true;
				System.out.println("글올림");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, ppst, null);
		}
		
		return isSuccess;
	}
	
	public ArrayList<guestVO> selectAllg(){
		ArrayList<guestVO> list = new ArrayList<guestVO>();
		Connection con = bbsConnection.getConnection();
		String sql = "select * from guesttbl";
		Statement stmt = null;
		ResultSet rs = null;
		guestVO vo = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				String title = rs.getString(3);
				String message = rs.getString(4);
				vo = new guestVO(title,message);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, stmt, rs);
		}
		
		return list;
	}
	
	public boolean validateId(String id) {
		Connection con = bbsConnection.getConnection();
		String sql = "select * from bbsTBL where user_id='"+id+"'";
		Statement stmt = null;
		ResultSet rs = null;
		String isnull = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				isnull = rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			bbsConnection.closeConnection(con, stmt, rs);
		}
		
		
		if(isnull==null) {
			isSuccess = true;
		}
		
		return isSuccess;
	}
	
}

