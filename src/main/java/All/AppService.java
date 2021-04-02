package All;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepo appRepo;

    public List<Users> getAll() {
        return appRepo.findAll();
    }

    public void add(Users users) {
        appRepo.save(users);
    }

    public void delete(Long id) {
        appRepo.deleteById(id);
    }

    public void update(Users users, long id) {
        appRepo.deleteById(id);
        appRepo.save(users);
    }
}
