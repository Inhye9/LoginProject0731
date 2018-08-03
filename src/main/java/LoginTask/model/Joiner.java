package LoginTask.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.springframework.web.multipart.MultipartFile;


public class Joiner {
	private String id;
	private String pwd; 
	private String name;
	private String birth_year;
	private String birth_mon;
	private String birth_day;
	private String birth;
	private String birth2;
	private String gender;
	private String email;
	private String confirm;
	private int phone;
	private String photo;	//DB에 입력하기 위한 변수
	private MultipartFile photoFile;  //파일 업로드 처리를 위한 변수
	
	public Joiner() {
		
	}
	
	
	public Joiner(String id, String pwd, String name, String birth, String gender, String email, int phone,
			String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
	}



	public Joiner(String id, String pwd, String name, String birth_year, String birth_mon, String birth_day,
			String gender, String email, int phone) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth_year = birth_year;
		this.birth_mon = birth_mon;
		this.birth_day = birth_day;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	

	public Joiner(String id, String pwd, String name, String birth_year, String birth_mon, String birth_day,
			String gender, String email, int phone, String photo) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.birth_year = birth_year;
		this.birth_mon = birth_mon;
		this.birth_day = birth_day;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.photo = photo;
		
		
	}
	
	
	
	public String getConfirm() {
		return confirm;
	}


	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}


	public String getBirth2() {
		String birth2 = birth_year +"-" + birth_mon +"-" + birth_day;
		return birth2;
	}


	public void setBirth2(String birth2) {
		this.birth2 = birth2;
	}


	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public MultipartFile getPhotoFile() {
		return photoFile;
	}

	public void setPhotoFile(MultipartFile photoFile) {
		this.photoFile = photoFile;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}

	public String getBirth_mon() {
		return birth_mon;
	}

	public void setBirth_mon(String birth_mon) {
		this.birth_mon = birth_mon;
	}

	public String getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(String birth_day) {
		this.birth_day = birth_day;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Joiner [id=" + id + ", pwd=" + pwd + ", name=" + name + ", birth_year=" + birth_year + ", birth_mon="
				+ birth_mon + ", birth_day=" + birth_day + ", gender=" + gender + ", email=" + email + ", phone="
				+ phone + ", photo=" + photo + "]";
	}

	
	
}
