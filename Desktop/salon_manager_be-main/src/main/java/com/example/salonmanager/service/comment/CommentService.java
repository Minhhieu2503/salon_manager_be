package com.example.salonmanager.service.comment;

import com.example.salonmanager.entity.Comment;
import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByEmployee(Integer employeeId);
    Comment addComment(Comment comment);
}