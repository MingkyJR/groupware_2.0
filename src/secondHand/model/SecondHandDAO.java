package secondHand.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.conn.ConnectionProvider;

public class SecondHandDAO {

	// 중고장터 리스트 조회
	public List<SecondHandDTO> listSelect(SecondHandPageDTO pageDTO) {
		System.out.println("listSelect");
		System.out.println("pageDTO = "+pageDTO);
		List<SecondHandDTO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = 	"select * from(select s.*, row_number()over(order by s.no desc) as num from secondhand s)"+
						" where num>"+pageDTO.getStartRow()+" and num<"+pageDTO.getEndRow();
		System.out.println("start : " + pageDTO.getStartRow() + "end : " + pageDTO.getEndRow());
		try {
			conn = ConnectionProvider.getConnection();
			System.out.println(conn);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				SecondHandDTO dto = new SecondHandDTO();
				dto.setNo(rs.getInt("no"));
				dto.setEmpID(rs.getString("emp_id"));
				dto.setTitle(rs.getString("title"));
				dto.setRefileName(rs.getString("refilename"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegDate(rs.getDate("regDate"));
				dto.setViews(rs.getInt("views"));
				list.add(dto);
				System.out.println("list = "+list);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	// 중고장터 게시글 검색
	public List<SecondHandDTO> listSearch(SecondHandPageDTO pageDTO, String keyword){
		String query = "select * from"+
				" (select s.*, row_number()over(order by s.no desc) as num from secondhand s where title LIKE '%'||?||'%')"+ 
				" where num>"+pageDTO.getStartRow()+" and num<"+pageDTO.getEndRow();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<SecondHandDTO> list = new ArrayList<>();
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SecondHandDTO dto = new SecondHandDTO();
				dto.setNo(rs.getInt("no"));
				dto.setEmpID(rs.getString("emp_id"));
				dto.setTitle(rs.getString("title"));
				dto.setRefileName(rs.getString("refilename"));
				dto.setPrice(rs.getInt("price"));
				dto.setRegDate(rs.getDate("regDate"));
				dto.setViews(rs.getInt("views"));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	
	// 중고장터 게시글 등록
	public int insert(SecondHandDTO dto) {
		System.out.println(dto);
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query=	"insert into secondhand(no, emp_id, title, filename, refilename, regdate, price)"+
						" values(NO_SEQ.nextval, ?, ?, ?, ?, sysdate, ?)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getEmpID());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getFileName());
			pstmt.setString(4, dto.getRefileName());
			pstmt.setInt(5, dto.getPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 제일 마지막 행번호 찾기
	public int lookup() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int maxNo = -1;
		String query = 	"select max(no)" + 
						" from secondhand";
		
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				maxNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return maxNo;
	}
	// 상세내용 등록
	public int insert(SecondHandContentDTO dto) {
		System.out.println(dto);
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query=	"insert into secondhand_data"+
						" values(?, ?)";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getContent());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	//상세조회 
	public SecondHandContentDTO selectContent(int no) {
		
		SecondHandContentDTO contentDTO = new SecondHandContentDTO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 	"select *"+
						" from secondhand a inner join secondhand_data b"+
						" on a.no = b.no"+
						" where a.no=?";
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				contentDTO.setNo(rs.getInt("no"));
				contentDTO.setEmpID(rs.getString("emp_id"));
				contentDTO.setTitle(rs.getString("title"));
				contentDTO.setRefileName(rs.getString("refilename"));
				contentDTO.setRegDate(rs.getDate("regdate"));
				contentDTO.setPrice(rs.getInt("price"));
				contentDTO.setContent(rs.getString("content"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(contentDTO);
		System.out.println("---"+contentDTO+"---");
		return contentDTO;
	}
	// 총 페이지수 구하기
	public int totalRows() {
		int result = -1;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "SELECT count(no) FROM secondhand";
		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 검색 키워드 결과 수
	public int searchTotalRows(String keyword) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = 	"SELECT count(no)" + 
						"FROM secondhand" + 
						"WHERE title LIKE '%'||'?'||'%'";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, keyword);
			rs = pstmt.executeQuery(query);
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 조회수 증가
	public void viewCount(int no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = 	"UPDATE secondhand" + 
						" SET views=views+1" + 
						" where no=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// 게시글 삭제
	public int delete(int no) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query= "delete from secondhand where no=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 게시글 수정
	public int update(String query, SecondHandDTO dto) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 파일포함 게시글수정
	public int update2(String query, SecondHandDTO dto) {
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		System.out.println("update2"+dto);
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getTitle());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setString(3, dto.getFileName());
			pstmt.setString(4, dto.getRefileName());
			pstmt.setInt(5, dto.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	// 내용수정
	public void contentUpdate(SecondHandContentDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = 	"update secondhand_data" + 
						" set content=?" + 
						" where no=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getContent());
			pstmt.setInt(2, dto.getNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
