package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class Config {
  @Bean
  public IA a() {
    return new A();
  }

  //  @Bean
  //  public B b() {
  //    return new B();
  //  }
}
