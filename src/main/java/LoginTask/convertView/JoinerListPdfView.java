package LoginTask.convertView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import LoginTask.model.Joiner;

public class JoinerListPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Joiner> joinerList = (List<Joiner>) model.get("joinerList");
		
		//Table 생성
		Table table = new Table(8, joinerList.size()+1);
		table.setPadding(5);
		
		//Font 지정
		 BaseFont bf = BaseFont.createFont("c:\\windows\\fonts\\batang.ttc,0", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	     Font font = new Font(bf);
	     
	     //첫번째 Cell 생성 및 테이블에 추가: 제목1
	     Cell cell = new Cell(new Paragraph("ID", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("비밀번호", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("이름", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("생년월일", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("성별", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("Email", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("핸드폰 번호", font));
	     cell.setHeader(true);
	     table.addCell(cell);
	     
	     cell = new Cell(new Paragraph("사진", font));
	     table.addCell(cell);
	     table.endHeaders();
	     
	     for(Joiner joiner: joinerList) {
	    	 table.addCell(joiner.getId());
	    	 table.addCell(joiner.getPwd());
	    	 table.addCell(new Paragraph(joiner.getName(), font));
	    	 table.addCell(joiner.getBirth());
	    	 table.addCell(joiner.getGender());
	    	 table.addCell(joiner.getEmail());
	    	 table.addCell(Integer.toString(joiner.getPhone()));
	    	 table.addCell(joiner.getPhoto());
	    	 
	    	 System.out.println(joiner.getName());
	     }
	     
	     document.add(table);
		
	}

}
