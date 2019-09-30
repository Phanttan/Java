/*
 * Copyright (c) Robert Bosch GmbH. All rights reserved.
 */
package Transient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author PP81HC
 *
 */
class NameStore implements Serializable{

  /**
   * @param args
   */
  private String firstName;
  private transient String middleName;
  private String lastName;

  public NameStore (String fName, String mName, String lName){
      this.firstName = fName;
      this.middleName = mName;
      this.lastName = lName;
  }
// Must to defin toString function to use print out:
  public String toString(){
      StringBuffer sb = new StringBuffer(40);
      sb.append("First Name : ");
      sb.append(this.firstName + "\n");
      sb.append("Middle Name : ");
      sb.append(this.middleName +"\n");
      sb.append("Last Name : ");
      sb.append(this.lastName);
      return sb.toString();
  }
}
public class TransientExample{
  public static void main(String[] args) throws Exception{
    NameStore nameStore = new NameStore("Steve","Middle","Jobs");
    ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("nameStore"));
    // writing to object
    o.writeObject(nameStore);
    o.close();
    System.out.println(nameStore); // do not care that variable is transient or not
    //reading from object
    ObjectInputStream i = new ObjectInputStream(new FileInputStream("nameStore"));
    NameStore nameStore1 = (NameStore) i.readObject();    
    System.out.println(nameStore1); // Do not save transient variable
  }

}
