package LoginTask.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Joiner-list")
public class JoinerList {

	@XmlElement(name="joiner")
	private List<Joiner> joinerList;

	public JoinerList() {
		
	}
	
	public JoinerList(List<Joiner> joinerList) {
		this.joinerList = joinerList;
	}
	
	public List<Joiner> getJoinerList() {
		return joinerList;
	}

	public void setJoinerList(List<Joiner> joinerList) {
		this.joinerList = joinerList;
	}

}
