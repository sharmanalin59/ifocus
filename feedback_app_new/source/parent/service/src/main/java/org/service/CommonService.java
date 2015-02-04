package org.service;
/**
 * @author : nalin sharma
 *
 */
import java.util.List;

import org.dtos.FeedbackAppraisalDTO;
import org.dtos.UsersBasicDetailsDTO;

public interface CommonService {
  public FeedbackAppraisalDTO getFeedBackAppraisal(Integer frequencyType,Integer appraisalType,Integer userId);
  public FeedbackAppraisalDTO getFeedBackAppraisalValue(Integer feedbackFrequencyType,Integer appraisalFrequencyType,Integer groupId);
  public List<UsersBasicDetailsDTO> getUsers(Integer roleId);
  public List<UsersBasicDetailsDTO> getUsers();
  public UsersBasicDetailsDTO getUser(Integer userId);
}
