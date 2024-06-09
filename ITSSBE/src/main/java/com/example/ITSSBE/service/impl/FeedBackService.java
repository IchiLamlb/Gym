package com.example.ITSSBE.service.impl;

import com.example.ITSSBE.converter.FeedBackConverter;
import com.example.ITSSBE.dto.FeedBackDTO;
import com.example.ITSSBE.entity.FeedBack;
import com.example.ITSSBE.entity.User;
import com.example.ITSSBE.repository.*;
import com.example.ITSSBE.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class FeedBackService implements IFeedbackService {
    @Autowired
    private IFeedBackRepo feedBackRepo;
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private FeedBackConverter feedBackConverter;

    public List<FeedBackDTO> getAllFeedBack() {
        List<FeedBack> feedBacks = feedBackRepo.findAll();
        return feedBacks.stream().map(feedBack -> feedBackConverter.toDTO(feedBack)).collect(Collectors.toList());

    }
    public FeedBackDTO getFeedBack(int id) {
        return feedBackConverter.toDTO(feedBackRepo.findById(id));

    }
    public List<FeedBackDTO> getFromUser(User user) {
        List<FeedBack> feedBacks = feedBackRepo.findByUser(user.getId());
        return feedBacks.stream().map(feedBack -> feedBackConverter.toDTO(feedBack)).collect(Collectors.toList());

    }
    public FeedBackDTO addFeedBack(FeedBackDTO feedBackDTO) {
        User user = userRepo.findFirstById(feedBackDTO.getUser_id());
        FeedBack feedBack = feedBackConverter.toEntity( feedBackDTO, user);
        FeedBack savedFeedBack = feedBackRepo.save(feedBack);
        return feedBackConverter.toDTO(savedFeedBack);
    }
    public FeedBackDTO changeFeedBack(FeedBackDTO feedBackDTO, int id) {
        FeedBack feedBack = feedBackRepo.findById(id);
        feedBack.setContent(feedBack.getContent());
        feedBack.setCreated_at(feedBack.getCreated_at());
        FeedBack savedFeedBack = feedBackRepo.save(feedBack);
        return feedBackConverter.toDTO(savedFeedBack);
    }
    public FeedBackDTO deleteFeedBack(int id) {
        FeedBack feedBack = feedBackRepo.findById(id);
        feedBack.set_deleted(true);
        FeedBack savedFeedBack = feedBackRepo.save(feedBack);
        return feedBackConverter.toDTO(savedFeedBack);
    }
}
