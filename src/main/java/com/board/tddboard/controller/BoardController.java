package com.board.tddboard.controller;

import com.board.tddboard.domain.Board;
import com.board.tddboard.dto.BoardDto;
import com.board.tddboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("boards")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("")
    public String create(@Valid BoardDto.CreateDto createDto) {
        Board newBoard = createDto.toBoard();

        boardService.save(newBoard);

        return "redirect:/boards";
    }

    @GetMapping("")
    public String getList(Model model) {
        List<Board> boardList = boardService.getList();

        model.addAttribute("list", boardList);

        return "list";
    }

    @GetMapping("/{id}")
    public String getDetail(Model model, @PathVariable("id") Long id) {
        Board board = boardService.getDetail(id);

        model.addAttribute("board", board);

        return "detail";
    }

    @GetMapping("register-form")
    public String getRegisterForm() {
        return "registerForm";
    }

}