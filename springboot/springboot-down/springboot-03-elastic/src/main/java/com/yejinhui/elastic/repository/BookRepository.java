package com.yejinhui.elastic.repository;

import com.yejinhui.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ye.jinhui
 * @project springboot-03-elastic
 * @description
 * @create 2018/10/17 17:16
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

    //参见 https://docs.spring.io/spring-data/elasticsearch/docs/3.0.11.RELEASE/reference/html/
    List<Book> findByBookNameLike(String bookName);
}
