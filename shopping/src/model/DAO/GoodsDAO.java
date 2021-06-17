package model.DAO;

import java.sql.SQLException;

import model.DTO.ProductDTO;

public class GoodsDAO extends DataBaseInfo{
	
	public void prodInsert(ProductDTO dto) {
		final String COLUMNS = "PROD_NUM, PROD_NAME, PROD_PRICE, PROD_IMAGE, "
				+ "PROD_DETAIL, PROD_CAPACITY, PROD_SUPPLYER,"
				+ "PROD_DEL_FEE, RECOMMEND, EMPLOYEE_ID, CTGR";
		sql = "insert into products ( "+ COLUMNS + ") values(?,?,?,?,?,?,?,?,?,?,?)";
		getConnect();
		try {
			pstmt=conn.prepareStatement(sql); //sql값을 날려줌
			pstmt.setString(1, dto.getProdNum()); //앞의 번호는 쿼리문에 대한 ?의 순서
			pstmt.setString(2, dto.getProdName());
			pstmt.setInt(3, dto.getProdPrice());
			pstmt.setString(4, dto.getProdImage());
			pstmt.setString(5, dto.getProdDetail());
			pstmt.setString(6, dto.getProdCapasity());
			pstmt.setString(7, dto.getProdSupplyer());
			pstmt.setString(8, dto.getProdDelFee());
			pstmt.setString(9, dto.getRecommend());
			pstmt.setString(10, dto.getEmployeeId());
			pstmt.setString(11, dto.getCtgr());
			int i = pstmt.executeUpdate();
			System.out.println(i +"개가 입력되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public String goodsNum() {
		//SQL에 create SEQUENCE prod_seq START WITH 100000; 입력 및 생성
		String prodNum = null;
		sql = "select prod_seq.nextval from dual";
		getConnect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			prodNum = rs.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return prodNum;
	}
}
