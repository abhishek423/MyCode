package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PostDAO;
import model.Post;

@Service
public class SendMsgOperation {

	@Autowired
	PostDAO pdao;

	public void execute(Post p){

		String datetime= new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		
		p.setDateTime(datetime);
		pdao.create(p);


	} 
}
