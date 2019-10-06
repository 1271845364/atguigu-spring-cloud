package com.yejinhui.service;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yejinhui.dao.BookDao;

/**
 * 
 * @author ye.jinhui
 * @date 018年8月18日
 */
@Service
public class BookService {

//	@Qualifier(value="bookDao")
//	@Autowired(required=false)
//	@Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;

	public void print() {
		System.out.println(bookDao.toString());
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}

}
