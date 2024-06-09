package com.example.ITSSBE.converter;

import com.example.ITSSBE.dto.FeedBackDTO;
import com.example.ITSSBE.entity.FeedBack;
import com.example.ITSSBE.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedBackConverter {
    @Autowired
    private ModelMapper modelMapper;
    public FeedBackDTO toDTO(FeedBack feedback){
        FeedBackDTO feedBackDTO = modelMapper.map(feedback, FeedBackDTO.class);
        feedBackDTO.setUser_id(feedback.getBy_user().getId());
        return feedBackDTO;
    }

    public FeedBack toEntity(FeedBackDTO feedBackDTO, User user) {
        FeedBack feedBack = modelMapper.map(feedBackDTO, FeedBack.class);
        feedBack.setBy_user(user);
        return feedBack;
    }
}
