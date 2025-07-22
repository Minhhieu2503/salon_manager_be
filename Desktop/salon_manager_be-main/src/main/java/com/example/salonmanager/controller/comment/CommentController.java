package com.example.salonmanager.controller.comment;

import com.example.salonmanager.entity.Comment;
import com.example.salonmanager.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/employee/{employeeId}")
    public List<Comment> getCommentsByEmployee(@PathVariable Integer employeeId) {
        return commentService.getCommentsByEmployee(employeeId);
    }

    @PostMapping("/")
    public Comment addComment(@RequestBody Comment comment) {
        comment.setCreatedAt(LocalDateTime.now());
        return commentService.addComment(comment);
    }
}