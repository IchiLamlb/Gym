package com.example.ITSSBE.service;

import com.example.ITSSBE.dto.FeedBackDTO;
import com.example.ITSSBE.entity.FeedBack;
import com.example.ITSSBE.entity.User;

import java.util.List;

public interface IFeedbackService {
    List<FeedBackDTO> getAllFeedBack();
    FeedBackDTO getFeedBack( int id);
    List<FeedBackDTO> getFromUser(User user);
    FeedBackDTO addFeedBack(FeedBackDTO feedBackDTO);
    FeedBackDTO changeFeedBack( FeedBackDTO feedBackDTO, int id);
    FeedBackDTO deleteFeedBack( int id);
}
