package LoginTask.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Joiner-list")
public class ConvertJoinerList {

	@XmlElement(name="joiner")
	private List<ConvertJoiner> joinerList;

	public ConvertJoinerList() {
		
	}
	
	public ConvertJoinerList(List<ConvertJoiner> joinerList) {
		this.joinerList = joinerList;
	}
	
	public List<ConvertJoiner> getJoinerList() {
		return joinerList;
	}

	public void setJoinerList(List<ConvertJoiner> joinerList) {
		this.joinerList = joinerList;
	}

}
