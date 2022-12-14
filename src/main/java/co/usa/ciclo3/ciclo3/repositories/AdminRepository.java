package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Admin;
import co.usa.ciclo3.ciclo3.repositories.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    //GET
    public List<Admin> getAllAdmins(){
        return (List<Admin>) adminCrudRepository.findAll();
    }
    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    
    //POST
    public Admin saveAdmin(Admin admin){ 
        return adminCrudRepository.save(admin);
    }
    
    //DELETE
    public void deleteAdmin(int id){
        if (adminCrudRepository.findById(id).isPresent()) {
            adminCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateAdmin(int id, Admin admin){
        
        if(adminCrudRepository.findById(id).isPresent()){
            Admin adminDB = adminCrudRepository.findById(id).get();
            if (admin.getName() != null) {
                adminDB.setName(admin.getName());
            }
            if (admin.getPassword() != null) {
                adminDB.setPassword(admin.getPassword());
            }
            adminCrudRepository.save(adminDB);
        }
    }
    
}
