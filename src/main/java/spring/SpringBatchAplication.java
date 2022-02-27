package spring;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

public class SpringBatchAplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("MessageJob.xml");

		SimpleJobLauncher launcher = new SimpleJobLauncher();
		JobRepository jobRepository = (JobRepository) context.getBean("jobRepository");

		launcher.setJobRepository(jobRepository);
		launcher.setTaskExecutor(new SimpleAsyncTaskExecutor());

		try {
			launcher.run((Job) context.getBean("messageJob"), new JobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
