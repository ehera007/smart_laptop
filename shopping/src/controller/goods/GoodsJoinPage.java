package controller.goods;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.DAO.GoodsDAO;
import model.DTO.AuthInfo;
import model.DTO.ProductDTO;

public class GoodsJoinPage {
	public void goodsJoin(HttpServletRequest request) {
		String filePath = "goods/upload"; //파일 업로드할 경로
		String realPath = request.getServletContext().getRealPath(filePath);
		System.out.println(realPath);
		int fileSize = 1024*1024*5; //파일크기 설정 저장
		MultipartRequest multi = null;
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String emp_no = authInfo.getGrade();
		String storeFileName1;
		String storeFileName2;
		String storeFileName3;
		String images="";
		try {//파일이 없을 때를 대비해 트라이캐치 사용
			multi = new MultipartRequest(request, realPath, fileSize, "utf-8", new DefaultFileRenamePolicy());
			storeFileName1 = multi.getFilesystemName("prodImage1");
			storeFileName2 = multi.getFilesystemName("prodImage2");
			storeFileName3 = multi.getFilesystemName("prodImage3");
			images = storeFileName1+","+storeFileName2+","+storeFileName3;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ProductDTO dto = new ProductDTO();
		dto.setEmployeeId(emp_no);
		dto.setProdCapasity(multi.getParameter("prodCapasity"));
		dto.setProdDelFee(multi.getParameter("prodDelFee"));
		dto.setProdDetail(multi.getParameter("prodDetail"));
		dto.setProdImage(images);
		dto.setProdName(multi.getParameter("prodName"));
		dto.setProdNum(multi.getParameter("goodsNum"));
		dto.setProdPrice(Integer.parseInt(multi.getParameter("prodPrice")));
		dto.setProdSupplyer(multi.getParameter("prodSupplyer"));
		dto.setRecommend(multi.getParameter("recommend"));
		dto.setCtgr(multi.getParameter("ctgr"));
		GoodsDAO dao = new GoodsDAO();
		dao.prodInsert(dto);
		
		
	}
}
