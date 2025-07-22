package com.example.salonmanager.service.comment;

import com.example.salonmanager.entity.Comment;
import com.example.salonmanager.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;

    @Override
    public List<Comment> getCommentsByEmployee(Integer employeeId) {
        return commentRepo.findAll().stream()
                .filter(c -> c.getEmployee().getId().equals(employeeId))
                .toList();
    }

    @Override
    public Comment addComment(Comment comment) {
        return commentRepo.save(comment);
    }
}