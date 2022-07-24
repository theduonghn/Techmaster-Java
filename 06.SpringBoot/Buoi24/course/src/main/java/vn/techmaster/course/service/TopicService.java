package vn.techmaster.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.course.repository.TopicRepository;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
}
