package cn.eli.vue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "cn.eli.vue.entity")
public class VueLoginJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueLoginJavaApplication.class, args);
	}

}
