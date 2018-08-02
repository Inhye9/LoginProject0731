package LoginTask.convertView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import LoginTask.model.Joiner;

public class joinerListXmlView extends AbstractExcelView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//1. Sheet를 생성
		HSSFSheet sheet = createFirstSheet(workbook);
		//2. Sheet 행의 라벨 작성
		createColumnLabel(sheet);
		
		List<Joiner> joinerList = (List<Joiner>)model.get("joinerList");
		
		//3.셀에 데이터 넣기 
		int rowNum = 1;
		for(Joiner joiner: joinerList) {
			createJoinerRow(sheet, joiner, rowNum++);
		}
		
	}

	private void createJoinerRow(HSSFSheet sheet, Joiner joiner, int rowNum) {
		//rowNum번째 줄 생성
		HSSFRow row = sheet.createRow(rowNum);
		
		//rowNum번째 줄의 첫번째 칸에 데이터 넣기 
		HSSFCell cell = row.createCell(0);
		cell.setCellValue(joiner.getId());
		
		cell = row.createCell(1);
		cell.setCellValue(joiner.getPwd());
		
		cell = row.createCell(2);
		cell.setCellValue(joiner.getName());
		
		cell = row.createCell(3);
		cell.setCellValue(joiner.getBirth());
		
		cell = row.createCell(4);
		cell.setCellValue(joiner.getGender());
		
		cell = row.createCell(5);
		cell.setCellValue(joiner.getEmail());
		
		cell = row.createCell(6);
		cell.setCellValue(joiner.getPhone());
		
		cell = row.createCell(7);
		cell.setCellValue(joiner.getPhoto());
		
	}

	private void createColumnLabel(HSSFSheet sheet) {
		//첫번째 줄 생성
		HSSFRow firstRow = sheet.createRow(0);
	
		//첫번째 줄의 첫번째 칸의 생성 및 이름 지정 
		HSSFCell cell = firstRow.createCell(0);
		cell.setCellValue("ID");
		
		cell = firstRow.createCell(1);
		cell.setCellValue("비밀번호");
		
		cell = firstRow.createCell(2);
		cell.setCellValue("이름");
		
		cell = firstRow.createCell(3);
		cell.setCellValue("생년월일");
		
		cell = firstRow.createCell(4);
		cell.setCellValue("성별");
		
		cell = firstRow.createCell(5);
		cell.setCellValue("Email");
		
		cell = firstRow.createCell(6);
		cell.setCellValue("핸드폰 번호");
		
		cell = firstRow.createCell(7);
		cell.setCellValue("사진");
		
		
		
		
	}

	private HSSFSheet createFirstSheet(HSSFWorkbook workbook) {
		
		HSSFSheet sheet = workbook.createSheet();
		workbook.setSheetName(0, "회원 리스트");
		sheet.setColumnWidth(1, 256*20);
		return sheet;
	}

}
