package escreviews.data;

import java.sql.Timestamp;

public class EscReviewsDto {
	private String reviewcode;
	private String memcode;
	private String roomcode;
	private String score;
	private String comment;
	private Timestamp writeday;

	public String getReviewcode() {
		return reviewcode;
	}

	public void setReviewcode(String reviewcode) {
		this.reviewcode = reviewcode;
	}

	public String getMemcode() {
		return memcode;
	}

	public void setMemcode(String memcode) {
		this.memcode = memcode;
	}

	public String getRoomcode() {
		return roomcode;
	}

	public void setRoomcode(String roomcode) {
		this.roomcode = roomcode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getWriteday() {
		return writeday;
	}

	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}

}
