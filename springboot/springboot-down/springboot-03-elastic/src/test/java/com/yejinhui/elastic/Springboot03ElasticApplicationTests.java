package com.yejinhui.elastic;

import com.yejinhui.elastic.bean.Article;
import com.yejinhui.elastic.bean.Book;
import com.yejinhui.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){
//        Book book = new Book();
//        book.setId(1);
//        book.setAuthor("吴承恩");
//        book.setBookName("西游记");
//        bookRepository.index(book);
        for(Book book : bookRepository.findByBookNameLike("游")) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        //1、给ES中索引（保存）一个文档
        Article article = new Article(1,"zhangsan","好消息","Hello World");
        //构建一个索引
        Index index = new Index.Builder(article).index("yejinhui").type("news").build();
        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void testSearch(){
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("yejinhui").addType("news").build();
        try {
            SearchResult searchResult = jestClient.execute(search);
            System.out.println("searchResult.getJsonString() = " + searchResult.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
