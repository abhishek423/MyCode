package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.Post;
import service.GetFriendMsg;
import service.GetLastSentMsgOperation;
import service.GetMsgOperation;
import service.SendMsgOperation;

@Controller
@EnableWebMvc
public class MsgController {
	
	/*@Autowired
	GetMsgOperation msgOperation;//get all msg operation
*/	@Autowired
	GetFriendMsg getFriendMsgOperation;
	@Autowired
	GetLastSentMsgOperation lastMsgOperation;
	@Autowired
	SendMsgOperation sendMsgOperation;


	
	@RequestMapping("/getFriendMsg")
	@ResponseBody
	public List<Post> getFriendMsg(@RequestParam("userId") String userId,@RequestParam("friendValue") String friendValue) {
		List<Post> msg = getFriendMsgOperation.execute(userId,friendValue);
		return msg;
	}
	@RequestMapping("/getSentMsg")
	@ResponseBody
	public Post getSentMsg(@RequestParam("linkId") String linkIdparam) {
		System.out.println("last msg retrieving ");
		int linkId = Integer.parseInt(linkIdparam);
		Post msg = lastMsgOperation.execute(linkId);
		return msg;
	}
	
	@RequestMapping("/sendMsg")
	@ResponseBody
	public void sendMsg(@ModelAttribute("post") Post p) {
		//int linkId = Integer.parseInt(linkIdparam);
		sendMsgOperation.execute(p);
		//return msg;
	}
	
	
/*	@RequestMapping("/getMsg")
	@ResponseBody
	public List<Post> getMsg(@RequestParam("userId") String userId,@RequestParam("linkId") String linkIdparam) {
		int linkId = Integer.parseInt(linkIdparam);
		List<Post> msg = msgOperation.execute(linkId);
		return msg;
	}*/
}
