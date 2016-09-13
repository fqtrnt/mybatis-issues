package com.other;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.binding.MapperProxy;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.DateTaskMapper;


/**
 * @author young [2016-08-17]
 * @version 1.0.0
 */
public class Issue768Test {

  /**
   * When use JDK8 compile this code, and run this test method, JUnit catch a error message that
   * org.apache.ibatis.binding.BindingException: Parameter 'record' not found. Available parameters are [0, 1, param1, param2].
   * When use JDK7 compile this code and run, above error message go away.
   */
  @Test
  public void testIssue768() {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
    DatetaskLogic logic = context.getBean(DatetaskLogic.class);
    DateTaskDto u = new DateTaskDto();
    u.setDateTaskId("aaa");
    logic.execute(u);
  }

  @Test
  public void testMethodParameterAnnotation3() throws Exception {
    Class<?> mapperInterface = PAC.class;
    PAC proxyInstance = (PAC) Proxy.newProxyInstance(
      mapperInterface.getClassLoader(), new Class[] { mapperInterface }, new MyInvocationHandler("test", "kkkkkkkk")
    );
    proxyInstance.test("aaaa");
  }

  /**
   * Run this test case, [org.apache.ibatis.binding.BindingException: Parameter 'record' not found. Available parameters are [0, 1, param1, param2].]
   * of error message never occurred.
   */
  @Test
  @SuppressWarnings("unchecked")
  public void testMethodParameterAnnotation2() throws Exception {
    Class<?> mapperInterface = DateTaskMapper.class;
    BaseNoKeyMapper<DateTaskExample, DateTask> proxyInstance = (BaseNoKeyMapper<DateTaskExample, DateTask>) Proxy.newProxyInstance(
      mapperInterface.getClassLoader(), new Class[] { mapperInterface },
//      new MyInvocationHandler("updateByExampleSelective", 1)
      new MapperProxy(null, mapperInterface, new HashMap<>())
    );
    proxyInstance.updateByExampleSelective(new DateTask(), new DateTaskExample());
  }

  @Test
  public void testMethodParameterAnnotation() throws Exception {
    Method[] methods = PAC.class.getMethods();
    for (Method method : methods) {
      if ("test".equals(method.getName())) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotations : parameterAnnotations) {
          for (Annotation annotation : annotations) {
            Param p = (Param) annotation;
            System.out.println("----------------" + p.value());
          }
        }
      }
    }
  }
  public class MyInvocationHandler implements InvocationHandler {
    private String methodName;
    private Object retVal;
    public MyInvocationHandler(String methodName, Object retVal) {
      this.methodName = methodName;
      this.retVal = retVal;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (methodName.equals(method.getName())) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotations : parameterAnnotations) {
          for (Annotation annotation : annotations) {
            Param p = (Param) annotation;
            System.out.println("----------------" + p.value());
          }
        }
      }
      return retVal;
    }

  }
  public interface ParameterAnnotationInterface {
    void test(@Param("record") String record);
  }
  public interface NothingInterface extends ParameterAnnotationInterface {

  }

  public interface PAC extends NothingInterface {
    void test(@Param("record") String record);
  }
}
