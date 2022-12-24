package hello.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.config.auth.PrincipalUser;
import hello.model.BoardCounsel;
import hello.service.BoardCounselService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	@Autowired
	private BoardCounselService bcservice;

	// 전문의 찾기
	@GetMapping("boardDocSearch")
	public String boardDocSearch() {
		return "/board/boardDocSearch";
	}

	// 지도 API
	@GetMapping("docMaps")
	public String docMap() {
		return "/board/docMaps";
	}

//////////////////////////////////////////////////////////////////////////////////////
	// 전문의상담게시판 페이징 검색 전체보기
	@GetMapping("boardCounsel")
	public String boardCounsel(Model model,
			@PageableDefault(size = 5, sort = "counselID", direction = Direction.DESC) Pageable pageable,
			@RequestParam(required = false, defaultValue = "") String field,
			@RequestParam(required = false, defaultValue = "") String word) {
		Page<BoardCounsel> lists = bcservice.findAll(field, word, pageable);
		Long count = bcservice.count(field, word);
		model.addAttribute("count", count);
		model.addAttribute("clists", lists);
		return "/board/boardCounsel";
	}

	// 전문의상담게시판 상세보기
	@GetMapping("boardCounselview/{counselID}")
	public String bcview(@PathVariable Long counselID, Model model) {
		model.addAttribute("board", bcservice.findById(counselID));
		return "/board/boardCounselview";
	}

	// 전문의 상담게시판 글쓰기폼
	@GetMapping("boardCounselinsert")
	@PreAuthorize("isAuthenticated()")
	public String bcinsert() {
		return "/board/boardCounselinsert";
	}

	// 전문의 상담게시판 글쓰기
	@PostMapping("boardCounselinsert")
	public String bcinsert(BoardCounsel board, @AuthenticationPrincipal PrincipalUser principal, HttpSession session) {
		String uploadFolder = session.getServletContext().getRealPath("/") + "\\resources\\img";
		bcservice.boardCounselinsert(board, principal.getUser(), uploadFolder);
		return "redirect:boardCounsel";
	}

	// 전문의 상담게시판 수정폼
	@GetMapping("boardCounselupdate/{counselID}")
	public String bcupdate(@PathVariable Long counselID, Model model) {
		model.addAttribute("board", bcservice.detail(counselID));
		return "board/boardCounselupdate";
	}

	// 전문의 상담게시판 수정하기
	@PutMapping("boardCounselupdate")
	@ResponseBody
	public String bcupdate(@RequestBody BoardCounsel csboard, HttpSession session) {
		String uploadFolder = session.getServletContext().getRealPath("/") + "\\resources\\img";
		bcservice.bcupdate(csboard, uploadFolder);
		return "success";
	}

	// 전문의 상담게시판 게시글삭제
	@DeleteMapping("bcdelete/{counselID}")
	@ResponseBody
	public String bcdelete(@PathVariable Long counselID) {
		bcservice.bcdelete(counselID);
		return "success";
	}

//	// 전문의 상담게시판 댓글전체보기
//	@GetMapping("/reply/list/{counselID}")
//	public List<CommentCounsel> list(Long counselID) {
//		// System.out.println("num:"+num);
//		List<CommentCounsel> clist = commentservice.list(counselID);
//		return clist;
//	}
	/*
	 * //인증된 회원만 게시글 작성하기
	 * 
	 * @GetMapping("boardCounselinsert")
	 * 
	 * @PreAuthorize("isAuthenticated()") public String insert() { return
	 * "/board/boardCounselinsert"; }
	 * 
	 * @PostMapping("boardCounselinsert") public String insert(BoardCounsel board,
	 * 
	 * @AuthenticationPrincipal PrincipalUser principal) { bcservice.insert(board,
	 * principal.getUser()); return "redirect:boardCounselinsert"; }
	 */

}