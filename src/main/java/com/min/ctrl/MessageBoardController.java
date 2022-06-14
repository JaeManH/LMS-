package com.min.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.min.service.IMessageBoardService;
import com.min.vo.MessageBoardVo;

@Controller
public class MessageBoardController {

	@Autowired
	IMessageBoardService service;
	
	@RequestMapping(value = "/messendBoardSelectAll.do", method = RequestMethod.GET)
	public String mesBoardQSelectAll(@RequestParam(required = false) String mes_cate, Model model) {
		MessageBoardVo vo = new MessageBoardVo();
		System.out.println(mes_cate);
		if(mes_cate==null) {
			System.out.println(mes_cate);
			vo.setMes_cate("Q");
			vo.setMes_sender("ghkdwoaks1234");
			List<MessageBoardVo> lists = service.messendBoardSelectAll(vo);
			model.addAttribute("lists", lists);
			model.addAttribute("mes_cate", mes_cate);
		}else {
			vo.setMes_cate(mes_cate);
			vo.setMes_recipient("ghkdwoaks1234");
			vo.setMes_sender("ghkdwoaks1234");
			List<MessageBoardVo> lists = service.messendBoardSelectAll(vo);
			service.messendBoardSelectAll(vo);
			model.addAttribute("lists", lists);
			model.addAttribute("mes_cate", mes_cate);
		}
//		model.addAttribute("lists", lists);
//		model.addAttribute("mes_cate", mes_cate);
		return "admin/admin_messageBoardSelectAll";
	}
	
	@RequestMapping(value = "/messageSelectDetail.do", method = RequestMethod.GET)
	public String MessageSelectDetail(@RequestParam int mes_seq, Model model, HttpServletRequest req, HttpSession session) {
		String query_string = req.getQueryString();
		System.out.println(query_string);
		String num = query_string.substring(8);
		int seq = Integer.parseInt(num);
		MessageBoardVo result = service.mesBoardSelectDetail(seq);
		model.addAttribute("result", result);
		session.setAttribute("mes_recipient", result.getMes_recipient());
		session.setAttribute("mes_reffer", result.getMes_reffer());
		return "admin/admin_messageBoardSelectDetail";
	}
	
	@RequestMapping(value = "/messageBoardInsertForm.do", method = RequestMethod.GET)
	public String classVideoInsertForm() {
		return "admin/admin_messageBoardInsertForm";
	}
	
	@RequestMapping(value = "/mesBoardInsert.do", method = RequestMethod.POST)
	public String mesBoardInsert(@RequestParam Map<String, Object> map, @RequestParam String mes_recipient, @RequestParam String mes_content) {
		map.put("mes_sender", "ghkdwoaks1234");
		map.put("mes_recipient", mes_recipient);
		map.put("mes_content", mes_content);
		service.mesBoardInsert(map);
		return "redirect:/messendBoardSelectAll.do";
	}
	
	
	@RequestMapping(value = "/mesBoardDelete.do", method = RequestMethod.GET)
	public String mesBoardDelete(@RequestParam int mes_seq) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mes_seq", mes_seq);
		service.mesBoardDelete(map);
		return "redirect:/messendBoardSelectAll.do";
	}
	
	@RequestMapping(value = "/mesBoardReplyForm.do", method = RequestMethod.GET)
	public String mesBoardReplyForm(Model model, @SessionAttribute("mes_recipient") String mes_recipient,HttpSession session ,@SessionAttribute("mes_reffer") int mes_reffer) {
		model.addAttribute("mes_recipient", mes_recipient);
		session.setAttribute("mes_reffer", mes_reffer);
		return "admin/admin_messageBoardReplyForm";
	}
	
	@RequestMapping(value = "/mesBoardReply.do", method = RequestMethod.POST)
	public String mesBoardReply(@RequestParam Map<String, Object> map, @SessionAttribute("mes_reffer") int mes_reffer,@RequestParam String content ,@RequestParam String mes_recipient) {
		map.put("mes_sender", "ghkdwoaks1234");
		map.put("mes_recipient", mes_recipient);
		map.put("mes_reffer", mes_reffer);
		map.put("mes_content", content);
		service.mesBoardReply(map);
		return "redirect:/messendBoardSelectAll.do";
	}
	
}
