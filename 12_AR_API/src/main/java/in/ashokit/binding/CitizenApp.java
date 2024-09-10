package in.ashokit.binding;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class CitizenApp {
   
   private Integer caseNum;
	
	private String citizenName;
	
	private String citizenEmail;
	
	private Long citizenPhno;
	
	private String CitizenGender;
	
	private LocalDate CitizenDob;
	
	private Long citizenSsn;
	
	private LocalDate createdDate;
	
	private LocalDate updateDate;
	
	private Integer createdBy;

	public Integer getCaseNum() {
		return caseNum;
	}

	public void setCaseNum(Integer caseNum) {
		this.caseNum = caseNum;
	}

	public String getCitizenName() {
		return citizenName;
	}

	public void setCitizenName(String citizenName) {
		this.citizenName = citizenName;
	}

	public String getCitizenEmail() {
		return citizenEmail;
	}

	public void setCitizenEmail(String citizenEmail) {
		this.citizenEmail = citizenEmail;
	}

	public Long getCitizenPhno() {
		return citizenPhno;
	}

	public void setCitizenPhno(Long citizenPhno) {
		this.citizenPhno = citizenPhno;
	}

	public String getCitizenGender() {
		return CitizenGender;
	}

	public void setCitizenGender(String citizenGender) {
		CitizenGender = citizenGender;
	}

	public LocalDate getCitizenDob() {
		return CitizenDob;
	}

	public void setCitizenDob(LocalDate citizenDob) {
		CitizenDob = citizenDob;
	}

	public Long getCitizenSsn() {
		return citizenSsn;
	}

	public void setCitizenSsn(Long citizenSsn) {
		this.citizenSsn = citizenSsn;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
