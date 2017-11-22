package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Blurryface on 10/31/17.
 */

public class UserDaoTest extends AbstractDaoTest{

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private CountryDao countryDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;


    private void setUpData(){
        Role role = roleDao.findRoleByName("Tailor Premium");
        if (role == null){
            role = new Role();
            role.setName("Tailor Premium");
            role.setDescription("Premium tailors who can have their own virtual stores");
            role = roleDao.create(role);
        }

        Permission permission = permissionDao.findPermissionByName("View Shopping");
        if (permission == null){
            permission.setName("View Shopping");
            permission.setDescription("View all items in the shopping cart");
            permission = permissionDao.create(permission);
        }

        Country country = countryDao.findCountryByName("Nigeria");
        if (country == null){
            country = new Country();
            country.setName("Nigeria");
            country = countryDao.create(country);
        }

        Address address = addressDao.find(1);
        if (address == null){
            address = new Address();
            address.setAddress("Plot B61b, Road B6, Carlton Gate Estate");
            address.setCity("Lekki");
            address.setState("Lagos");
            address.setZipCode("23401");
            address.setCountryId(country.getId());
            address = addressDao.create(address);
        }

        User user = new User();
        user.setFirstName("Nkechinyere");
        user.setLastName("Ogbuagu");
        user.setEmail("nkechi.ogbuagu@expertflow.com");
        user.setPassword("password");
        user.setRoleId(role.getId());

        userDao.create(user);
    }
}
