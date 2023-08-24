package cn.hsa.its;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <h3>Description</h3>
 * Class Name: ItsFormDesignerApplication
 * <p>Description: </p>
 *
 * @author 李磊(cn32040)
 * @version 1.0.0
 * @date 2021-11-17 16:52
 */
@EnableSwagger2
@EnableCaching
@ImportResource("classpath*:config/spring.xml")
@MapperScan({"cn.hsa.**.dao"})
@ComponentScan(basePackages = {"cn.hsa"}, excludeFilters= {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE)})
@SpringBootApplication
public class ItsFormDesignerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItsFormDesignerApplication.class, args);
    }
}
