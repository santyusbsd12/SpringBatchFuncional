package spring.batch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import spring.domain.User;

public class UserMapper implements FieldSetMapper<User> {

	public User mapFieldSet(FieldSet fieldSet) throws BindException {
		User u = new User();
		u.setName(fieldSet.readString(0));
		u.setAge(fieldSet.readInt(1));
		return u;
	}
}
