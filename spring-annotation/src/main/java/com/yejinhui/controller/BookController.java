package com.yejinhui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.yejinhui.service.BookService;

/**
 * 
 * @author ye.jinhui
 * @date 2018年8月18日
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;
}
