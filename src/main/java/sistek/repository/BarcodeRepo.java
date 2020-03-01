package sistek.repository;

import org.springframework.data.repository.CrudRepository;
import sistek.entity.Barcode;

import java.util.List;

public interface BarcodeRepo extends CrudRepository<Barcode, Integer> {

    Barcode findOneById(Integer bid);

    List<Barcode> findAllByUser(Integer userid);

    List<Barcode> findAllByUserId(Integer userid);
}
