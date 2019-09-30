/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package Transient;

import java.io.Serializable;

/**
 * @author PP81HC
 *
 */
class transient_exp1 implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static int a = 3;
  private static transient int b = 2;
  private int c = 4; 
  

  public static void main(String[] args) {
    System.out.println(b);
    System.out.println(a+b);
    
  }

}
