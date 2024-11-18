package com.blogbd.blogatv.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.blogbd.blogatv.model.Post;
import com.blogbd.blogatv.model.PostService;

@Controller
public class MainController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String main(Model model) {
        PostService ps = context.getBean(PostService.class);
        List<Map<String, Object>> lista = ps.listarPosts();
        model.addAttribute("posts", lista);
        return "main";
    }

    @GetMapping("/novo-post")
    public String postar(Model model) {
        model.addAttribute("post", new Post());
        return "novo-post";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        PostService ps = context.getBean(PostService.class);
        Post post = ps.mostrarPost(id);
        model.addAttribute("post", post);
        return "novo-post";
    }

    @PostMapping({"/postar", "/editar/{id}"})
    public String postarOuEditar(@ModelAttribute Post post, @PathVariable(required = false) Integer id) {
        PostService ps = context.getBean(PostService.class);

        if (id != 0) {
            post.setId(id);
            ps.atualizarPost(post);
        }
        else {
            ps.publicarPost(post);
        }
        return "redirect:/";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable int id) {
        PostService ps = context.getBean(PostService.class);
        ps.excluirPost(id);
        return "redirect:/";
    }

}
