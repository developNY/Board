package Dto;

public class Dto {
	int bId;
	String name;
	String title;
	String content;

	public Dto(int bId, String name, String title, String content) {
		super();
		this.bId = bId;
		this.name = name;
		this.title = title;
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}	
