package spring.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

import spring.domain.Message;

public class MessagesItemWriter implements ItemWriter<Message> {
	
	private int contadorPaquete = 1;

	public void write(List<? extends Message> items) throws Exception {
		
		System.out.println();
		System.out.println("Imprimiendo paquete " + contadorPaquete++);
		
		for (Message message : items) {
			System.out.println(message.getContent());
		}

	}

}
