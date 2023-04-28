package Convert;

import entity.User;

import java.util.Map;

public class DataTableConvert {
    public static User convertToUser(Map<String, String> entry){
        String userName = entry.get("userName");
        String email = entry.get("email");
        String currentAddress = entry.get("currentAddress");
        String permanentAddress = entry.get("permanentAddress");
        return  new User( userName,   email,  currentAddress,  permanentAddress) ;
    }





}
