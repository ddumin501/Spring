package a;

import org.springframework.stereotype.Component;

@Component(value = "s2")
public class Second2 implements Second {

   @Override
   public String info() {
      return "Second2객체입니다.";
   }

}