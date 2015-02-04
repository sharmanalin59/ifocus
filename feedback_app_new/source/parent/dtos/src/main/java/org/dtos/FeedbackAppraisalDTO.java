package org.dtos;
/**
 * @author nalin.sharma
 */
public class FeedbackAppraisalDTO {

	private Integer feedbackFrequency;
	private Integer appraisalFrequency;
	public Integer getFeedbackFrequency() {
		return feedbackFrequency;
	}
	public void setFeedbackFrequency(Integer feedbackFrequency) {
		this.feedbackFrequency = feedbackFrequency;
	}
	public Integer getAppraisalFrequency() {
		return appraisalFrequency;
	}
	public void setAppraisalFrequency(Integer appraisalFrequency) {
		this.appraisalFrequency = appraisalFrequency;
	}
	@Override
	public String toString() {
		return "FeedbackAppraisalDTO [feedbackFrequency=" + feedbackFrequency
				+ ", appraisalFrequency=" + appraisalFrequency + "]";
	}
	
}
