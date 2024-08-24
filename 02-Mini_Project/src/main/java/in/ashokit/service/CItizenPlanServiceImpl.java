package in.ashokit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.Binding.SearchCriteria;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepo;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CItizenPlanServiceImpl implements CitizenPlanService{
	
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public List<String> getPlanNames() {
		return repo.getPlanNames();
	}
	
	@Override
	public List<String> getPlanStatus() {
		
		return repo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> searchCitizens(SearchCriteria criteria) {
		// TODO Auto-generated method stub
		 CitizenPlan entity = new CitizenPlan();
//		if(null != criteria.getPlanName() &&  !"".equals(criteria.getPlanName())) {
//			entity.setPlanName(criteria.getPlanName());
//		}
//		 
		 
		 // WE are filtering the data by using QBE and entity 
		 if(StringUtils.isNotBlank(criteria.getPlanName())) {
			 entity.setPlanName(criteria.getPlanName());
		 }
		 if(StringUtils.isNotBlank(criteria.getPlanStatus())) {
			 entity.setPlanStatus(criteria.getPlanStatus());
		 }
		 if(StringUtils.isNotBlank(criteria.getGender())) {
			 entity.setGender(criteria.getGender());
		 }
		 if(null!=criteria.getPlanStartDate())
		 {
			 entity.setPlanStartDate(criteria.getPlanStartDate());
		 }
		 if(criteria.getPlanEndDate()!=null)
		 {
			 entity.setPlanEndDate(criteria.getPlanEndDate());
		 }
		 // QBE
		 Example<CitizenPlan> of = Example.of(entity);
		 
		return repo.findAll(of);
	}
	
	@Override
	public void generateExcel(HttpServletResponse response) throws Exception{
		// TODO Auto-generated method stub
		
		List<CitizenPlan> records = repo.findAll();
		
		HSSFWorkbook workbook  = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Data");
		HSSFRow headerRow = sheet.createRow(0) ;
		
        // set data for Header row cells
		
		headerRow.createCell(0).setCellValue("Name");
		headerRow.createCell(1).setCellValue("Email");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(5).setCellValue("SSN");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		
		int rowIndex =1;
		for(CitizenPlan record :records) {
			HSSFRow dataRow = sheet.createRow(rowIndex);
			dataRow.createCell(0).setCellValue(record.getName());
			dataRow.createCell(1).setCellValue(record.getEmail());
			dataRow.createCell(2).setCellValue(record.getGender());
			dataRow.createCell(3).setCellValue(record.getSsn());
			dataRow.createCell(4).setCellValue(record.getPlanName());
			dataRow.createCell(5).setCellValue(record.getPlanStatus());
			rowIndex++;
		}
	         ServletOutputStream outputStream =  response.getOutputStream();
	         workbook.write(outputStream);
	         workbook.close();
	         outputStream.close();
	         
	      

	}
	
	@Override
	public void generatePdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<CitizenPlan> records = repo.findAll();
		Document pdfDoc = new Document(PageSize.A4);
		ServletOutputStream outputStream = response.getOutputStream();
		PdfWriter.getInstance(pdfDoc, outputStream);
		pdfDoc.open();
		Paragraph p = new Paragraph("Citizen Plans Info");
		pdfDoc.add(p);
		
		pdfDoc.close();
		outputStream.close();
	}
}
