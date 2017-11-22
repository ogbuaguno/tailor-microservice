package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Address;
import ng.com.soh.ms.core.model.Country;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

/**
 * Created by Blurryface on 11/4/17.
 */

public class AdressDaoTest extends AbstractDaoTest {
    @Autowired
    private AddressDao addressDao;

    @Autowired
    private CountryDao countryDao;

    @Test
    public void create() {
        Country country = new Country();
        country.setName("Nigeria");
        country = countryDao.create(country);

        Address address = new Address();
        address.setAddress("Plot B61b, Road B6, Carlton Gate Estate");
        address.setCity("Lekki");
        address.setState("Lagos");
        address.setZipCode("23401");
        address.setCountryId(country.getId());
        address = addressDao.create(address);

        Assert.assertNotNull(address);
        Assert.assertTrue(address.getId() > 0);
    }

    @Test(expected = DuplicateKeyException.class)
    public void findFail() {
        Country country = new Country();
        country.setName("Nigeria");
        country = countryDao.create(country);

        Address address = new Address();
        address.setAddress("Plot B61b, Road B6, Carlton Gate Estate");
        address.setCity("Lekki");
        address.setState("Lagos");
        address.setZipCode("23401");
        address.setCountryId(country.getId());
        address = addressDao.create(address);

        Address gotAddress = addressDao.find(address.getId());

        Assert.assertNotNull(gotAddress);
        Assert.assertTrue(address.getCountryName().equalsIgnoreCase("Nigeria"));
    }

    @Test
    public void find() {
        Country country = new Country();
        country.setName("America");
        country = countryDao.create(country);

        Address address = new Address();
        address.setAddress("Plot B61b, Road B6, Carlton Gate Estate");
        address.setCity("Lekki");
        address.setState("Lagos");
        address.setZipCode("23401");
        address.setCountryId(country.getId());
        address = addressDao.create(address);

        Address gotAddress = addressDao.find(address.getId());

        Assert.assertNotNull(gotAddress);
        Assert.assertTrue(gotAddress.getCountryName().equalsIgnoreCase("America"));
    }

    @AfterClass
    public static void tearDown() {
        jdbcTemplate.execute("delete from addresses where id > 0");
        jdbcTemplate.execute("delete from countries where id > 0");
    }
}
