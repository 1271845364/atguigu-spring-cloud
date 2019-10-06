package com.yejinhui.tx;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月24日
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(rollbackFor=Exception.class)
	public void insertUser() throws FileNotFoundException {
		userDao.insertUser();
		// otherDao.other(),xxx
		System.out.println("插入完成...");
//		int i = 10 / 0;
		throw new FileNotFoundException();
	}

}
