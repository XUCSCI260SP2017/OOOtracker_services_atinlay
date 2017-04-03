/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package edu.xavier.csci260.atinlay.mvc;

import edu.xavier.csci260.atinlay.dal.MessageRepository;
import edu.xavier.csci260.atinlay.dal.UserRepository;
import edu.xavier.csci260.atinlay.domain.Message;
import edu.xavier.csci260.atinlay.domain.User;
import edu.xavier.csci260.atinlay.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for managing {@link Message} instances.
 *
 * @author Rob Winch
 * @author Joe Grandja
 * @modifiedby Luke McNamee
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/messages")
public class MessageController {

	private final MessageRepository messageRepository;
	private final UserRepository userRepository;

	@Autowired
	public MessageController(MessageRepository messageRepository, UserRepository userRepository) {

		this.messageRepository = messageRepository;

		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/inbox")
	public Iterable<Message> inbox() {

		return messageRepository.inbox();
	}

	@RequestMapping(value = "/sent")
	public Iterable<Message> sent() {

		return messageRepository.sent();
	}

	@RequestMapping(value = "/{id}")
	public Message get(@PathVariable Long id) {
		return messageRepository.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Message save(@Valid @RequestBody Message message, @CurrentUser User currentUser) {

		message.setTo(userRepository.findByEmail(message.getTo().getEmail()));

		message.setFrom(userRepository.findByEmail(currentUser.getEmail()));

		message = messageRepository.save(message);

		return message;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {

		messageRepository.delete(id);
	}

}