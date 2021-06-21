package controller.goods;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import model.DAO.GoodsDAO;
import model.DTO.ProductDTO;

public class GoodsDeletePage {
	public void prodDelete(HttpServletRequest request) {
		String prodNum = request.getParameter("prodNum");
		GoodsDAO dao = new GoodsDAO();
		ProductDTO dto = dao.GoodsOne(prodNum);
		
		//파일패스 먼저 지정_기니까
		String filePath = "goods/upload";
		String realpath = request.getServletContext().getRealPath(filePath);
		
		//파일이 여러개 있을 수 있기 때문에 split사용
		String [] fileNames = dto.getProdImage().split(",");
		if(fileNames.length > 0) {
			for(String fileName : fileNames) {
				String path = realpath + "/" + fileName; //파일 삭제 할 때 = 경로 + 파일이름
				File f = new File(path); //io로 임포트
				if(f.exists()) f.delete();//파일(f)이 있다면 파일을 삭제해라
			}
		}
		dao.prodDel(prodNum);
	}
}
