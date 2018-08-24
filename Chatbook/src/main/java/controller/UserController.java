package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import model.Link;
import model.Post;
import model.User;
import service.AddFriendOperation;
import service.GetFriendActivityOperation;
import service.GetFriendListOperation;
import service.GetRegisteredUserOperation;
import service.GetlinkIdOperation;
import service.SetUserActivityLogOperation;
import service.VerifyUserOperation;

@Controller
@EnableWebMvc
public class UserController {
	
	@Autowired
	VerifyUserOperation verifyUseroperation;
	@Autowired
	SetUserActivityLogOperation activity;
	@Autowired
	GetFriendListOperation flOperation;
	@Autowired
	GetFriendActivityOperation getFriendActivityOperation;
	@Autowired
	GetRegisteredUserOperation registeredUserOperation;
	@Autowired
	GetlinkIdOperation getlinkIdOperation;
	@Autowired
	AddFriendOperation addFriendOperation;
	
	
	@RequestMapping("/userHome")
	public String addSession(@RequestParam("userId") String userId,@RequestParam("pass") String pass) {
		System.out.println("going to verify.......");
		boolean verification = verifyUseroperation.execute(userId, pass);
		System.out.println("verification = "+verification);
		if(verification) {
			System.out.println("Acess Granted");
			ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
    		HttpSession session = attr.getRequest().getSession();
	        session.setAttribute("userId",userId);
	        activity.execute(userId,1);//logvalue=1
			return "userHome.html";
		}
		else {
			System.out.println("Denied");

			return "userLogin.html";
		}
	}
	
	@RequestMapping("/getSession")
	@ResponseBody
	public String getSession(HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		System.out.println("ur session is "+userId);
		return userId;
	}
	
	@RequestMapping("/getFriendList")
	@ResponseBody
	public List<Link> getFriendList(@RequestParam("userId") String userId) {
		System.out.println("userId is ->"+userId);
		List<Link> friends = flOperation.execute(userId);
		return friends;
	}
	
	@RequestMapping("/getAllRegisteredUser")
	@ResponseBody
	public List<User> getAllRegisteredUser(@RequestParam("searchInput") String userId) {
		//System.out.println("userId is ->"+userId);
		List<User> user = registeredUserOperation.execute(userId);
		return user;
	}
	@RequestMapping("/addFriend")
	@ResponseBody
	public void addFriend(@ModelAttribute("link") Link l) {
		addFriendOperation.execute(l);
	}
	@RequestMapping("/getFriendActivity")
	@ResponseBody
	public User getFriendActivity(@RequestParam("friendValue") String friendId) {
		System.out.println("activity retrieving ");
		User u = getFriendActivityOperation.execute(friendId);
		System.out.println(u.toString());
		return u;
	}
	
	@RequestMapping("/getLinkId")
	@ResponseBody
	public int getLinkId(@RequestParam("userId") String userId,@RequestParam("friendValue") String friendValue) {
		System.out.println("link retrieving ");
		int linkId = getlinkIdOperation.execute(userId,friendValue);
		return linkId;
	}
	
	@RequestMapping("/logout")
	public String removeSession(@RequestParam("userId") String userId) {
		System.out.println("logout.......");
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = attr.getRequest().getSession();
		
		//String sessionId = (String) session.getAttribute("userId");
		
		
		//if(userId==sessionId) {
			//logvalue=1
			session.removeAttribute("userId");
	        activity.execute(userId,0);
	        session.invalidate();  
			return "userHome.html";
		//}
	//HttpSession session=request.getSession();  
	}
}
