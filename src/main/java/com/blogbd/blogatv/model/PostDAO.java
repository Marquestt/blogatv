package com.blogbd.blogatv.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PostDAO {
    @Autowired
    DataSource dataSource;

        JdbcTemplate jdbc;

        @PostConstruct
        private void Initialize() {
            jdbc = new JdbcTemplate(dataSource);
        }

    public void publicarPost(Post post) {
        String sql = "INSERT INTO Post(titulo, conteudo) VALUES (?, ?)";
        Object[] obj = new Object[2];
        obj[0] = post.getTitulo();
        obj[1] = post.getConteudo();
        jdbc.update(sql, obj);
    }

    public List<Map<String, Object>> listarPosts() {
        String sql = "SELECT * FROM Post";
        return jdbc.queryForList(sql);
    }

    public Post mostrarPost(int id) {
        String sql = "SELECT * FROM Post WHERE id = ?";
        return jdbc.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getInt("id"));
            post.setTitulo(rs.getString("titulo"));
            post.setConteudo(rs.getString("conteudo"));
            return post;
        });
    }

    public void excluirPost(int id) {
        String sql = "DELETE FROM Post WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void atualizarPost(Post post) {
        String sql = "UPDATE Post SET titulo = ?, conteudo = ? WHERE id = ?";
        jdbc.update(sql, post.getTitulo(), post.getConteudo(), post.getId());
    }

}
