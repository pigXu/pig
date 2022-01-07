package test;

import javax.annotation.PreDestroy;

// @Component
public class A implements IA {
  private B b1;

  public A() {
    System.out.println(1);
  }

  public A(B b) {
    this.b1 = b;
  }

  public B getB1() {
    return b1;
  }

  //  @Resource
  //  @Autowired
  public void setB1(B b) {
    this.b1 = b;
  }

  public int div(int i, int j) {
    System.out.println("MathCalculator...div...");
    return i / j;
  }

  @PreDestroy
  public void test() {
    System.out.println(1);
  }
}
