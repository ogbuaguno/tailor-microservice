package ng.com.soh.tailor.ms.dao;

import ng.com.soh.ms.core.model.Authorities;
import ng.com.soh.ms.core.model.Role;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

/**
 * Created by Blurryface on 10/30/17.
 */


public class RoleDaoTest extends AbstractDaoTest{

    @Autowired
    private RoleDao roleDao;

    @Test
    public void create(){
        Role role = new Role();
        role.setName("Tailor Premium");
        role.setDescription("Premium tailors who can have their own virtual stores");
        role = roleDao.create(role);

        Assert.assertNotNull(role);
        Assert.assertTrue(role.getId() > 0);
    }

    @Test(expected = DuplicateKeyException.class)
    public void findFail(){
        Role role = new Role();
        role.setName("Tailor Premium");
        role.setDescription("Premium tailors who can have their own virtual stores");
        role = roleDao.create(role);

        Role newRole = roleDao.find(role.getId());

        Assert.assertNotNull(newRole);
        Assert.assertEquals(newRole.getName(), "Tailor Premium");
    }

    @Test
    public void find(){
        Role role = new Role();
        role.setName("Tailor Regular");
        role.setDescription("Regular tailors who can't have their own virtual stores");
        role = roleDao.create(role);

        Role newRole = roleDao.find(role.getId());

        Assert.assertNotNull(newRole);
        Assert.assertEquals(newRole.getName(), "Tailor Regular");
    }

    @Test
    public void update(){
        Role role = new Role();
        role.setName("Customer");
        role.setDescription("Cannot own a store or upload clothes");
        role = roleDao.create(role);

        role.setName("User");
        role = roleDao.update(role);

        Assert.assertNotNull(role);
        Assert.assertTrue(role.getName().equalsIgnoreCase("User"));
    }

    @Test
    public void getAuthorities(){
        Authorities authorities = roleDao.getAuthorities(14);
        Assert.assertNotNull(authorities);
    }

    /*@AfterClass
    public static void tearDown(){
        jdbcTemplate.execute("delete from roles where id > 0");
    }*/
}
