package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import operation.CreateStringRandom;

public class History {
	private String time;
	private String username;
	private String id;
	private String no;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(String time, String username, String id) {
		super();
		this.time = time;
		this.username = username;
		this.id = id;
		this.no = CreateStringRandom.getRandomString(15);
	}

	public History(String time, String username, String id, String no) {
		super();
		this.time = time;
		this.username = username;
		this.id = id;
		this.no = no;
	}

	public String getTime() {
		return time;
	}

	public String getNo() {
		return no;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setTime() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		this.time = simpleDateFormat.format(new Date());
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "History [time=" + time + ", username=" + username + ", id=" + id + ", no=" + no + "]";
	}

}
