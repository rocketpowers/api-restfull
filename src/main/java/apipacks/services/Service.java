package apipacks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import apipacks.model.Message;
import apipacks.model.Peoples;
import apipacks.repository.Repository;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private Message message;

	@Autowired
	private Repository action;

	// register

	public ResponseEntity<?> register(Peoples obj) {
		if (obj.getName().equals("")) {
			message.setMessage("the name is empty");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else if (obj.getAge() < 0) {
			message.setMessage("invalid age");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {

			/* action.save(obj); */
			/* return new ResponseEntity<>(obj, HttpStatus.CREATED); */
			return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);

		}

	}
	

	public ResponseEntity<?> select(){
		return new ResponseEntity<>(action.findAll(), HttpStatus.OK);

}

}