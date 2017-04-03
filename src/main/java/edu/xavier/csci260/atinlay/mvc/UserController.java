/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.xavier.csci260.atinlay.mvc;

import edu.xavier.csci260.atinlay.dal.UserRepository;
import edu.xavier.csci260.atinlay.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *  Controller for managing {@link User} instances.
 *
 * @author Joe Grandja
 * @modifiedby Luke McNamee
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/users")
public class UserController {
	private final UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<User> get() {
		return userRepository.findAll();
	}

	@RequestMapping("/{id}")
	public User user(@PathVariable Long id) {
		return userRepository.findOne(id);
	}
}