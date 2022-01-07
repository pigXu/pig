package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {
  public static void main(String[] args) {
    //    ClassPathResource resource = new ClassPathResource("spring.xml");
    //    DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
    //    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    //    reader.loadBeanDefinitions(resource);

    //    ApplicationContext factory = new ClassPathXmlApplicationContext("spring.xml");

    AnnotationConfigApplicationContext factory = new AnnotationConfigApplicationContext("test");

    IA bean = factory.getBean(IA.class);
    bean.div(1, 2);
    //    factory.close();

    System.out.println(bean.toString());
  }
}
