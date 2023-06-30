package com.example.controller;

import com.example.model.URLMapping;
import com.example.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Random;

@Controller
public class URLShortenerController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private URLRepository urlRepository;

    @PostMapping("/shorten")
    public String shortenURL(@RequestParam("url") String originalURL, Model model) {
        String shortURL = generateShortURL();
        redisTemplate.opsForValue().set(shortURL, originalURL);
        urlRepository.save(new URLMapping(shortURL, originalURL));
        model.addAttribute("shortURL", shortURL);
        return "index";
    }


    @GetMapping("/{shortURL}")
    public RedirectView redirect(@PathVariable String shortURL) {
        String originalURL = redisTemplate.opsForValue().get(shortURL);
        if (originalURL != null) {
            return new RedirectView(originalURL);
        }
        // Caso a URL encurtada não seja encontrada, redirecionar de volta para a página inicial
        return new RedirectView("/");
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }



    private String generateShortURL() {
        // Lógica para gerar uma sequência curta de caracteres para a URL encurtada
        // Pode ser implementada usando algoritmos como Base64 ou hashing
        // Neste exemplo, vamos gerar uma sequência aleatória de 6 caracteres alfanuméricos
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }
}

