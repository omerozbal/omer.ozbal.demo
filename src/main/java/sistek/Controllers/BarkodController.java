package sistek.Controllers;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sistek.entity.Barcode;
import sistek.repository.BarcodeRepo;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/barcode" , produces = MediaType.APPLICATION_JSON_VALUE)
@EnableAutoConfiguration
@CrossOrigin(origins = "*")
public class BarkodController {

    @Autowired
    BarcodeRepo barcodeRepo;

    @PostMapping
    public String createBarkod(@RequestBody Barcode barkod) {

        barcodeRepo.save(barkod);
        return "OK";
    }

    @GetMapping
    public List<Barcode> getBarkods(){
        List<Barcode> barkodList = (List<Barcode>) barcodeRepo.findAll();
        List<JSONObject> entities = new ArrayList<JSONObject>();

        return barkodList;
    }




    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ResponseBody
    public Long count(){
        Long count = barcodeRepo.count();
        return count;
    }


}
