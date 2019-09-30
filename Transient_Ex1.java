/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package Transient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Tan Phan
 *
 */
class CountNumber implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  /**
   * @param a : first parameter
   * @param b : second parameter

   */
  public CountNumber(int a, int b) {
    super();
    this.a = a;
    this.b = b;
    extracted();
  }
  private int extracted() {
    return this.c = a + b;
  }
  int a;
  transient int b;
  /** 
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CountNumber [a=");
    builder.append(a);
    builder.append(", b=");
    builder.append(b);
    builder.append(", c=");
    builder.append(c);
    builder.append(", getClass()=");
    builder.append(getClass());
    builder.append(", hashCode()=");
    builder.append(hashCode());
    builder.append(", toString()=");
    builder.append(super.toString());
    builder.append("]");
    return builder.toString();
  }
  int c = a+b;
  
}
/**
 * @author PP81HC
 *
 */
public class Transient_Ex1 {

  /**
   * @param args
   * @throws IOException 
   * @throws FileNotFoundException 
   * @throws ClassNotFoundException 
   */
  @SuppressWarnings("javadoc")
  public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
    CountNumber countNumber = new CountNumber(1, 2);
    System.out.println(countNumber); // a=1, b=2, c=3
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("countNumber"));
    // write object 
    o.writeObject(countNumber);
    o.close();
    // read object
    ObjectInputStream i = new ObjectInputStream(new FileInputStream("countNumber"));
    CountNumber countnumber1 = (CountNumber) i.readObject();
    System.out.println(countnumber1); // a=1, b=0, c=3
    i.close();
    
  }

}
