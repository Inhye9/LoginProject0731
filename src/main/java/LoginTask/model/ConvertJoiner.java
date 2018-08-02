package LoginTask.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import org.springframework.web.multipart.MultipartFile;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "id", "pwd", "name", "birth", "gender", "email", "phone", "photo" })
public class ConvertJoiner {

	private String pwd;
	private String name;
	private String birth;
	private String gender;
	private String email;
	private int phone;
	private String photo; // DB에 입력하기 위한 변수

	public ConvertJoiner() {

	}
	
	public ConvertJoiner(String id, String pwd, String name, String birth, String gender, String email, int phone,
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

	private String id;
	
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
	
	public String getBirth() {
		return birth;
	}
	
	public void setBirth(String birth) {
		this.birth = birth;
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
		return "JoinerXml [pwd=" + pwd + ", name=" + name + ", birth=" + birth + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", photo=" + photo + ", id=" + id + "]";
	}
	
	
	

}
