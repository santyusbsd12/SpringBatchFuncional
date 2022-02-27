package spring.batch;

import org.springframework.batch.item.ItemProcessor;

import spring.domain.Message;
import spring.domain.User;

public class MessagesItemProcessor implements ItemProcessor<User, Message> {

	public Message process(User user) throws Exception {
		Message m = new Message();
		m.setContent("Hola " + user.getName() + ", por favor pagar antes de fin de mes.");
		return m;
	}
}
