package test;

// @Component
public class B {
  //  @Autowired
  private A a;

  public B() {}

  public B(A a) {
    this.a = a;
  }

  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }
}
