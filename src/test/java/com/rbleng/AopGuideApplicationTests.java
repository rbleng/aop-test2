package com.rbleng;

import com.rbleng.security.CurrentUserHolder;
import com.rbleng.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopGuideApplicationTests {

    @Autowired
    ProductService productService;

	// 未通过
    @Test(expected = Exception.class)
    public void annoInsertTest(){
        CurrentUserHolder.set("tom");
        productService.delete(1L);
    }

	// 通过
    @Test
    public void adminInsert(){
        CurrentUserHolder.set("admin");
        productService.delete(1L);
    }
}
