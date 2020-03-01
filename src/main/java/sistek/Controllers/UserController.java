package sistek.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sistek.entity.Barcode;
import sistek.entity.User;
import sistek.repository.BarcodeRepo;
import sistek.repository.UserRepo;

import java.util.List;

@RestController
@RequestMapping(value = "/user" , produces = MediaType.APPLICATION_JSON_VALUE)
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    BarcodeRepo barcodeRepo;

    @Autowired
    UserRepo userRepo;

    @PostMapping
    public String createuser(@RequestBody User user) {
        String name = user.getName();
        String password = user.getPassword();
        Boolean check = userRepo.existsByNameAndPassword(name,password);
        if(check == true)
            return "EXISTS";
        else {
            userRepo.save(user);
            return "Save success";
        }
    }

    @PostMapping("/login")
    public Integer loginUser(@RequestBody User user) {
        String name = user.getName();
        String password = user.getPassword();
        Boolean check = userRepo.existsByNameAndPassword(name,password);
        user = userRepo.findOneByNameAndPassword(name,password);
        if(check == true)
            return user.getId();
        else
            return -1;
    }

    @RequestMapping(value = "/getbarcodes/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public List<Barcode> getbarcode(@PathVariable("userid") Integer userid
                             ){
        List<Barcode> barcodes = barcodeRepo.findAllByUserId(userid);
        return barcodes;
    }

    @RequestMapping(value = "/addbarcode/{userid}/{barcode}", method = RequestMethod.GET)
    @ResponseBody
    public String barkodEkle(@PathVariable("userid") Integer userid,
                             @PathVariable("barcode") Integer barcodeid){
        Barcode barcode = barcodeRepo.findById(barcodeid).get();
        User user = userRepo.findById(userid).get();
        barcode.setUser(user);
        barcodeRepo.save(barcode);
        return "OK";
    }

    @GetMapping
    public List<User> getusers(){
        List<User> users = (List<User>) userRepo.findAll();
        return users;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public Long count(){
        Long count = userRepo.count();
        return count;
    }


}
