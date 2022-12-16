package petcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(){
		return "home";
	}
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
//	@PostMapping("/member/login")
//	public String logi() {
//		return "redirect:/home";
//	}
	@GetMapping("/member/join")
	public String join() {
		return "/member/joinForm";
	}
	@GetMapping("/member/userJoin")
	public String userJoin() {
		return "/member/join";
	}
	@GetMapping("/member/doctorJoin")
	public String doctorJoin() {
		return "/member/doctorJoin";
	}
	@GetMapping("/member/adminJoin")
	public String joinAdmin() {
		return "/member/adminJoin";
	}
}
