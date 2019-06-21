package dao;


import model.User;

import java.util.*;

public class UserDao {



  private Map<String, User> usersDB = new HashMap<>();

  {
    usersDB.put("hkeraga@mum.edu", new User(1,"hkeraga@mum.edu","123", "", "", ""));
    usersDB.put("zgelgelo@mum.edu", new User(2,"zgelgelo@mum.edu","123", "", "", ""));

  }

  public boolean checkExistUser(String email, String password){
    if(usersDB.containsKey(email) && usersDB.get(email).getPassword().equals(password)){
      return true;
    }
    return false;
  }
  public User getUserByEmail(String email){
      return usersDB.get(email);
  }
  public User getUser(String email){

    return usersDB.get(email);
  }
  public boolean checkExistEmail(String email){
    if (usersDB.containsKey(email)){
      return true;
    }
    return false;
  }
  public int getMaxID(){
    return usersDB.entrySet().stream().max((entry1, entry2) -> entry1.getValue().getId() > entry2.getValue().getId() ? 1 : -1).get().getValue().getId();
  }
  public boolean addUser(String email, String pw,String fullname,String telephone,String address)
  {
    if (checkExistEmail(email)) {
      return false;
    }
    else {
      int newId = getMaxID() + 1;
      usersDB.put(email,new User(newId,email, pw, fullname, telephone, address));
      return true;
    }
  }

//  public List<User> getUsersDB(){
//
//    return new ArrayList<User>(usersDB.values());
//  }
}
