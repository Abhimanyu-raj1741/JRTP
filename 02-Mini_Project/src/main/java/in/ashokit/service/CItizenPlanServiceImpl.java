package in.ashokit.service;

import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font.*;

import in.ashokit.Binding.SearchCriteria;
import in.ashokit.entity.CitizenPlan;
import in.ashokit.repo.CitizenPlanRepo;
import in.ashokit.utils.EmailUtils;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CItizenPlanServiceImpl implements CitizenPlanService{
	
	@Autowired
	private CitizenPlanRepo repo;
	
	@Autowired
	private EmailUtils emailUtils;

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
		     // to send file in email attachment
		     File f = new File("data.xls");
		     FileOutputStream  fos = new FileOutputStream(f);
		     workbook.write(fos);
		     emailUtils.sendEmail(f);
		     
		     
	         ServletOutputStream outputStream =  response.getOutputStream();
	         workbook.write(outputStream);
	         workbook.close();
	         outputStream.close();
	         
	      

	}
	
	
	
	@Override
	public void generatePdf(HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
	
		
		
		
		
		Document pdfDoc1 = new Document(PageSize.A4); // browser
		Document pdfDoc2 = new Document(PageSize.A4);  // attachment
		
		
		ServletOutputStream outputStream = response.getOutputStream();
		PdfWriter.getInstance(pdfDoc1, outputStream);
		pdfDoc1.open();
		
		File f = new File("Report.pdf");
		FileOutputStream fos = new FileOutputStream(f);
		PdfWriter.getInstance(pdfDoc2, fos);
		
		pdfDoc2.open();
		
		com.lowagie.text.Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
	    fontTiltle.setSize(20);
		Paragraph p = new Paragraph("Citizen Plans Info",fontTiltle);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		pdfDoc1.add(p);
		pdfDoc2.add(p);
		
		  PdfPTable table = new PdfPTable(6);
		  table.setWidthPercentage(100);
		   table.setWidths(new int[] {3,3,3,3,3,3});
		   table.setSpacingBefore(5);
		    
		    PdfPCell cell = new PdfPCell();
		    // Setting the background color and padding of the table cell
		    cell.setBackgroundColor(CMYKColor.BLUE);
		    cell.setPadding(5);
		    
		    com.lowagie.text.Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		    font.setColor(CMYKColor.WHITE);
		    
		    cell.setPhrase(new Phrase("Name", font));
		    table.addCell(cell);
		    
		    cell.setPhrase(new Phrase("Email", font));
		    table.addCell(cell);
		    
		    cell.setPhrase(new Phrase("Gender", font));
		    table.addCell(cell);
		    
		    cell.setPhrase(new Phrase("SSN", font));
		    table.addCell(cell);
		    
		    cell.setPhrase(new Phrase("Plan Name", font));
		    table.addCell(cell);
		    
		    cell.setPhrase(new Phrase("Plan Status", font));
		    table.addCell(cell);
		    
		    List<CitizenPlan> records = repo.findAll();
		    
		    for(CitizenPlan record:records)
		    {
		    	table.addCell(record.getName());
		    	table.addCell(record.getEmail());
		    	table.addCell(record.getGender());
		        table.addCell(String.valueOf(record.getSsn()));
		    	table.addCell(record.getPlanName());
		    	table.addCell(record.getPlanStatus());
		    }
		
		pdfDoc1.add(table);
		pdfDoc2.add(table);
		

		emailUtils.sendEmail(f);
		pdfDoc2.close();
		fos.close();
		pdfDoc1.close();
		outputStream.close();
		
	}
}
