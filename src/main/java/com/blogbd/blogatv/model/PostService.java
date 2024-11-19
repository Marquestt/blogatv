<<<<<<< HEAD
package com.blogbd.blogatv.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    public void publicarPost(Post post) {
        postDAO.publicarPost(post);
    }

    public List<Map<String, Object>> listarPosts() {
        return postDAO.listarPosts();
    }

    public void excluirPost(int id) {
        postDAO.excluirPost(id);
    }

    public void atualizarPost(Post post) {
        postDAO.atualizarPost(post);
    }

    public Post mostrarPost(int id) {
        return postDAO.mostrarPost(id);
    }

}
=======
package com.blogbd.blogatv.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    PostDAO postDAO;

    public void publicarPost(Post post) {
        postDAO.publicarPost(post);
    }

    public List<Map<String, Object>> listarPosts() {
        return postDAO.listarPosts();
    }

    public void excluirPost(int id) {
        postDAO.excluirPost(id);
    }

    public void atualizarPost(Post post) {
        postDAO.atualizarPost(post);
    }

    public Post mostrarPost(int id) {
        return postDAO.mostrarPost(id);
    }

}
>>>>>>> 535d9ebea6059fcf3778d8a47e91d052330501e7
