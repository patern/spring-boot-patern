
package com.patern.mongodb;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.patern.mongodb.config.props.MultipleMongoProperties;
import com.patern.mongodb.repository.primary.PrimaryMongoObject;
import com.patern.mongodb.repository.primary.PrimaryRepository;
import com.patern.mongodb.repository.secondary.SecondaryMongoObject;
import com.patern.mongodb.repository.secondary.SecondaryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(MultipleMongoProperties.class)
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class MuliDatabaseTest {

    @Autowired
    private PrimaryRepository primaryRepository;

    @Autowired
    private SecondaryRepository secondaryRepository;

    @Test
    public void TestSave() {

        System.out.println("************************************************************");
        System.out.println("测试开始");
        System.out.println("************************************************************");

        this.primaryRepository
                .save(new PrimaryMongoObject(null, "第一个库的对象"));

        this.secondaryRepository
                .save(new SecondaryMongoObject(null, "第二个库的对象"));

        List<PrimaryMongoObject> primaries = this.primaryRepository.findAll();
        for (PrimaryMongoObject primary : primaries) {
            System.out.println(primary.toString());
        }

        List<SecondaryMongoObject> secondaries = this.secondaryRepository.findAll();

        for (SecondaryMongoObject secondary : secondaries) {
            System.out.println(secondary.toString());
        }

        System.out.println("************************************************************");
        System.out.println("测试完成");
        System.out.println("************************************************************");
    }

}