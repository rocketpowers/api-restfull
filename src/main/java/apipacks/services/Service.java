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
	
	public ResponseEntity<?> register(Peoples obj) {
		if (obj.getName().equals("")) {
			message.setMessage("the name is empty");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			
		} else if (obj.getAge() < 0) {
			message.setMessage("invalid age");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			
		}else if (obj.getEmail().equals("")) {
			message.setMessage("the email is empty");
			return new ResponseEntity<>(message,HttpStatus.BAD_REQUEST);
	
			
		} else {

			/* action.save(obj); */
			/* return new ResponseEntity<>(obj, HttpStatus.CREATED); */
			return new ResponseEntity<>(action.save(obj), HttpStatus.CREATED);

		}

	}

	// select method

	public ResponseEntity<?> select() {
		return new ResponseEntity<>(action.findAll(), HttpStatus.OK);

	}

	public ResponseEntity<?> selectForCode(int code) {

		if (action.countBycode(code) == 0) {

			message.setMessage("people not find");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(action.findByCode(code), HttpStatus.OK);
		}

	}

	public ResponseEntity<?> edit(Peoples obj) {

		if (action.countBycode(obj.getCode()) == 0) {
			message.setMessage("code not found");
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
			
		} else if (obj.getName().equals("")) {
			message.setMessage("insert a valid name");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			
		}else if(obj.getEmail().equals("")) {
			message.setMessage("insert valid email");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			
			
		} else if (obj.getAge() < 0) {
			message.setMessage("insert a valid age");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			
		} else {
			return new ResponseEntity<>(action.save(obj), HttpStatus.OK);

		}
	}

	public ResponseEntity<?> remove(int code) {
		if (action.countBycode(code) == 0) {
			message.setMessage("code not found");
			return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
		} else {

			Peoples obj = action.findByCode(code);
			action.delete(obj);
			message.setMessage("removed sucessfull");
			return new ResponseEntity<>(message, HttpStatus.OK);

		}
	}
}
